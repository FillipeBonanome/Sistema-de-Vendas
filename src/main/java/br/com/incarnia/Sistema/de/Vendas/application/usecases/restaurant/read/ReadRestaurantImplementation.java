package br.com.incarnia.Sistema.de.Vendas.application.usecases.restaurant.read;

import br.com.incarnia.Sistema.de.Vendas.application.gateways.RestaurantGateway;
import br.com.incarnia.Sistema.de.Vendas.core.domain.Restaurant;

public class ReadRestaurantImplementation implements ReadRestaurantInterface{

    private final RestaurantGateway restaurantGateway;

    public ReadRestaurantImplementation(RestaurantGateway restaurantGateway) {
        this.restaurantGateway = restaurantGateway;
    }

    @Override
    public Restaurant findById(Long id) {
        return restaurantGateway.findById(id);
    }
}
