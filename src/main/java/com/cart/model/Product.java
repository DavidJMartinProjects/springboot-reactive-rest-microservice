package com.cart.model;

import org.springframework.data.annotation.Id;

import lombok.Data;
import lombok.Value;

@Value
@Data
public class Product {

    @Id
    private long id;

    private String name;
    private String description;
    private String sku;
    private double price;

}