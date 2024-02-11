package cart.application.controller;

import cart.application.controller.contract.ICartController;
import cart.application.dto.response.CartResponse;
import cart.domain.service.contract.ICartService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/carts")
public class CartController implements ICartController {

    private final ICartService service;

    @Override
    public List<CartResponse> getAll() {
        return service.getAll();
    }
}
