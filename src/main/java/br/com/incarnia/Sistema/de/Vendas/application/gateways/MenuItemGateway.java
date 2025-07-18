package br.com.incarnia.Sistema.de.Vendas.application.gateways;

import br.com.incarnia.Sistema.de.Vendas.core.domain.MenuItem;

public interface MenuItemGateway {
    MenuItem createMenuItem(MenuItem menuItem);
    MenuItem findById(Long id);
}
