package github.com.simaomenezes.roleapp.infrastructure.persistence.repository;

import github.com.simaomenezes.roleapp.infrastructure.integrationtests.AbstractIntegrationTest;
import github.com.simaomenezes.roleapp.domain.entity.PermissionEntity;
import github.com.simaomenezes.roleapp.infrastructure.persistence.repositoty.IPermissionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest(showSql = true)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class PermissionRepositoryTest extends AbstractIntegrationTest {

    @Autowired
    private IPermissionRepository repository;
    private PermissionEntity permissionEntity;

    @BeforeEach
    public void setup(){
        // Given / Arrange
        permissionEntity = new PermissionEntity("READ_USER");
    }

    @DisplayName("Given Permission Object when Save then Return Saved Permission")
    @Test
    void testGivenPermissionObject_whenSave_thenReturnSavedPermissionObject(){
        //When / Act
        PermissionEntity permission = repository.save(permissionEntity);
        //Then / Assert
        assertNotNull(permission);
        assertTrue(permission.getId() > 0);
    }

    @DisplayName("Given a name Permission when Permission name to update then Return Permission name")
    @Test
    void testGivenNamePermission_whenPermissionNameToUpdate_thenReturnPermissionName(){
        // Given / Arrange
        repository.save(permissionEntity);
        PermissionEntity permissionFound = repository.findById(permissionEntity.getId()).get();
        permissionFound.setName("READ_USER_2");
        //When / Act
        repository.save(permissionFound);
        // Then / Assert
        assertNotNull(permissionFound);
        assertEquals("READ_USER_2", permissionFound.getName());
    }

    @DisplayName("Given Permission List when List All then Return List")
    @Test
    void testGivenPermissionList_whenListAll_thenReturnList(){
        //Given / Arrange
        repository.save(permissionEntity);
        PermissionEntity p1 = new PermissionEntity("CREATE_USER");
        PermissionEntity p2 = new PermissionEntity("DELETE_USER");
        repository.save(p1);
        repository.save(p2);
        // When / Act
        List<PermissionEntity> permissionEntityList = repository.findAll();
        //Then / Assert
        assertNotNull(permissionEntity);
        assertNotNull(p1);
        assertNotNull(p2);
        assertNotNull(permissionEntityList);
        assertEquals(3, permissionEntityList.size());
    }

    @DisplayName("Given Permission Object when delete by id remove it")
    @Test
    void testGivenPermissionObject_whenDeleteById_thenRemoveIt(){
        // Given / Arrange
        repository.save(permissionEntity);
        //When / Act
        repository.deleteById(permissionEntity.getId());
        Optional<PermissionEntity> permissionEntityOptional = repository.findById(permissionEntity.getId());
        // Then / Assert
        assertTrue(permissionEntityOptional.isEmpty());
    }
}
