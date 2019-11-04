package com.thoughtworks.aceleradora.repository;

import com.thoughtworks.aceleradora.domain.Stage;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;

public class StageRepository {



    private static ArrayList<Stage> stages = new ArrayList<>(Arrays.asList(
            new Stage("naum", 1, "explicatione"),
            new Stage("naum2", 2, "explicatwo")));

    public void addStage(Stage stage) {
        if(StringUtils.isEmpty(stage.getSolution())) {
            throw new IllegalArgumentException("The stage solution cannot be null.");
        }else if(StringUtils.isEmpty(stage.getDoubt())){
            throw new IllegalArgumentException("The stage doubt cannot be null.");
        }
        for (Stage auxStage: stages) {
            if (stage.getNumber() == auxStage.getNumber()){
                throw new IllegalArgumentException("The stage number already exist.");
            }
        }
        stages.add(stage);
    }

    public Stage deleteStage(int number) {
        for (Stage auxStage: stages) {
            if (auxStage.getNumber() == number){
                stages.remove(auxStage);
                return auxStage;
            }
        }
        throw new IllegalArgumentException("This stage number does not exist.");
    }

    public static ArrayList<Stage> getStages() {
        return stages;
    }
}
