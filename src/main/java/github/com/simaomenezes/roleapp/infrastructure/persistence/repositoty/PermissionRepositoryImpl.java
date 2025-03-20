package github.com.simaomenezes.roleapp.infrastructure.persistence.repositoty;


import github.com.simaomenezes.roleapp.domain.repository.PermissionRepository;
import github.com.simaomenezes.roleapp.domain.entity.PermissionEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@AllArgsConstructor
@Repository
public class PermissionRepositoryImpl implements PermissionRepository {
    private final IPermissionRepository repository;

    @Override
    public PermissionEntity save(PermissionEntity permissionEntity) {
        return repository.save(permissionEntity);
    }

    @Override
    public PermissionEntity update(PermissionEntity permissionEntity) {
        return repository.save(permissionEntity);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<PermissionEntity> findAll() {
        return repository.findAll();
    }

    @Override
    public Boolean existByName() {
        return null;
    }
}
