package br.com.incarnia.Sistema.de.Vendas.application.gateways;

import br.com.incarnia.Sistema.de.Vendas.core.domain.Restaurant;

public interface RestaurantGateway {
    Restaurant createRestaurant(Restaurant restaurant);
    Restaurant findById(Long id);

}
