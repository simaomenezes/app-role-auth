package github.com.simaomenezes.roleapp.infrastructure.persistence.repository;

import github.com.simaomenezes.roleapp.domain.entity.PermissionEntity;
import github.com.simaomenezes.roleapp.domain.entity.RoleEntity;
import github.com.simaomenezes.roleapp.domain.entity.UserEntity;
import github.com.simaomenezes.roleapp.infrastructure.integrationtests.AbstractIntegrationTest;
import github.com.simaomenezes.roleapp.infrastructure.persistence.repositoty.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class UserRepositoryImplTest extends AbstractIntegrationTest {

    /*
    *  Test for save
    *  Test for update
    *  Test for listAll
    *  Test for delete by id
    *  Test for find by name
    *  Test for find by email
    * */
    @Autowired
    private IUserRepository repository;
    @Autowired
    private IRoleRepository roleRepository;
    @Autowired
    private IPermissionRepository permissionRepository;
    private UserRepositoryImpl userRepositoryImpl;
    private RoleRepositoryImpl roleRepositoryImpl;
    private PermissionRepositoryImpl permissionRepositoryImpl;

    private UserEntity user;
    private RoleEntity role;
    private PermissionEntity permission;

    @BeforeEach
    void setUp(){
        // Given / Arrange
        userRepositoryImpl = new UserRepositoryImpl(repository);
        roleRepositoryImpl = new RoleRepositoryImpl(roleRepository);
        permissionRepositoryImpl = new PermissionRepositoryImpl(permissionRepository);

        permission = new PermissionEntity("CREATE_USER");
        permissionRepositoryImpl.save(permission);
        role = new RoleEntity("ADMIN", Set.of(permission));
        roleRepositoryImpl.save(role);
        user = new UserEntity("user", "email", "password", Set.of(role));
    }

    @DisplayName("Given a User when save then return User saved")
    @Test
    void testGivenUser_whenSave_thenReturnUserSaved(){
        // When / Act
        UserEntity userSaved = userRepositoryImpl.save(user);

        // Then / Assert
        assertNotNull(userSaved);
        assertTrue(userSaved.getId() > 0);
    }

    @DisplayName("Given a User when update then return User updated")
    @Test
    void testGivenUser_whenUserUpdate_thenReturnUserUpdated(){
        // Given / Arrange
        UserEntity userSaved = userRepositoryImpl.save(user);
        userSaved.setName("userUpdate");
        // When / Act
        UserEntity userUpdated = userRepositoryImpl.update(userSaved);
        // Then / Assert
        assertEquals("userUpdate", userUpdated.getName());
    }

    @DisplayName("Given a User id when delete it then do nothing")
    @Test
    void testGivenUserId_whenDeleteById_thenDoNothing(){
        // Given / Arrange
        UserEntity userSaved = userRepositoryImpl.save(user);
        Optional<UserEntity> userFound = userRepositoryImpl.findById(userSaved.getId());
        // When / Act
        userRepositoryImpl.deleteById(userFound.get().getId());
        // Then / Assert
        assertTrue(userRepositoryImpl.findById(userSaved.getId()).isEmpty());
    }
}