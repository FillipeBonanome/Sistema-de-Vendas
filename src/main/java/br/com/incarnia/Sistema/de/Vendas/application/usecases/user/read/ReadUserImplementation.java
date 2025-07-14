package br.com.incarnia.Sistema.de.Vendas.application.usecases.user.read;

import br.com.incarnia.Sistema.de.Vendas.application.gateways.UserGateway;
import br.com.incarnia.Sistema.de.Vendas.core.domain.User;

public class ReadUserImplementation implements ReadUserInterface{

    private final UserGateway userGateway;

    public ReadUserImplementation(UserGateway userGateway) {
        this.userGateway = userGateway;
    }

    @Override
    public User findById(Long id) {
        return userGateway.findById(id);
    }

}
