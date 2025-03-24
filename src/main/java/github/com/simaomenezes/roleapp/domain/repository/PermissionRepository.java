package github.com.simaomenezes.roleapp.domain.repository;

import github.com.simaomenezes.roleapp.domain.entity.PermissionEntity;

import java.util.List;
import java.util.Optional;

public interface PermissionRepository {
    PermissionEntity save(PermissionEntity permissionEntity);
    PermissionEntity update(PermissionEntity permissionEntity);
    void deleteById(Long id);
    List<PermissionEntity> findAll();
    Boolean existByName(String name);
    Optional<PermissionEntity> findByName(String name);
}
