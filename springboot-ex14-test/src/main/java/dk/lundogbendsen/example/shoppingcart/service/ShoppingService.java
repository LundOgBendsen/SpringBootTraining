package dk.lundogbendsen.example.shoppingcart.service;

import dk.lundogbendsen.example.shoppingcart.model.ShoppingCart;
import dk.lundogbendsen.example.shoppingcart.repository.ShoppingCartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShoppingService {
    @Autowired
    private ShoppingCartRepository shoppingCartRepository;

    public Iterable<ShoppingCart> getShoppingCarts() {
        return shoppingCartRepository.findAll();
    }
}
