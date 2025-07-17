package br.com.incarnia.Sistema.de.Vendas.infra.controllers.menu;

public record CreateMenuRequest(
        String name,
        String description,
        Long restaurantId
        //TODO --> add menu items
) {
}
