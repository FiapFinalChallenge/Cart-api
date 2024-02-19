package cart.infra.external.dto.response;

import java.math.BigDecimal;

public record ItemResponse(BigDecimal price, Integer amount) {
}
