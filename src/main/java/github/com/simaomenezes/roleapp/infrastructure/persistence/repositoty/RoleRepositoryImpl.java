package github.com.simaomenezes.roleapp.infrastructure.persistence.repositoty;

import github.com.simaomenezes.roleapp.domain.entity.RoleEntity;
import github.com.simaomenezes.roleapp.domain.repository.RoleRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Transactional
@AllArgsConstructor
@Repository
public class RoleRepositoryImpl implements RoleRepository {

    private final IRoleRepository repository;

    @Override
    public RoleEntity save(RoleEntity roleEntity) {
        return repository.save(roleEntity);
    }

    @Override
    public RoleEntity update(RoleEntity roleEntity) {
        return repository.save(roleEntity);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<RoleEntity> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<RoleEntity> findByName(String name) {
        return repository.findByName(name);
    }

    @Override
    public Optional<RoleEntity> findById(Long id) {
        return repository.findById(id);
    }
}
