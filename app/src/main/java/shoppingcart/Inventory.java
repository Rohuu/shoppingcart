package shoppingcart;

import java.util.HashMap;
import java.util.Map;

public class Inventory {

    private final Map<String, Item> items = new HashMap<>();

    public void add(Item item) {
        this.items.put(item.getId(), item);
    }

    public Item get(String id) {
        return items.get(id);
    }

    @Override
    public String toString() {

        return "Inventory [items=" + items + "]";
    }

    public void remove(Item item) {
        this.items.remove(item.getId());
    }

    public boolean isItemPresentInInventory(String itemId) {
        return items.containsKey(itemId);
    }
}
