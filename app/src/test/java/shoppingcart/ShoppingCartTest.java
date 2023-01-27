package shoppingcart;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

public class ShoppingCartTest {
    private Inventory inventory;
    private ShoppingCart cart;

    @Before
    public void setUp() throws Exception {
        Item item1 = new Item("item-1", "Effectice Java", ItemType.BOOK, BigDecimal.valueOf(4000));
        Item item2 = new Item("item-2", "pen", ItemType.PEN, BigDecimal.valueOf(250));
        inventory = new Inventory();
        inventory.add(item1);
        cart = new ShoppingCart(inventory);

    }

    @Test
    public void should_add_an_item_to_a_cart() {
        cart.addItem(new LineItem("item-1"));
        int totalItemCount = cart.totalNumberOfItems();
        assertThat(totalItemCount).isEqualTo(1);
    }

    @Test
    public void should_add_multiple_items_to_the_cart() {
        cart.addItem(new LineItem("item-1"));
        cart.addItem(new LineItem("item-2"));
        int totalItemCount = cart.totalNumberOfItems();
        assertThat(totalItemCount).isEqualTo(2);
    }

    @Test
    public void should_add_multiple_quantity_of_the_same_item_to_the_cart() {
        cart.addItem(new LineItem("item-1", 2));
        int totalItemCount = cart.totalNumberOfItems();
        assertThat(totalItemCount).isEqualTo(2);
    }

    @Test
    public void should_remove_an_item_from_cart() {
        cart.addItem(new LineItem("item-1"));
        cart.addItem(new LineItem("item-2"));

        cart.removeItem(new LineItem("item-1"));
        int totalItemCount = cart.totalNumberOfItems();
        assertThat(totalItemCount).isEqualTo(1);
    }

    @Test
    public void should_remove_specific_quantity_of_an_item_from_cart() {
        cart.addItem(new LineItem("item-1", 3));
        cart.addItem(new LineItem("item-2", 4));

        cart.removeItem(new LineItem("item-1", 2));
        cart.removeItem(new LineItem("item-2", 2));
        int totalItemCount = cart.totalNumberOfItems();
        assertThat(totalItemCount).isEqualTo(3);
    }

}
