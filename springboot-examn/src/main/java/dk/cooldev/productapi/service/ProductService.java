package dk.cooldev.productapi.service;

import dk.cooldev.productapi.model.Product;
import dk.cooldev.productapi.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Page<Product> list(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    public Product createOrUpdate(Product product) {
        return productRepository.save(product);
    }

    public Product get(String productName) {
        return productRepository.findByName(productName);
    }

    public void delete(String productName) {
        Product product = productRepository.findByName(productName);
        if (product != null) {
            productRepository.delete(product);
        }
    }

}
