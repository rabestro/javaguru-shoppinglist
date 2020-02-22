package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.domain.Product;
import org.springframework.stereotype.Service;
import java.util.Set;

@Service
public class ProductValidationService {

    private final Set<ProductValidationRule> validationRules;

    public ProductValidationService(Set<ProductValidationRule> rules) {
        validationRules = rules;
    }

    public void validate(Product product) {
        validationRules.forEach(s -> s.validate(product));
    }
}
