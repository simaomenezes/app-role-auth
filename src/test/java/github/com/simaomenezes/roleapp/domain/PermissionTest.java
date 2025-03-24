package github.com.simaomenezes.roleapp.domain;

import github.com.simaomenezes.roleapp.application.dtos.PermissionDTO;
import github.com.simaomenezes.roleapp.domain.entity.PermissionEntity;
import github.com.simaomenezes.roleapp.domain.exceptions.AlreadyExistsException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PermissionTest {

    private PermissionEntity permissionEntity;

    @BeforeEach
    void setup(){
        permissionEntity = new PermissionEntity("CREATE_USER");
    }

    @DisplayName("Should an exception when name exist")
    @Test
    void testShouldAnExceptionWhenNameExist(){
        assertThrows(AlreadyExistsException.class, () -> permissionEntity.alreadyExistsName(true));
    }

    @DisplayName("Not Should an exception when name don't already")
    @Test
    void testShouldNotAnExceptionWhenNameNotAlready(){
        assertDoesNotThrow(() -> permissionEntity.alreadyExistsName(false));
    }
}
