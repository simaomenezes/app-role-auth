package github.com.simaomenezes.roleapp.application.usecases.role;

import github.com.simaomenezes.roleapp.application.dtos.RoleDTO;
import github.com.simaomenezes.roleapp.domain.entity.RoleEntity;
import github.com.simaomenezes.roleapp.domain.repository.RoleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class ListAllRoleUseCase {
    private RoleRepository repository;

    public List<RoleDTO> execute(){
        List<RoleEntity> roleList = repository.findAll();
        return roleList.stream().map(re -> new RoleDTO(re.getName())).collect(Collectors.toList());
    }
}
