package dk.cooldev.productapi.api;

import dk.cooldev.productapi.api.dto.ProductDTO;
import dk.cooldev.productapi.model.Product;
import dk.cooldev.productapi.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public Page<ProductDTO> list() {
        Page<Product> page = productService.list(Pageable.unpaged());
        return new PageImpl<>(toDto(page.getContent()));
    }

    private List<ProductDTO> toDto(List<Product> content) {
        return content.stream().map(product -> toDto(product)).collect(Collectors.toList());
    }

    private ProductDTO toDto(Product product) {
        return ProductDTO.builder().name(product.getName()).price(product.getPrice()).build();
    }

    @GetMapping("/{productName}")
    public ProductDTO get(@PathVariable String productName) {
        return toDto(productService.get(productName));
    }

    @PostMapping()
    public ProductDTO create(@RequestBody ProductDTO productDTO) {
        return toDto(productService.createOrUpdate(toModel(productDTO)));
    }

    private Product toModel(ProductDTO productDTO) {
        return Product.builder().price(productDTO.getPrice()).name(productDTO.getName()).build();
    }

    @PutMapping("/{productName}")
    public ProductDTO update(@PathVariable("productName") String productName, @RequestBody ProductDTO update) {
        Product product = productService.get(productName);
        product.setName(update.getName());
        product.setPrice(update.getPrice());
        return toDto(productService.createOrUpdate(product));
    }

    @DeleteMapping("/{productName}")
    public void delete(@PathVariable String productName) {
        productService.delete(productName);
    }


}
