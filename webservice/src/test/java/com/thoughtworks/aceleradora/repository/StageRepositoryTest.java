package com.thoughtworks.aceleradora.repository;

import com.thoughtworks.aceleradora.domain.Stage;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.List;

public class StageRepositoryTest {

    @Rule
    public ExpectedException
    expectedException = ExpectedException.none();

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
        Stage stage = new Stage ("solution", 3, "doubt");
        Stage stageRepeated = new Stage("solution not repeated", 3, "doubt not repeated");

        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("The stage number already exist.");

        StageRepository stageRepository = new StageRepository();
        stageRepository.addStage(stage);
        stageRepository.addStage(stageRepeated);
    }
}
