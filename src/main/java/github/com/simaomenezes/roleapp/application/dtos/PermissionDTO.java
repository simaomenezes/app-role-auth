package github.com.simaomenezes.roleapp.application.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
public class PermissionDTO implements Serializable {
    private Long id;
    private String name;

    public PermissionDTO(String name){
        this.name = name;
    }

}
