package com.cart.controller;

import com.cart.model.Product;
import com.cart.service.ProductService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = ProductController.PRODUCTS)
@RequiredArgsConstructor
public class ProductController {

    public static final String PRODUCTS = "/products";

    private ProductService productService;

    @GetMapping
    public Flux<Product> getProducts() {
        return productService.getProducts();
    }

    @GetMapping("/{id}")
    public Mono<Product> getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }
    
    @PostMapping
    public Mono<Product> createProduct(@RequestBody Product product) {
        return productService.save(product);
    }

    @PutMapping
    public Mono<Product> updateProduct(@RequestBody Product product) {
        return productService
            .findByName(product.getName())
            .flatMap(productResult -> productService.save(product));
    }

    @DeleteMapping
    public Mono<Void> deleteProduct(@RequestBody Product product) {
        return productService.deleteById(product.getId());
    }

    
}
