package br.com.incarnia.Sistema.de.Vendas.infra.persistence.menu;

import br.com.incarnia.Sistema.de.Vendas.core.domain.MenuItem;
import br.com.incarnia.Sistema.de.Vendas.core.domain.Restaurant;
import br.com.incarnia.Sistema.de.Vendas.infra.persistence.restaurant.RestaurantEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "menus")
public class MenuEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_id")
    private RestaurantEntity restaurantEntity;
    //private List<MenuItem> menuItems = new ArrayList<>(); TODO --> add menu item

    public MenuEntity() {}

    public MenuEntity(Long id, String name, String description, RestaurantEntity restaurantEntity) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.restaurantEntity = restaurantEntity;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public RestaurantEntity getRestaurantEntity() {
        return restaurantEntity;
    }

    public void setRestaurantEntity(RestaurantEntity restaurantEntity) {
        this.restaurantEntity = restaurantEntity;
    }
}
