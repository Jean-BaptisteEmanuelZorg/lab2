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
                } else if (order.equals(SortOrder.DESC)) {
                    Collections.sort(this.items, (i1, i2) -> (i1.getItemName().compareTo(i2.getItemName())));
                    Collections.reverse(this.items);
                }
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + field);
        }

    }

}
