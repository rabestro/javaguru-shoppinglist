package com.javaguru.shoppinglist.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Product {

    private Long id;
    private String name;
    private BigDecimal price;
    private String description;
    private BigDecimal discount;
    private Category category;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount.setScale(2, RoundingMode.HALF_EVEN);

    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        if (price.signum() == 1) {
            this.price = price;
        } else {
            throw new IllegalArgumentException("Price must be nonzero positive");
        }
    }
}