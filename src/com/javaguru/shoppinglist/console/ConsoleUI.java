package com.javaguru.shoppinglist.console;

import java.util.Scanner;

public class ConsoleUI {

    public void execute() {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            try {
                System.out.println("1. Create task");
                System.out.println("2. Find task by id");
                System.out.println("3. Exit");
                int userInput = scanner.nextInt();
                switch (userInput) {
                    case 1:
                        //createTask();
                        break;
                    case 2:
                        //findTask();
                        break;
                    case 3:
                        return;
                }
            } catch (Exception e) {
                System.out.println("Error! Please try again.");
            }
        }
    }
}
