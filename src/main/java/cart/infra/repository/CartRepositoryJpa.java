package cart.infra.repository;

import cart.domain.model.Cart;
import cart.domain.repository.ICartRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepositoryJpa extends JpaRepository<Cart, Long>, ICartRepository {
}
