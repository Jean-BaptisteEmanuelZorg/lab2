package FlowerStore;

public class HousePlant extends Item{
    private int lifetime;
    private boolean sunLoving;
    private HousePlantType plantType;

    public HousePlant(String itemName, int price, String description, int lifetime, boolean sunLoving, HousePlantType plantType) {
        super(itemName, price, description);
        this.lifetime = lifetime;
        this.sunLoving = sunLoving;
        this.plantType = plantType;
    }
}
