package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.domain.Product;

public class ProductPriceValidationRule implements ProductValidationRule {
    @Override
    public void validate(Product product) {
        checkNotNull(product);
        if (product.getPrice() == null) {
            throw new ProductValidationException("Product price must be not null.");
        } else if (product.getPrice().signum() <= 0) {
            throw new ProductValidationException("Price must be nonzero positive");
        }
    }
}
