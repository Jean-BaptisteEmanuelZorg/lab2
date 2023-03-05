package FlowerStore;

import java.util.*;

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

    public List<Item> compileBouquet(BouquetConfiguration configuration, List<Item> base){

        // define configurations

        List<Item> bouquet= new ArrayList<>();
        String color = configuration.getColor();
        int lowerBound = configuration.getPriceRange().getLowerBound();
        int upperBound = configuration.getPriceRange().getUpperBound();
        List<String> flower = configuration.getFlowers();
        int count = configuration.getCount();

        // logic

        int flowerTypeCount = count / flower.size();

        for (Item tempFlower : base) {
            for (String f : flower) {
                if (tempFlower.getItemName() == f && tempFlower.getColor() == color) {
                    bouquet.add(tempFlower);
                }
            }
        }

        return bouquet;
    }

}
