package br.com.incarnia.Sistema.de.Vendas.infra.persistence.restaurant;

import br.com.incarnia.Sistema.de.Vendas.core.domain.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepository extends JpaRepository<RestaurantEntity, Long> {
}
