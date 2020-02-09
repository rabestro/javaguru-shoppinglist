package com.javaguru.shoppinglist;

import com.javaguru.shoppinglist.console.ConsoleUI;
import com.javaguru.shoppinglist.repository.ProductInMemoryRepository;
import com.javaguru.shoppinglist.service.ProductService;
import com.javaguru.shoppinglist.service.validation.ProductValidationService;

class ShoppingListApplication {

    public static void main(String[] args) {
        final var repository = ProductInMemoryRepository.getInstance();
        final var validation = new ProductValidationService();
        final var productService = new ProductService(repository, validation);

        ConsoleUI consoleUI = new ConsoleUI(productService);
        consoleUI.execute();
    }
}
