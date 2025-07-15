package br.com.incarnia.Sistema.de.Vendas.infra.gateways.restaurant;

import br.com.incarnia.Sistema.de.Vendas.application.gateways.RestaurantGateway;
import br.com.incarnia.Sistema.de.Vendas.core.domain.Restaurant;
import br.com.incarnia.Sistema.de.Vendas.core.exceptions.RestaurantException;
import br.com.incarnia.Sistema.de.Vendas.infra.persistence.UserEntity;
import br.com.incarnia.Sistema.de.Vendas.infra.persistence.UserRepository;
import br.com.incarnia.Sistema.de.Vendas.infra.persistence.restaurant.RestaurantEntity;
import br.com.incarnia.Sistema.de.Vendas.infra.persistence.restaurant.RestaurantRepository;

import java.util.Optional;

public class RestaurantRepositoryGateway implements RestaurantGateway {

    private final RestaurantRepository restaurantRepository;
    private final UserRepository userRepository;                //TODO --> only one restaurant per user
    private final RestaurantEntityMapper restaurantEntityMapper;

    public RestaurantRepositoryGateway(RestaurantRepository restaurantRepository, RestaurantEntityMapper restaurantEntityMapper, UserRepository userRepository) {
        this.restaurantRepository = restaurantRepository;
        this.restaurantEntityMapper = restaurantEntityMapper;
        this.userRepository = userRepository;
    }

    @Override
    public Restaurant createRestaurant(Restaurant restaurant) {
        RestaurantEntity restaurantEntity = restaurantEntityMapper.toEntity(restaurant);
        RestaurantEntity savedRestaurant = restaurantRepository.save(restaurantEntity);
        return restaurantEntityMapper.toDomain(savedRestaurant);
    }

    @Override
    public Restaurant findById(Long id) {
        Optional<RestaurantEntity> restaurantOptional = restaurantRepository.findById(id);

        if(restaurantOptional.isEmpty()) {
            throw new RestaurantException("Restaurant with id " + id + " not found");
        }

        RestaurantEntity restaurantEntity = restaurantOptional.get();
        return restaurantEntityMapper.toDomain(restaurantEntity);
    }
}
