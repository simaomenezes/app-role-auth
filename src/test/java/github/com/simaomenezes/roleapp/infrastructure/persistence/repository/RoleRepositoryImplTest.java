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

import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

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

    @DisplayName("Given a role List when list all then return list")
    @Test
    void testGivenRoleList_whenListAll_thenReturnList(){
        // Given / Arrange
        permissionA.setName("SUPPORT_READ_USER_DETAILS");
        permissionRepositoryImpl.save(permissionA);
        permissionB.setName("SUPPORT_UPDATE_USER");
        permissionRepositoryImpl.save(permissionB);

        RoleEntity role1 = new RoleEntity("ADMIN_UPDATE", Set.of(permissionA, permissionB));
        RoleEntity role2 = new RoleEntity("ADMIN_DELETE", Set.of(permissionA, permissionB));

        roleRepositoryImpl.save(role1);
        roleRepositoryImpl.save(role2);
        roleRepositoryImpl.save(role);

        //When / Act
        List<RoleEntity> roleListAll = roleRepositoryImpl.findAll();
        // Then /Assert
        assertNotNull(roleListAll);
        assertFalse(roleListAll.isEmpty());
        assertEquals(3, roleListAll.size() );
    }

    @DisplayName("Given name role when find by name then return role object")
    @Test
    void testGivenNameRole_whenFindByName_thenReturnRoleObject(){
        // Given / Arrange
        RoleEntity roleSaved = roleRepositoryImpl.save(role);

        // When / Act
        Optional<RoleEntity> roleFound = roleRepositoryImpl.findByName(roleSaved.getName());

        // Then / Assert
        assertNotNull(roleFound);
        assertTrue(roleFound.isPresent());
        assertEquals(roleSaved.getName(), roleFound.get().getName());
    }

    @DisplayName("Given id role when find by id then return role object")
    @Test
    void testGivenIdRole_whenFindById_thenReturnRoleObject(){
        // Given / Arrange
        RoleEntity roleSaved = roleRepositoryImpl.save(role);

        // When / Act
        Optional<RoleEntity> roleFound = roleRepositoryImpl.findById(roleSaved.getId());

        // Then / Assert
        assertNotNull(roleFound);
        assertTrue(roleFound.isPresent());
        assertEquals(roleSaved.getName(), roleFound.get().getName());
    }

    @DisplayName("Given a role when update then return role updated")
    @Test
    void testGivenRole_whenUpdate_thenReturnRoleUpdated(){
        // Given / Arrange
        RoleEntity roleSaved = roleRepositoryImpl.save(role);
        role.setName("ADMIN_UPDATE");
        // When / Act
        RoleEntity roleUpdated = roleRepositoryImpl.update(role);
        // Then / Assert
        assertNotNull(roleUpdated);
        assertEquals("ADMIN_UPDATE", roleUpdated.getName());
    }

}
