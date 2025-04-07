package github.com.simaomenezes.roleapp.infrastructure.persistence.repositoty;

import github.com.simaomenezes.roleapp.domain.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IUserRepository extends JpaRepository<UserEntity, Long> {

    Optional<UserEntity> findByName(String name);

    Optional<UserEntity> findByEmail(String email);
}
