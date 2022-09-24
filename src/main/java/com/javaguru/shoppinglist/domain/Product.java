package com.javaguru.shoppinglist.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Product {
    private static final BigDecimal HUNDRED = new BigDecimal(100);

    private Long id;
    private Category category;
    private String name;
    private String description;
    private BigDecimal price;
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
        this.discount = discount;
        if (discount != null) {
            this.discount = this.discount.setScale(2, RoundingMode.HALF_EVEN);
        }
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
        this.price = price;
    }

    public BigDecimal getActualPrice() {
        return price
                .multiply(HUNDRED.subtract(discount))
                .divide(HUNDRED, 2, RoundingMode.HALF_EVEN);
    }

    @Override
    public String toString() {
        return "Product{" + "id=" + id +
                ", category=" + category +
                ", description='" + description + '\'' +
                ", discount=" + discount +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}