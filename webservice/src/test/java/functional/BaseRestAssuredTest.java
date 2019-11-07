package functional;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@ActiveProfiles("dev")
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = RANDOM_PORT, classes = BaseRestAssuredTest.TestConfiguration.class)
public class BaseRestAssuredTest {

    @Configuration
    @EnableAutoConfiguration
    @ComponentScan("com.thoughtworks.aceleradora")
    public static class TestConfiguration {
    }

    @LocalServerPort
    private int port;

    protected RequestSpecification aRequestToEasyBeasy() {
        return new RequestSpecBuilder()
            .setPort(port)
            .build();
    }

}
