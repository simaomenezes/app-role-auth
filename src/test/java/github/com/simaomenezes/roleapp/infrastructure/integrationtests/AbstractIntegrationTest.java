package github.com.simaomenezes.roleapp.infrastructure.integrationtests;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.annotation.DirtiesContext;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;


@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_CLASS)
@Testcontainers
public class AbstractIntegrationTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Container
    @ServiceConnection
    static final PostgreSQLContainer<?> POSTGRE_SQL_CONTAINER = new PostgreSQLContainer<>("postgres:15");

    @BeforeAll
    static void beforeAll(){
        POSTGRE_SQL_CONTAINER.start();
        System.setProperty("spring.datasource.url", POSTGRE_SQL_CONTAINER.getJdbcUrl());
        System.setProperty("spring.datasource.username", POSTGRE_SQL_CONTAINER.getUsername());
        System.setProperty("spring.datasource.password", POSTGRE_SQL_CONTAINER.getPassword());
    }

    @AfterEach
    void cleanDataBase(){
       String sqlPermission = "TRUNCATE TABLE permission RESTART IDENTITY CASCADE";
       String sqlRole = "TRUNCATE TABLE roles RESTART IDENTITY CASCADE";
       String sqlUser = "TRUNCATE TABLE users RESTART IDENTITY CASCADE";
       jdbcTemplate.execute(sqlPermission);
       jdbcTemplate.execute(sqlRole);
       jdbcTemplate.execute(sqlUser);
    }

    @AfterAll
    static void afterAll(){
        POSTGRE_SQL_CONTAINER.stop();
    }
}
