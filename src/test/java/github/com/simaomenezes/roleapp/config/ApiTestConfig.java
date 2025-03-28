package github.com.simaomenezes.roleapp.config;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class ApiTestConfig {
    public final static int SERVER_PORT = 8888;

    public static RequestSpecification requestSpec(String endpoint) {
        return new RequestSpecBuilder()
                .setBasePath("/"+endpoint)
                .setPort(SERVER_PORT)
                .addFilter(new RequestLoggingFilter(LogDetail.ALL))
                .addFilter(new ResponseLoggingFilter(LogDetail.ALL))
                .build()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON);
    }
}
