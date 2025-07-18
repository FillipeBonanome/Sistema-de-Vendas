package br.com.incarnia.Sistema.de.Vendas.application.usecases.menu.read;

import br.com.incarnia.Sistema.de.Vendas.application.gateways.MenuGateway;
import br.com.incarnia.Sistema.de.Vendas.core.domain.Menu;
import br.com.incarnia.Sistema.de.Vendas.core.exceptions.MenuException;
import br.com.incarnia.Sistema.de.Vendas.core.exceptions.MenuItemException;

public class ReadMenuImplementation implements ReadMenuInterface{

    private final MenuGateway menuGateway;

    public ReadMenuImplementation(MenuGateway menuGateway) {
        this.menuGateway = menuGateway;
    }

    @Override
    public Menu findById(Long id) {

        if(id == null) {
            throw new MenuException("Cannot find menu by null id");
        }

        return this.menuGateway.findById(id);
    }
}
