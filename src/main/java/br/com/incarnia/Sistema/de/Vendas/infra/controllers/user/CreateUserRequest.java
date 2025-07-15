package br.com.incarnia.Sistema.de.Vendas.infra.controllers.user;
import br.com.incarnia.Sistema.de.Vendas.core.domain.Address;

public record CreateUserRequest(
        String name,
        String password,
        String email,
        String phone,
        Address address,
        String CPF
) {
}
