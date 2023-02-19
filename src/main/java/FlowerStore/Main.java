package FlowerStore;


import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        ItemManager list = new ItemManager();
        list.addItem(new BouquetFlower(BouquetFlowerType.ROSE, 55, "special", "blue"));
        list.addItem(new BouquetFlower(BouquetFlowerType.TULIP, 35, "fine", "purple"));
        list.addItem(new BouquetFlower(BouquetFlowerType.DAISY, 44, "average", "white"));
        System.out.println(list.toString());
        list.sortByField("itemName", SortOrder.ASC);
        System.out.println(list.toString());
        list.sortByField("itemName", SortOrder.DESC);
        System.out.println(list.toString());
    }
}
