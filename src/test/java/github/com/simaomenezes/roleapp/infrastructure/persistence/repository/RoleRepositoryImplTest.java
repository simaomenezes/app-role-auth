package github.com.simaomenezes.roleapp.infrastructure.persistence.repository;

import github.com.simaomenezes.roleapp.domain.entity.PermissionEntity;
import github.com.simaomenezes.roleapp.domain.entity.RoleEntity;
import github.com.simaomenezes.roleapp.infrastructure.persistence.repositoty.IPermissionRepository;
import github.com.simaomenezes.roleapp.infrastructure.persistence.repositoty.IRoleRepository;
import github.com.simaomenezes.roleapp.infrastructure.integrationtests.AbstractIntegrationTest;
import github.com.simaomenezes.roleapp.infrastructure.persistence.repositoty.PermissionRepositoryImpl;
import github.com.simaomenezes.roleapp.infrastructure.persistence.repositoty.RoleRepositoryImpl;
import jakarta.persistence.Entity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RoleRepositoryImplTest extends AbstractIntegrationTest {
    @Autowired
    private IRoleRepository repository;
    private RoleRepositoryImpl roleRepositoryImpl;
    @Autowired
    private IPermissionRepository permissionRepository;
    private PermissionRepositoryImpl permissionRepositoryImpl;
    private RoleEntity role;
    private PermissionEntity permissionA, permissionB;

    @BeforeEach
    void setUp(){
        // Given / Arrange
        permissionA = new PermissionEntity("CREATE_USER");
        permissionB = new PermissionEntity("LIST_USER");
        role = new RoleEntity("ADMIN", Set.of(permissionA, permissionB));
        roleRepositoryImpl = new RoleRepositoryImpl(repository);
        permissionRepositoryImpl = new PermissionRepositoryImpl(permissionRepository);

        permissionRepositoryImpl.save(permissionA);
        permissionRepositoryImpl.save(permissionB);

    }

    @DisplayName("Given a role, when save, then return role saved")
    @Test
    void testGivenRole_whenSave_thenReturnRoleSaved(){
        // When / Act
        RoleEntity roleSaved = roleRepositoryImpl.save(role);
        // Then / Assert
        assertNotNull(roleSaved);
        assertTrue(roleSaved.getId() > 0);
    }

    @DisplayName("Given a role, when delete by id, then do nothing")
    @Test
    void testGivenRole_whenDeleteById_thenDoNothing(){
        // Given / Arrange
        role.setName("ADMIN_UPDATE");
        RoleEntity roleSaved = roleRepositoryImpl.save(role);
        Optional<RoleEntity> roleFound = roleRepositoryImpl.findById(role.getId());
        // When / Act
        roleRepositoryImpl.deleteById(roleFound.get().getId());
        // Then / Assert
        assertTrue(roleRepositoryImpl.findById(role.getId()).isEmpty());
    }

}
