package shoppingcart;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;

import org.junit.Test;

public class ShoppingCartTest {
    @Test
    public void should_add_an_item_to_a_cart() {
        ShoppingCart cart = new ShoppingCart();
        cart.addItem(new Item("item-1", "Effectice Java", ItemType.BOOK, BigDecimal.valueOf(4000)));
        int totalItemCount = cart.totalNumberOfItems();
        assertThat(totalItemCount).isEqualTo(1);
    }
}
