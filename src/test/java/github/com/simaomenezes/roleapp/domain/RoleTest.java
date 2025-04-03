package github.com.simaomenezes.roleapp.domain;

import github.com.simaomenezes.roleapp.domain.entity.RoleEntity;
import github.com.simaomenezes.roleapp.domain.exceptions.AlreadyExistsException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RoleTest {
    private RoleEntity role;

    @BeforeEach
    void setUp() {
        role = new RoleEntity();
    }

    @DisplayName("Should an exception when name exist")
    @Test
    void testShouldAnExceptionWhenNameExist(){
        assertThrows(AlreadyExistsException.class, () -> role.alreadyExistsName(true));
    }

    @DisplayName("Not Should an exception when name don't already")
    @Test
    void testShouldNotAnExceptionWhenNameNotAlready(){
        assertDoesNotThrow(() -> role.alreadyExistsName(false));
    }
}
