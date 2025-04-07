package github.com.simaomenezes.roleapp.domain.repository;

import github.com.simaomenezes.roleapp.domain.entity.UserEntity;

import java.util.Optional;

public interface UserRepository extends AbstractRepository<UserEntity> {
    Optional<UserEntity> findByName(String name);
    Optional<UserEntity> findByEmail(String email);
}
