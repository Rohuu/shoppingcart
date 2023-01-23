package shoppingcart;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

    private List<Item> itemsInCart = new ArrayList<>();

    public ShoppingCart() {
    }

    public ShoppingCart(List<Item> items) {
        this.itemsInCart = items;
    }

    public List<Item> getItems() {
        return itemsInCart;
    }

    public void addItem(Item item) {
        this.itemsInCart.add(item);
    }

    public int totalNumberOfItems() {
        return itemsInCart.size();
    }

}