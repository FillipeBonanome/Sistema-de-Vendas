package br.com.incarnia.Sistema.de.Vendas.config.beans;

import br.com.incarnia.Sistema.de.Vendas.application.gateways.RestaurantGateway;
import br.com.incarnia.Sistema.de.Vendas.application.usecases.restaurant.create.CreateRestaurantImplementation;
import br.com.incarnia.Sistema.de.Vendas.application.usecases.restaurant.read.ReadRestaurantImplementation;
import br.com.incarnia.Sistema.de.Vendas.infra.controllers.restaurant.RestaurantDTOMapper;
import br.com.incarnia.Sistema.de.Vendas.infra.gateways.address.AddressEntityMapper;
import br.com.incarnia.Sistema.de.Vendas.infra.gateways.menu.MenuEntityMapper;
import br.com.incarnia.Sistema.de.Vendas.infra.gateways.restaurant.RestaurantEntityMapper;
import br.com.incarnia.Sistema.de.Vendas.infra.gateways.restaurant.RestaurantRepositoryGateway;
import br.com.incarnia.Sistema.de.Vendas.infra.persistence.user.UserRepository;
import br.com.incarnia.Sistema.de.Vendas.infra.persistence.restaurant.RestaurantRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RestaurantConfig {

    @Bean
    public CreateRestaurantImplementation createRestaurantImplementation(RestaurantGateway restaurantGateway) {
        return new CreateRestaurantImplementation(restaurantGateway);
    }

    @Bean
    public ReadRestaurantImplementation readRestaurantImplementation(RestaurantGateway restaurantGateway) {
        return new ReadRestaurantImplementation(restaurantGateway);
    }

    @Bean
    public RestaurantRepositoryGateway restaurantRepositoryGateway(RestaurantRepository restaurantRepository, RestaurantEntityMapper restaurantEntityMapper, UserRepository userRepository) {
        return new RestaurantRepositoryGateway(restaurantRepository, restaurantEntityMapper, userRepository);
    }

    @Bean
    public RestaurantEntityMapper restaurantEntityMapper(AddressEntityMapper addressEntityMapper) {
        return new RestaurantEntityMapper(addressEntityMapper);
    }

    //DTO MAPPER
    @Bean
    public RestaurantDTOMapper restaurantDTOMapper() {
        return new RestaurantDTOMapper();
    }


}
