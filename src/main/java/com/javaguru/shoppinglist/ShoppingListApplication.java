package com.javaguru.shoppinglist;

import com.javaguru.shoppinglist.console.ConsoleUI;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

class ShoppingListApplication {

    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
        var consoleUI = context.getBean(ConsoleUI.class);
        consoleUI.execute();
    }
}
