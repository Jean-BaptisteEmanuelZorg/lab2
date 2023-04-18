package FlowerStore;

public class BouquetFlower extends Item {
    private BouquetFlowerType name;
    private String color;

    public BouquetFlower(BouquetFlowerType name, int price, String description, String color) {
        super(String.valueOf(name), price, description);
        this.name = name;
        this.color = color;
    }

    @Override
    public String getName() {
        return String.valueOf(name);
    }

    public void setName(BouquetFlowerType name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(this.getName()).append(" ");
        builder.append(this.getPrice()).append(" ");
        builder.append(this.getDescription()).append(" ");
        builder.append(this.getColor()).append("\n");
        return builder.toString();
    }

}
