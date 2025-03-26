package github.com.simaomenezes.roleapp.application.usecases.permission;

import github.com.simaomenezes.roleapp.application.dtos.PermissionDTO;
import github.com.simaomenezes.roleapp.domain.entity.PermissionEntity;
import github.com.simaomenezes.roleapp.domain.repository.PermissionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class UpdatePermissionUseCase {
    private PermissionRepository repository;
    public PermissionDTO execute(PermissionDTO permissionDTO){
        Optional<PermissionEntity> permissionFound = repository.findByName(permissionDTO.getName());
        PermissionEntity permissionEntity = new PermissionEntity(permissionDTO.getName(), permissionDTO.getId());
        permissionEntity.alreadyExistsName(permissionFound.isPresent());
        PermissionEntity permissionEntityUpdated = repository.update(permissionEntity);
        return new PermissionDTO(permissionEntityUpdated.getId(), permissionEntityUpdated.getName());
    }
}
