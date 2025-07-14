package br.com.incarnia.Sistema.de.Vendas.config.beans;

import br.com.incarnia.Sistema.de.Vendas.infra.gateways.AddressEntityMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AddressConfig {

    @Bean
    public AddressEntityMapper addressEntityMapper() {
        return new AddressEntityMapper();
    }

}
