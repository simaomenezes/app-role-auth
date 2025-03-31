package github.com.simaomenezes.roleapp.domain;

import github.com.simaomenezes.roleapp.domain.entity.PermissionEntity;
import github.com.simaomenezes.roleapp.domain.entity.RoleEntity;
import org.junit.jupiter.api.BeforeEach;

import java.util.Set;

public class RoleTest {
    private RoleEntity role;
    private PermissionEntity permission;

    @BeforeEach
    void setUp() {
        permission = new PermissionEntity("CREATE_USER", 1L);
        PermissionEntity p1 = new PermissionEntity("READ_USER", 2L);
        PermissionEntity p2 = new PermissionEntity("LIST_USER", 3L);
        PermissionEntity p3 = new PermissionEntity("DELETE_USER", 4L);

        role = new RoleEntity("ADMIN", Set.of(permission, p1, p2, p3));


    }
}
