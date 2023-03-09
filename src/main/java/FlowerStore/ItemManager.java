package FlowerStore;

import java.util.*;
import java.util.stream.Collectors;

public class ItemManager {
    private List<Item> items;

    private static final Map<String, Comparator<Item>> LIST_COMPARATOR;

    static {
        final Map<String, Comparator<Item>>
                comparators = new HashMap<>();
        comparators.put("itemName", (i1, i2) -> (i1.getItemName().compareTo(i2.getItemName())));
        comparators.put("price", (i1, i2) -> i1.getPrice() - i2.getPrice());
        comparators.put("description", (i1, i2) -> (i1.getDescription().compareTo(i2.getDescription())));

        LIST_COMPARATOR = Collections.unmodifiableMap(comparators);
    }

    public ItemManager() {

        this.items = new ArrayList<>();
    }

    public void addItem(Item item) {
        this.items.add(item);
    }
    public void removeItemById(Integer id) {
        this.items.remove(id);

    }

    public List<Item> getItems() {
        return items;
    }


    @Override
    public String toString() {
        return "ItemManager\n\n" +
                "items:\n" + items.toString();
    }
    public void sortByField(String field, SortOrder order){
        Comparator<Item> comparator = LIST_COMPARATOR.get(field);
        if (order.equals(SortOrder.ASC)){
            Collections.sort(this.items, comparator);
        } else if (order.equals(SortOrder.DESC)){
            Collections.sort(this.items, comparator);
            Collections.reverse(this.items);
        }
    }

    public List<BouquetFlower> compileBouquet(BouquetConfiguration configuration, List<Item> base){

        // define configurations

        List<BouquetFlower> baseFlowers = base.stream()
                .filter(item -> item instanceof BouquetFlower)
                .map(item -> (BouquetFlower) item)
                .collect(Collectors.toList());
        List<BouquetFlower> bouquet= new ArrayList<>();
        String color = configuration.getColor();
        int lowerBound = configuration.getPriceRange().getLowerBound();
        int upperBound = configuration.getPriceRange().getUpperBound();
        List<String> flower = configuration.getFlowers();
        int count = configuration.getCount();
        int flowerTypeCount = count / flower.size();
        int priceTotal = 0;

        // logic

        for (String flowerType : flower) {
            int i = 0;
            for (BouquetFlower tempFlower : baseFlowers){
                if (tempFlower.getItemName() == flowerType && tempFlower.getColor() == color && i < flowerTypeCount) {
                        bouquet.add(tempFlower);
                        priceTotal += tempFlower.getPrice();
                        System.out.println(priceTotal);
                        i++;
                }
            }
        }
        Comparator<Item> comparator = LIST_COMPARATOR.get("price");
        Collections.sort(bouquet, comparator);
        Collections.reverse(bouquet);
        Collections.sort(baseFlowers, comparator);
        Collections.reverse(baseFlowers);

        int i = 0;
        while (priceTotal > upperBound){
            for (BouquetFlower bouquetFlower : bouquet){
                for (BouquetFlower tempFlower : baseFlowers){
                    if(bouquetFlower.getPrice() > tempFlower.getPrice()){
                        bouquet.set(bouquet.indexOf(bouquetFlower), tempFlower);
                        priceTotal -= bouquetFlower.getPrice();
                        priceTotal += tempFlower.getPrice();
                        baseFlowers.remove(tempFlower);
                        System.out.println(priceTotal);
                        System.out.println(bouquet);
                        break;
                    }
                }
                if(priceTotal < upperBound){
                    break;
                }
            }
            i++;
            if (i == count){
                break;
            }
        }
        return bouquet;
    }
}
