package com.thoughtworks.aceleradora.repository;

import com.thoughtworks.aceleradora.domain.Stage;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class StageRepository {

    private static List<Stage> stages = new ArrayList<>(Arrays.asList(
            new Stage("Controle seus gastos!", 1, "doubt"),
            new Stage("Controle seu tempo!", 2, "doubt")));

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
}
