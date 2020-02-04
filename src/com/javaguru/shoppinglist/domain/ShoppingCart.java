package com.javaguru.shoppinglist.domain;

import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {
    private final String name;
    private final Map<Product, Integer> list = new HashMap<>();

    public ShoppingCart(final String name) {
        this.name = name;
    }
}
