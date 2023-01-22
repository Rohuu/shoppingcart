package shoppingcart;

import java.math.BigDecimal;

public class Item {

    private final BigDecimal price;
    private final ItemType itemType;
    private final String name;
    private final String id;

    public Item(String id, String name, ItemType itemType, BigDecimal price) {
        this.id = id;
        this.name = name;
        this.itemType = itemType;
        this.price = price;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public ItemType getItemType() {
        return itemType;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

}
