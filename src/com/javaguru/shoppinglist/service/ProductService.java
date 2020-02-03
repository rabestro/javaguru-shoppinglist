package com.javaguru.shoppinglist.service;

import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.repository.ProductInMemoryRepository;
import com.javaguru.shoppinglist.service.validation.ProductValidationService;

public class ProductService {
    private ProductInMemoryRepository repository = new ProductInMemoryRepository();
    private ProductValidationService validationService = new ProductValidationService();

    public Long createTask(Product product) {
        validationService.validate(product);
        Product createdTask = repository.insert(product);
        return createdTask.getId();
    }
}
