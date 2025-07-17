package br.com.incarnia.Sistema.de.Vendas.application.usecases.menu.create;

import br.com.incarnia.Sistema.de.Vendas.application.gateways.MenuGateway;
import br.com.incarnia.Sistema.de.Vendas.core.domain.Menu;

public class CreateMenuImplementation implements CreateMenuInterface {
    private final MenuGateway menuGateway;

    public CreateMenuImplementation(MenuGateway menuGateway) {
        this.menuGateway = menuGateway;
    }

    @Override
    public Menu createMenu(Menu menu) {
        return this.menuGateway.createMenu(menu);
    }
}
