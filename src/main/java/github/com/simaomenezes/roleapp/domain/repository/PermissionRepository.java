package github.com.simaomenezes.roleapp.domain.repository;

import github.com.simaomenezes.roleapp.domain.entity.PermissionEntity;

import java.util.List;

public interface PermissionRepository {
    PermissionEntity save(PermissionEntity permissionEntity);
    PermissionEntity update(PermissionEntity permissionEntity);
    void deleteById(Long id);
    List<PermissionEntity> findAll();
    Boolean existByName();
}
