package br.com.incarnia.Sistema.de.Vendas.application.usecases.restaurant.create;

import br.com.incarnia.Sistema.de.Vendas.application.gateways.RestaurantGateway;
import br.com.incarnia.Sistema.de.Vendas.core.domain.Restaurant;

public class CreateRestaurantImplementation implements  CreateRestaurantInterface {

    private final RestaurantGateway restaurantGateway;

    public CreateRestaurantImplementation(RestaurantGateway restaurantGateway) {
        this.restaurantGateway = restaurantGateway;
    }

    @Override
    public Restaurant createRestaurant(Restaurant restaurant) {
        return restaurantGateway.createRestaurant(restaurant);
    }
}
