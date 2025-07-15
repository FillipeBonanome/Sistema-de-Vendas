package br.com.incarnia.Sistema.de.Vendas.application.gateways;

import br.com.incarnia.Sistema.de.Vendas.core.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserGateway {
    User createUser(User user);
    User findById(Long id);
    Page<User> findAll(Pageable pageable);
}
