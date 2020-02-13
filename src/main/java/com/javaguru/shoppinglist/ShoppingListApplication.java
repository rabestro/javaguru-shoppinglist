package com.javaguru.shoppinglist;

import com.javaguru.shoppinglist.console.ConsoleUI;
import com.javaguru.shoppinglist.repository.ProductInMemoryRepository;
import com.javaguru.shoppinglist.service.ProductService;
import com.javaguru.shoppinglist.service.validation.ProductDiscountValidationRule;
import com.javaguru.shoppinglist.service.validation.ProductNameValidationRule;
import com.javaguru.shoppinglist.service.validation.ProductPriceValidationRule;
import com.javaguru.shoppinglist.service.validation.ProductValidationRule;
import com.javaguru.shoppinglist.service.validation.ProductValidationService;

import java.util.HashSet;

class ShoppingListApplication {

    public static void main(String[] args) {
        final var repository = ProductInMemoryRepository.getInstance();

        final var rules = new HashSet<ProductValidationRule>();
        rules.add(new ProductNameValidationRule(repository));
        rules.add(new ProductDiscountValidationRule());
        rules.add(new ProductPriceValidationRule());
        final var productValidation = new ProductValidationService(rules);

        final var productService = new ProductService(repository, productValidation);
        final var consoleUI = new ConsoleUI(productService);
        consoleUI.execute();
    }
}
