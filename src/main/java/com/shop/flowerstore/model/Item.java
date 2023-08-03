package com.shop.flowerstore.model;


import jakarta.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;


public class Item {
    private String name;
    @Range(min = 0, message = "Price can't be below 0")
    private int price;
    @NotEmpty(message = "Please enter description")
    private String description;

    public Item(String name, int price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

