package br.com.incarnia.Sistema.de.Vendas.infra.controllers.restaurant;

import br.com.incarnia.Sistema.de.Vendas.core.domain.Address;
import br.com.incarnia.Sistema.de.Vendas.core.domain.Restaurant;
import br.com.incarnia.Sistema.de.Vendas.core.exceptions.UserException;
import br.com.incarnia.Sistema.de.Vendas.infra.controllers.menu.ReadMenuResponse;
import br.com.incarnia.Sistema.de.Vendas.infra.controllers.menuitem.ReadMenuItemResponse;

public class RestaurantDTOMapper {

    public CreateRestaurantResponse toResponse(Restaurant restaurant) {
        return new CreateRestaurantResponse(
                restaurant.getId(),
                restaurant.getName(),
                restaurant.getDescription(),
                restaurant.getAddress(),
                restaurant.getPhoneNumber(),
                restaurant.getCNPJ(),
                restaurant.getDeliveryFee(),
                restaurant.getDeliveryTime(),
                restaurant.getMenus().stream().map(m -> new ReadMenuResponse(
                        m.getId(),
                        m.getName(),
                        m.getDescription(),
                        m.getMenuItems().stream().map( i -> new ReadMenuItemResponse(
                                i.getName(),
                                i.getDescription(),
                                i.getPrice()
                        )).toList()
                )).toList()
        );
    }

    public ReadRestaurantResponse toReadResponse(Restaurant restaurant) {
        return new ReadRestaurantResponse(
                restaurant.getId(),
                restaurant.getName(),
                restaurant.getDescription(),
                restaurant.getAddress(),
                restaurant.getPhoneNumber(),
                restaurant.getCNPJ(),
                restaurant.getDeliveryFee(),
                restaurant.getDeliveryTime(),
                restaurant.getMenus().stream().map(m -> new ReadMenuResponse(
                        m.getId(),
                        m.getName(),
                        m.getDescription(),
                        m.getMenuItems().stream().map(i -> new ReadMenuItemResponse(
                                i.getName(),
                                i.getDescription(),
                                i.getPrice()
                        )).toList()
                )).toList()
        );
    }

    public Restaurant toRestaurant(CreateRestaurantRequest request) {
        Address responseAddress = request.address();

        if(responseAddress == null) {
            throw new UserException("Restaurant address cannot be null");
        }

        Address restaurantAddress = new Address(
                responseAddress.getStreet(),
                responseAddress.getNumber(),
                responseAddress.getNeighborhood(),
                responseAddress.getCity(),
                responseAddress.getState(),
                responseAddress.getCEP(),
                responseAddress.getComplement()
        );
        return new Restaurant(
                null,
                request.name(),
                request.description(),
                restaurantAddress,
                request.phoneNumber(),
                request.CNPJ(),
                request.deliveryFee(),
                request.deliveryTime(),
                request.menus());
    }
}
