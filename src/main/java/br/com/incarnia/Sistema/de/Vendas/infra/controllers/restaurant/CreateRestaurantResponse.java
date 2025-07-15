package br.com.incarnia.Sistema.de.Vendas.infra.controllers.restaurant;

import br.com.incarnia.Sistema.de.Vendas.core.domain.Address;
import br.com.incarnia.Sistema.de.Vendas.core.domain.Menu;

import java.math.BigDecimal;
import java.util.List;

public record CreateRestaurantResponse(
        Long id,
        String name,
        String description,
        Address address,
        String phoneNumber,
        String CNPJ,
        BigDecimal deliveryFee,
        Integer deliveryTime,
        List<Menu> menus            //TODO --> Use DTO for menus
) {
}
