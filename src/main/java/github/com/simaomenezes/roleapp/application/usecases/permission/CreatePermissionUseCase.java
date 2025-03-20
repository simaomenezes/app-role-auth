package github.com.simaomenezes.roleapp.application.usecases.permission;

import github.com.simaomenezes.roleapp.application.dtos.PermissionDTO;
import github.com.simaomenezes.roleapp.domain.entity.PermissionEntity;
import github.com.simaomenezes.roleapp.domain.repository.PermissionRepository;
import github.com.simaomenezes.roleapp.infrastructure.utils.ModelMapperUtil;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CreatePermissionUseCase {
    private final PermissionRepository repository;

    public PermissionDTO execute(PermissionDTO permissionDTO) {
        PermissionEntity permissionSaved = repository.save(ModelMapperUtil.convertPermissionDTOToPermissionEntity(permissionDTO));
        return ModelMapperUtil.convertPermissionEntityToPermissionDTO(permissionSaved);
    }
}
