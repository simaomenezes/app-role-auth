package github.com.simaomenezes.roleapp.application.usecases.role;

import github.com.simaomenezes.roleapp.application.dtos.RoleDTO;
import github.com.simaomenezes.roleapp.domain.entity.RoleEntity;
import github.com.simaomenezes.roleapp.domain.repository.RoleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class CreateRoleUseCase {
    private RoleRepository repository;

    public RoleDTO execute(RoleDTO roleDTO){
        RoleEntity roleEntity = new RoleEntity();
        boolean dtoFound = repository.findByName(roleDTO.getName()).isPresent();
        roleEntity.alreadyExistsName(dtoFound);
        roleEntity.setName(roleDTO.getName());
        RoleEntity roleEntitySaved = repository.save(roleEntity);
        roleDTO.setId(roleEntitySaved.getId());
        roleDTO.setName(roleEntitySaved.getName());
        return roleDTO;
    }
}
