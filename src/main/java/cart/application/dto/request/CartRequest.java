package cart.application.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Set;

@Getter
@AllArgsConstructor
public class CartRequest {

    private final Long userId;
    private final Set<CartItemRequest> items;
    @Setter
    private BigDecimal totalValue;
}
