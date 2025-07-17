package br.com.incarnia.Sistema.de.Vendas.infra.gateways.menu;

import br.com.incarnia.Sistema.de.Vendas.core.domain.Menu;
import br.com.incarnia.Sistema.de.Vendas.core.domain.Restaurant;
import br.com.incarnia.Sistema.de.Vendas.infra.gateways.restaurant.RestaurantEntityMapper;
import br.com.incarnia.Sistema.de.Vendas.infra.persistence.menu.MenuEntity;
import br.com.incarnia.Sistema.de.Vendas.infra.persistence.restaurant.RestaurantEntity;

import java.util.ArrayList;

public class MenuEntityMapper {

    private final RestaurantEntityMapper restaurantEntityMapper;

    public MenuEntityMapper(RestaurantEntityMapper restaurantEntityMapper) {
        this.restaurantEntityMapper = restaurantEntityMapper;
    }

    public Menu toDomain(MenuEntity entity) {
        Restaurant restaurant = restaurantEntityMapper.toDomain(entity.getRestaurantEntity());
        return new Menu(entity.getId(), entity.getName(), entity.getDescription(), restaurant, new ArrayList<>()); //TODO --> add menu items
    }

    public MenuEntity toEntity(Menu menu) {
        RestaurantEntity restaurantEntity = restaurantEntityMapper.toEntity(menu.getRestaurant());
        return new MenuEntity(menu.getId(), menu.getName(), menu.getDescription(), restaurantEntity);           //TODO --> add menu items
    }

}
