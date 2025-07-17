package br.com.incarnia.Sistema.de.Vendas.core.domain;

import br.com.incarnia.Sistema.de.Vendas.core.exceptions.MenuException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class MenuTest {

    private final Restaurant restaurant = new Restaurant();

    @Test
    @DisplayName("Should create Menu successfully with valid data")
    public void shouldCreateMenuSuccessfullyWithValidData() {
        assertDoesNotThrow(() -> {
            new Menu(
                    1L,
                    "Churrasco",
                    "Seleção de carnes feitas no nosso forno a lenha",
                    restaurant,
                    new ArrayList<>()
            );
        });
    }

    @Test
    @DisplayName("Should throw when name is null")
    public void shouldThrowWhenNameIsNull() {
        Menu menu = new Menu();
        assertThrows(MenuException.class, () -> {
           menu.setName(null);
        });
    }

    @Test
    @DisplayName("Should throw when name is blank")
    public void shouldThrowWhenNameIsBlank() {
        Menu menu = new Menu();
        assertThrows(MenuException.class, () -> {
            menu.setName("");
        });
    }

    @Test
    @DisplayName("Should throw when name is too short")
    public void shouldThrowWhenNameIsTooShort() {
        Menu menu = new Menu();
        assertThrows(MenuException.class, () -> {
            menu.setName("A");
        });
    }

    @Test
    @DisplayName("Should throw when name is too long")
    public void shouldThrowWhenNameIsTooLong() {
        Menu menu = new Menu();
        assertThrows(MenuException.class, () -> {
            menu.setName("A".repeat(17));
        });
    }

    @Test
    @DisplayName("Should throw when description is too large")
    public void shouldThrowWhenDescriptionIsTooLarge() {
        Menu menu = new Menu();
        assertThrows(MenuException.class, () -> {
            menu.setDescription("A".repeat(256));
        });
    }

    @Test
    @DisplayName("Should throw when restaurant is null")
    public void shouldThrowWhenRestaurantIsNull() {
        Menu menu = new Menu();
        assertThrows(MenuException.class, () -> {
            menu.setRestaurant(null);
        });
    }

    @Test
    @DisplayName("Should throw when adding existing menu item")
    public void shouldThrowWhenAddingExistingMenuItem() {
        Menu menu = new Menu();
        MenuItem menuItem = new MenuItem();
        menu.addMenuItem(menuItem);
        assertThrows(MenuException.class, () -> {
            menu.addMenuItem(menuItem);
        });
    }

    @Test
    @DisplayName("Should throw when removing non existing menu item")
    public void shouldThrowWhenRemovingNonExistingMenuitem() {
        Menu menu = new Menu();
        MenuItem menuItem = new MenuItem();
        assertThrows(MenuException.class, () -> {
            menu.removeMenuItem(menuItem);
        });
    }

    @Test
    @DisplayName("Should update name successfully")
    public void shouldUpdateNameSuccessfully() {
        Menu menu = new Menu();
        String name = "Menu Name";
        menu.setName(name);
        assertEquals(name, menu.getName());
    }

    @Test
    @DisplayName("Should update description successfully")
    public void shouldUpdateDescriptionSuccessfully() {
        Menu menu = new Menu();
        String description = "Menu Description";
        menu.setDescription(description);
        assertEquals(description, menu.getDescription());
    }

    @Test
    @DisplayName("Should update description successfully with null")
    public void shouldUpdateDescriptionSuccessfullyWithNull() {
        Menu menu = new Menu();
        assertDoesNotThrow(() -> {
            menu.setDescription(null);
        });
    }

    @Test
    @DisplayName("Should update restaurant successfully")
    public void shouldUpdateRestaurantSuccessfully() {
        Menu menu = new Menu();
        menu.setRestaurant(restaurant);
        assertEquals(restaurant, menu.getRestaurant());
    }

    @Test
    @DisplayName("Should add menu item successfully")
    public void shouldAddMenuItemSuccessfully() {
        Menu menu = new Menu();
        MenuItem menuItem = new MenuItem();
        menu.addMenuItem(menuItem);
        assertEquals(1, menu.getMenuItems().size());
        assertEquals(menuItem, menu.getMenuItems().get(0));
    }

    @Test
    @DisplayName("Should remove menu item successfully")
    public void shouldRemoveMenuItemSuccessfully() {
        Menu menu = new Menu();
        MenuItem menuItem = new MenuItem();
        menu.addMenuItem(menuItem);
        menu.removeMenuItem(menuItem);
        assertEquals(0, menu.getMenuItems().size());
    }

    @Test
    @DisplayName("Should update id successfully")
    public void shouldUpdateIdSuccessfully() {
        Menu menu = new Menu();
        Long id = 122L;
        menu.setId(id);
        assertEquals(id, menu.getId());
    }
}