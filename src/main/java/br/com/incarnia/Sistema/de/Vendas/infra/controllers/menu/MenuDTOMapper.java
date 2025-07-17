package br.com.incarnia.Sistema.de.Vendas.infra.controllers.menu;

import br.com.incarnia.Sistema.de.Vendas.core.domain.Menu;
import br.com.incarnia.Sistema.de.Vendas.core.domain.Restaurant;

import java.util.ArrayList;

public class MenuDTOMapper {

    public CreateMenuResponse toResponse(Menu menu) {
        return new CreateMenuResponse(
                menu.getName(),
                menu.getDescription(),
                menu.getRestaurant().getId()
        );
    }

    public Menu toMenu(CreateMenuRequest request) {
        return new Menu(
                null,
                request.name(),
                request.description(),
                new Restaurant(),
                new ArrayList<>()
        );
    }

}
