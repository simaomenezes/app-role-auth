package github.com.simaomenezes.roleapp.infrastructure.persistence.repository;

import github.com.simaomenezes.roleapp.domain.entity.PermissionEntity;
import github.com.simaomenezes.roleapp.infrastructure.integrationtests.AbstractIntegrationTest;
import github.com.simaomenezes.roleapp.infrastructure.persistence.repositoty.IPermissionRepository;
import github.com.simaomenezes.roleapp.infrastructure.persistence.repositoty.PermissionRepositoryImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class PermissionRepositoryImplTest extends AbstractIntegrationTest {

    @Autowired
    private IPermissionRepository repository;

    private PermissionRepositoryImpl permissionRepositoryImpl;

    private PermissionEntity permissionEntity;

    @BeforeEach
    void setup(){
        // Given / Arrange
        permissionEntity = new PermissionEntity("CREATE_ADM");
        permissionRepositoryImpl = new PermissionRepositoryImpl(repository);
    }

    @DisplayName("Should save permission Object on data base")
    @Test
    void testShouldSavePermissionObjectOnDataBase(){
        // When / Act
        PermissionEntity permissionEntitySaved = permissionRepositoryImpl.save(permissionEntity);
        // Then / Assert
        assertNotNull(permissionEntity);
        assertTrue(permissionEntitySaved.getId() > 0);
    }

    @DisplayName("Should update Permission name Object when findByName Permission then Return Permission name Object ")
    @Test
    void testShouldUpdatePermissionNameObject_whenFindByNamePermission_thenReturnPermissionNameObject(){
        // When / Act
        PermissionEntity permissionSaved = permissionRepositoryImpl.update(permissionEntity);
        PermissionEntity permissionEntityFound = permissionRepositoryImpl.findByName(
                permissionSaved.getName()).get();
        permissionEntityFound.setName("CREATE_SUPORT_USER");
        PermissionEntity permissionUpdate = permissionRepositoryImpl.save(permissionEntityFound);
        // Then / Assert
        assertNotNull(permissionEntity);
        assertNotNull(permissionEntityFound);
        assertEquals("CREATE_SUPORT_USER", permissionUpdate.getName());

    }

    @DisplayName("Given Permission Id when Delete Permission then do nothing")
    @Test
    void testGivenPermissionId_whenDeletePermission_thenDoNothing(){
        // Given / Arrange
        PermissionEntity permissionSaved = permissionRepositoryImpl.save(permissionEntity);
        // When / Act
        permissionRepositoryImpl.deleteById(permissionSaved.getId());
        Optional<PermissionEntity> permissionEntityOptional = permissionRepositoryImpl.findById(permissionSaved.getId());

        // Then / Assert
        assertTrue(permissionEntityOptional.isEmpty());
    }

    @DisplayName("Given Permission List when list all then return list")
    @Test
    void testGivenPermissionList_whenListAll_thenReturnList(){
        // Given / Arrange
        permissionRepositoryImpl.save(permissionEntity);
        PermissionEntity permissionEntity1 = new PermissionEntity("LIST_ADM");
        PermissionEntity permissionEntity2 = new PermissionEntity("DELETE_ADM");
        permissionRepositoryImpl.save(permissionEntity1);
        permissionRepositoryImpl.save(permissionEntity2);

        //When / Act
        List<PermissionEntity> permissionEntityAllList = permissionRepositoryImpl.findAll();
        // Then /Assert
        assertEquals(3, permissionEntityAllList.size() );
    }

    @DisplayName("Given name Permission when Find By Name then Return Permission Object")
    @Test
    void testGivenNamePermission_whenFindByName_thenReturnPermissionObject(){
        //Given / Arrange
        PermissionEntity permissionEntitySaved = permissionRepositoryImpl.save(permissionEntity);

        // When / Act
        Optional<PermissionEntity> permissionFound = permissionRepositoryImpl.findByName(permissionEntitySaved.getName());

        // Then / Assert
        assertTrue(permissionFound.isPresent());
        assertEquals("CREATE_ADM", permissionFound.get().getName());
    }

    @DisplayName("Given id Permission when Find By Id then Return Permission Object")
    @Test
    void testGivenIdPermission_whenFindById_thenReturnPermissionObject(){
        //Given / Arrange
        PermissionEntity permissionEntitySaved = permissionRepositoryImpl.save(permissionEntity);

        // When / Act
        Optional<PermissionEntity> permissionFound = permissionRepositoryImpl.findById(permissionEntitySaved.getId());

        // Then / Assert
        assertTrue(permissionFound.isPresent());
    }


}
