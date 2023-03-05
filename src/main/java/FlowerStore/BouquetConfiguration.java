package FlowerStore;

import java.util.List;

public class BouquetConfiguration {
    private String color;
    private PriceRange priceRange;
    private List<String> flowers;
    private String paper;
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
