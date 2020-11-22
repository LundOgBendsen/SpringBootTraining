package dk.lundogbendsen.example.bookstore.repository;

import dk.lundogbendsen.example.bookstore.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
    Book findByName(String name);
}
