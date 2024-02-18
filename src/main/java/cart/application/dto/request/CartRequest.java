package cart.application.dto.request;

import java.util.Set;

public record CartRequest(Long userId, Set<CartItemRequest> items) {
}
