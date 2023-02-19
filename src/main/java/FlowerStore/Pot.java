package FlowerStore;

public class Pot extends Item{
    private int diameter;
    private int height;
    private int volume;
    private String material;

    public Pot(String itemName, int price, String description, int diameter, int height, int volume, String material) {
        super(itemName, price, description);
        this.diameter = diameter;
        this.height = height;
        this.volume = volume;
        this.material = material;
    }
}
