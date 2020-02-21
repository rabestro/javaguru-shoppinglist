package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.domain.Product;
import java.util.HashSet;
import java.util.Set;

public class ProductValidationService {

    private final Set<ProductValidationRule> validationRules;

    public ProductValidationService(HashSet<ProductValidationRule> rules) {
        validationRules = rules;
    }

    public void validate(Product product) {
        validationRules.forEach(s -> s.validate(product));
    }
}
