package dk.lundogbendsen.example.bookstore.repository;

import dk.lundogbendsen.example.bookstore.model.OrderLine;
import org.springframework.data.repository.CrudRepository;

public interface OrderLineRepository extends CrudRepository<OrderLine, Long> {
}
