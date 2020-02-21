package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.domain.Product;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ProductPriceValidationRuleTest {
    Product productOne;
    ProductPriceValidationRule validationRule;

    @BeforeEach
    void setUp() {
        productOne = new Product();
        validationRule = new ProductPriceValidationRule();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    @DisplayName("Test that product is not null")
    void testProductIsNull() {
        productOne = null;
        var e = Assertions.assertThrows(ProductValidationException.class, () ->
                validationRule.validate(productOne)
        );
        assertEquals("Product must be not null", e.getMessage());
    }

    @Test
    @DisplayName("Test that product price is not null")
    void testProductPriceIsNull() {
        productOne.setPrice(null);
        var e = Assertions.assertThrows(ProductValidationException.class, () ->
                validationRule.validate(productOne)
        );
        assertEquals("Product price must be not null.", e.getMessage());
    }

    @ParameterizedTest
    @ValueSource(floats = {0, -2, -0.01f})
    @DisplayName("Test that product price has to be nonzero positive")
    void testProductPriceIsNonZeroPositive(float price) {
        productOne.setPrice(new BigDecimal(price));
        var e = Assertions.assertThrows(ProductValidationException.class, () ->
                validationRule.validate(productOne)
        );
        assertEquals("Price must be nonzero positive", e.getMessage());
    }

    @Test /* no exception expected */
    @DisplayName("Test that product price is Ok if positive")
    void testProductPriceIsPositive() {
        productOne.setPrice(new BigDecimal(1));
        validationRule.validate(productOne);
    }
}