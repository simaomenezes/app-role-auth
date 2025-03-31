package github.com.simaomenezes.roleapp.domain.entity;

import github.com.simaomenezes.roleapp.domain.exceptions.AlreadyExistsException;
import github.com.simaomenezes.roleapp.domain.exceptions.NotFoundException;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "permission")
public class PermissionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name", unique = true, nullable = false)
    private String name;
    @ManyToMany(mappedBy = "permissions")
    private Set<RoleEntity> roles = new HashSet<>();

    public PermissionEntity(){}
    public PermissionEntity(String name, Long id){
        this.name = name;
        this.id = id;
    }

    public PermissionEntity(String name){
        this.name = name;
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

    public Set<RoleEntity> getRoles() {
        return roles;
    }
    public void setRoles(Set<RoleEntity> roles) {
        this.roles = roles;
    }


    public void alreadyExistsName(Boolean nameAlready){
        if (nameAlready) {
            throw new AlreadyExistsException("Name already!.");
        }
    }
}
