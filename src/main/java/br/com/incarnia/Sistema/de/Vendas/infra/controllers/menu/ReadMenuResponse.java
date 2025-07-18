package br.com.incarnia.Sistema.de.Vendas.infra.controllers.menu;

import br.com.incarnia.Sistema.de.Vendas.infra.controllers.menuitem.ReadMenuItemResponse;

import java.util.List;

public record ReadMenuResponse(
        Long id,
        String name,
        String description,
        List<ReadMenuItemResponse> items
) {
}
