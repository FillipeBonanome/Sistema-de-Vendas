package br.com.incarnia.Sistema.de.Vendas.infra.controllers.menu;

import br.com.incarnia.Sistema.de.Vendas.core.domain.Menu;
import br.com.incarnia.Sistema.de.Vendas.core.domain.Restaurant;
import br.com.incarnia.Sistema.de.Vendas.infra.controllers.menuitem.ReadMenuItemResponse;

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

    public ReadMenuResponse toReadResponse(Menu menu) {
        return new ReadMenuResponse(
                menu.getId(),
                menu.getName(),
                menu.getDescription(),
                menu.getMenuItems().stream().map(i -> new ReadMenuItemResponse(
                        i.getName(),
                        i.getDescription(),
                        i.getPrice()
                )).toList()
        );
    }

}
