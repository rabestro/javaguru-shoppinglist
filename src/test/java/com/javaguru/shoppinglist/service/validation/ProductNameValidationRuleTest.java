package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.repository.ProductInMemoryRepository;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Test of Product Name Validation")
@ExtendWith(MockitoExtension.class)
class ProductNameValidationRuleTest {
    Product productOne;
    ProductNameValidationRule validationRule;

    @Mock
    ProductInMemoryRepository repository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        productOne = new Product();
        validationRule = new ProductNameValidationRule(repository);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testProductNameIsNull() {
        productOne.setName(null);
        var e = Assertions.assertThrows(ProductValidationException.class, () ->
                validationRule.validate(productOne)
        );
        assertEquals("Product name must be not null.", e.getMessage());
    }

    @Test
    void testProductIsNull() {
        productOne = null;
        var e = Assertions.assertThrows(ProductValidationException.class, () ->
                validationRule.validate(productOne)
        );
        assertEquals("Product must be not null", e.getMessage());
    }

    @Test
    void testProductNameTooLong() {
        productOne.setName("x".repeat(33));
        var e = Assertions.assertThrows(ProductValidationException.class, () ->
                validationRule.validate(productOne)
        );
        assertEquals("The name cannot be longer than 32 symbols", e.getMessage());
    }

    @Test
    void testProductNameTooShort() {
        productOne.setName("Ab");
        var e = Assertions.assertThrows(ProductValidationException.class, () ->
                validationRule.validate(productOne)
        );
        assertEquals("The name cannot be shorter than 3 symbols", e.getMessage());
    }

    @Test /* no exception expected */
    public void testProductNameOk() {
        productOne.setName("Apple");
        validationRule.validate(productOne);
    }
}