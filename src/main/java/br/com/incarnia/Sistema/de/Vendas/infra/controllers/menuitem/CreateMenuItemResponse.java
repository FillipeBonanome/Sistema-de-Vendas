package br.com.incarnia.Sistema.de.Vendas.infra.controllers.menuitem;

import java.math.BigDecimal;

public record CreateMenuItemResponse(
        String name,
        String description,
        BigDecimal price,
        Long menuId
) {
}
