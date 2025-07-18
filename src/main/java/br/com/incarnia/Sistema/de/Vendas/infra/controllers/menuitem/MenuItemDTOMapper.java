package br.com.incarnia.Sistema.de.Vendas.infra.controllers.menuitem;

import br.com.incarnia.Sistema.de.Vendas.core.domain.Menu;
import br.com.incarnia.Sistema.de.Vendas.core.domain.MenuItem;

public class MenuItemDTOMapper {

    public CreateMenuItemResponse toCreateResponse(MenuItem menuItem) {
        return new CreateMenuItemResponse(
                menuItem.getName(),
                menuItem.getDescription(),
                menuItem.getPrice(),
                menuItem.getMenu().getId()
        );
    }

    public MenuItem toMenuItem(CreateMenuItemRequest menuItemRequest) {
        return new MenuItem(
                null,
                menuItemRequest.name(),
                menuItemRequest.description(),
                menuItemRequest.price(),
                new Menu()                                  //Menu is added later...
        );
    }

    public ReadMenuItemResponse toReadResponse(MenuItem menuItem) {
        return new ReadMenuItemResponse(
                menuItem.getName(),
                menuItem.getDescription(),
                menuItem.getPrice()
        );
    }

}
