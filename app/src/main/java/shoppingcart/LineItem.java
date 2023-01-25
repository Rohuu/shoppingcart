package shoppingcart;

public class LineItem {
    private Item item;
    private int quantity;

    public LineItem(Item item) {
        this(item, 1);
    }

    public LineItem(Item item, int quantity) {
        this.item = item;
        this.quantity = quantity;
    }

    public Item getItem() {
        return item;
    }

    public int getQuantity() {
        return quantity;
    }

}
