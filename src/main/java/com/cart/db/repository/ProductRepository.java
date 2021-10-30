package com.cart.db.repository;

import com.cart.model.Product;

import org.springframework.data.r2dbc.repository.R2dbcRepository;

import reactor.core.publisher.Mono;

public interface ProductRepository extends R2dbcRepository<Product, Long> {  
    Mono<Product> findByName(String productName);  
}
