package github.com.simaomenezes.roleapp.infrastructure.persistence.repository;

import github.com.simaomenezes.roleapp.domain.entity.RoleEntity;
import github.com.simaomenezes.roleapp.infrastructure.persistence.repositoty.IRoleRepository;
import github.com.simaomenezes.roleapp.infrastructure.integrationtests.AbstractIntegrationTest;
import github.com.simaomenezes.roleapp.infrastructure.persistence.repositoty.RoleRepositoryImpl;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest(showSql = true)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class RoleRepositoryImplTest extends AbstractIntegrationTest {
    @Autowired
    private IRoleRepository repository;
    private RoleRepositoryImpl roleRepositoryImpl;
    private RoleEntity role;

    @BeforeEach
    void setUp(){
        role = new RoleEntity();
        roleRepositoryImpl = new RoleRepositoryImpl(repository);
    }
}
