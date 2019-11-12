package com.thoughtworks.aceleradora.repository;

import com.thoughtworks.aceleradora.domain.Question;
import com.thoughtworks.aceleradora.domain.Stage;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class StageRepository {


    private ArrayList<Question> P1 = new ArrayList<>(Arrays.asList(
            new Question("Você tem uma organização de tempo e tarefas?"),
            new Question("Você geralmente esquece de coisas que precisam ser feitas?"),
            new Question("Você organiza a semana em tarefas e metas a serem cumpridas?"),
            new Question("Você utiliza alguma ferramenta ou estratégia para organizar a sua semana?"),
            new Question("Você tem um controle do dinheiro que entra e sai da empresa?")));

    private List<Stage> stages = new ArrayList<>(Arrays.asList(
            new Stage("Controle seus gastos!", 1, "hint", P1, 1L)));

    public List<Stage> save(Stage stage) {
        stages.add(stage);
        return stages;
    }

    public Stage deleteStage(Stage stage) {
        stages.remove(stage);
        return stage;
    }

    public List<Stage> getStages() {
        return stages;
    }

    public Stage getStageById(Long id) {
        return getStages().stream().filter(stage -> stage.getId() == id).findFirst().get();
    }
}
