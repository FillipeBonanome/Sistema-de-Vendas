package br.com.incarnia.Sistema.de.Vendas.application.usecases.restaurant.read;

import br.com.incarnia.Sistema.de.Vendas.application.gateways.RestaurantGateway;
import br.com.incarnia.Sistema.de.Vendas.core.domain.Restaurant;
import br.com.incarnia.Sistema.de.Vendas.core.exceptions.RestaurantException;

public class ReadRestaurantImplementation implements ReadRestaurantInterface{

    private final RestaurantGateway restaurantGateway;

    public ReadRestaurantImplementation(RestaurantGateway restaurantGateway) {
        this.restaurantGateway = restaurantGateway;
    }

    @Override
    public Restaurant findById(Long id) {

        if(id == null) {
            throw new RestaurantException("Cannot find restaurant by null id");
        }

        return restaurantGateway.findById(id);
    }
}
