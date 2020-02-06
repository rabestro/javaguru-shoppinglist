package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.domain.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.*;

class ProductDiscountValidationRuleTest {
    Product productOne;
    ProductDiscountValidationRule validationRule;

    @BeforeEach
    void setUp() {
        productOne = new Product();
        productOne.setPrice(new BigDecimal(50));
        validationRule = new ProductDiscountValidationRule();
    }

    @Test
    void testProductIsNull() {
        productOne = null;
        var e = assertThrows(ProductValidationException.class, () ->
                validationRule.validate(productOne)
        );
        assertEquals("Product must be not null", e.getMessage());
    }

    @Test
    void testProductDiscountIsNull() {
        productOne.setDiscount(null);
        var e = assertThrows(ProductValidationException.class, () ->
                validationRule.validate(productOne)
        );
        assertEquals("Product discount must be not null.", e.getMessage());
    }

    @Test
    void testProductDiscountIsTooBig() {
        productOne.setDiscount(new BigDecimal("100.01"));
        var e = assertThrows(ProductValidationException.class, () ->
                validationRule.validate(productOne)
        );
        assertEquals("The discount cannot exceed the 100%", e.getMessage());
    }

    @Test
    void testProductDiscountIsNegative() {
        productOne.setDiscount(new BigDecimal(-1));
        var e = assertThrows(ProductValidationException.class, () ->
                validationRule.validate(productOne)
        );
        assertEquals("The discount cannot be less then 0%", e.getMessage());
    }

    @Test
    void testProductDiscountLowPrice() {
        productOne.setPrice(new BigDecimal(15));
        productOne.setDiscount(new BigDecimal(10));
        var e = assertThrows(ProductValidationException.class, () ->
                validationRule.validate(productOne)
        );
        assertEquals("The discount can not be applied if price is below 20", e.getMessage());
    }

    @Test /* no exception expected */
    void testProductDiscountIsOk() {
        productOne.setPrice(new BigDecimal(35));
        productOne.setDiscount(new BigDecimal(10));
        validationRule.validate(productOne);
    }
}