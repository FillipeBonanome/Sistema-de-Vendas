package br.com.incarnia.Sistema.de.Vendas.core.domain;

import br.com.incarnia.Sistema.de.Vendas.core.exceptions.RestaurantException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class RestaurantTest {

    private final Address address = new Address(
            "1",
            "2",
            "3",
            "4",
            "5",
            "6",
            null
    );

    @Test
    @DisplayName("Should create Restaurant successfully with valid data")
    public void shouldCreateRestaurantSuccessfullyWithValidData() {
        assertDoesNotThrow(() -> new Restaurant(
                1L,
                "Restaurant Name",
                "This is a restaurant description",
                address,
                "(11) 91111-2222",
                "64.540.607/0001-47",
                new BigDecimal("4.99"),
                10,
                new ArrayList<>()
        ));
    }

    @Test
    @DisplayName("Should throw exception when name is null")
    public void shouldThrowExceptionWhenNameIsNull() {
        Restaurant restaurant = new Restaurant();
        assertThrows(RestaurantException.class, () -> restaurant.setName(null));
    }

    @Test
    @DisplayName("Should throw exception when name is blank")
    public void shouldThrowExceptionWhenNameIsBlank() {
        Restaurant restaurant = new Restaurant();
        assertThrows(RestaurantException.class, () -> restaurant.setName(""));
    }

    @Test
    @DisplayName("Should throw exception when name is too short")
    public void shouldThrowExceptionWhenNameIsTooShort() {
        Restaurant restaurant = new Restaurant();
        assertThrows(RestaurantException.class, () -> restaurant.setName("A"));
    }

    @Test
    @DisplayName("Should throw exception when description is null")
    public void shouldThrowExceptionWhenDescriptionIsNull() {
        Restaurant restaurant = new Restaurant();
        assertThrows(RestaurantException.class, () -> restaurant.setDescription(null));
    }

    @Test
    @DisplayName("Should throw exception when description is blank")
    public void shouldThrowExceptionWhenDescriptionIsBlank() {
        Restaurant restaurant = new Restaurant();
        assertThrows(RestaurantException.class, () -> restaurant.setDescription(""));
    }

    @Test
    @DisplayName("Should throw exception when description is too long")
    public void shouldThrowExceptionWhenDescriptionIsTooLong() {
        Restaurant restaurant = new Restaurant();
        String string = "a".repeat(260);
        assertThrows(RestaurantException.class, () -> restaurant.setDescription(string));
    }

    @Test
    @DisplayName("Should throw exception when menus is null")
    public void shouldThrowExceptionWhenMenusIsNull() {
        Restaurant restaurant = new Restaurant();
        assertThrows(RestaurantException.class, () -> restaurant.setMenus(null));
    }

    @Test
    @DisplayName("Should throw exception when address is null")
    public void shouldThrowExceptionWhenAddressIsNull() {
        Restaurant restaurant = new Restaurant();
        assertThrows(RestaurantException.class, () -> restaurant.setAddress(null));
    }

    @Test
    @DisplayName("Should throw exception when phone number is null")
    public void shouldThrowExceptionWhenPhoneNumberIsNull() {
        Restaurant restaurant = new Restaurant();
        assertThrows(RestaurantException.class, () -> restaurant.setPhoneNumber(null));
    }

    @Test
    @DisplayName("Should throw exception when phone number is blank")
    public void shouldThrowExceptionWhenPhoneNumberIsBlank() {
        Restaurant restaurant = new Restaurant();
        assertThrows(RestaurantException.class, () -> restaurant.setPhoneNumber(""));
    }

    @Test
    @DisplayName("Should throw exception when cnpj is null")
    public void shouldThrowExceptionWhenCNPJIsNull() {
        Restaurant restaurant = new Restaurant();
        assertThrows(RestaurantException.class, () -> restaurant.setCNPJ(null));
    }

    @Test
    @DisplayName("Should throw exception when cnpj is blank")
    public void shouldThrowExceptionWhenCNPJIsBlank() {
        Restaurant restaurant = new Restaurant();
        assertThrows(RestaurantException.class, () -> restaurant.setCNPJ(""));
    }

    @Test
    @DisplayName("Should throw exception when cnpj have invalid size")
    public void shouldThrowExceptionWhenCNPJHaveInvalidSize() {
        Restaurant restaurant = new Restaurant();
        assertThrows(RestaurantException.class, () -> restaurant.setCNPJ("95.607.1/0001-18"));
    }

    @Test
    @DisplayName("Should throw exception when cnpj is invalid")
    public void shouldThrowExceptionWhenCNPJIsInvalid() {
        Restaurant restaurant = new Restaurant();
        assertThrows(RestaurantException.class, () -> restaurant.setCNPJ("95.607.521/0001-08"));
        assertThrows(RestaurantException.class, () -> restaurant.setCNPJ("95.607.521/0001-10"));
    }

    @Test
    @DisplayName("Should update Restaurant when cnpj is valid")
    public void shouldUpdateRestaurantWhenCNPJIsValid() {
        Restaurant restaurant = new Restaurant();
        assertDoesNotThrow(() -> restaurant.setCNPJ("95.607.521/0001-18"));
        assertDoesNotThrow(() -> restaurant.setCNPJ("04.704.703/0001-51"));
        assertDoesNotThrow(() -> restaurant.setCNPJ("21.074.652/0001-40"));
        assertDoesNotThrow(() -> restaurant.setCNPJ("19.350.027/0001-32"));
        assertDoesNotThrow(() -> restaurant.setCNPJ("53.910.279/0001-07"));
        assertDoesNotThrow(() -> restaurant.setCNPJ("98.329.272/0001-34"));
        assertDoesNotThrow(() -> restaurant.setCNPJ("57.025.027/0001-56"));
        assertDoesNotThrow(() -> restaurant.setCNPJ("63.125.035/0001-77"));
        assertDoesNotThrow(() -> restaurant.setCNPJ("66.997.095/0001-78"));
        assertDoesNotThrow(() -> restaurant.setCNPJ("43.287.872/0001-95"));
        assertDoesNotThrow(() -> restaurant.setCNPJ("23.361.170/0001-05"));
    }

    @Test
    @DisplayName("Should throw when Delivery Fee is Null")
    public void shouldThrowWhenDeliveryFeeIsNull() {
        Restaurant restaurant = new Restaurant();
        assertThrows(RestaurantException.class, () -> restaurant.setDeliveryFee(null));
    }

    @Test
    @DisplayName("Should throw when Delivery Fee is less than zero")
    public void shouldThrowWhenDeliveryFeeIsLessThanZero() {
        Restaurant restaurant = new Restaurant();
        assertThrows(RestaurantException.class, () -> restaurant.setDeliveryFee(new BigDecimal("-0.5")));
    }

    @Test
    @DisplayName("Should throw when Delivery Time is null")
    public void shouldThrowWhenDeliveryTimeIsNull() {
        Restaurant restaurant = new Restaurant();
        assertThrows(RestaurantException.class, () -> restaurant.setDeliveryTime(null));
    }

    @Test
    @DisplayName("Should throw when Delivery Time is less than five")
    public void shouldThrowWhenDeliveryTimeIsLessThanFive() {
        Restaurant restaurant = new Restaurant();
        assertThrows(RestaurantException.class, () -> restaurant.setDeliveryTime(4));
    }

    @Test
    @DisplayName("Should throw when add null menu")
    public void shouldThrowWhenAddNullMenu() {
        Restaurant restaurant = new Restaurant();
        assertThrows(RestaurantException.class, () -> restaurant.addMenu(null));
    }

    @Test
    @DisplayName("Should throw when remove not existing menu")
    public void shouldThrowWhenRemoveNotExisingMenu() {
        Restaurant restaurant = new Restaurant();
        Menu menu = new Menu(
                1L,
                "Menu Test",
                "Description",
                restaurant,
                new ArrayList<>()
        );
        assertThrows(RestaurantException.class, () -> restaurant.removeMenu(menu));
    }

    @Test
    @DisplayName("Should update id successfully")
    public void shouldUpdateIdSuccessfully() {
        Restaurant restaurant = new Restaurant();
        Long id = 3L;
        restaurant.setId(id);
        assertEquals(id, restaurant.getId());
    }

    @Test
    @DisplayName("Should update name successfully")
    public void shouldUpdateNameSuccessfully() {
        Restaurant restaurant = new Restaurant();
        String name = "Restaurant Test";
        restaurant.setName(name);
        assertEquals(name, restaurant.getName());
    }

    @Test
    @DisplayName("Should update description successfully")
    public void shouldUpdateDescriptionSuccessfully() {
        Restaurant restaurant = new Restaurant();
        String description = "Restaurant Description";
        restaurant.setDescription(description);
        assertEquals(description, restaurant.getDescription());
    }

    @Test
    @DisplayName("Should update address successfully")
    public void shouldUpdateAddressSuccessfully() {
        Restaurant restaurant = new Restaurant();
        restaurant.setAddress(address);
        assertEquals(address, restaurant.getAddress());
    }

    @Test
    @DisplayName("Should update phone successfully")
    public void shouldUpdatePhoneSuccessfully() {
        Restaurant restaurant = new Restaurant();
        String phone = "(11) 91111-4444";
        restaurant.setPhoneNumber(phone);
        assertEquals(phone, restaurant.getPhoneNumber());
    }

    @Test
    @DisplayName("Should update cnpj successfully")
    public void shouldUpdateCNPJSuccessfully() {
        Restaurant restaurant = new Restaurant();
        String cnpj = "54.880.208/0001-71";
        restaurant.setCNPJ(cnpj);
        cnpj = cnpj.replaceAll("[^\\d]", "");
        assertEquals(cnpj, restaurant.getCNPJ());
    }

    @Test
    @DisplayName("Should update delivery fee successfully")
    public void shouldUpdateDeliveryFeeSuccessfully() {
        Restaurant restaurant = new Restaurant();
        BigDecimal fee = new BigDecimal("10");
        restaurant.setDeliveryFee(fee);
        assertEquals(fee, restaurant.getDeliveryFee());
    }

    @Test
    @DisplayName("Should update delivery time successfully")
    public void shouldUpdateDeliveryTimeSuccessfully() {
        Restaurant restaurant = new Restaurant();
        Integer time = 5;
        restaurant.setDeliveryTime(time);
        assertEquals(time, restaurant.getDeliveryTime());
    }

    @Test
    @DisplayName("Should update menu successfully")
    public void shouldUpdateMenuSuccessfully() {
        Restaurant restaurant = new Restaurant();
        Menu menu = new Menu();
        restaurant.addMenu(menu);
        assertEquals(1, restaurant.getMenus().size());
        assertEquals(menu, restaurant.getMenus().get(0));
    }

    @Test
    @DisplayName("Should remove menu successfully")
    public void shouldUpdateRemoveSuccessfully() {
        Restaurant restaurant = new Restaurant();
        Menu menu = new Menu();
        restaurant.addMenu(menu);
        assertDoesNotThrow(() -> restaurant.removeMenu(menu));
    }


}