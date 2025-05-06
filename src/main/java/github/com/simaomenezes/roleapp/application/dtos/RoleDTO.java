package github.com.simaomenezes.roleapp.application.dtos;

import github.com.simaomenezes.roleapp.domain.entity.PermissionEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
public class RoleDTO {

    private Long id;
    private String name;
    private Set<PermissionDTO> permissions;

    public RoleDTO(Long id, String name){
        this.id = id;
        this.name = name;
    }
    public RoleDTO(String name){
        this.name = name;
    }
    public RoleDTO(String name, Set<PermissionDTO> permissionDTOSet){
        this.name = name;
        this.permissions = permissionDTOSet;
    }

}
