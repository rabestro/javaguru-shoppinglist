package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.domain.Product;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
    void testProductIsNull() {
        productOne = null;
        var e = Assertions.assertThrows(ProductValidationException.class, () ->
                validationRule.validate(productOne)
        );
        assertEquals("Product must be not null", e.getMessage());
    }

    @Test
    void testProductPriceIsNull() {
        productOne.setPrice(null);
        var e = Assertions.assertThrows(ProductValidationException.class, () ->
                validationRule.validate(productOne)
        );
        assertEquals("Product price must be not null.", e.getMessage());
    }

    @Test
    void testProductPriceIsZero() {
        productOne.setPrice(new BigDecimal(0));
        var e = Assertions.assertThrows(ProductValidationException.class, () ->
                validationRule.validate(productOne)
        );
        assertEquals("Price must be nonzero positive", e.getMessage());
    }

    @Test
    void testProductPriceIsNegative() {
        productOne.setPrice(new BigDecimal(-1));
        var e = Assertions.assertThrows(ProductValidationException.class, () ->
                validationRule.validate(productOne)
        );
        assertEquals("Price must be nonzero positive", e.getMessage());
    }

    @Test /* no exception expected */
    void testProductPriceIsPositive() {
        productOne.setPrice(new BigDecimal(1));
        validationRule.validate(productOne);
    }
}