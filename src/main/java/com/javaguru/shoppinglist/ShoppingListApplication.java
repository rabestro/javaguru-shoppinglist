package com.javaguru.shoppinglist;

import com.javaguru.shoppinglist.console.ConsoleUI;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

class ShoppingListApplication {

    public static void main(String[] args) {

        final var context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
        final var consoleUI = context.getBean(ConsoleUI.class);
        consoleUI.execute();
    }
}
