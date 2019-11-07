package functional;

import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class QuestionsTest extends BaseRestAssuredTest {

    @Test
    public void shouldReturnSingleQuestionAtSpecifiedIndex() {
        given(aRequestToEasyBeasy())
            .when()
            .get("/questions/1")
            .then()
            .statusCode(200)
            .body("description", equalTo("Você geralmente esquece de coisas que precisam ser feitas?"));
    }
}
