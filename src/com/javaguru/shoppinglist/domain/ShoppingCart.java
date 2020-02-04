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
                .map(i -> i.getKey().getActualPrice().multiply(new BigDecimal(i.getValue())))
                .reduce((a,b) -> a.add(b)).get().setScale(2);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ShoppingCart{");
        sb.append("name='").append(name).append('\'');
        sb.append('}');
        sb.append('\n');
        list.entrySet().stream().forEach(i->sb.append(i.getKey().toString()).append('\n')
                .append(i.getValue()).append('\n'));
        return sb.toString();
    }
}
