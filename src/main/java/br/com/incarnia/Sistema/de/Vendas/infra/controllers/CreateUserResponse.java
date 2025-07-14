package br.com.incarnia.Sistema.de.Vendas.infra.controllers;

import br.com.incarnia.Sistema.de.Vendas.core.domain.Address;
import br.com.incarnia.Sistema.de.Vendas.core.domain.UserRole;

public record CreateUserResponse(
        String name,
        String email,
        String phone,
        Address address,
        String CPF,
        UserRole userRole
) {
}
