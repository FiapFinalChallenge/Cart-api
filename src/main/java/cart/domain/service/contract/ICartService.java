package cart.domain.service.contract;

import cart.application.dto.request.CartRequest;
import cart.application.dto.response.CartResponse;

import java.util.List;

public interface ICartService {

    List<CartResponse> getAll();

    CartResponse getById(Long id);

    CartResponse create(CartRequest cartRequest);

    CartResponse update(Long id, CartRequest cartRequest);

    void deleteById(Long id);
}
