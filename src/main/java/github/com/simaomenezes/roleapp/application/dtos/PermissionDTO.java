package github.com.simaomenezes.roleapp.application.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PermissionDTO {
    private Long id;
    private String name;
}
