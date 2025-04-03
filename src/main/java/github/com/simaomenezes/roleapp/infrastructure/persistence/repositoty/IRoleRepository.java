package github.com.simaomenezes.roleapp.infrastructure.persistence.repositoty;

import github.com.simaomenezes.roleapp.domain.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRoleRepository extends JpaRepository<RoleEntity, Long> {
}
