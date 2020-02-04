package com.javaguru.shoppinglist.domain;

import java.math.BigDecimal;

public class Product {

    private Long id;
    private String name;
    private BigDecimal price;
    private String description;
    private BigDecimal discount;

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
        if (discount.compareTo(new BigDecimal(100)) <= 0) {
            this.discount = discount;
        } else {
            throw new IllegalArgumentException("The discount cannot exceed the 100%");
        }
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    private Category category;

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
        if (name.length() >= 3 && name.length() <= 32) {
            this.name = name;
        } else {
            throw new IllegalArgumentException(
                    "The name cannot be shorter than 3 symbols or longer than 32 symbols");
        }
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