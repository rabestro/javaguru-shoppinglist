package com.javaguru.shoppinglist.domain;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {
    private final String name;
    private static final Map<Product, Integer> list = new HashMap<>();

    public ShoppingCart(final String name) {
        this.name = name;
    }

    public void addProduct(Product product) {
        if (list.containsKey(product)) {
            final int count = list.get(product) + 1;
            list.put(product, count);
        } else {
            list.put(product, 1);
        }
    }

    public Map<Product, Integer> getList() {
        return list;
    }

    public BigDecimal getTotalPrice() {
        return list.entrySet().stream()
                .map(i -> i.getKey().getPrice()
                        .multiply(new BigDecimal(100).subtract(i.getKey().getDiscount()))
                        .divide(new BigDecimal(100))
                        .multiply(new BigDecimal(i.getValue())))
                .reduce((a,b) -> a.add(b))
                .get();
    }
}
