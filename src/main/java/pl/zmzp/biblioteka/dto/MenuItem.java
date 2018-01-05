package pl.zmzp.biblioteka.dto;

import javax.persistence.*;

@Entity
@Table(name="menu_item")
public class MenuItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_menu")
    private Integer idItem;

    @Column(name = "key")
    private String key;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "role")
    private Roles roles;

    public MenuItem(String key, String name) {
        this.key = key;
        this.name = name;
    }

    public Integer getIdItem() {
        return idItem;
    }

    public void setIdItem(Integer idItem) {
        this.idItem = idItem;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Roles getRoles() {
        return roles;
    }

    public void setRoles(Roles roles) {
        this.roles = roles;
    }
}
