package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.repository.ProductInMemoryRepository;
import org.springframework.stereotype.Component;

@Component
public class ProductNameValidationRule implements ProductValidationRule {

    final private ProductInMemoryRepository repository;

    public ProductNameValidationRule(ProductInMemoryRepository repository) {
        this.repository = repository;
    }

    @Override
    public void validate(Product product) {
        checkNotNull(product);
        if (product.getName() == null) {
            throw new ProductValidationException("Product name must be not null.");
        } else if (product.getName().length() < 3) {
            throw new ProductValidationException("The name cannot be shorter than 3 symbols");
        } else if (product.getName().length() > 32) {
            throw new ProductValidationException("The name cannot be longer than 32 symbols");
        }

        if (repository.containsProductName(product.getName())) {
            throw new ProductValidationException("The name has to be unique");
        }
    }
}
