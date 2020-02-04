package com.javaguru.shoppinglist.service;

import com.javaguru.shoppinglist.domain.ShoppingCart;

public class ShoppingCartService {
    private ShoppingCart shoppingCart;

    public void createShoppingCart(String name) {
        shoppingCart = new ShoppingCart(name);
    }
}
