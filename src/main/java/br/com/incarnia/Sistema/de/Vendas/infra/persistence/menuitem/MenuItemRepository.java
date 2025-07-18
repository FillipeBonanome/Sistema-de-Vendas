package br.com.incarnia.Sistema.de.Vendas.infra.persistence.menuitem;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuItemRepository extends JpaRepository<MenuItemEntity, Long> {
}
