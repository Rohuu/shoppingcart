package shoppingcart;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

    List<Item> items = new ArrayList<>();

    public ShoppingCart() {
    }

    public ShoppingCart(List<Item> items) {
        this.items = items;
    }

    public List<Item> getItems() {
        return items;
    }

    public void add(Item item) {

    }

}