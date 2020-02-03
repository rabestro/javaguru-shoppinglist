package com.javaguru.shoppinglist;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class ShoppingListApplication {

    public static void main(String[] args) {
        Map<Long, Product> productRepository = new HashMap<>();
        Long productIdSequence = 0L;
        while (true) {
            Scanner scanner = new Scanner(System.in);
            try {
                System.out.println("1. Create product");
                System.out.println("2. Find product by id");
                System.out.println("3. Exit");
                Integer userInput = Integer.valueOf(scanner.nextLine());
                switch (userInput) {
                    case 1:
                        System.out.println("Enter product name: ");
                        String name = scanner.nextLine();
                        
                        System.out.println("Enter product description: ");
                        String description = scanner.nextLine();
                        
                        System.out.print("Enter product price: ");
                        BigDecimal price = scanner.nextBigDecimal();
                        
                        System.out.print("Enter product discount: ");
                        BigDecimal discount = scanner.nextBigDecimal();
                   
                        System.out.print("Enter product Category: ");
                        Category category = Category.valueOf(scanner.next().toUpperCase());
                        
                        Product product = new Product();
                        product.setName(name);
                        product.setPrice(price);
                        product.setDescription(description);
                        product.setDiscount(discount);
                        product.setCategory(category);

                        product.setId(productIdSequence);
                        productRepository.put(productIdSequence, product);
                        productIdSequence++;
                        System.out.println("Result: " + product.getId());
                        break;
                    case 2:
                        System.out.println("Enter product id: ");
                        long id = scanner.nextLong();
                        Product findProductResult = productRepository.get(id);
                        System.out.println(findProductResult);
                        break;
                    case 3:
                        return;
                }
            } catch (Exception e) {
                System.out.println("Error! Please try again.");
                System.out.println(e.getMessage());
            }
        }
    }
}
