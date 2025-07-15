package br.com.incarnia.Sistema.de.Vendas.infra.controllers.user;

import br.com.incarnia.Sistema.de.Vendas.core.domain.Address;
import br.com.incarnia.Sistema.de.Vendas.core.domain.User;
import br.com.incarnia.Sistema.de.Vendas.core.domain.UserRole;
import br.com.incarnia.Sistema.de.Vendas.core.exceptions.UserException;

public class UserDTOMapper {
    public CreateUserResponse toResponse(User user) {
        return new CreateUserResponse(user.getName(), user.getEmail(), user.getPhoneNumber(), user.getAddress(), user.getCPF(), user.getUserRole());
    }

    //TODO Change user role
    public User toUser(CreateUserRequest request) {
        Address responseAddress = request.address();

        if(responseAddress == null) {
            throw new UserException("User address cannot be null");
        }

        Address userAddress = new Address(responseAddress.getStreet(), responseAddress.getNumber(), responseAddress.getNeighborhood(), responseAddress.getCity(), responseAddress.getState(), responseAddress.getCEP(), responseAddress.getComplement());
        return new User(null, request.name(), request.email(), request.password(), request.phone(), userAddress, request.CPF(), UserRole.CLIENT, false);
    }
}
