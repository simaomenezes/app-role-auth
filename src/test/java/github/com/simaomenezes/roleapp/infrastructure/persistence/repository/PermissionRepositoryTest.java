package github.com.simaomenezes.roleapp.infrastructure.persistence.repository;

import github.com.simaomenezes.roleapp.infrastructure.integrationtests.AbstractIntegrationTest;
import github.com.simaomenezes.roleapp.infrastructure.persistence.entity.PermissionEntity;
import github.com.simaomenezes.roleapp.infrastructure.persistence.repositoty.IPermissionRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest(showSql = true)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class PermissionRepositoryTest extends AbstractIntegrationTest {

    @Autowired
    private IPermissionRepository repository;

    @Test
    void testGivenPersmissionObject_whenSave_thenReturnPermissionObject(){
        //Given / Arrange
        PermissionEntity permissionEntity = new PermissionEntity(
                "Can Create User"
        );

        //When / Act
        PermissionEntity permission = repository.save(permissionEntity);

        //Then / Assert
        assertNotNull(permission);

    }
}
