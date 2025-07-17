package br.com.incarnia.Sistema.de.Vendas.infra.persistence.restaurant;

import br.com.incarnia.Sistema.de.Vendas.infra.persistence.address.AddressEntity;
import br.com.incarnia.Sistema.de.Vendas.infra.persistence.menu.MenuEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

//TODO --> add menus
@Entity
@Table(name = "restaurants")
public class RestaurantEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;

    @NotBlank
    private String description;
    private AddressEntity address;

    @NotBlank
    private String phoneNumber;

    @NotBlank
    private String CNPJ;
    private BigDecimal deliveryFee;
    private Integer deliveryTime;

    @OneToMany(mappedBy = "restaurantEntity", cascade = CascadeType.ALL)
    private List<MenuEntity> menus = new ArrayList<>();

    public RestaurantEntity() { }

    public RestaurantEntity(Long id, String name, String description, AddressEntity address, String phoneNumber, String CNPJ, BigDecimal deliveryFee, Integer deliveryTime, List<MenuEntity> menuEntityList) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.CNPJ = CNPJ;
        this.deliveryFee = deliveryFee;
        this.deliveryTime = deliveryTime;
        this.menus = menuEntityList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotBlank String getName() {
        return name;
    }

    public void setName(@NotBlank String name) {
        this.name = name;
    }

    public @NotBlank String getDescription() {
        return description;
    }

    public void setDescription(@NotBlank String description) {
        this.description = description;
    }

    public AddressEntity getAddress() {
        return address;
    }

    public void setAddress(AddressEntity address) {
        this.address = address;
    }

    public @NotBlank String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(@NotBlank String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public @NotBlank String getCNPJ() {
        return CNPJ;
    }

    public void setCNPJ(@NotBlank String CNPJ) {
        this.CNPJ = CNPJ;
    }

    public BigDecimal getDeliveryFee() {
        return deliveryFee;
    }

    public void setDeliveryFee(BigDecimal deliveryFee) {
        this.deliveryFee = deliveryFee;
    }

    public Integer getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(Integer deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public List<MenuEntity> getMenus() {
        return menus;
    }

    public void setMenus(List<MenuEntity> menus) {
        this.menus = menus;
    }

}
