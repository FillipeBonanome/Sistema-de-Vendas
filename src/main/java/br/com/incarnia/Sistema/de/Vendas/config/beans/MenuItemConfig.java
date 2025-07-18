package br.com.incarnia.Sistema.de.Vendas.config.beans;

import br.com.incarnia.Sistema.de.Vendas.application.gateways.MenuItemGateway;
import br.com.incarnia.Sistema.de.Vendas.application.usecases.menuitem.create.CreateMenuItemImplementation;
import br.com.incarnia.Sistema.de.Vendas.application.usecases.menuitem.read.ReadMenuItemImplementation;
import br.com.incarnia.Sistema.de.Vendas.infra.controllers.menuitem.MenuItemDTOMapper;
import br.com.incarnia.Sistema.de.Vendas.infra.gateways.menu.MenuEntityMapper;
import br.com.incarnia.Sistema.de.Vendas.infra.gateways.menuitem.MenuItemEntityMapper;
import br.com.incarnia.Sistema.de.Vendas.infra.gateways.menuitem.MenuItemRepositoryGateway;
import br.com.incarnia.Sistema.de.Vendas.infra.persistence.menuitem.MenuItemRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MenuItemConfig {

    @Bean
    public CreateMenuItemImplementation createMenuItemImplementation(MenuItemGateway menuItemGateway) {
        return new CreateMenuItemImplementation(menuItemGateway);
    }

    @Bean
    public ReadMenuItemImplementation readMenuItemImplementation(MenuItemGateway menuItemGateway) {
        return new ReadMenuItemImplementation(menuItemGateway);
    }

    @Bean
    public MenuItemRepositoryGateway menuItemRepositoryGateway(MenuItemRepository menuItemRepository, MenuItemEntityMapper menuItemEntityMapper) {
        return new MenuItemRepositoryGateway(menuItemRepository, menuItemEntityMapper);
    }

    @Bean
    public MenuItemEntityMapper menuItemEntityMapper() {
        return new MenuItemEntityMapper();
    }

    @Bean
    public MenuItemDTOMapper menuItemDTOMapper() {
        return new MenuItemDTOMapper();
    }


}
