package FlowerStore;

import java.util.List;

public class BouquetConfiguration {
    private String color;
    private PriceRange priceRange;
    private List<String> flowers;
    private String paper;

    public BouquetConfiguration(String color, PriceRange priceRange, List<String> flowers, String paper) {
        this.color = color;
        this.priceRange = priceRange;
        this.flowers = flowers;
        this.paper = paper;
    }
}
