package br.com.incarnia.Sistema.de.Vendas.application.usecases.user.readall;

import br.com.incarnia.Sistema.de.Vendas.application.gateways.UserGateway;
import br.com.incarnia.Sistema.de.Vendas.core.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class ReadAllUserImplementation implements ReadAllUserInterface{

    private UserGateway userGateway;

    public ReadAllUserImplementation(UserGateway userGateway) {
        this.userGateway = userGateway;
    }

    @Override
    public Page<User> findAll(Pageable pageable) {
        return userGateway.findAll(pageable);
    }
}
