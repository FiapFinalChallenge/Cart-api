package cart.application.dto.response;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public record CartResponse(
        Long id,
        Long userId,
        List<CartItemResponse> items,
        BigDecimal totalValue,
        LocalDateTime createdAt,
        LocalDateTime updatedAt) {
}
