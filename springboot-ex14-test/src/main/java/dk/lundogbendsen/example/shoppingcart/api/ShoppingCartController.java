package dk.lundogbendsen.example.shoppingcart.api;

import dk.lundogbendsen.example.shoppingcart.model.ShoppingCart;
import dk.lundogbendsen.example.shoppingcart.service.ShoppingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/carts")
public class ShoppingCartController {

    @Autowired
    private ShoppingService shoppingService;

    @GetMapping
    private Iterable<ShoppingCart> getAllShoppingCarts() {
        return shoppingService.getShoppingCarts();
    }
}
