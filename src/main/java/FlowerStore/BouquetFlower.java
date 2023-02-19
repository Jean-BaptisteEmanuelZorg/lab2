package FlowerStore;

public class BouquetFlower extends Item {
    private BouquetFlowerType itemName;
    private String color;

    public BouquetFlower(BouquetFlowerType itemName, int price, String description,String color) {
        super(String.valueOf(itemName), price, description);
        this.itemName = itemName;
        this.color = color;
    }

    @Override
    public String getItemName() {
        return String.valueOf(itemName);
    }

    public void setItemName(BouquetFlowerType itemName) {
        this.itemName = itemName;
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
        builder.append(this.getItemName()).append(" ");
        builder.append(this.getPrice()).append(" ");
        builder.append(this.getDescription()).append(" ");
        builder.append(this.getColor()).append("");
        return builder.toString();
    }

}
