package github.com.simaomenezes.roleapp.infrastructure.persistence.repositoty;

import github.com.simaomenezes.roleapp.domain.entity.PermissionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPermissionRepository extends JpaRepository<PermissionEntity, Long> {
}
