package br.com.incarnia.Sistema.de.Vendas.config.beans;

import br.com.incarnia.Sistema.de.Vendas.application.gateways.UserGateway;
import br.com.incarnia.Sistema.de.Vendas.application.usecases.user.create.CreateUserImplementation;
import br.com.incarnia.Sistema.de.Vendas.application.usecases.user.read.ReadUserImplementation;
import br.com.incarnia.Sistema.de.Vendas.infra.controllers.user.UserDTOMapper;
import br.com.incarnia.Sistema.de.Vendas.infra.gateways.AddressEntityMapper;
import br.com.incarnia.Sistema.de.Vendas.infra.gateways.UserEntityMapper;
import br.com.incarnia.Sistema.de.Vendas.infra.gateways.UserRepositoryGateway;
import br.com.incarnia.Sistema.de.Vendas.infra.persistence.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfig {

    @Bean
    public CreateUserImplementation createUserImplementation(UserGateway userGateway) {
        return new CreateUserImplementation(userGateway);
    }

    @Bean
    public ReadUserImplementation readUserImplementation(UserGateway userGateway) {
        return new ReadUserImplementation(userGateway);
    }

    @Bean
    public UserRepositoryGateway userGateway(UserRepository userRepository, UserEntityMapper mapper) {
        return new UserRepositoryGateway(userRepository, mapper);
    }

    @Bean
    public UserEntityMapper userEntityMapper(AddressEntityMapper addressEntityMapper){
        return new UserEntityMapper(addressEntityMapper);
    }

    @Bean
    public UserDTOMapper userDTOMapper() {
        return new UserDTOMapper();
    }
}
