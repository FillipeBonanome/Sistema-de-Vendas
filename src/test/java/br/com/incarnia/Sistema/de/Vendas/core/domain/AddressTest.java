package br.com.incarnia.Sistema.de.Vendas.core.domain;

import br.com.incarnia.Sistema.de.Vendas.core.exceptions.AddressException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AddressTest {

    @Test
    @DisplayName("Should create Address successfully with valid data")
    public void shouldCreateAddressSuccessfullyWithValidData() {
        assertDoesNotThrow(() -> new Address(
                "Street",
                "Number",
                "Neighborhood",
                "City",
                "State",
                "CEP",
                null
        ));
    }

    @Test
    @DisplayName("Should create Address successfully with valid and complement")
    public void shouldCreateAddressSuccessfullyWithValidDataAndComplement() {
        assertDoesNotThrow(() -> new Address(
                "Street",
                "Number",
                "Neighborhood",
                "City",
                "State",
                "CEP",
                "house"
        ));
    }

    @Test
    @DisplayName("Should throw AddressException when street is null")
    public void shouldThrowAddressExceptionWhenStreetIsNull() {
        Address address = new Address();
        assertThrows(AddressException.class, () -> address.setStreet(null));
    }

    @Test
    @DisplayName("Should throw AddressException when street is blank")
    public void shouldThrowAddressExceptionWhenStreetIsBlank() {
        Address address = new Address();
        assertThrows(AddressException.class, () -> address.setStreet(""));
    }

    @Test
    @DisplayName("Should throw AddressException when number is null")
    public void shouldThrowAddressExceptionWheNumberIsNull() {
        Address address = new Address();
        assertThrows(AddressException.class, () -> address.setNumber(null));
    }

    @Test
    @DisplayName("Should throw AddressException when number is blank")
    public void shouldThrowAddressExceptionWheNumberIsBlank() {
        Address address = new Address();
        assertThrows(AddressException.class, () -> address.setNumber(""));
    }

    @Test
    @DisplayName("Should throw AddressException when neighborhood is null")
    public void shouldThrowAddressExceptionWhenNeighborhoodIsNull() {
        Address address = new Address();
        assertThrows(AddressException.class, () -> address.setNeighborhood(null));
    }

    @Test
    @DisplayName("Should throw AddressException when neighborhood is blank")
    public void shouldThrowAddressExceptionWhenNeighborhoodIsBlank() {
        Address address = new Address();
        assertThrows(AddressException.class, () -> address.setNeighborhood(""));
    }

    @Test
    @DisplayName("Should throw AddressException when city is null")
    public void shouldThrowAddressExceptionWhenCityIsNull() {
        Address address = new Address();
        assertThrows(AddressException.class, () -> address.setCity(null));
    }

    @Test
    @DisplayName("Should throw AddressException when city is blank")
    public void shouldThrowAddressExceptionWhenCityIsBlank() {
        Address address = new Address();
        assertThrows(AddressException.class, () -> address.setCity(""));
    }

    @Test
    @DisplayName("Should throw AddressException when state is null")
    public void shouldThrowAddressExceptionWhenStateIsNull() {
        Address address = new Address();
        assertThrows(AddressException.class, () -> address.setState(null));
    }

    @Test
    @DisplayName("Should throw AddressException when state is blank")
    public void shouldThrowAddressExceptionWhenStateIsBlank() {
        Address address = new Address();
        assertThrows(AddressException.class, () -> address.setState(""));
    }

    @Test
    @DisplayName("Should throw AddressException when CEP is null")
    public void shouldThrowAddressExceptionWhenCEPIsNull() {
        Address address = new Address();
        assertThrows(AddressException.class, () -> address.setCEP(null));
    }

    @Test
    @DisplayName("Should throw AddressException when CEP is blank")
    public void shouldThrowAddressExceptionWhenCEPIsBlank() {
        Address address = new Address();
        assertThrows(AddressException.class, () -> address.setCEP(""));
    }

    @Test
    @DisplayName("Should update street successfully")
    public void shouldUpdateStreetSuccessfully() {
        Address address = new Address();
        String street = "Street";
        assertDoesNotThrow(() -> address.setStreet(street));
        assertEquals(street, address.getStreet());
    }

    @Test
    @DisplayName("Should update number successfully")
    public void shouldUpdateNumberSuccessfully() {
        Address address = new Address();
        String number = "Number";
        assertDoesNotThrow(() -> address.setNumber(number));
        assertEquals(number, address.getNumber());
    }

    @Test
    @DisplayName("Should update neighborhood successfully")
    public void shouldUpdateNeighborhoodSuccessfully() {
        Address address = new Address();
        String neighborhood = "Neighborhood";
        assertDoesNotThrow(() -> address.setNeighborhood(neighborhood));
        assertEquals(neighborhood, address.getNeighborhood());
    }

    @Test
    @DisplayName("Should update city successfully")
    public void shouldUpdateCitySuccessfully() {
        Address address = new Address();
        String city = "city";
        assertDoesNotThrow(() -> address.setCity(city));
        assertEquals(city, address.getCity());
    }

    @Test
    @DisplayName("Should update state successfully")
    public void shouldUpdateStateSuccessfully() {
        Address address = new Address();
        String state = "state";
        assertDoesNotThrow(() -> address.setState(state));
        assertEquals(state, address.getState());
    }

    @Test
    @DisplayName("Should update CEP successfully")
    public void shouldUpdateCEPSuccessfully() {
        Address address = new Address();
        String cep = "cep";
        assertDoesNotThrow(() -> address.setCEP(cep));
        assertEquals(cep, address.getCEP());
    }

    @Test
    @DisplayName("Should update complement successfully")
    public void shouldUpdateComplementSuccessfully() {
        Address address = new Address();
        assertDoesNotThrow(() -> address.setComplement(""));
        assertEquals("", address.getComplement());
        assertDoesNotThrow(() -> address.setComplement(null));
        assertNull(address.getComplement());
    }

    @Test
    @DisplayName("Should Be Equal to Itself")
    public void shouldBeEqualToItself() {
        Address address = new Address("1", "2", "3", "4", "7", "6", "7");
        assertEquals(address, address);
    }

    @Test
    @DisplayName("Should Be Equal to Another Address With Same Parameters")
    public void shouldBeEqualToAnotherAddressWithSameParameters() {
        Address address = new Address("1", "2", "3", "4", "7", "6", "7");
        Address anotherAddress = new Address("1", "2", "3", "4", "7", "6", "7");
        assertEquals(address, anotherAddress);
    }

    @Test
    @DisplayName("Should Be Different to a null object")
    public void shouldBeDifferentToANullObject() {
        Address address = new Address("1", "2", "3", "4", "7", "6", "7");
        assertNotEquals(address, new Object());
    }

    @Test
    @DisplayName("Should Be Different to null")
    public void shouldBeDifferentToNull() {
        Address address = new Address("1", "2", "3", "4", "7", "6", "7");
        assertNotEquals(address, null);
    }

    @Test
    @DisplayName("Should Be Different to Another Address With Different Street")
    public void shouldBeDifferentToAnotherAddressWithDifferentStreet() {
        Address address = new Address();
        Address anotherAddress = new Address();

        address.setStreet("1");
        anotherAddress.setStreet("2");

        assertFalse(address.equals(anotherAddress));
    }

    @Test
    @DisplayName("Should Be Different to Another Address With Different Number")
    public void shouldBeDifferentToAnotherAddressWithDifferentNumber() {
        Address address = new Address();
        Address anotherAddress = new Address();

        address.setNumber("1");
        anotherAddress.setNumber("2");

        assertFalse(address.equals(anotherAddress));
    }

    @Test
    @DisplayName("Should Be Different to Another Address With Different Neighborhood")
    public void shouldBeDifferentToAnotherAddressWithDifferentNeighborhood() {
        Address address = new Address();
        Address anotherAddress = new Address();

        address.setNeighborhood("1");
        anotherAddress.setNeighborhood("2");

        assertFalse(address.equals(anotherAddress));
    }

    @Test
    @DisplayName("Should Be Different to Another Address With Different City")
    public void shouldBeDifferentToAnotherAddressWithDifferentCity() {
        Address address = new Address();
        Address anotherAddress = new Address();

        address.setCity("1");
        anotherAddress.setCity("2");

        assertFalse(address.equals(anotherAddress));
    }

    @Test
    @DisplayName("Should Be Different to Another Address With Different State")
    public void shouldBeDifferentToAnotherAddressWithDifferentState() {
        Address address = new Address();
        Address anotherAddress = new Address();

        address.setState("1");
        anotherAddress.setState("2");

        assertFalse(address.equals(anotherAddress));
    }

    @Test
    @DisplayName("Should Be Different to Another Address With Different CEP")
    public void shouldBeDifferentToAnotherAddressWithDifferentCEP() {
        Address address = new Address();
        Address anotherAddress = new Address();

        address.setCEP("1");
        anotherAddress.setCEP("2");

        assertFalse(address.equals(anotherAddress));
    }

    @Test
    @DisplayName("Should Be Different to Another Address With Different Complement")
    public void shouldBeDifferentToAnotherAddressWithDifferentComplement() {
        Address address = new Address();
        Address anotherAddress = new Address();

        address.setComplement("1");
        anotherAddress.setComplement("2");

        assertFalse(address.equals(anotherAddress));
    }

    @Test
    @DisplayName("Hash code should be consistent")
    public void hashCodeShouldBeConsistent() {
        Address address = new Address("1", "2", "3", "4", "7", "6", "7");
        int hashOne = address.hashCode();
        int hashTwo = address.hashCode();
        assertEquals(hashOne, hashTwo);
    }

    @Test
    @DisplayName("Hash code should be different for different objects")
    public void hashCodeShouldBeDifferentForDifferentObjects() {
        Address address = new Address("1", "2", "3", "4", "7", "6", "7");
        Address anotherAddress = new Address("10", "2", "3", "4", "7", "6", "7");
        int hashOne = address.hashCode();
        int hashTwo = anotherAddress.hashCode();
        assertNotEquals(hashOne, hashTwo);
    }

}