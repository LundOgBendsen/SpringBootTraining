package dk.cooldev.productapi.repositories;

import dk.cooldev.productapi.model.Product;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ProductRepository extends PagingAndSortingRepository<Product, Long> {
    Product findByName(String name);
}
