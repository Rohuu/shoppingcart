package shoppingcart;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

    private List<LineItem> itemsInCart = new ArrayList<>();

    // public ShoppingCart() {
    // }

    // public ShoppingCart(List<LineItem> lineItems) {
    // this.itemsInCart = lineItems;
    // }

    public List<LineItem> getItems() {
        return itemsInCart;
    }

    public void addItem(LineItem item) {
        this.itemsInCart.add(item);
    }

    public int totalNumberOfItems() {
        int totalItem = 0;
        for (LineItem lineItem : itemsInCart) {
            totalItem = totalItem + lineItem.getQuantity();
        }
        return totalItem;
    }

}