package br.com.incarnia.Sistema.de.Vendas.application.usecases.restaurant.read;

import br.com.incarnia.Sistema.de.Vendas.core.domain.Restaurant;

public interface ReadRestaurantInterface {
    public Restaurant findById(Long id);
}
