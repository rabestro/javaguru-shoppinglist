package com.javaguru.shoppinglist.dihelper;

import com.javaguru.shoppinglist.console.ConsoleUI;
import com.javaguru.shoppinglist.repository.ProductInMemoryRepository;
import com.javaguru.shoppinglist.service.ProductService;
import com.javaguru.shoppinglist.service.validation.ProductDiscountValidationRule;
import com.javaguru.shoppinglist.service.validation.ProductNameValidationRule;
import com.javaguru.shoppinglist.service.validation.ProductPriceValidationRule;
import com.javaguru.shoppinglist.service.validation.ProductValidationRule;
import com.javaguru.shoppinglist.service.validation.ProductValidationService;

import java.util.HashSet;

public class DiHelper {
    public static ConsoleUI createApplication() {
        final var repository = new ProductInMemoryRepository();

        final var rules = new HashSet<ProductValidationRule>();
        rules.add(new ProductNameValidationRule(repository));
        rules.add(new ProductDiscountValidationRule());
        rules.add(new ProductPriceValidationRule());
        final var productValidation = new ProductValidationService(rules);

        final var productService = new ProductService(repository, productValidation);
        final var consoleUI = new ConsoleUI(productService);

        return consoleUI;
    }
}
