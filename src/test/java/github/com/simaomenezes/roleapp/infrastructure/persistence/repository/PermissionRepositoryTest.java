package github.com.simaomenezes.roleapp.infrastructure.persistence.repository;

import github.com.simaomenezes.roleapp.infrastructure.integrationtests.AbstractIntegrationTest;
import github.com.simaomenezes.roleapp.infrastructure.persistence.entity.PermissionEntity;
import github.com.simaomenezes.roleapp.infrastructure.persistence.repositoty.IPermissionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
    void testGivenPersmissionObject_whenSave_thenReturnPermissionObject(){
        //When / Act
        PermissionEntity permission = repository.save(permissionEntity);
        //Then / Assert
        assertNotNull(permission);
        assertTrue(permission.getId() > 0);
    }
}
