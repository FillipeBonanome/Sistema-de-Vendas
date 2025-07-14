package br.com.incarnia.Sistema.de.Vendas.application.usecases.user.create;

import br.com.incarnia.Sistema.de.Vendas.application.gateways.UserGateway;
import br.com.incarnia.Sistema.de.Vendas.core.domain.User;

public class CreateUserImplementation implements CreateUserInterface {

    private final UserGateway userGateway;

    public CreateUserImplementation(UserGateway userGateway) {
        this.userGateway = userGateway;
    }

    @Override
    public User createUser(User user) {
        return userGateway.createUser(user);
    }
}
