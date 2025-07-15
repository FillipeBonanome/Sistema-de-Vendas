package br.com.incarnia.Sistema.de.Vendas.infra.controllers.restaurant;

import br.com.incarnia.Sistema.de.Vendas.core.domain.Address;
import br.com.incarnia.Sistema.de.Vendas.core.domain.Restaurant;
import br.com.incarnia.Sistema.de.Vendas.core.exceptions.UserException;

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
                restaurant.getMenus()
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
