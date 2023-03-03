package FlowerStore;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ItemManager list = new ItemManager();
        list.addItem(new BouquetFlower(BouquetFlowerType.ROSE, 55, "special", "blue"));
        list.addItem(new BouquetFlower(BouquetFlowerType.ROSE, 50, "great", "red"));
        list.addItem(new BouquetFlower(BouquetFlowerType.ROSE, 50, "great", "red"));
        list.addItem(new BouquetFlower(BouquetFlowerType.ROSE, 50, "great", "red"));
        list.addItem(new BouquetFlower(BouquetFlowerType.ROSE, 50, "great", "pink"));
        list.addItem(new BouquetFlower(BouquetFlowerType.ROSE, 50, "great", "pink"));
        list.addItem(new BouquetFlower(BouquetFlowerType.TULIP, 35, "fine", "red"));
        list.addItem(new BouquetFlower(BouquetFlowerType.DAISY, 44, "average", "white"));
        list.addItem(new BouquetFlower(BouquetFlowerType.IRIS, 62, "great", "purple"));
        list.addItem(new BouquetFlower(BouquetFlowerType.PEONY, 70, "perfect", "pink"));
        System.out.println(list.toString());
        /*list.sortByField("itemName", SortOrder.ASC);
        System.out.println(list.toString());
        list.sortByField("price", SortOrder.DESC);
        System.out.println(list.toString());*/
        ItemManager manager = new ItemManager();
        manager.compileBouquet(new BouquetConfiguration("red", new PriceRange(0, 50), Arrays.asList("ROSE", "TULIP", "DAISY"), 3, "blue paper"), list.getItems());
        System.out.println(manager.toString());
    }
}
