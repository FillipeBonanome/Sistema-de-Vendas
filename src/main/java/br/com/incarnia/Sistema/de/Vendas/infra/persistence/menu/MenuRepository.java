package br.com.incarnia.Sistema.de.Vendas.infra.persistence.menu;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuRepository extends JpaRepository<MenuEntity, Long> {
}
