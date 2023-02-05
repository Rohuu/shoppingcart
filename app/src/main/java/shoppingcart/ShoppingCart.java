package shoppingcart;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.google.common.base.Objects;

public class ShoppingCart {

    private final List<LineItem> itemsInCart = new ArrayList<>();
    private final Inventory inventory;

    public ShoppingCart(Inventory inventory) {
        this.inventory = inventory;
    }

    public void addItem(LineItem lineItem) {
        boolean isItemAlreadyPresent = isItemPresntInCart(lineItem.getItemId());
        if (isItemAlreadyPresent) {
            for (LineItem existingItem : itemsInCart) {
                if (existingItem.getItemId().equals(lineItem.getItemId())) {
                    existingItem.setQuantity(existingItem.getQuantity() + lineItem.getQuantity());
                    return;
                }
            }
        }

        Item item = inventory.get(lineItem.getItemId());
        if (item == null) {
            throw new IllegalArgumentException("Item with given itemId does not exist in inventory");
        }
        lineItem.setName(item.getName());
        lineItem.setPrice(item.getPrice());
        this.itemsInCart.add(lineItem);
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
        for (LineItem lineItem : itemsInCart) {
            if (Objects.equal(lineItem.getItemId(), lineItemToRemove.getItemId())) {
                if (lineItemToRemove.getQuantity() == lineItem.getQuantity()) {
                    deleteLineItem = true;
                } else {
                    lineItem.reduceQuantityBy(lineItemToRemove.getQuantity());
                }
            }
        }

        if (deleteLineItem) {
            this.itemsInCart.remove(lineItemToRemove);
        }
    }

    public List<LineItem> listItemsInCart() {
        return Collections.unmodifiableList(this.itemsInCart);
    }

    @Override
    public String toString() {
        return "ShoppingCart{" +
                "itemsInCart=" + itemsInCart +
                '}';
    }

    public boolean isItemPresntInCart(String itemId) {
        for (LineItem lineitem : itemsInCart) {
            if (lineitem.getItemId().equals(itemId)) {
                return true;
            }
        }
        return false;
    }
}