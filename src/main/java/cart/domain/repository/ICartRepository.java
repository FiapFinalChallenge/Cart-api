package cart.domain.repository;

import cart.domain.model.Cart;

import java.util.List;
import java.util.Optional;

public interface ICartRepository {

    List<Cart> findAll();

    Optional<Cart> findById(Long id);

    Cart save(Cart cart);

    void deleteById(Long id);
}
