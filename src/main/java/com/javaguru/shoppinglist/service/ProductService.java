package com.javaguru.shoppinglist.service;

import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.repository.ProductInMemoryRepository;
import com.javaguru.shoppinglist.service.validation.ProductValidationService;

public class ProductService {
    private final ProductInMemoryRepository repository = ProductInMemoryRepository.getInstance();
    private final ProductValidationService validationService = new ProductValidationService();

    public Long createProduct(Product product) {
        validationService.validate(product);
        final Product createdProduct = repository.insert(product);
        return createdProduct.getId();
    }

    public Product findProductById(Long id) {
        return repository.findProductById(id);
    }
}
