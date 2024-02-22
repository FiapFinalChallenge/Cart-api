package cart.application.dto.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Set;

@Getter
@AllArgsConstructor
public class CartRequest {

    @NotNull
    private final Long userId;

    @Valid
    @NotEmpty
    private final Set<CartItemRequest> items;

    @Setter
    private BigDecimal totalValue;
}
