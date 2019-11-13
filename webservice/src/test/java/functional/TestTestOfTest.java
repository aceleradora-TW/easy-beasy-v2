package functional;

import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class TestTestOfTest extends BaseRestAssuredTest {

    @Test
    public void shouldReturnSingleStageAtSpecifiedIndex() {
        given(aRequestToEasyBeasy())
                .when()
                .get("/stage/1")
                .then()
                .statusCode(200)
                .body("solution", equalTo("Controle seus gastos!"))
                .body("number", equalTo(1))
                .body("hint", equalTo("hint"));
    }
}