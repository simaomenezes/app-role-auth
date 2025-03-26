package github.com.simaomenezes.roleapp.domain.entity;

import github.com.simaomenezes.roleapp.domain.exceptions.AlreadyExistsException;
import github.com.simaomenezes.roleapp.domain.exceptions.NotFoundException;
import jakarta.persistence.*;

@Entity
@Table(name = "permission")
public class PermissionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

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

    public void alreadyExistsName(Boolean nameAlready){
        if (nameAlready) {
            throw new AlreadyExistsException("Name already!.");
        }
    }
}
