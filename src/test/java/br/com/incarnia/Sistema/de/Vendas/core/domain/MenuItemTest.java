package br.com.incarnia.Sistema.de.Vendas.core.domain;

import br.com.incarnia.Sistema.de.Vendas.core.exceptions.MenuItemException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class MenuItemTest {

    private final Menu menu = new Menu();

    @Test
    @DisplayName("Should create menu item successfully with valid data")
    public void shouldCreateMenuItemSuccessfullyWithValiData() {
        assertDoesNotThrow(() -> {
            new MenuItem(
                    1L,
                    "Picanha 500g",
                    "A melhor picanha da região",
                    new BigDecimal("69.99"),
                    menu
            );
        });
    }

    @Test
    @DisplayName("Should throw when name is null")
    public void shouldThrowWhenNameIsNull() {
        MenuItem menuItem = new MenuItem();
        assertThrows(MenuItemException.class, () -> {
            menuItem.setName(null);
        });
    }

    @Test
    @DisplayName("Should throw when name is blank")
    public void shouldThrowWhenNameIsBlank() {
        MenuItem menuItem = new MenuItem();
        assertThrows(MenuItemException.class, () -> {
            menuItem.setName("");
        });
    }

    @Test
    @DisplayName("Should throw when name is too short")
    public void shouldThrowWhenNameIsTooShort() {
        MenuItem menuItem = new MenuItem();
        assertThrows(MenuItemException.class, () -> {
            menuItem.setName("A");
        });
    }

    @Test
    @DisplayName("Should throw when name is too long")
    public void shouldThrowWhenNameIsTooLong() {
        MenuItem menuItem = new MenuItem();
        assertThrows(MenuItemException.class, () -> {
            menuItem.setName("A".repeat(17));
        });
    }

    @Test
    @DisplayName("Should throw when description is too long")
    public void shouldThrowWhenDescriptionIsTooLong() {
        MenuItem menuItem = new MenuItem();
        assertThrows(MenuItemException.class, () -> {
            menuItem.setDescription("A".repeat(256));
        });
    }

    @Test
    @DisplayName("Should throw when price is less or equal to zero")
    public void shouldThrowWhenPriceIsLessOrEqualToZero() {
        MenuItem menuItem = new MenuItem();
        assertThrows(MenuItemException.class, () -> {
            menuItem.setPrice(new BigDecimal("0"));
        });
        assertThrows(MenuItemException.class, () -> {
            menuItem.setPrice(new BigDecimal("-0.99"));
        });
    }

    @Test
    @DisplayName("Should update name successfully")
    public void shouldUpdateNameSuccessfully() {
        MenuItem menuItem = new MenuItem();
        String name = "Menu Item Name";
        menuItem.setName(name);
        assertEquals(name, menuItem.getName());
    }

    @Test
    @DisplayName("Should update id successfully")
    public void shouldUpdateIdSuccessfully() {
        MenuItem menuItem = new MenuItem();
        Long id = 1L;
        menuItem.setId(id);
        assertEquals(id, menuItem.getId());
    }

    @Test
    @DisplayName("Should update description successfully")
    public void shouldUpdateDescriptionSuccessfully() {
        MenuItem menuItem = new MenuItem();
        String description = "New description";
        menuItem.setDescription(description);
        assertEquals(description, menuItem.getDescription());
    }

    @Test
    @DisplayName("Should update description successfully with null")
    public void shouldUpdateDescriptionSuccessfullyWithNull() {
        MenuItem menuItem = new MenuItem();
        menuItem.setDescription(null);
        assertNull(menuItem.getDescription());
    }

    @Test
    @DisplayName("Should update price successfully")
    public void shouldUpdatePriceSuccessfully() {
        MenuItem menuItem = new MenuItem();
        BigDecimal price = new BigDecimal("10.99");
        menuItem.setPrice(price);
        assertEquals(price, menuItem.getPrice());
    }

    @Test
    @DisplayName("Should update menu successfully")
    public void shouldUpdateMenuSuccessfully() {
        MenuItem menuItem = new MenuItem();
        menuItem.setMenu(menu);
        assertEquals(menu, menuItem.getMenu());
    }
}