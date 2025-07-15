package br.com.incarnia.Sistema.de.Vendas.application.usecases.user.readall;

import br.com.incarnia.Sistema.de.Vendas.core.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ReadAllUserInterface {
    public Page<User> findAll(Pageable pageable);
}
