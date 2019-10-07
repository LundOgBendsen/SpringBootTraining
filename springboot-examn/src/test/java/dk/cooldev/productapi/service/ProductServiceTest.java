package dk.cooldev.productapi.service;

import dk.cooldev.productapi.model.Product;
import dk.cooldev.productapi.repositories.ProductRepository;
import org.junit.Before;
import org.junit.Test;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ProductServiceTest {

    private ProductService productService;
    private ProductRepository productRepository;

    @Before
    public void init() {
        productRepository = mock(ProductRepository.class);
        productService = new ProductService(productRepository);
    }

    @Test
    public void listNoProducts() {
        when(productRepository.findAll((Pageable) null)).thenReturn(new PageImpl<>(Collections.emptyList()));
        Page<Product> list = productService.list(null);
        assertEquals(0, list.getContent().size());
    }

    @Test
    public void listWhenThereAreTwoProducts() {
        List<Product> products = Arrays.asList(Product.builder().name("p1").price(1.5).build(), Product.builder().name("p2").price(2.5).build());
        when(productRepository.findAll((Pageable) null)).thenReturn(new PageImpl<>(products));
        Page<Product> list = productService.list(null);
        assertEquals(2, list.getContent().size());
    }

    @Test
    public void create() {
        when(productRepository.save(any())).then(invocationOnMock -> {
            Product product = invocationOnMock.getArgument(0);
            if (product.getId() == null) {
                product.setId(1L);
            }
            return product;
        });

        Product product = Product.builder().name("p1").price(1.0).build();
        Product created = productService.createOrUpdate(product);

        assertEquals(new Long(1), created.getId());
        assertEquals("p1", created.getName());
        assertEquals(new Double(1.0), created.getPrice());
    }

    @Test
    public void update() {
        when(productRepository.save(any())).then(invocationOnMock -> invocationOnMock.getArgument(0));

        Product product = Product.builder().id(2L).name("p1").price(1.0).build();
        Product created = productService.createOrUpdate(product);

        assertEquals(new Long(2), created.getId());
        assertEquals("p1", created.getName());
        assertEquals(new Double(1.0), created.getPrice());
    }
}