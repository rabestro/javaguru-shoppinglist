package com.javaguru.shoppinglist.console;

import com.javaguru.shoppinglist.domain.Category;
import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.service.ProductService;
import com.javaguru.shoppinglist.service.ShoppingCartService;

import java.math.BigDecimal;
import java.util.Scanner;

public class ConsoleUI {
    final private ProductService productService = new ProductService();
    final private ShoppingCartService shoppingCartService = new ShoppingCartService();
    final private Scanner scanner = new Scanner(System.in);

    public void execute() {
        do {
            try {
                System.out.println("1. Create product");
                System.out.println("2. Find product by id");
                System.out.println("3. Create Shopping Cart");
                System.out.println("0. Exit");

                final int userInput = scanner.nextInt();
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                switch (userInput) {
                    case 1:
                        createProduct();
                        break;
                    case 2:
                        findProduct();
                        break;
                    case 3:
                        createShoppingCart();
                        break;
                    case 0:
                        scanner.close();
                        return;
                }
            } catch (Exception e) {
                System.out.println("Error! Please try again.");
                System.out.println(e.getMessage());
            }
        } while (true);
    }

    private void createShoppingCart() {
        System.out.println("Enter Shopping Cart name: ");
        String name = scanner.nextLine();
        shoppingCartService.createShoppingCart(name);
    }

    void createProduct() {
        System.out.println("Enter product name: ");
        String name = scanner.nextLine();

        System.out.println("Enter product description: ");
        String description = scanner.nextLine();

        System.out.print("Enter product price: ");
        BigDecimal price = new BigDecimal(scanner.nextLine());

        System.out.print("Enter product discount: ");
        BigDecimal discount = new BigDecimal(scanner.nextLine());

        System.out.print("Enter product Category: ");
        Category category = Category.valueOf(scanner.nextLine().strip().toUpperCase());

        Product product = new Product();
        product.setName(name);
        product.setPrice(price);
        product.setDescription(description);
        product.setDiscount(discount);
        product.setCategory(category);

        Long id = productService.createProduct(product);
        System.out.println("Result: " + id);
    }

    private void findProduct() {
        System.out.println("Enter task id: ");
        Long id = scanner.nextLong();
        Product product = productService.findProductById(id);
        System.out.println(product);
    }
}
