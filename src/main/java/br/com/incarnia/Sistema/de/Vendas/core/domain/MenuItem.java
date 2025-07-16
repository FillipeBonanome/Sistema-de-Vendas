package br.com.incarnia.Sistema.de.Vendas.core.domain;

import br.com.incarnia.Sistema.de.Vendas.core.exceptions.MenuItemException;

import java.math.BigDecimal;

public class MenuItem {

    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
    private Menu menu;

    public MenuItem() { }

    public MenuItem(Long id, String name, String description, BigDecimal price, Menu menu) {
        setId(id);
        setName(name);
        setDescription(description);
        setPrice(price);
        setMenu(menu);
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
            throw new MenuItemException("Menu item name cannot be null");
        }

        if(name.isBlank()) {
            throw new MenuItemException("Menu item name cannot be blank");
        }

        if(name.length() < 3) {
            throw new MenuItemException("Menu item name length cannot be less than 3");
        }

        if (name.length() > 16) {
            throw new MenuItemException("Menu item name length cannot be larger than 16");
        }

        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {

        if(description != null) {
            if(description.length() > 255) {
                throw new MenuItemException("Menu description cannot exceed 255 characters");
            }
        }

        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {

        if(price.compareTo(BigDecimal.ZERO) <= 0) {
            throw new MenuItemException("Menu item price cannot be zero or negative");
        }

        this.price = price;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }
}
