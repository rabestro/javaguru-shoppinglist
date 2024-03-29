package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.domain.Product;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class ProductDiscountValidationRule implements ProductValidationRule {

    @Override
    public void validate(Product product) {
        checkNotNull(product);
        if (product.getDiscount() == null) {
            throw new ProductValidationException("Product discount must be not null.");
        }
        var isPriceBelow20 = product.getPrice().compareTo(new BigDecimal(20)) < 0;
        var isDiscount = product.getDiscount().signum() > 0;
        var isDiscountMore100 = product.getDiscount().compareTo(new BigDecimal(100)) > 0;

        if (product.getDiscount().signum() < 0) {
            throw new ProductValidationException("The discount cannot be less then 0%");
        } else if (isDiscountMore100) {
            throw new ProductValidationException("The discount cannot exceed the 100%");
        }

        if (isPriceBelow20 && isDiscount) {
            throw new ProductValidationException("The discount can not be applied if price is below 20");
        }
    }
}
