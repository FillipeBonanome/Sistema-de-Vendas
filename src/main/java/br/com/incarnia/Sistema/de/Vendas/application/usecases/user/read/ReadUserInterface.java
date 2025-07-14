package br.com.incarnia.Sistema.de.Vendas.application.usecases.user.read;

import br.com.incarnia.Sistema.de.Vendas.core.domain.User;

public interface ReadUserInterface {
    public User findById(Long id);
}
