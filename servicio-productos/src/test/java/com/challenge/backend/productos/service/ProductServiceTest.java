package com.challenge.backend.productos.service;

import com.challenge.backend.productos.Model.Product;
import com.challenge.backend.productos.exception.ProductNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

public class ProductServiceTest {

    private ProductService productService;

    @BeforeEach
    void setUp() {
        productService = new ProductService();
    }

    @Test
    void findAll_should_return_all_products() {
        Flux<Product> result = productService.findAll();
        StepVerifier.create(result)
                .expectNextCount(3)
                .verifyComplete();
    }

    @Test
    void findById_should_return_product_when_exists() {
        Mono<Product> result = productService.findById(1L);
        StepVerifier.create(result)
                .expectNextMatches(product -> product.id().equals(1L) && product.nombre().equals("Papaya"))
                .verifyComplete();
    }

    @Test
    void findById_return_empty_when_not_exists() {
        Mono<Product> result = productService.findById(99L);
        StepVerifier.create(result)
                .expectError(ProductNotFoundException.class)
                .verify();
    }

}
