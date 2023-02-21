package FlowerStore;

import java.util.*;

public class ItemManager {
    private List<Item> items;

    public ItemManager() {

        this.items = new ArrayList<>();
    }

    public void addItem(Item item) {
        this.items.add(item);
    }
    public void removeItemById(Integer id) {
        this.items.remove(id);

    }

    @Override
    public String toString() {
        return "ItemManager\n\n" +
                "items:\n" + items.toString();
    }

    public void sortByField(String field, SortOrder order){
        switch (field){
            case "itemName":
                if (order.equals(SortOrder.ASC)) {
                    Collections.sort(this.items, (i1, i2) -> (i1.getItemName().compareTo(i2.getItemName())));
                    System.out.println("Sorted by itemName (ASC)");
                } else if (order.equals(SortOrder.DESC)) {
                    Collections.sort(this.items, (i1, i2) -> (i1.getItemName().compareTo(i2.getItemName())));
                    Collections.reverse(this.items);
                    System.out.println("Sorted by itemName (DESC)");
                }
                break;
            case "price":
                if (order.equals(SortOrder.ASC)) {
                    Collections.sort(this.items, (i1, i2) -> i1.getPrice() - i2.getPrice());
                    System.out.println("Sorted by price (ASC)");
                } else if (order.equals(SortOrder.DESC)) {
                    Collections.sort(this.items, (i1, i2) -> i1.getPrice() - i2.getPrice());
                    Collections.reverse(this.items);
                    System.out.println("Sorted by price (DESC)");
                }
                break;
            case "description":
                if (order.equals(SortOrder.ASC)) {
                    Collections.sort(this.items, (i1, i2) -> (i1.getDescription().compareTo(i2.getDescription())));
                    System.out.println("Sorted by description (ASC)");
                } else if (order.equals(SortOrder.DESC)) {
                    Collections.sort(this.items, (i1, i2) -> (i1.getDescription().compareTo(i2.getDescription())));
                    Collections.reverse(this.items);
                    System.out.println("Sorted by description (DESC)");
                }
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + field);
        }

    }

}
