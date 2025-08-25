package com.booleanuk.api.bagels;

import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductRepository productRepository;

    @GetMapping
    public List<Product> getProducts() {
        return this.productRepository.getProductList();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Product> getSpecificProduct(@PathVariable int id) {
        Product product = this.productRepository.getProductById(id);
        return product != null ?
                ResponseEntity.ok(product):
                ResponseEntity.notFound().build();
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Product createProduct(@RequestBody Product product) {
         this.productRepository.createProduct(product);
        return product;
    }
    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable int id, @RequestBody Product product) {
        Product foundProduct = this.productRepository.updateProduct(id, product);
        return foundProduct != null ?
                ResponseEntity.ok(foundProduct):
                ResponseEntity.notFound().build();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Product> deleteProduct(@PathVariable int id) {
        Product foundProduct = this.productRepository.deleteProduct(id);
        return foundProduct != null ?
                ResponseEntity.ok(foundProduct):
                ResponseEntity.notFound().build();
    }
}
