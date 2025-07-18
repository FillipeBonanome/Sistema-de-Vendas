package br.com.incarnia.Sistema.de.Vendas.application.usecases.menuitem.read;

import br.com.incarnia.Sistema.de.Vendas.core.domain.MenuItem;

public interface ReadMenuItemInterface {
    MenuItem findById(Long id);
}
