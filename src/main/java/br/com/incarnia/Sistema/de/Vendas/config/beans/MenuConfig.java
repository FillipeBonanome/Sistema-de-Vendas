package br.com.incarnia.Sistema.de.Vendas.config.beans;

import br.com.incarnia.Sistema.de.Vendas.application.gateways.MenuGateway;
import br.com.incarnia.Sistema.de.Vendas.application.usecases.menu.create.CreateMenuImplementation;
import br.com.incarnia.Sistema.de.Vendas.application.usecases.menu.read.ReadMenuImplementation;
import br.com.incarnia.Sistema.de.Vendas.infra.controllers.menu.MenuDTOMapper;
import br.com.incarnia.Sistema.de.Vendas.infra.gateways.menu.MenuEntityMapper;
import br.com.incarnia.Sistema.de.Vendas.infra.gateways.menu.MenuRepositoryGateway;
import br.com.incarnia.Sistema.de.Vendas.infra.gateways.restaurant.RestaurantEntityMapper;
import br.com.incarnia.Sistema.de.Vendas.infra.persistence.menu.MenuRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MenuConfig {

    @Bean
    public CreateMenuImplementation createMenuImplementation(MenuGateway menuGateway) {
        return new CreateMenuImplementation(menuGateway);
    }

    @Bean
    public ReadMenuImplementation readMenuImplementation(MenuGateway menuGateway) {
        return new ReadMenuImplementation(menuGateway);
    }

    @Bean
    public MenuRepositoryGateway menuRepositoryGateway(MenuRepository menuRepository, MenuEntityMapper menuEntityMapper) {
        return new MenuRepositoryGateway(menuRepository, menuEntityMapper);
    }

    @Bean
    public MenuEntityMapper menuEntityMapper(RestaurantEntityMapper restaurantEntityMapper) {
        return new MenuEntityMapper(restaurantEntityMapper);
    }

    @Bean
    public MenuDTOMapper menuDTOMapper() {
        return new MenuDTOMapper();
    }

}
