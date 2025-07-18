package br.com.incarnia.Sistema.de.Vendas.infra.gateways.menuitem;

import br.com.incarnia.Sistema.de.Vendas.application.gateways.MenuItemGateway;
import br.com.incarnia.Sistema.de.Vendas.core.domain.MenuItem;
import br.com.incarnia.Sistema.de.Vendas.core.exceptions.MenuItemException;
import br.com.incarnia.Sistema.de.Vendas.infra.persistence.menu.MenuEntity;
import br.com.incarnia.Sistema.de.Vendas.infra.persistence.menuitem.MenuItemEntity;
import br.com.incarnia.Sistema.de.Vendas.infra.persistence.menuitem.MenuItemRepository;
import br.com.incarnia.Sistema.de.Vendas.infra.persistence.restaurant.RestaurantEntity;

import java.util.Optional;

public class MenuItemRepositoryGateway implements MenuItemGateway {

    private final MenuItemRepository menuItemRepository;
    private final MenuItemEntityMapper menuItemEntityMapper;

    public MenuItemRepositoryGateway(MenuItemRepository menuItemRepository, MenuItemEntityMapper menuItemEntityMapper) {
        this.menuItemRepository = menuItemRepository;
        this.menuItemEntityMapper = menuItemEntityMapper;
    }

    @Override
    public MenuItem createMenuItem(MenuItem menuItem) {
        MenuItemEntity menuItemEntity = menuItemEntityMapper.toEntity(menuItem);
        MenuItemEntity savedEntity = menuItemRepository.save(menuItemEntity);
        return menuItemEntityMapper.toDomain(savedEntity);
    }

    @Override
    public MenuItem findById(Long id) {
        Optional<MenuItemEntity> menuItemOptional = menuItemRepository.findById(id);

        if (menuItemOptional.isEmpty()) {
            throw new MenuItemException("Menu item with id " + id + " not found");
        }
        MenuItemEntity menuItem = menuItemOptional.get();
        return menuItemEntityMapper.toDomain(menuItem);
    }
}
