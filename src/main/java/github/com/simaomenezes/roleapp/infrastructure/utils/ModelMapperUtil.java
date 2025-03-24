package github.com.simaomenezes.roleapp.infrastructure.utils;

import github.com.simaomenezes.roleapp.application.dtos.PermissionDTO;
import github.com.simaomenezes.roleapp.domain.entity.PermissionEntity;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;

@AllArgsConstructor
public class ModelMapperUtil {
    private static ModelMapper mapper;

    public static PermissionEntity convertPermissionDTOToPermissionEntity(PermissionDTO permissionDTO){
        return mapper.map(permissionDTO, PermissionEntity.class);
    }
    public static PermissionDTO convertPermissionEntityToPermissionDTO(PermissionEntity permissionEntity) {
        return mapper.map(permissionEntity, PermissionDTO.class);
    }
}
