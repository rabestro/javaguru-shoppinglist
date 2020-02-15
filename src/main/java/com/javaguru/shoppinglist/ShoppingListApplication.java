package com.javaguru.shoppinglist;

import com.javaguru.shoppinglist.dihelper.DiHelper;

class ShoppingListApplication {

    public static void main(String[] args) {

        final var consoleUI = DiHelper.createApplication();
        consoleUI.execute();
    }
}
