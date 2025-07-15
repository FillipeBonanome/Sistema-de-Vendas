package br.com.incarnia.Sistema.de.Vendas.infra.controllers.restaurant;

import br.com.incarnia.Sistema.de.Vendas.application.usecases.restaurant.create.CreateRestaurantImplementation;
import br.com.incarnia.Sistema.de.Vendas.application.usecases.restaurant.read.ReadRestaurantImplementation;
import br.com.incarnia.Sistema.de.Vendas.core.domain.Restaurant;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {
    private final CreateRestaurantImplementation createRestaurantImplementation;
    private final ReadRestaurantImplementation readRestaurantImplementation;
    private final RestaurantDTOMapper restaurantDTOMapper;

    public RestaurantController(CreateRestaurantImplementation createRestaurantImplementation, RestaurantDTOMapper restaurantDTOMapper, ReadRestaurantImplementation readRestaurantImplementation) {
        this.createRestaurantImplementation = createRestaurantImplementation;
        this.restaurantDTOMapper = restaurantDTOMapper;
        this.readRestaurantImplementation = readRestaurantImplementation;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<CreateRestaurantResponse> create(@RequestBody CreateRestaurantRequest request) {
        Restaurant restaurantObject = restaurantDTOMapper.toRestaurant(request);
        Restaurant restaurant = createRestaurantImplementation.createRestaurant(restaurantObject);
        return ResponseEntity.ok(restaurantDTOMapper.toResponse(restaurant));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CreateRestaurantResponse> findById(@PathVariable(name = "id") Long id) {
        Restaurant restaurant = readRestaurantImplementation.findById(id);
        return ResponseEntity.ok(restaurantDTOMapper.toResponse(restaurant));
    }

}
