package functional;

import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class StageTest extends BaseRestAssuredTest {

    @Test
    public void shouldReturnSingleStageAtSpecifiedIndex() {
        given(aRequestToEasyBeasy())
                .when()
                .get("/stage/1")
                .then()
                .statusCode(200)
                .body("solution", equalTo("Podemos melhorar alguns pontos na sua gestão de tempo e tarefas. A solução consistirá em como organizar suas atividades, definir prazos e metas, além da indicação de algumas ferramentas que poderão complementar a sua rotina. Confira no link a baixo a solução para a sua pendência: https://medium.com/@easybeasybr/gestão-de-tempo-e-tarefas-p1-12a51de24f75"))
                .body("number", equalTo(1))
                .body("hint", equalTo("Pense no seu dia a dia, se você sabe qual o próximo passo que deve ser tomado, se tem esclarecido quais e quando suas tarefas devem ser feitas."))
                .body("questions[0].description", equalTo("Você tem uma organização de tempo e tarefas?"))
                .body("questions[1].description", equalTo("Você geralmente lembra de coisas que precisam ser feitas?"))
                .body("questions[2].description", equalTo("Você organiza a semana em tarefas e metas a serem cumpridas?"))
                .body("questions[3].description", equalTo("Você utiliza alguma ferramenta ou estratégia para organizar a sua semana?"));
    }
}