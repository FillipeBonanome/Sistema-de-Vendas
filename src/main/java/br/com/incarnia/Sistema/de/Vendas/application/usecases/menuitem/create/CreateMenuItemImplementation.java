package br.com.incarnia.Sistema.de.Vendas.application.usecases.menuitem.create;

import br.com.incarnia.Sistema.de.Vendas.application.gateways.MenuItemGateway;
import br.com.incarnia.Sistema.de.Vendas.application.usecases.menu.create.CreateMenuImplementation;
import br.com.incarnia.Sistema.de.Vendas.core.domain.MenuItem;

public class CreateMenuItemImplementation implements CreateMenuItemInterface {

    private final MenuItemGateway menuItemGateway;

    public CreateMenuItemImplementation(MenuItemGateway menuItemGateway) {
        this.menuItemGateway = menuItemGateway;
    }

    @Override
    public MenuItem createMenuItem(MenuItem menuItem) {
        return this.menuItemGateway.createMenuItem(menuItem);
    }
}
