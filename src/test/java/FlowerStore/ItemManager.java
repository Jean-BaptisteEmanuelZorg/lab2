package FlowerStore;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class ItemManagerTest {
    static ItemManager manager = new ItemManager();

    @BeforeEach
    public void addingItemsTest() {

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

    }

    @Test
    public void addedItemTest() {
        assertFalse(manager.getItems().isEmpty());
    }

    @Test
    public void removeItemById() {
        Item testItem = manager.getItemById(1);
        manager.removeItemById(0);
        assertEquals(testItem, manager.getItemById(0));
    }

    @Nested
    class SortByFieldTest {
        @Test
        public void sortByNameAscTest() {
            List<Item> names = manager.getItems().stream()
                    .sorted((n1, n2) -> n1.getName().compareTo(n2.getName()))
                    .collect(Collectors.toList());
            List<Item> sortedByName = manager.sortByField("name", false);
            for (int i = 0; i < sortedByName.size(); i++) {
                assertEquals(names.get(i).getName(), sortedByName.get(i).getName());
            }
        }

        @Test
        public void sortByNameDescTest() {
            List<Item> names = manager.getItems().stream()
                    .sorted((n1, n2) -> n2.getName().compareTo(n1.getName()))
                    .collect(Collectors.toList());
            List<Item> sortedByName = manager.sortByField("name", true);
            for (int i = 0; i < sortedByName.size(); i++) {
                assertEquals(names.get(i).getName(), sortedByName.get(i).getName());
            }
        }

        @Test
        public void sortByPriceAscTest() {
            List<Item> prices = manager.getItems().stream()
                    .sorted((n1, n2) -> n1.getPrice() - (n2.getPrice()))
                    .collect(Collectors.toList());
            List<Item> sortedByPrice = manager.sortByField("price", false);
            for (int i = 0; i < sortedByPrice.size(); i++) {
                assertEquals(prices.get(i).getPrice(), (sortedByPrice.get(i).getPrice()));
            }
        }

        @Test
        public void sortByPriceDescTest() {
            List<Item> prices = manager.getItems().stream()
                    .sorted((n1, n2) -> n2.getPrice() - (n1.getPrice()))
                    .collect(Collectors.toList());
            List<Item> sortedByPrice = manager.sortByField("price", true);
            for (int i = 0; i < sortedByPrice.size(); i++) {
                assertEquals(prices.get(i).getPrice(), (sortedByPrice.get(i).getPrice()));
            }
        }

        @Test
        public void sortByDescriptionAscTest() {
            List<Item> descriptions = manager.getItems().stream()
                    .sorted((n1, n2) -> n1.getDescription().compareTo(n2.getDescription()))
                    .collect(Collectors.toList());
            List<Item> sortedByDescription = manager.sortByField("description", false);
            for (int i = 0; i < sortedByDescription.size(); i++) {
                assertEquals(descriptions.get(i).getDescription(), sortedByDescription.get(i).getDescription());
            }
        }

        @Test
        public void sortByDescriptionDescTest() {
            List<Item> descriptions = manager.getItems().stream()
                    .sorted((n1, n2) -> n2.getDescription().compareTo(n1.getDescription()))
                    .collect(Collectors.toList());
            List<Item> sortedByDescription = manager.sortByField("description", true);
            for (int i = 0; i < sortedByDescription.size(); i++) {
                assertEquals(descriptions.get(i).getDescription(), sortedByDescription.get(i).getDescription());
            }
        }
    }

    @Nested
    class CompileBouquetTest {
        BouquetConfiguration bouquetConfiguration = new BouquetConfiguration("red",
                new PriceRange(333, 500),
                Arrays.asList("ROSE", "TULIP", "DAISY"),
                9,
                "blue paper"
        );
        List<BouquetFlower> bouquetProposal = manager.compileBouquet(bouquetConfiguration,
                manager.getItems());

        @Test
        public void compileBouquetUpperBoundFitTest() {
            int totalPrice = 0;
            for (BouquetFlower flower : bouquetProposal) {
                totalPrice += flower.getPrice();
            }
            assertTrue(bouquetConfiguration.getPriceRange().getUpperBound() >= totalPrice);
        }

        @Test
        public void compileBouquetLowerBoundFitTest() {
            int totalPrice = 0;
            for (BouquetFlower flower : bouquetProposal) {
                totalPrice += flower.getPrice();
            }
            assertTrue(bouquetConfiguration.getPriceRange().getLowerBound() <= totalPrice);
        }

        @Test
        public void compileBouquetFlowerCountTest() {
            assertEquals(bouquetConfiguration.getCount(), bouquetProposal.size());
        }

        @Test
        public void compileBouquetReplacerTest() {

        }
    }
}
