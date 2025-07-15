package br.com.incarnia.Sistema.de.Vendas.core.domain;

import br.com.incarnia.Sistema.de.Vendas.core.exceptions.MenuException;

import java.util.List;

public class Menu {

    private Long id;
    private String name;
    private String description;
    private Restaurant restaurant;
    private List<MenuItem> menuItems;

    public Menu() { }

    public Menu(Long id, String name, String description, Restaurant restaurant, List<MenuItem> menuItems) {
        setId(id);
        setName(name);
        setDescription(description);
        setRestaurant(restaurant);
        setMenuItems(menuItems);
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
            throw new MenuException("Menu name cannot be null");
        }

        if(name.isBlank()) {
            throw new MenuException("Menu name cannot be blank");
        }

        if(name.length() < 4) {
            throw new MenuException("Menu name length cannot be less than 4");
        }

        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {

        if(description != null) {
            if(description.length() > 255) {
                throw new MenuException("Menu description cannot be this big");
            }
        }

        this.description = description;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public List<MenuItem> getMenuItems() {
        return menuItems;
    }

    public void setMenuItems(List<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }

    public void addMenuItem(MenuItem menuItem) {
        if(this.menuItems.contains(menuItem)) {
            throw new MenuException("Menu already contain this menu item");
        }
        this.menuItems.add(menuItem);
    }

    public void removeMenuItem(MenuItem menuItem) {
        if(!this.menuItems.contains(menuItem)) {
            throw new MenuException("Menu item not found in menu");
        }
        this.menuItems.remove(menuItem);
    }
}
