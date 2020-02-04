package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.domain.ShoppingCart;

public interface ShoppingCartValidationRule {
    void validate(ShoppingCart shoppingCart);

    default void checkNotNull(ShoppingCart shoppingCart) {
        if (shoppingCart == null) {
            throw new ProductValidationException("Shopping Cart must be not null");
        }
    }
}
