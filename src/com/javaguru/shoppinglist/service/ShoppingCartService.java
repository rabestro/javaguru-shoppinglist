package com.javaguru.shoppinglist.service;

import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.domain.ShoppingCart;

import java.math.BigDecimal;

public class ShoppingCartService {
    private static ShoppingCart shoppingCart;

    public void createShoppingCart(String name) {
        shoppingCart = new ShoppingCart(name);
    }

    public void addProduct(Product product) {
        shoppingCart.addProduct(product);
    }

    public BigDecimal calculatePrice() {
        return shoppingCart.getTotalPrice();
    }

    public void printShoppingCart() {
        System.out.println(shoppingCart.toString());
    }
}
