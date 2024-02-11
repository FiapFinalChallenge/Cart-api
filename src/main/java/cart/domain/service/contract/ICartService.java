package cart.domain.service.contract;

import cart.application.dto.response.CartResponse;

import java.util.List;

public interface ICartService {

    List<CartResponse> getAll();
}
