package github.com.simaomenezes.roleapp.infrastructure.persistence.repositoty;

import github.com.simaomenezes.roleapp.domain.entity.UserEntity;
import github.com.simaomenezes.roleapp.domain.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Transactional
@AllArgsConstructor
@Repository
public class UserRepositoryImpl implements UserRepository {
    @Override
    public UserEntity save(UserEntity object) {
        return null;
    }

    @Override
    public UserEntity update(UserEntity object) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public List<UserEntity> findAll() {
        return List.of();
    }

    @Override
    public Optional<UserEntity> findByName(String name) {
        return Optional.empty();
    }

    @Override
    public Optional<UserEntity> findByEmail(String email) {
        return Optional.empty();
    }

    @Override
    public Optional<UserEntity> findById(Long id) {
        return Optional.empty();
    }
}
