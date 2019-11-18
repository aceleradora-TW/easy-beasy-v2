package functional;

import com.thoughtworks.aceleradora.domain.NetPromoterScore;
import com.thoughtworks.aceleradora.domain.User;
import io.restassured.http.ContentType;
import org.json.JSONException;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class TestRestAssured extends BaseRestAssuredTest {

    @Test
    public void shouldReturnSingleStageAtSpecifiedIndex() {
        given(aRequestToEasyBeasy())
                .when()
                .get("/stage/1")
                .then()
                .statusCode(200)
                .body("solution", equalTo("Controle seus gastos!"))
                .body("number", equalTo(1))
                .body("hint", equalTo("hint"))
                .body("questions[0].description", equalTo("Você tem uma organização de tempo e tarefas?"))
                .body("questions[1].description", equalTo("Você geralmente esquece de coisas que precisam ser feitas?"))
                .body("questions[2].description", equalTo("Você organiza a semana em tarefas e metas a serem cumpridas?"))
                .body("questions[3].description", equalTo("Você utiliza alguma ferramenta ou estratégia para organizar a sua semana?"));
    }

    @Test
    public void shouldReturnOKIfSaveValidUser(){
        User newUser = new User("Maria", "maria@gmail.com");

        given(aRequestToEasyBeasy())
                .contentType(ContentType.JSON)
                .body(newUser)
                .when()
                .post("/user/")
                .then()
                .statusCode(200);
    }

    @Test
    public void shouldReturnOKIfSaveValidNPS(){
        NetPromoterScore newNPS = new NetPromoterScore();
        newNPS.setScore(10);
        newNPS.setComments("comment");

        given(aRequestToEasyBeasy())
                .contentType(ContentType.JSON)
                .body(newNPS)
                .when()
                .post("/net-promoter-score/")
                .then()
                .statusCode(200);
    }
}