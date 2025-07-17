package br.com.incarnia.Sistema.de.Vendas.infra.gateways.address;

import br.com.incarnia.Sistema.de.Vendas.core.domain.Address;
import br.com.incarnia.Sistema.de.Vendas.infra.persistence.address.AddressEntity;

public class AddressEntityMapper {

    public Address toDomain(AddressEntity entity) {
        return new Address(entity.getStreet(), entity.getNumber(), entity.getNeighborhood(), entity.getCity(), entity.getState(), entity.getCEP(), entity.getComplement());
    }

    public AddressEntity toEntity(Address address) {
        return new AddressEntity(address.getStreet(), address.getNumber(), address.getNeighborhood(), address.getCity(), address.getState(), address.getCEP(), address.getComplement());
    }

}
