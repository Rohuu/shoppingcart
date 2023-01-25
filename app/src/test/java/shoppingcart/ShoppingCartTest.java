package shoppingcart;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;

import org.junit.Test;

public class ShoppingCartTest {
    @Test
    public void should_add_an_item_to_a_cart() {
        ShoppingCart cart = new ShoppingCart();
        cart.addItem(new LineItem(new Item("item-1", "Effectice Java", ItemType.BOOK, BigDecimal.valueOf(4000))));
        int totalItemCount = cart.totalNumberOfItems();
        assertThat(totalItemCount).isEqualTo(1);
    }

    @Test
    public void should_add_multiple_items_to_the_cart() {
        ShoppingCart cart = new ShoppingCart();
        cart.addItem(new LineItem(new Item("item-1", "Effectice Java", ItemType.BOOK, BigDecimal.valueOf(4000))));
        cart.addItem(new LineItem(new Item("item-2", "pen", ItemType.PEN, BigDecimal.valueOf(250))));
        int totalItemCount = cart.totalNumberOfItems();
        assertThat(totalItemCount).isEqualTo(2);
    }

    @Test
    public void should_add_multiple_quantity_of_the_same_item_to_the_cart() {
        ShoppingCart cart = new ShoppingCart();
        cart.addItem(new LineItem(new Item("item-1", "Effectice Java", ItemType.BOOK, BigDecimal.valueOf(4000)), 2));
        int totalItemCount = cart.totalNumberOfItems();
        assertThat(totalItemCount).isEqualTo(2);
    }
}
