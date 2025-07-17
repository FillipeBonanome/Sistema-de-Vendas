package br.com.incarnia.Sistema.de.Vendas.application.gateways;

import br.com.incarnia.Sistema.de.Vendas.core.domain.Menu;

public interface MenuGateway {
    Menu createMenu(Menu menu);
    Menu findById(Long id);
}
