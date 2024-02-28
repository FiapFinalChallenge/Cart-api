package cart.infra.external.client;

import cart.infra.external.dto.response.ItemResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ITEMS-SERVICE")
public interface ItemClient {

    @GetMapping("api/items/{id}")
    ItemResponse getItemById(@PathVariable Long id);
}
