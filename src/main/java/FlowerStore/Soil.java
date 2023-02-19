package FlowerStore;

public class Soil extends Item{
    private double acidity;
    private String components;
    private int volume;
    private int weight;
    private SoilType soilType;

    public Soil(String itemName, int price, String description, double acidity, String components, int volume, int weight, SoilType soilType) {
        super(itemName, price, description);
        this.acidity = acidity;
        this.components = components;
        this.volume = volume;
        this.weight = weight;
        this.soilType = soilType;
    }
}
