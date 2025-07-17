package br.com.incarnia.Sistema.de.Vendas.core.domain;

import br.com.incarnia.Sistema.de.Vendas.core.exceptions.UserException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class User {
    private Long id;
    private String name;
    private String email;
    private String password;
    private String phoneNumber;
    private Address address;
    private String CPF;
    private UserRole userRole;
    private boolean deleted;

    public User() {}

    public User(Long id, String name, String email, String password, String phoneNumber, Address address, String CPF, UserRole userRole, boolean deleted) {
        this.id = id;
        setName(name);
        setEmail(email);
        setPassword(password);
        setPhoneNumber(phoneNumber);
        setAddress(address);
        setCPF(CPF);
        setUserRole(userRole);
        setDeleted(deleted);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null) {
            throw new UserException("User name cannot be null");
        }

        if(name.isBlank()) {
            throw new UserException("User name cannot be blank");
        }

        if (name.length() < 2) {
            throw new UserException("User name cannot be less than 2 digits");
        }

        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {

        if(email == null || email.isBlank()) {
            throw new UserException("User email cannot be null or blank");
        }

        String emailREGEX = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(emailREGEX);
        Matcher matcher = pattern.matcher(email);

        if (!matcher.matches()) {
            throw new UserException("User email is not valid");
        }

        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {

        if (password == null) {
            throw new UserException("User password cannot be null");
        }

        if (password.isBlank()) {
            throw new UserException("User password cannot be blank");
        }

        if (password.length() < 8) {
            throw new UserException("User password cannot be less than 8 digits");
        }

        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {

        if (phoneNumber == null || phoneNumber.isBlank()) {
            throw new UserException("User phone number cannot be null or blank");
        }

        this.phoneNumber = phoneNumber;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {

        if (address == null) {
            throw new UserException("User address cannot be null");
        }

        this.address = address;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String cpf) {

        if(cpf == null) {
            throw new UserException("User CPF cannot be null");
        }

        cpf = cpf.replaceAll("[^\\d]", "");

        if (!cpf.matches("\\d+")) {
            throw new UserException("User CPF with invalid format");
        }

        if(cpf.length() != 11) {
            throw new UserException("User CPF with invalid format");
        }

        int sum = 0;
        for(int i = 0; i < 9; i++) {
            sum = sum + (cpf.charAt(i) - '0') * (10 - i);
        }

        int module = 11 - (sum % 11);
        int firstDigit = (module == 10 || module == 11) ? 0 : module;

        sum = 0;
        for(int i = 0; i < 10; i++) {
            sum = sum + (cpf.charAt(i) - '0') * (11 - i);
        }

        module = 11 - (sum % 11);
        int secondDigit = (module == 10 || module == 11) ? 0 : module;

        if (cpf.charAt(9) - '0' != firstDigit || cpf.charAt(10) - '0' != secondDigit) {
            throw new UserException("User CPF is invalid");
        }

        this.CPF = cpf;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {

        if (userRole == null) {
            throw new UserException("User role cannot be null");
        }

        this.userRole = userRole;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {

        if(deleted && isDeleted()) {
            throw new UserException("User is already deleted");
        }

        this.deleted = deleted;
    }
}
