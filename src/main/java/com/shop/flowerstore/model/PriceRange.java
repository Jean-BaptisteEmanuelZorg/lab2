package com.shop.flowerstore.model;

public class PriceRange {
    private int lowerBound;
    private int upperBound;

    public PriceRange(int lowerBound, int upperBound) {
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
    }

    public int getLowerBound() {
        return lowerBound;
    }

    public int getUpperBound() {
        return upperBound;
    }
}
