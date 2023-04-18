package FlowerStore;


import org.slf4j.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    private static final Logger log = LoggerFactory.getLogger(Main.class);
    public static void main(String[] args) {
        ItemManager manager = new ItemManager();
        manager.addItem(new BouquetFlower(BouquetFlowerType.ROSE, 55, "special", "blue"));
        manager.addItem(new BouquetFlower(BouquetFlowerType.ROSE, 50, "great", "red"));
        manager.addItem(new BouquetFlower(BouquetFlowerType.ROSE, 50, "great", "red"));
        manager.addItem(new BouquetFlower(BouquetFlowerType.ROSE, 50, "great", "red"));
        manager.addItem(new BouquetFlower(BouquetFlowerType.ROSE, 50, "great", "red"));
        manager.addItem(new BouquetFlower(BouquetFlowerType.ROSE, 50, "great", "red"));
        manager.addItem(new BouquetFlower(BouquetFlowerType.ROSE, 50, "great", "pink"));
        manager.addItem(new BouquetFlower(BouquetFlowerType.ROSE, 50, "great", "pink"));
        manager.addItem(new BouquetFlower(BouquetFlowerType.TULIP, 155, "fine", "red"));
        manager.addItem(new BouquetFlower(BouquetFlowerType.TULIP, 155, "fine", "red"));
        manager.addItem(new BouquetFlower(BouquetFlowerType.TULIP, 155, "fine", "red"));
        manager.addItem(new BouquetFlower(BouquetFlowerType.DAISY, 44, "average", "white"));
        manager.addItem(new BouquetFlower(BouquetFlowerType.DAISY, 44, "average", "red"));
        manager.addItem(new BouquetFlower(BouquetFlowerType.DAISY, 44, "average", "red"));
        manager.addItem(new BouquetFlower(BouquetFlowerType.DAISY, 44, "average", "red"));
        manager.addItem(new BouquetFlower(BouquetFlowerType.DAISY, 44, "average", "red"));
        manager.addItem(new BouquetFlower(BouquetFlowerType.IRIS, 62, "great", "purple"));
        manager.addItem(new BouquetFlower(BouquetFlowerType.PEONY, 70, "perfect", "pink"));
        manager.addItem(new HousePlant("plant", 55, "description", 5, true, HousePlantType.CITRUS));
        manager.addItem(new Pot("vase", 45, "some vase", 20, 40, 99, "glass"));
        manager.addItem(new Soil("dirt", 78, "some soil", 4.5, "1,2,3", 5, 5, SoilType.UNIVERSAL));

        BouquetConfiguration bouquetConfiguration = new BouquetConfiguration("red",
                new PriceRange(333, 500),
                Arrays.asList("ROSE", "TULIP", "DAISY"),
                9,
                "blue paper"
        );
        List<BouquetFlower> bouquetProposal =  manager.compileBouquet(bouquetConfiguration,
                manager.getItems());
        log.info("{}", bouquetProposal);

    }
}
