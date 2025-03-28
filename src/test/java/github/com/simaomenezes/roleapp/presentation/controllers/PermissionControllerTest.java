package github.com.simaomenezes.roleapp.presentation.controllers;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import github.com.simaomenezes.roleapp.config.ApiTestConfig;
import github.com.simaomenezes.roleapp.infrastructure.integrationtests.AbstractIntegrationTest;
import github.com.simaomenezes.roleapp.presentation.dtos.PermissionRequestDTO;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import com.fasterxml.jackson.databind.ObjectMapper;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class PermissionControllerTest extends AbstractIntegrationTest {
    private static RequestSpecification specification;
    private static ObjectMapper mapper;
    private static PermissionRequestDTO permissionRequestDTO;

    @BeforeAll
    public static void setUp(){
        // Given / Arrange
        mapper = new ObjectMapper();
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        specification = ApiTestConfig.requestSpec("permissions");
        permissionRequestDTO = new PermissionRequestDTO();
        permissionRequestDTO.setName("CREATE_USER");
    }

    @Test
    @DisplayName("Integration Given Permission Object when Create one Permission should Return a Permission Object")
    void integrationTestGivenPermissionObject_when_CreateOnePermissionShouldReturnAPermissionObject() throws JsonProcessingException {
        String content = given()
                .spec(specification)
                .body(permissionRequestDTO)
                .when()
                .post("/add")
                .then()
                .statusCode(201)
                .extract()
                .body()
                .asString();
        PermissionRequestDTO createdPermissionDTO = mapper.readValue(content, PermissionRequestDTO.class);
        permissionRequestDTO = createdPermissionDTO;
        assertNotNull(createdPermissionDTO);
    }

    @Test
    @DisplayName("Integration Given Permission Object when List all Permission should Return a Permission Object")
    void integrationTestGivenPermissionObject_when_ListAllPermissionShouldReturnAPermissionObject() throws JsonProcessingException {
        // Given / Arrange
            given()
                .spec(specification)
                .body(permissionRequestDTO)
                .when()
                .post("/add")
                .then()
                .statusCode(201)
                .extract()
                .body()
                .asString();

            // When / Act
        String content = given()
                .spec(specification)
                .when()
                .get()
                .then()
                .statusCode(200)
                .extract()
                .body()
                .asString();

        // Then / Assert
        assertNotNull(content);
        assertTrue(content.contains(permissionRequestDTO.getName()));
        assertTrue(content.contains("id"));
    }

}