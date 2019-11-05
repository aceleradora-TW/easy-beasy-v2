package com.thoughtworks.aceleradora.repository;

import com.thoughtworks.aceleradora.domain.Stage;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class StageRepositoryTest {
    @Test
    public void shouldReturnOKIfAddValidStage(){
        Stage stage = new Stage("solution", 5, "doubt");

        StageRepository stageRepository = new StageRepository();
        stageRepository.addStage(stage);
        List<Stage> stages = stageRepository.getStages();

        Stage stageResult =  stages.get(stages.size()-1);
        Assert.assertEquals(stage.getSolution(), stageResult.getSolution());
        Assert.assertEquals(stage.getDoubt(), stageResult.getDoubt());
        Assert.assertEquals(stage.getNumber(), stageResult.getNumber());
    }

    @Test
    public void shouldTrowExceptionIfStageNumberAlredyExists(){
        Stage stage = new Stage ("solution", 2, "doubt");

    }
}
