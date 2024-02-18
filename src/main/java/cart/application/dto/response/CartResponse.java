package cart.application.dto.response;

import java.time.LocalDateTime;
import java.util.List;

public record CartResponse(
        Long id,
        Long userId,
        List<CartItemResponse> items,
        LocalDateTime createdAt,
        LocalDateTime updatedAt) {
}
