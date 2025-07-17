package br.com.incarnia.Sistema.de.Vendas.infra.gateways.menu;

import br.com.incarnia.Sistema.de.Vendas.application.gateways.MenuGateway;
import br.com.incarnia.Sistema.de.Vendas.core.domain.Menu;
import br.com.incarnia.Sistema.de.Vendas.core.exceptions.MenuException;
import br.com.incarnia.Sistema.de.Vendas.infra.persistence.menu.MenuEntity;
import br.com.incarnia.Sistema.de.Vendas.infra.persistence.menu.MenuRepository;

import java.util.Optional;

public class MenuRepositoryGateway implements MenuGateway {

    private final MenuRepository menuRepository;
    private final MenuEntityMapper menuEntityMapper;


    public MenuRepositoryGateway(MenuRepository menuRepository, MenuEntityMapper menuEntityMapper) {
        this.menuRepository = menuRepository;
        this.menuEntityMapper = menuEntityMapper;
    }

    @Override
    public Menu createMenu(Menu menu) {
        MenuEntity menuEntity = menuEntityMapper.toEntity(menu);
        MenuEntity savedEntity = menuRepository.save(menuEntity);
        return menuEntityMapper.toDomain(savedEntity);
    }

    @Override
    public Menu findById(Long id) {
        Optional<MenuEntity> menuOptional = menuRepository.findById(id);
        if(menuOptional.isEmpty()) {
            throw new MenuException("Menu with id " + id + " not found");
        }
        MenuEntity entity = menuOptional.get();
        return menuEntityMapper.toDomain(entity);
    }
}
