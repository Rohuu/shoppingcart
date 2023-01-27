package shoppingcart;

import java.util.ArrayList;
import java.util.List;

import com.google.common.base.Objects;

public class ShoppingCart {

    private List<LineItem> itemsInCart = new ArrayList<>();
    private final Inventory inventory;

    public ShoppingCart(Inventory inventory) {
        this.inventory = inventory;
    }

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

    public void removeItem(LineItem lineItemToRemove) {
        boolean deleteLineItem = false;
        for (LineItem itemInCart : itemsInCart) {
            if (Objects.equal(itemInCart.getItemId(), lineItemToRemove.getItemId())) {
                if (lineItemToRemove.getQuantity() == itemInCart.getQuantity()) {
                    deleteLineItem = true;
                } else {
                    itemInCart.reduceQuantityBy(lineItemToRemove.getQuantity());
                }
            }
        }
        if (deleteLineItem == true) {
            this.itemsInCart.remove(lineItemToRemove);
        }
    }

}