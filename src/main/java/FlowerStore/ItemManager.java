package FlowerStore;

import org.slf4j.*;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class ItemManager {
    private List<Item> items;
    private static final Logger log = LoggerFactory.getLogger(ItemManager.class);
    private static final Map<String, Comparator<Item>> LIST_COMPARATOR = new HashMap<>();


    static {
        LIST_COMPARATOR.put("name", (i1, i2) -> (i1.getName().compareTo(i2.getName())));
        LIST_COMPARATOR.put("price", (i1, i2) -> i1.getPrice() - i2.getPrice());
        LIST_COMPARATOR.put("description", (i1, i2) -> (i1.getDescription().compareTo(i2.getDescription())));
    }

    public ItemManager() {

        this.items = new ArrayList<>();
    }

    public void addItem(Item item) {
        this.items.add(item);
    }

    public void removeItemById(Integer id) {
        this.items.remove(this.items.get(id));

    }

    public Item getItemById(Integer id) {
        return this.items.get(id);
    }

    public List<Item> getItems() {
        return items;
    }

    @Override
    public String toString() {
        return "ItemManager\n\n" +
                "items:\n" + items.toString();
    }

    public List<Item> sortByField(String field, boolean reverse) {
        Comparator<Item> comparator = LIST_COMPARATOR.get(field);
        this.items.sort(comparator);
        if (reverse) {
            Collections.reverse(this.items);
        }
        return this.items;
    }

    public List<BouquetFlower> compileBouquet(BouquetConfiguration configuration, List<Item> base) {

        List<BouquetFlower> baseFlowers = base.stream()
                .filter(item -> item instanceof BouquetFlower)
                .map(item -> (BouquetFlower) item)
                .collect(Collectors.toList());
        List<BouquetFlower> bouquetFlowers = new ArrayList<>();
        String color = configuration.getColor();
        int lowerBound = configuration.getPriceRange().getLowerBound();
        int upperBound = configuration.getPriceRange().getUpperBound();
        List<String> flowers = configuration.getFlowers();
        int count = configuration.getCount();
        int flowerTypeCount = count / flowers.size();
        AtomicInteger priceTotal = new AtomicInteger();


        bouquetFlowers = flowers.stream()
                .map(f -> baseFlowers.stream()
                        .filter(b -> b.getName().equals(f) && b.getColor().equals(color))
                        .limit(flowerTypeCount)
                        .peek(b -> priceTotal.addAndGet(b.getPrice()))
                        .collect(Collectors.toList()))
                .flatMap(Collection::stream)
                .collect(Collectors.toList());

        log.info("{}", bouquetFlowers);

        Comparator<Item> comparator = LIST_COMPARATOR.get("price");
        bouquetFlowers.sort(comparator.reversed());
        baseFlowers.sort(comparator.reversed());

        int loopCounter = 0;
        while (priceTotal.get() > upperBound) {
            for (BouquetFlower bouquetFlower : bouquetFlowers) {
                for (BouquetFlower tempFlower : baseFlowers) {
                    if (bouquetFlower.getPrice() > tempFlower.getPrice()) {
                        bouquetFlowers.set(bouquetFlowers.indexOf(bouquetFlower), tempFlower);
                        priceTotal.addAndGet(-bouquetFlower.getPrice());
                        priceTotal.addAndGet(tempFlower.getPrice());
                        baseFlowers.remove(tempFlower);
                        log.trace("priceTotal - {}", priceTotal);
                        break;
                    }
                }
                if (priceTotal.get() < upperBound) {
                    break;
                }
            }
            loopCounter++;
            if (loopCounter == count) {
                break;
            }
        }
        return bouquetFlowers;
    }
}
