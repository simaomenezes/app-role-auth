package github.com.simaomenezes.roleapp.application.usecases.permission;

import github.com.simaomenezes.roleapp.application.dtos.PermissionDTO;
import github.com.simaomenezes.roleapp.domain.entity.PermissionEntity;
import github.com.simaomenezes.roleapp.domain.repository.PermissionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class CreatePermissionUseCase {
    private final PermissionRepository repository;

    public PermissionDTO execute(PermissionDTO permissionDTO) {

        boolean value = repository.findByName(permissionDTO.getName()).isPresent();
        PermissionEntity permissionEntity = new PermissionEntity(permissionDTO.getName());
        permissionEntity.alreadyExistsName(value);
        PermissionEntity permissionSaved = repository.save(permissionEntity);
        return new PermissionDTO(permissionSaved.getId(), permissionSaved.getName());
    }
}
