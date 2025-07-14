package br.com.incarnia.Sistema.de.Vendas.infra.controllers;

import br.com.incarnia.Sistema.de.Vendas.core.domain.Address;
import br.com.incarnia.Sistema.de.Vendas.core.domain.User;
import br.com.incarnia.Sistema.de.Vendas.core.domain.UserRole;

public class UserDTOMapper {
    public CreateUserResponse toResponse(User user) {
        return new CreateUserResponse(user.getName(), user.getEmail(), user.getPhoneNumber(), user.getAddress(), user.getCPF(), user.getUserRole());
    }

    //TODO Change user role
    public User toUser(CreateUserRequest response) {
        Address responseAddress = response.address();
        Address userAddress = new Address(responseAddress.getStreet(), responseAddress.getNumber(), responseAddress.getNeighborhood(), responseAddress.getCity(), responseAddress.getState(), responseAddress.getCEP(), responseAddress.getComplement());
        return new User(null, response.name(), response.email(), response.password(), response.phone(), userAddress, response.CPF(), UserRole.CLIENT, false);
    }
}
