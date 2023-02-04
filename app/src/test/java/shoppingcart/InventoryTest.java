
package shoppingcart;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;

import org.junit.Test;

public class InventoryTest {

    @Test
    public void should_return_true_if_item_is_present_in_inventory() {
        Inventory inventory = new Inventory();
        inventory.add(new Item("1", "java book", ItemType.BOOK, BigDecimal.valueOf(150)));

        boolean actual = inventory.isItemPresentInInventory("1");

        assertThat(actual).isEqualTo(true);
    }

    @Test
    public void should_return_false_if_item_is_not_present_in_inventory() {
        Inventory inventory = new Inventory();
        inventory.add(new Item("1", "java book", ItemType.BOOK, BigDecimal.valueOf(150)));

        boolean actual = inventory.isItemPresentInInventory("2");

        assertThat(actual).isEqualTo(false);
    }
}
