package br.com.incarnia.Sistema.de.Vendas.core.domain;

import br.com.incarnia.Sistema.de.Vendas.core.exceptions.MenuException;
import br.com.incarnia.Sistema.de.Vendas.core.exceptions.RestaurantException;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Restaurant {

    private Long id;
    private String name;
    private String description;
    private Address address;
    private String phoneNumber;
    private String CNPJ;
    private BigDecimal deliveryFee;
    private Integer deliveryTime;
    private List<Menu> menus = new ArrayList<>();

    public Restaurant() { }

    public Restaurant(Long id, String name, String description, Address address, String phoneNumber, String CNPJ, BigDecimal deliveryFee, Integer deliveryTime, List<Menu> menus) {
        setId(id);
        setName(name);
        setDescription(description);
        setAddress(address);
        setPhoneNumber(phoneNumber);
        setCNPJ(CNPJ);
        setDeliveryFee(deliveryFee);
        setDeliveryTime(deliveryTime);
        setMenus(menus);
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

        if(name == null) {
            throw new RestaurantException("Restaurant name cannot be null");
        }

        if(name.isBlank()) {
            throw new RestaurantException("Restaurant name cannot be blank");
        }

        if(name.length() < 3) {
            throw new RestaurantException("Restaurant name cannot be this short");
        }

        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {

        if(description == null) {
            throw new RestaurantException("Restaurant description cannot be null");
        }

        if(description.isBlank()) {
            throw new RestaurantException("Restaurant description cannot be blank");
        }

        if(description.length() > 255) {
            throw new RestaurantException("Restaurant description cannot be longer than 255 characters");
        }

        this.description = description;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {

        if(address == null) {
            throw new RestaurantException("Restaurant address cannot be null");
        }

        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {

        if(phoneNumber == null) {
            throw new RestaurantException("Restaurant phone number cannot be null");
        }

        if(phoneNumber.isBlank()) {
            throw new RestaurantException("Restaurant phone number cannot be blank");
        }

        this.phoneNumber = phoneNumber;
    }

    public String getCNPJ() {
        return CNPJ;
    }

    public void setCNPJ(String cnpj) {

        if (cnpj == null) {
            throw new RestaurantException("Restaurant CNPJ can't be null");
        }

        cnpj = cnpj.replaceAll("[^\\d]", "");

        if (cnpj.length() != 14) {
            throw new RestaurantException("Invalid CNPJ size");
        }
        char firstDigit, secondDigit;
        int sum, number, weight, result;

        sum = 0;
        weight = 2;

        for(int i = 11; i >= 0; i--) {
            number = (int)(cnpj.charAt(i) - '0');
            sum = sum + (number * weight);
            weight = weight + 1;
            if (weight == 10) {
                weight = 2;
            }
        }

        result = sum % 11;
        if(result == 0 || result == 1) {
            firstDigit = '0';
        } else {
            firstDigit = (char)((11 - result) + '0');
        }

        sum = 0;
        weight = 2;
        for(int i = 12; i >= 0; i--) {
            number = (int)(cnpj.charAt(i) - '0');
            sum = sum + (number * weight);
            weight = weight + 1;
            if (weight == 10) {
                weight = 2;
            }
        }

        result = sum % 11;
        if (result == 0 || result == 1) {
            secondDigit = '0';
        } else {
            secondDigit = (char)((11 - result) + '0');
        }
        if (firstDigit != cnpj.charAt(12) || secondDigit != cnpj.charAt(13)) {
            throw new RestaurantException("Invalid CNPJ digits");
        }

        this.CNPJ = cnpj;
    }

    public BigDecimal getDeliveryFee() {
        return deliveryFee;
    }

    public void setDeliveryFee(BigDecimal deliveryFee) {

        if(deliveryFee == null) {
            throw new RestaurantException("Restaurant Delivery Fee cannot be null");
        }

        if(deliveryFee.compareTo(BigDecimal.ZERO) < 0) {
            throw new RestaurantException("Restaurant Delivery Fee cannot be negative");
        }

        this.deliveryFee = deliveryFee;
    }

    public Integer getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(Integer deliveryTime) {

        if(deliveryTime == null) {
            throw new RestaurantException("Restaurant Delivery Time cannot be null");
        }

        if (deliveryTime < 5) {
            throw new RestaurantException("Restaurant Delivery Time cannot be less than 5 minutes");
        }

        this.deliveryTime = deliveryTime;
    }

    public List<Menu> getMenus() {
        return menus;
    }

    public void setMenus(List<Menu> menus) {

        if(menus == null) {
            throw new RestaurantException("Restaurant menus can'1t be null");
        }

        this.menus = menus;
    }

    public void addMenu(Menu menu) {
        if (menu == null) {
            throw new RestaurantException("Restaurant cannot add a null menu");
        }
        this.menus.add(menu);
    }

    public void removeMenu(Menu menu) {

        if(!this.menus.contains(menu)) {
            throw new RestaurantException("Menu not found is restaurant");
        }

        this.menus.remove(menu);
    }

}
