package cart.domain.service.impl;

import cart.application.dto.request.CartRequest;
import cart.application.dto.response.CartResponse;
import cart.application.mapper.CartMapper;
import cart.domain.repository.ICartRepository;
import cart.domain.service.contract.ICartService;
import jakarta.ws.rs.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements ICartService {

    private final ICartRepository repository;
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
}
