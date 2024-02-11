package cart.domain.repository;

import cart.domain.model.Cart;

import java.util.List;

public interface ICartRepository {

    List<Cart> findAll();
}
