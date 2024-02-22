package cart.application.dto.request;

import jakarta.validation.constraints.NotNull;

public record CartItemRequest(@NotNull Long itemId, @NotNull Integer amount) {
}
