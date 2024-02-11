package cart.application.controller.contract;

import cart.application.dto.response.CartResponse;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public interface ICartController {

    @GetMapping
    List<CartResponse> getAll();
}
