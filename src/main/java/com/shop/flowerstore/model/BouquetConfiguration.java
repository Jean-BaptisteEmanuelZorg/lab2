package com.shop.flowerstore.model;


import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;

public class BouquetConfiguration {
    private String color;
    private PriceRange priceRange;
    private List<String> flowers;
    private String paper;
    @NotNull(message = "Count can't be NULL")
    @Size(min = 2, max = 5, message = "Count must be 2-5")
    private int count;

    public BouquetConfiguration(String color, PriceRange priceRange, List<String> flowers, int count, String paper) {
        this.color = color;
        this.priceRange = priceRange;
        this.flowers = flowers;
        this.count = count;
        this.paper = paper;
    }

    public String getColor() {
        return color;
    }

    public PriceRange getPriceRange() {
        return priceRange;
    }

    public List<String> getFlowers() {
        return flowers;
    }

    public String getPaper() {
        return paper;
    }

    public int getCount() {
        return count;
    }
}
