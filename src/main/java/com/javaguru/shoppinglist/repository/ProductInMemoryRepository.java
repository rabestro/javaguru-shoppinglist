package com.javaguru.shoppinglist.repository;

import com.javaguru.shoppinglist.domain.Product;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class ProductInMemoryRepository {
    private static Long PRODUCT_ID_SEQUENCE = 0L;
    private final Map<Long, Product> productMap = new HashMap<>();

    public ProductInMemoryRepository() {
    }

    public Product insert(Product product) {
        product.setId(PRODUCT_ID_SEQUENCE);
        productMap.put(PRODUCT_ID_SEQUENCE, product);
        PRODUCT_ID_SEQUENCE++;
        return product;
    }

    public Product findProductById(Long id) {
        return productMap.get(id);
    }

    public boolean containsProductName(String name) {
        return productMap.entrySet().stream().anyMatch(p -> p.getValue().getName().equals(name));
    }
}
