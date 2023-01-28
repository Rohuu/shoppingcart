package shoppingcart;

import java.math.BigDecimal;

public class LineItem {
    private String itemId;
    private int quantity;
    private BigDecimal price;
    private String name;

    public String getName() {
        return name;
    }

    public LineItem(String string) {
        this(string, 1);
    }

    public LineItem(String itemId, int quantity) {
        this.itemId = itemId;
        this.quantity = quantity;
    }

    public String getItemId() {
        return itemId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((itemId == null) ? 0 : itemId.hashCode());
        result = prime * result + quantity;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        LineItem other = (LineItem) obj;
        if (itemId == null) {
            if (other.itemId != null)
                return false;
        } else if (!itemId.equals(other.itemId))
            return false;
        if (quantity != other.quantity)
            return false;
        return true;
    }

    public void reduceQuantityBy(int quantityToReduceBy) {
        this.quantity -= quantityToReduceBy;
    }

    public BigDecimal getPrice() {
        return price.multiply(BigDecimal.valueOf(quantity));
    }

}
