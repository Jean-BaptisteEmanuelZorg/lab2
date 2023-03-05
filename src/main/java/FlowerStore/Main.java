package FlowerStore;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ItemManager manager = new ItemManager();
        manager.addItem(new BouquetFlower(BouquetFlowerType.ROSE, 55, "special", "blue"));
        manager.addItem(new BouquetFlower(BouquetFlowerType.ROSE, 50, "great", "red"));
        manager.addItem(new BouquetFlower(BouquetFlowerType.ROSE, 50, "great", "red"));
        manager.addItem(new BouquetFlower(BouquetFlowerType.ROSE, 50, "great", "red"));
        manager.addItem(new BouquetFlower(BouquetFlowerType.ROSE, 50, "great", "pink"));
        manager.addItem(new BouquetFlower(BouquetFlowerType.ROSE, 50, "great", "pink"));
        manager.addItem(new BouquetFlower(BouquetFlowerType.TULIP, 35, "fine", "red"));
        manager.addItem(new BouquetFlower(BouquetFlowerType.DAISY, 44, "average", "white"));
        manager.addItem(new BouquetFlower(BouquetFlowerType.IRIS, 62, "great", "purple"));
        manager.addItem(new BouquetFlower(BouquetFlowerType.PEONY, 70, "perfect", "pink"));

        BouquetConfiguration bouquetConfiguration = new BouquetConfiguration("red",
                new PriceRange(0, 500),
                Arrays.asList("ROSE", "TULIP", "DAISY"),
                9,
                "blue paper"
        );

        List<Item> bouquetProposal =  manager.compileBouquet(bouquetConfiguration,
                manager.getItems());

        System.out.println(bouquetProposal);
    }
}
