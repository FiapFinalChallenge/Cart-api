package cart.application.mapper;

import cart.application.dto.request.CartRequest;
import cart.application.dto.response.CartResponse;
import cart.domain.model.Cart;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CartMapper {

    @Mapping(target = "id", source = "cart.id")
    @Mapping(target = "amount", source = "cart.amount")
    CartResponse convertToCartResponse(Cart cart);

    @Mapping(target = "amount", source = "cartRequest.amount")
    Cart convertToCart(CartRequest cartRequest);
}
