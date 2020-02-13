package com.javaguru.shoppinglist.service;

import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.repository.ProductInMemoryRepository;
import com.javaguru.shoppinglist.service.validation.ProductValidationService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@DisplayName("Test of Product Services")
@ExtendWith(MockitoExtension.class)
class ProductServiceTest {
    Product testProduct;

    @Mock
    ProductInMemoryRepository repository;

    @Mock
    ProductValidationService validationService;

    @InjectMocks
    ProductService productService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        productService = new ProductService(repository, validationService);
        testProduct = new Product();
    }
    @DisplayName("Test of ProductServices.createProduct()")
    @Test
    void createProduct() {
        when(repository.insert(testProduct)).thenReturn(testProduct);
        productService.createProduct(testProduct);

        verify(validationService).validate(testProduct);
        verify(repository).insert(testProduct);
    }

    @DisplayName("Test of ProductServices.findProductById()")
    @Test
    void findProductById() {
        when(repository.findProductById(1l)).thenReturn(testProduct);
        assertEquals(testProduct, productService.findProductById(1l));
    }
}