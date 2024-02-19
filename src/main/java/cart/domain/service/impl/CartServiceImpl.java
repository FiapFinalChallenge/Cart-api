package cart.domain.service.impl;

import cart.application.dto.request.CartItemRequest;
import cart.application.dto.request.CartRequest;
import cart.application.dto.response.CartResponse;
import cart.application.mapper.CartMapper;
import cart.domain.repository.ICartRepository;
import cart.domain.service.contract.ICartService;
import cart.infra.external.ItemClient;
import cart.infra.external.dto.response.ItemResponse;
import jakarta.ws.rs.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements ICartService {

    private final String AMOUNT_EXCEED = "Requested amount exceeds available quantity for item ID: ";
    private final ICartRepository repository;
    private final ItemClient itemClient;
    private final CartMapper mapper;

    @Override
    public List<CartResponse> getAll() {
        return repository
                .findAll()
                .stream()
                .map(mapper::convertToCartResponse)
                .toList();
    }

    @Override
    public CartResponse getById(Long id) {
        return mapper.convertToCartResponse(repository
                .findById(id)
                .orElseThrow(() -> new NotFoundException("Cart not found")));
    }

    @Override
    public CartResponse create(CartRequest cartRequest) {
        cartRequest.setTotalValue(getTotalValue(cartRequest.getItems()));

        return mapper.convertToCartResponse(repository
                .save(mapper.convertToCart(cartRequest)));
    }

    @Override
    public CartResponse update(Long id, CartRequest cartRequest) {
        getById(id);
        return mapper.convertToCartResponse(repository
                .save(mapper.convertToCartWithId(cartRequest, id)));
    }

    @Override
    public void deleteById(Long id) {
        getById(id);
        repository.deleteById(id);
    }

    private BigDecimal getTotalValue(Set<CartItemRequest> items) {
        return items.stream()
                .map(itemRequest -> {
                    var itemResponse = fetchItemResponse(itemRequest.itemId());
                    checkItemAvailability(itemRequest, itemResponse);

                    return calculateItemTotal(itemRequest, itemResponse);
                })
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    private ItemResponse fetchItemResponse(Long itemId) {
        return itemClient.getItemById(itemId);
    }

    private void checkItemAvailability(CartItemRequest itemRequest, ItemResponse itemResponse) {
        if (itemRequest.amount() > itemResponse.amount()) {
            throw new IllegalArgumentException(AMOUNT_EXCEED + itemRequest.itemId());
        }
    }

    private BigDecimal calculateItemTotal(CartItemRequest itemRequest, ItemResponse itemResponse) {
        return itemResponse.price().multiply(BigDecimal.valueOf(itemRequest.amount()));
    }
}
