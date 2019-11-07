package functional;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static io.restassured.RestAssured.get;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = RANDOM_PORT, classes = RestAssuredTest.TestConfiguration.class)
@ActiveProfiles("dev")
public class RestAssuredTest {

    @Configuration
    @EnableAutoConfiguration
    public static class TestConfiguration {
    }

    @Value("${easy-beasy.functional-tests.base-uri}")
    private String baseUri;

    @LocalServerPort
    private int port;

    private RequestSpecification aRequest() {
        return new RequestSpecBuilder()
            .setBaseUri(baseUri)
            .setPort(port)
            .build();
    }

    @Test
    public void shouldReturnSingleQuestionAtSpecifiedIndex() {
        get("/questions/1")
            .then()
            .body("description", equalTo("Você geralmente esquece de coisas que precisam ser feitas?"));
    }
}
