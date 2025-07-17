package br.com.incarnia.Sistema.de.Vendas.infra.gateways.restaurant;

import br.com.incarnia.Sistema.de.Vendas.core.domain.Address;
import br.com.incarnia.Sistema.de.Vendas.core.domain.Menu;
import br.com.incarnia.Sistema.de.Vendas.core.domain.Restaurant;
import br.com.incarnia.Sistema.de.Vendas.infra.gateways.address.AddressEntityMapper;
import br.com.incarnia.Sistema.de.Vendas.infra.gateways.menu.MenuEntityMapper;
import br.com.incarnia.Sistema.de.Vendas.infra.persistence.address.AddressEntity;
import br.com.incarnia.Sistema.de.Vendas.infra.persistence.menu.MenuEntity;
import br.com.incarnia.Sistema.de.Vendas.infra.persistence.restaurant.RestaurantEntity;

import java.util.ArrayList;

public class RestaurantEntityMapper {

    private final AddressEntityMapper addressEntityMapper;

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
                restaurant.getDeliveryTime(),
                restaurant.getMenus().stream().map(m -> new MenuEntity(
                       m.getId(),
                        m.getName(),
                        m.getDescription(),
                        new RestaurantEntity()                  //TODO --> REMOVE GAMBIARRA
                )).toList()
        );
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
                restaurantEntity.getMenus().stream().map(m -> new Menu(
                            m.getId(),
                            m.getName(),
                            m.getDescription(),
                            new Restaurant(),
                            new ArrayList<>()
                    )).toList()
        );
    }

}
