package br.com.incarnia.Sistema.de.Vendas.infra.controllers.menuitem;

import br.com.incarnia.Sistema.de.Vendas.application.usecases.menu.create.CreateMenuImplementation;
import br.com.incarnia.Sistema.de.Vendas.application.usecases.menu.read.ReadMenuImplementation;
import br.com.incarnia.Sistema.de.Vendas.application.usecases.menuitem.create.CreateMenuItemImplementation;
import br.com.incarnia.Sistema.de.Vendas.application.usecases.menuitem.read.ReadMenuItemImplementation;
import br.com.incarnia.Sistema.de.Vendas.core.domain.Menu;
import br.com.incarnia.Sistema.de.Vendas.core.domain.MenuItem;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/menu_items")
public class MenuItemController {

    private final CreateMenuItemImplementation createMenuItemImplementation;
    private final ReadMenuImplementation readMenuImplementation;
    private final MenuItemDTOMapper menuItemDTOMapper;
    private final ReadMenuItemImplementation readMenuItemImplementation;

    public MenuItemController(CreateMenuItemImplementation createMenuItemImplementation, ReadMenuImplementation readMenuImplementation, MenuItemDTOMapper menuItemDTOMapper, ReadMenuItemImplementation readMenuItemImplementation) {
        this.createMenuItemImplementation = createMenuItemImplementation;
        this.readMenuImplementation = readMenuImplementation;
        this.menuItemDTOMapper = menuItemDTOMapper;
        this.readMenuItemImplementation = readMenuItemImplementation;
    }


    @PostMapping
    @Transactional
    public ResponseEntity<CreateMenuItemResponse> createMenuItem(@RequestBody CreateMenuItemRequest request) {
        //TODO --> refactor this logic?
        Menu menu = readMenuImplementation.findById(request.menuId());
        MenuItem menuItemObject = menuItemDTOMapper.toMenuItem(request);
        menuItemObject.setMenu(menu);
        MenuItem menuItems = new MenuItem(
                null,
                request.name(),
                request.description(),
                request.price(),
                menu
        );
        MenuItem menuItem = createMenuItemImplementation.createMenuItem(menuItems);
        return ResponseEntity.ok(menuItemDTOMapper.toCreateResponse(menuItem));
    }

    @GetMapping("{id}")
    public ResponseEntity<ReadMenuItemResponse> readMenuItem(@PathVariable(name = "id") Long id) {
        MenuItem menuItem = readMenuItemImplementation.findById(id);
        return ResponseEntity.ok(menuItemDTOMapper.toReadResponse(menuItem));
    }

}
