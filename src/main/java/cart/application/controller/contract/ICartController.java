package cart.application.controller.contract;

import cart.application.dto.request.CartRequest;
import cart.application.dto.response.CartResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface ICartController {

    @GetMapping
    List<CartResponse> getAll();

    @GetMapping("{id}")
    CartResponse getById(@PathVariable Long id);

    @PostMapping
    CartResponse create(@RequestBody CartRequest cartRequest);

    @PutMapping("{id}")
    CartResponse update(@PathVariable Long id, @RequestBody CartRequest cartRequest);

    @DeleteMapping("{id}")
    void deleteById(@PathVariable Long id);
}
