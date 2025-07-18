package br.com.incarnia.Sistema.de.Vendas.infra.gateways.menu;

import br.com.incarnia.Sistema.de.Vendas.core.domain.Menu;
import br.com.incarnia.Sistema.de.Vendas.core.domain.MenuItem;
import br.com.incarnia.Sistema.de.Vendas.core.domain.Restaurant;
import br.com.incarnia.Sistema.de.Vendas.infra.gateways.menuitem.MenuItemEntityMapper;
import br.com.incarnia.Sistema.de.Vendas.infra.gateways.restaurant.RestaurantEntityMapper;
import br.com.incarnia.Sistema.de.Vendas.infra.persistence.menu.MenuEntity;
import br.com.incarnia.Sistema.de.Vendas.infra.persistence.menuitem.MenuItemEntity;
import br.com.incarnia.Sistema.de.Vendas.infra.persistence.restaurant.RestaurantEntity;

import java.util.ArrayList;

public class MenuEntityMapper {

    private final RestaurantEntityMapper restaurantEntityMapper;
    private final MenuItemEntityMapper menuItemEntityMapper;

    public MenuEntityMapper(RestaurantEntityMapper restaurantEntityMapper, MenuItemEntityMapper menuItemEntityMapper) {
        this.restaurantEntityMapper = restaurantEntityMapper;
        this.menuItemEntityMapper = menuItemEntityMapper;
    }

    public Menu toDomain(MenuEntity entity) {
        Restaurant restaurant = restaurantEntityMapper.toDomain(entity.getRestaurantEntity());
        return new Menu(entity.getId(), entity.getName(), entity.getDescription(), restaurant, entity.getMenuItemEntityList().stream().map(menuItemEntityMapper::toDomain).toList());
    }

    public MenuEntity toEntity(Menu menu) {
        RestaurantEntity restaurantEntity = restaurantEntityMapper.toEntity(menu.getRestaurant());
        return new MenuEntity(menu.getId(), menu.getName(), menu.getDescription(), restaurantEntity, menu.getMenuItems().stream().map(menuItemEntityMapper::toEntity).toList());
    }

}
