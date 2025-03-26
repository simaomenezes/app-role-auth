package github.com.simaomenezes.roleapp.application.usecases.permission;

import github.com.simaomenezes.roleapp.application.dtos.PermissionDTO;
import github.com.simaomenezes.roleapp.domain.entity.PermissionEntity;
import github.com.simaomenezes.roleapp.domain.repository.PermissionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ListAllPermissionUseCase {
    private PermissionRepository repository;
    
    public List<PermissionDTO> execute(){

        List<PermissionEntity> permissionEntityListAll = repository.findAll();
        return permissionEntityListAll
                .stream()
                .map(permissionEntity ->
                        new PermissionDTO(permissionEntity.getId(), permissionEntity.getName()))
                .collect(Collectors.toList());
    }
}
