package github.com.simaomenezes.roleapp.domain.entity;

import github.com.simaomenezes.roleapp.domain.exceptions.AlreadyExistsException;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "roles")
public class RoleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name", unique = true, nullable = false)
    private String name;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "roles_permissions",
            joinColumns = @JoinColumn(name = "role_id"),
            inverseJoinColumns = @JoinColumn(name = "permission_id")
    )
    private Set<PermissionEntity> permissions;

    public RoleEntity() {}

    public RoleEntity(String name, Set<PermissionEntity> permissions) {
        this.name = name;
        this.permissions = permissions;
    }

    public RoleEntity(Long id ,String name, Set<PermissionEntity> permissions) {
        this.id = id;
        this.name = name;
        this.permissions = permissions;
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

    public Set<PermissionEntity> getPermissions() {
        return permissions;
    }

    public void setPermissions(Set<PermissionEntity> permissions) {
        this.permissions = permissions;
    }

    public void alreadyExistsName(Boolean value) {
        if (value) {
            throw new AlreadyExistsException("Name already!");
        }
    }
}
