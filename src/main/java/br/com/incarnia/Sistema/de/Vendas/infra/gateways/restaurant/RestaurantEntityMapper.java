package br.com.incarnia.Sistema.de.Vendas.infra.gateways.restaurant;

import br.com.incarnia.Sistema.de.Vendas.core.domain.Address;
import br.com.incarnia.Sistema.de.Vendas.core.domain.Restaurant;
import br.com.incarnia.Sistema.de.Vendas.infra.gateways.address.AddressEntityMapper;
import br.com.incarnia.Sistema.de.Vendas.infra.persistence.AddressEntity;
import br.com.incarnia.Sistema.de.Vendas.infra.persistence.restaurant.RestaurantEntity;

import java.util.ArrayList;

public class RestaurantEntityMapper {

    private AddressEntityMapper addressEntityMapper;

    public RestaurantEntityMapper(AddressEntityMapper addressEntityMapper) {
        this.addressEntityMapper = addressEntityMapper;
    }

    public RestaurantEntity toEntity(Restaurant restaurant) {
        AddressEntity addressEntity = addressEntityMapper.toEntity(restaurant.getAddress());
        return new RestaurantEntity(
                restaurant.getId(),
                restaurant.getName(),
                restaurant.getDescription(),
                addressEntity,
                restaurant.getPhoneNumber(),
                restaurant.getCNPJ(),
                restaurant.getDeliveryFee(),
                restaurant.getDeliveryTime()
        );                                  //TODO --> add menus
    }

    public Restaurant toDomain(RestaurantEntity restaurantEntity) {
        Address address = addressEntityMapper.toDomain(restaurantEntity.getAddress());
        return new Restaurant(
                restaurantEntity.getId(),
                restaurantEntity.getName(),
                restaurantEntity.getDescription(),
                address,
                restaurantEntity.getPhoneNumber(),
                restaurantEntity.getCNPJ(),
                restaurantEntity.getDeliveryFee(),
                restaurantEntity.getDeliveryTime(),
                new ArrayList<>()           //TODO --> add menus
        );
    }

}
