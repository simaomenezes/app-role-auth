package github.com.simaomenezes.roleapp.infrastructure.integrationtests;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Testcontainers;

@Testcontainers
public class AbstractIntegrationTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;

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
       jdbcTemplate.execute(sqlPermission);
    }

    @AfterAll
    static void afterAll(){
        POSTGRE_SQL_CONTAINER.stop();
    }
}
