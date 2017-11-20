package pl.zmzp.biblioteka.dto;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by lukasz on 20.11.17.
 */

@Entity
@Table(name = "role")
public class Roles implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Integer roleIdl;
    
    @Column(name = "NAME")
    private String name;
    
    @ManyToMany (mappedBy = "roles")
    private List<User> users;
    
    public Integer getRoleIdl () {
        return roleIdl;
    }
    
    public void setRoleIdl ( Integer roleIdl ) {
        this.roleIdl = roleIdl;
    }
    
    public String getName () {
        return name;
    }
    
    public void setName ( String name ) {
        this.name = name;
    }
    
    public List< User > getUsers () {
        return users;
    }
    
    public void setUsers ( List< User > users ) {
        this.users = users;
    }
}
