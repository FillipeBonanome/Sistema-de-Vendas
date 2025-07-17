package br.com.incarnia.Sistema.de.Vendas.infra.controllers.menu;

import br.com.incarnia.Sistema.de.Vendas.application.usecases.menu.create.CreateMenuImplementation;
import br.com.incarnia.Sistema.de.Vendas.application.usecases.menu.read.ReadMenuImplementation;
import br.com.incarnia.Sistema.de.Vendas.application.usecases.restaurant.read.ReadRestaurantImplementation;
import br.com.incarnia.Sistema.de.Vendas.core.domain.Menu;
import br.com.incarnia.Sistema.de.Vendas.core.domain.Restaurant;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/menus")
public class MenuController {

    private final CreateMenuImplementation createMenuImplementation;
    private final ReadMenuImplementation readMenuImplementation;
    private final MenuDTOMapper menuDTOMapper;
    private final ReadRestaurantImplementation readRestaurantImplementation;

    public MenuController(CreateMenuImplementation createMenuImplementation, ReadMenuImplementation readMenuImplementation, MenuDTOMapper menuDTOMapper, ReadRestaurantImplementation readRestaurantImplementation) {
        this.createMenuImplementation = createMenuImplementation;
        this.readMenuImplementation = readMenuImplementation;
        this.menuDTOMapper = menuDTOMapper;
        this.readRestaurantImplementation = readRestaurantImplementation;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<CreateMenuResponse> createMenu(@RequestBody CreateMenuRequest request) {
        //TODO --> refactor this logic?
        Menu menuObject = menuDTOMapper.toMenu(request);
        Restaurant restaurant = readRestaurantImplementation.findById(request.restaurantId());
        menuObject.setRestaurant(restaurant);
        Menu menu = createMenuImplementation.createMenu(menuObject);
        return ResponseEntity.ok(menuDTOMapper.toResponse(menu));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CreateMenuResponse> findById(@PathVariable(name = "id") Long id) {
        Menu menu = readMenuImplementation.findById(id);
        return ResponseEntity.ok(menuDTOMapper.toResponse(menu));
    }
}
