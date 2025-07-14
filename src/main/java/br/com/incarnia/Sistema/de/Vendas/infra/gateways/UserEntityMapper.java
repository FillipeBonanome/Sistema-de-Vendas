package br.com.incarnia.Sistema.de.Vendas.infra.gateways;

import br.com.incarnia.Sistema.de.Vendas.core.domain.Address;
import br.com.incarnia.Sistema.de.Vendas.core.domain.User;
import br.com.incarnia.Sistema.de.Vendas.infra.persistence.AddressEntity;
import br.com.incarnia.Sistema.de.Vendas.infra.persistence.UserEntity;

public class UserEntityMapper {

    private AddressEntityMapper addressEntityMapper;

    public UserEntityMapper(AddressEntityMapper addressEntityMapper) {
        this.addressEntityMapper = addressEntityMapper;
    }

    public UserEntity toEntity(User user) {
        AddressEntity addressEntity = addressEntityMapper.toEntity(user.getAddress());
        return new UserEntity(user.getId(), user.getName(), user.getEmail(), user.getPassword(), user.getPhoneNumber(), addressEntity, user.getCPF(), user.getUserRole(), user.isDeleted());
    }

    public User toDomain(UserEntity userEntity) {
        Address address = addressEntityMapper.toDomain(userEntity.getAddressEntity());
        return new User(userEntity.getId(), userEntity.getName(), userEntity.getEmail(), userEntity.getPassword(), userEntity.getPhoneNumber(), address, userEntity.getCPF(), userEntity.getUserRole(), userEntity.isDeleted());
    }

}
