package br.com.incarnia.Sistema.de.Vendas.core.domain;

import br.com.incarnia.Sistema.de.Vendas.core.exceptions.UserException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

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
    @DisplayName("Should create User successfully with valid data")
    public void shouldCreateUserSuccessfullyWithValidData() {
        assertDoesNotThrow(() -> new User(
                1L,
                "Pato Donald",
                "pato@pato.com",
                "12345678",
                "(11)4555-5545",
                address,
                "604.056.770-81",
                UserRole.CLIENT,
                false
        ));
    }

    @Test
    @DisplayName("Should throw UserException when name is null")
    public void shouldThrowUserExceptionWhenNameIsNull() {
        assertThrows(UserException.class, () -> new User(
                1L,
                null,
                "pato@pato.com",
                "12345678",
                "(11)4555-5545",
                address,
                "604.056.770-81",
                UserRole.CLIENT,
                false
        ));
    }

    @Test
    @DisplayName("Should throw UserException when name length is less than 2")
    public void shouldThrowUserExceptionWhenNameLengthIsLessThanTwo() {
        assertThrows(UserException.class, () -> new User(
                1L,
                "A",
                "pato@pato.com",
                "12345678",
                "(11)4555-5545",
                address,
                "604.056.770-81",
                UserRole.CLIENT,
                false
        ));
    }

    @Test
    @DisplayName("Should throw UserException when email is null")
    public void shouldThrowUserExceptionWhenEmailIsNull() {
        assertThrows(UserException.class, () -> new User(
                1L,
                "Pato",
                null,
                "12345678",
                "(11)4555-5545",
                address,
                "604.056.770-81",
                UserRole.CLIENT,
                false
        ));
    }

    @Test
    @DisplayName("Should throw UserException when email is blank")
    public void shouldThrowUserExceptionWhenEmailIsBlank() {
        assertThrows(UserException.class, () -> new User(
                1L,
                "Pato",
                "",
                "12345678",
                "(11)4555-5545",
                address,
                "604.056.770-81",
                UserRole.CLIENT,
                false
        ));
    }

    @Test
    @DisplayName("Should throw UserException when email is invalid")
    public void shouldThrowUserExceptionWhenEmailIsInvalid() {
        assertThrows(UserException.class, () -> new User(
                1L,
                "Pato",
                "pato.com",
                "12345678",
                "(11)4555-5545",
                address,
                "604.056.770-81",
                UserRole.CLIENT,
                false
        ));
    }

    @Test
    @DisplayName("Should throw UserException when password is null")
    public void shouldThrowUserExceptionWhenPasswordIsNull() {
        assertThrows(UserException.class, () -> new User(
                1L,
                "Pato",
                "pato@pato.com",
                null,
                "(11)4555-5545",
                address,
                "604.056.770-81",
                UserRole.CLIENT,
                false
        ));
    }

    @Test
    @DisplayName("Should throw UserException when password is less than 8 digits")
    public void shouldThrowUserExceptionWhenPasswordIsLessThanEightDigits() {
        assertThrows(UserException.class, () -> new User(
                1L,
                "Pato",
                "pato@pato.com",
                "1234567",
                "(11)4555-5545",
                address,
                "604.056.770-81",
                UserRole.CLIENT,
                false
        ));
    }

    @Test
    @DisplayName("Should throw UserException when phone number is null")
    public void shouldThrowUserExceptionWhenPhoneNumberIsNull() {
        assertThrows(UserException.class, () -> new User(
                1L,
                "Pato",
                "pato@pato.com",
                "12345678",
                null,
                address,
                "604.056.770-81",
                UserRole.CLIENT,
                false
        ));
    }

    @Test
    @DisplayName("Should throw UserException when phone number is blank")
    public void shouldThrowUserExceptionWhenPhoneNumberIsBlank() {
        assertThrows(UserException.class, () -> new User(
                1L,
                "Pato",
                "pato@pato.com",
                "12345678",
                "",
                address,
                "604.056.770-81",
                UserRole.CLIENT,
                false
        ));
    }

    @Test
    @DisplayName("Should throw UserException when address is null")
    public void shouldThrowUserExceptionWhenAddressIsNull() {
        assertThrows(UserException.class, () -> new User(
                1L,
                "Pato",
                "pato@pato.com",
                "12345678",
                "1234-5678",
                null,
                "604.056.770-81",
                UserRole.CLIENT,
                false
        ));
    }

    @Test
    @DisplayName("Should throw UserException when CPF is null")
    public void shouldThrowUserExceptionWhenCPFIsNull() {
        assertThrows(UserException.class, () -> new User(
                1L,
                "Pato",
                "pato@pato.com",
                "12345678",
                "1234-5678",
                address,
                null,
                UserRole.CLIENT,
                false
        ));
    }

    @Test
    @DisplayName("Should throw UserException when CPF is blank")
    public void shouldThrowUserExceptionWhenCPFIsBlank() {
        UserException exception = assertThrows(UserException.class, () -> new User(
                1L,
                "Pato",
                "pato@pato.com",
                "12345678",
                "1234-5678",
                address,
                "",
                UserRole.CLIENT,
                false
        ));
        System.out.println(exception.getMessage());
    }

    @Test
    @DisplayName("Should throw UserException when CPF length is different than 11")
    public void shouldThrowUserExceptionWhenCPFIsDifferentThanEleven() {
       UserException exception =  assertThrows(UserException.class, () -> new User(
                1L,
                "Pato",
                "pato@pato.com",
                "12345678",
                "1234-5678",
                address,
                "294.588.080-657",
                UserRole.CLIENT,
                false
        ));

        System.out.println("Invalid length?");
        System.out.println(exception.getMessage());
    }

    @Test
    @DisplayName("Should throw UserException when CPF contains invalid characters")
    public void shouldThrowUserExceptionWhenCPFContainsInvalidCharacters() {
        UserException exception = assertThrows(UserException.class, () -> new User(
                1L,
                "Pato",
                "pato@pato.com",
                "12345678",
                "1234-5678",
                address,
                "294.588.08A-65",
                UserRole.CLIENT,
                false
        ));

    }

    @Test
    @DisplayName("Should throw UserException when CPF is invalid")
    public void shouldThrowUserExceptionWhenCPFIsInvalid() {
        UserException exception = assertThrows(UserException.class, () -> new User(
                1L,
                "Pato",
                "pato@pato.com",
                "12345678",
                "1234-5678",
                address,
                "312.680.110-28",
                UserRole.CLIENT,
                false
        ));

    }

    @Test
    @DisplayName("Should throw UserException when User Role is Null")
    public void shouldThrowUserExceptionWhenUserRoleIsNull() {
        assertThrows(UserException.class, () -> new User(
                1L,
                "Pato",
                "pato@pato.com",
                "12345678",
                "1234-5678",
                address,
                "502.951.230-60",
                null,
                false
        ));
    }

    @Test
    @DisplayName("Should update user id successfully")
    void shouldUpdateUserIDSuccessfully() {
        User user = new User();
        Long id = 1L;
        user.setId(id);
        assertEquals(id, user.getId());
    }

    @Test
    @DisplayName("Should update user name successfully")
    void shouldUpdateUserNameSuccessfully() {
        User user = new User();
        String userName = "Pato";
        user.setName(userName);
        assertEquals(userName, user.getName());
    }

    @Test
    @DisplayName("Should update password successfully")
    void shouldUpdatePasswordSuccessfully() {
        User user = new User();
        String password = "12345678";
        user.setPassword(password);
        assertEquals(password, user.getPassword());
    }

    @Test
    @DisplayName("Should update email successfully")
    void shouldUpdateEmailSuccessfully() {
        User user = new User();
        String email = "pato@pato.com.br";
        user.setEmail(email);
        assertEquals(email, user.getEmail());
    }

    @Test
    @DisplayName("Should update phone successfully")
    void shouldUpdatePhoneSuccessfully() {
        User user = new User();
        String phone = "(11) 4444-5555";
        user.setPhoneNumber(phone);
        assertEquals(phone, user.getPhoneNumber());
    }

    @Test
    @DisplayName("Should update address successfully")
    void shouldUpdateAddressSuccessfully() {
        User user = new User();
        user.setAddress(address);
        assertEquals(address, user.getAddress());
    }

    @Test
    @DisplayName("Should update CPF successfully")
    void shouldUpdateCPFSuccessfully() {
        User user = new User();
        String cpf = "971.472.810-04";
        user.setCPF(cpf);
        String cleanCPF = cpf.replaceAll("[^\\d]", "");
        assertEquals(cleanCPF, user.getCPF());
    }

    @Test
    @DisplayName("Should update CPF successfully 2")
    void shouldUpdateCPFSuccessfullyTwo() {
        User user = new User();
        String cpf = "856.487.320-66";
        user.setCPF(cpf);
        String cleanCPF = cpf.replaceAll("[^\\d]", "");
        assertEquals(cleanCPF, user.getCPF());
    }

    @Test
    @DisplayName("Should update CPF successfully 3")
    void shouldUpdateCPFSuccessfullyThree() {
        User user = new User();
        String cpf = "738.893.020-50";
        user.setCPF(cpf);
        String cleanCPF = cpf.replaceAll("[^\\d]", "");
        assertEquals(cleanCPF, user.getCPF());
    }

    @Test
    @DisplayName("Should update CPF successfully 4")
    void shouldUpdateCPFSuccessfullyFour() {
        User user = new User();
        String cpf = "531.333.790-46";
        user.setCPF(cpf);
        String cleanCPF = cpf.replaceAll("[^\\d]", "");
        assertEquals(cleanCPF, user.getCPF());
    }

    @Test
    @DisplayName("Should update CPF successfully 5")
    void shouldUpdateCPFSuccessfullyFive() {
        User user = new User();
        String cpf = "121.558.690-61";
        user.setCPF(cpf);
        String cleanCPF = cpf.replaceAll("[^\\d]", "");
        assertEquals(cleanCPF, user.getCPF());
    }

    @Test
    @DisplayName("Should update CPF successfully 6")
    void shouldUpdateCPFSuccessfullySix() {
        User user = new User();
        String cpf = "585.408.460-04";
        user.setCPF(cpf);
        String cleanCPF = cpf.replaceAll("[^\\d]", "");
        assertEquals(cleanCPF, user.getCPF());
    }

    @Test
    @DisplayName("Should update CPF successfully 7")
    void shouldUpdateCPFSuccessfullySeven() {
        User user = new User();
        String cpf = "227.830.070-96";
        user.setCPF(cpf);
        String cleanCPF = cpf.replaceAll("[^\\d]", "");
        assertEquals(cleanCPF, user.getCPF());
    }

    @Test
    @DisplayName("Should update CPF successfully 8")
    void shouldUpdateCPFSuccessfullyEight() {
        User user = new User();
        String cpf = "825.248.910-97";
        user.setCPF(cpf);
        String cleanCPF = cpf.replaceAll("[^\\d]", "");
        assertEquals(cleanCPF, user.getCPF());
    }

    @Test
    @DisplayName("Should update CPF successfully 9")
    void shouldUpdateCPFSuccessfullyNine() {
        User user = new User();
        String cpf = "585.319.730-40";
        user.setCPF(cpf);
        String cleanCPF = cpf.replaceAll("[^\\d]", "");
        assertEquals(cleanCPF, user.getCPF());
    }

    @Test
    @DisplayName("Should update CPF successfully 10")
    void shouldUpdateCPFSuccessfullyTen() {
        User user = new User();
        String cpf = "955.776.650-60";
        user.setCPF(cpf);
        String cleanCPF = cpf.replaceAll("[^\\d]", "");
        assertEquals(cleanCPF, user.getCPF());
    }

    @Test
    @DisplayName("Should update user role successfully")
    void shouldUpdateUserRoleSuccessfully() {
        User user = new User();
        user.setUserRole(UserRole.CLIENT);
        assertEquals(UserRole.CLIENT, user.getUserRole());
    }

    @Test
    @DisplayName("Should update is deleted role successfully")
    void shouldUpdateIsDeletedSuccessfully() {
        User user = new User();
        user.setDeleted(false);
        assertFalse(user.isDeleted());
    }

    @Test
    @DisplayName("Should throw UserException when tries to delete already deleted user")
    void shouldThrowUserExceptionWhenTriesToDeleteAlreadyDeletedUser() {
        User user = new User();
        user.setDeleted(true);
        assertThrows(UserException.class, () -> user.setDeleted(true));
    }

    @Test
    @DisplayName("Should throw UserException when tries to update blank name")
    void shouldThrowUserExceptionWhenTriesToUpdateBlankName() {
        User user = new User();
        assertThrows(UserException.class, () -> user.setName(""));
    }

    @Test
    @DisplayName("Should throw UserException when tries to update cpf with invalid size")
    void shouldThrowUserExceptionWhenTriesToUpdateCPFWithInvalidSize() {
        User user = new User();
        assertThrows(UserException.class, () -> user.setCPF("205.651.650-0"));
    }

    @Test
    @DisplayName("Should throw UserException when tries to update cpf with invalid characters")
    void shouldThrowUserExceptionWhenTriesToUpdateCPFWithInvalidCharacters() {
        User user = new User();
        assertThrows(UserException.class, () -> user.setCPF("20S.6SI.650-0A"));
    }

    @Test
    @DisplayName("Should throw UserException when tries to update cpf with invalid numbers")
    void shouldThrowUserExceptionWhenTriesToUpdateCPFWithInvalidNumbers() {
        User user = new User();
        assertThrows(UserException.class, () -> user.setCPF("955.776.650-00"));
    }

    @Test
    @DisplayName("Should throw UserException when tries to update blank password")
    void shouldThrowUserExceptionWhenTriesToUpdateBlankPassword() {
        User user = new User();
        assertThrows(UserException.class, () -> user.setPassword(""));
    }

}