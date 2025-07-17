package br.com.incarnia.Sistema.de.Vendas.application.usecases.menu.read;

import br.com.incarnia.Sistema.de.Vendas.core.domain.Menu;

public interface ReadMenuInterface {
    public Menu findById(Long id);
}
