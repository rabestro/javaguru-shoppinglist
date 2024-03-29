package com.javaguru.shoppinglist.console;

import com.javaguru.shoppinglist.domain.Category;
import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.service.ProductService;
import com.javaguru.shoppinglist.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Scanner;

@Component
public class ConsoleUI {
    final private Scanner scanner = new Scanner(System.in);
    final private ProductService productService;
    final private ShoppingCartService shoppingCartService;

    @Autowired
    public ConsoleUI(ProductService service, ShoppingCartService shoppingCartService) {
        productService = service;
        this.shoppingCartService = shoppingCartService;
    }

    public void execute() {
        do {
            try {
                System.out.println("1. Create product");
                System.out.println("2. Find product by id");
                System.out.println("3. Create Shopping Cart");
                System.out.println("4. Add product to the Shopping Cart");
                System.out.println("5. Print Shopping Cart");
                System.out.println("6. Calculate total price");
                System.out.println("0. Exit");

                final int userInput = scanner.nextInt();
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                switch (userInput) {
                    case 1 -> createProduct();
                    case 2 -> findProduct();
                    case 3 -> createShoppingCart();
                    case 4 -> addProductToShoppingCart();
                    case 5 -> printShoppingCart();
                    case 6 -> calculateTotalPrice();
                    case 0 -> {
                        return;
                    }
                }
            } catch (Exception e) {
                System.out.println("Error! Please try again.");
                System.out.println(e.getMessage());
            }
        } while (true);
    }

    private void calculateTotalPrice() {
        System.out.println(shoppingCartService.calculatePrice());
    }

    private void printShoppingCart() {
        shoppingCartService.printShoppingCart();
    }

    private void addProductToShoppingCart() {
        System.out.println("Enter product id: ");
        Long id = scanner.nextLong();
        Product product = productService.findProductById(id);
        shoppingCartService.addProduct(product);
        System.out.println(product);
    }

    private void createShoppingCart() {
        System.out.println("Enter Shopping Cart name: ");
        String name = scanner.nextLine();
        shoppingCartService.createShoppingCart(name);
    }

    void createProduct() {
        System.out.println("Enter product name: ");
        var name = scanner.nextLine();

        System.out.println("Enter product description: ");
        var description = scanner.nextLine();

        System.out.print("Enter product price: ");
        var price = new BigDecimal(scanner.nextLine());

        System.out.print("Enter product discount: ");
        var discount = new BigDecimal(scanner.nextLine());

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
        System.out.println("Enter product id: ");
        Long id = scanner.nextLong();
        Product product = productService.findProductById(id);
        System.out.println(product);
    }
}
