package br.com.incarnia.Sistema.de.Vendas.application.usecases.menu.read;

import br.com.incarnia.Sistema.de.Vendas.application.gateways.MenuGateway;
import br.com.incarnia.Sistema.de.Vendas.core.domain.Menu;

public class ReadMenuImplementation implements ReadMenuInterface{

    private final MenuGateway menuGateway;

    public ReadMenuImplementation(MenuGateway menuGateway) {
        this.menuGateway = menuGateway;
    }

    @Override
    public Menu findById(Long id) {
        return this.menuGateway.findById(id);
    }
}
