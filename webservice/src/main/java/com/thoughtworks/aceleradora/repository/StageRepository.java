package com.thoughtworks.aceleradora.repository;

import com.thoughtworks.aceleradora.domain.Stage;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class StageRepository {

    private static ArrayList<Stage> stages = new ArrayList<>(Arrays.asList(
            new Stage("naum", 1, "explicatione"),
            new Stage("naum2", 2, "explicatwo")));

    public List<Stage> save(Stage stage) {
        stages.add(stage);
        return stages;
    }

    public Stage deleteStage(int number) {
        for (Stage auxStage : stages) {
            if (auxStage.getNumber() == number) {
                stages.remove(auxStage);
                return auxStage;
            }
        }
        throw new IllegalArgumentException("This stage number does not exist.");
    }

    public ArrayList<Stage> getStages() {
        return stages;
    }
}
