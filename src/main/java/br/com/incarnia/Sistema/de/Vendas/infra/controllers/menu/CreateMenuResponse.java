package br.com.incarnia.Sistema.de.Vendas.infra.controllers.menu;

public record CreateMenuResponse(
        String name,
        String description,
        Long restaurantId
        //TODO --> add menu item list
) {
}
