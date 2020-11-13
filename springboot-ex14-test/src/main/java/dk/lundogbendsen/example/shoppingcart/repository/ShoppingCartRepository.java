package dk.lundogbendsen.example.shoppingcart.repository;

import dk.lundogbendsen.example.shoppingcart.model.ShoppingCart;
import org.springframework.data.repository.CrudRepository;

public interface ShoppingCartRepository extends CrudRepository<ShoppingCart, String> {
}
