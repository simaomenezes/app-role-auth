package github.com.simaomenezes.roleapp.domain;

import github.com.simaomenezes.roleapp.domain.entity.UserEntity;
import github.com.simaomenezes.roleapp.domain.exceptions.AlreadyExistsException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class UserTest {
    private UserEntity user;

    @BeforeEach
    void setUp() {
        user = new UserEntity();
    }

    @DisplayName("Should an exception when name exist")
    @Test
    void testShouldAnExceptionWhenNameExist() {
        assertThrows(AlreadyExistsException.class, () -> user.alreadyExistsUsername(true));
    }

    @DisplayName("Should an exception when email exist")
    @Test
    void testShouldAnExceptionWhenEmailExist() {
        assertThrows(AlreadyExistsException.class, () -> user.alreadyExistsEmail(true));
    }

    @DisplayName("Not Should an exception when name don't already")
    @Test
    void testShouldNotAnExceptionWhenNameNotAlready() {
        assertDoesNotThrow(() -> user.alreadyExistsUsername(false));
    }

    @DisplayName("Not Should an exception when email don't already")
    @Test
    void testShouldNotAnExceptionWhenEmailNotAlready() {
        assertDoesNotThrow(() -> user.alreadyExistsEmail(false));
    }
}
