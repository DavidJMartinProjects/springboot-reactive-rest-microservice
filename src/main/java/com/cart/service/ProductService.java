package com.cart.service;

import com.cart.db.repository.ProductRepository;
import com.cart.model.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Flux<Product> getProducts() {
        return productRepository.findAll();
    }

    public Mono<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    public Mono<Product> findByName(String name) {
        return productRepository.findByName(name);
    }

}
