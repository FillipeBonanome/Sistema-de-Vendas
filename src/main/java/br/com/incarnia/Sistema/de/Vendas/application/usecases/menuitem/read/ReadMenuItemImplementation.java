package br.com.incarnia.Sistema.de.Vendas.application.usecases.menuitem.read;

import br.com.incarnia.Sistema.de.Vendas.application.gateways.MenuItemGateway;
import br.com.incarnia.Sistema.de.Vendas.core.domain.MenuItem;
import br.com.incarnia.Sistema.de.Vendas.core.exceptions.MenuItemException;
import br.com.incarnia.Sistema.de.Vendas.core.exceptions.RestaurantException;

public class ReadMenuItemImplementation implements ReadMenuItemInterface {

    private final MenuItemGateway menuItemGateway;

    public ReadMenuItemImplementation(MenuItemGateway menuItemGateway) {
        this.menuItemGateway = menuItemGateway;
    }

    @Override
    public MenuItem findById(Long id) {

        if(id == null) {
            throw new MenuItemException("Cannot find menu item by null id");
        }

        return menuItemGateway.findById(id);
    }
}
