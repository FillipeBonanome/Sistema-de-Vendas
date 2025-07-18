package br.com.incarnia.Sistema.de.Vendas.infra.persistence.menuitem;

import br.com.incarnia.Sistema.de.Vendas.infra.persistence.menu.MenuEntity;
import jakarta.persistence.*;

import java.math.BigDecimal;


@Entity
@Table(name = "menu_items")
public class MenuItemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private BigDecimal price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "menu_id")
    private MenuEntity menuEntity;

    public MenuItemEntity() { }

    public MenuItemEntity(Long id, String name, String description, BigDecimal price, MenuEntity menuEntity) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.menuEntity = menuEntity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public MenuEntity getMenuEntity() {
        return menuEntity;
    }

    public void setMenuEntity(MenuEntity menuEntity) {
        this.menuEntity = menuEntity;
    }
}
