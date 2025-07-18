package br.com.incarnia.Sistema.de.Vendas.infra.gateways.menuitem;

import br.com.incarnia.Sistema.de.Vendas.core.domain.Menu;
import br.com.incarnia.Sistema.de.Vendas.core.domain.MenuItem;
import br.com.incarnia.Sistema.de.Vendas.infra.persistence.menu.MenuEntity;
import br.com.incarnia.Sistema.de.Vendas.infra.persistence.menuitem.MenuItemEntity;

public class MenuItemEntityMapper {

    public MenuItem toDomain(MenuItemEntity entity) {
        Menu menu = new Menu();
        menu.setId(entity.getMenuEntity().getId());
        return new MenuItem(
                entity.getId(),
                entity.getName(),
                entity.getDescription(),
                entity.getPrice(),
                menu
        );
    }

    public MenuItemEntity toEntity(MenuItem menuItem) {
        MenuEntity entity = new MenuEntity();
        entity.setId(menuItem.getMenu().getId());
        return new MenuItemEntity(
                menuItem.getId(),
                menuItem.getName(),
                menuItem.getDescription(),
                menuItem.getPrice(),
                entity
        );
    }

}
