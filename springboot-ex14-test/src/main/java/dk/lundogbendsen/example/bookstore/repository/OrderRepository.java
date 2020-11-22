package dk.lundogbendsen.example.bookstore.repository;

import dk.lundogbendsen.example.bookstore.model.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Long> {
}
