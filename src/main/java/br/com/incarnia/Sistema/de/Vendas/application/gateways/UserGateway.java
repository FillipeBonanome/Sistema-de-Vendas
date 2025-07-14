package br.com.incarnia.Sistema.de.Vendas.application.gateways;

import br.com.incarnia.Sistema.de.Vendas.core.domain.User;

public interface UserGateway {
    User createUser(User user);
    User findById(Long id);

}
