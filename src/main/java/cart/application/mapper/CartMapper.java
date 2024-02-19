package cart.application.mapper;

import cart.application.dto.request.CartRequest;
import cart.application.dto.response.CartResponse;
import cart.domain.model.Cart;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CartMapper {

    @Mapping(target = "id", source = "cart.id")
    @Mapping(target = "userId", source = "cart.userId")
    @Mapping(target = "items", source = "cart.items")
    @Mapping(target = "totalValue", source = "cart.totalValue")
    @Mapping(target = "createdAt", source = "cart.createdAt")
    @Mapping(target = "updatedAt", source = "cart.updatedAt")
    CartResponse convertToCartResponse(Cart cart);

    @Mapping(target = "userId", source = "cartRequest.userId")
    @Mapping(target = "items", source = "cartRequest.items")
    @Mapping(target = "totalValue", source = "cartRequest.totalValue")
    Cart convertToCart(CartRequest cartRequest);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "userId", source = "cartRequest.userId")
    @Mapping(target = "items", source = "cartRequest.items")
    @Mapping(target = "totalValue", source = "cartRequest.totalValue")
    Cart convertToCartWithId(CartRequest cartRequest, Long id);
}
