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

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest(showSql = true)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
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
}
