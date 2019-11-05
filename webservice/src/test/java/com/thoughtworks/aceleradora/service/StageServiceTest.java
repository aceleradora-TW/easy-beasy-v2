package com.thoughtworks.aceleradora.service;

import com.thoughtworks.aceleradora.domain.Stage;
import com.thoughtworks.aceleradora.repository.StageRepository;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.List;

public class StageServiceTest {

    @Rule
    public ExpectedException
            expectedException = ExpectedException.none();

    @Test
    public void shouldReturnOKIfAddValidStage() {
        Stage stage = new Stage("solution", 5, "doubt");
        StageRepository stageRepository = new StageRepository();
        StageService stageService = new StageService(stageRepository);
        stageService.save(stage);
        List<Stage> stages = stageService.getStages();

        Stage stageResult = stages.get(stages.size() - 1);
        Assert.assertEquals(stage.getSolution(), stageResult.getSolution());
        Assert.assertEquals(stage.getDoubt(), stageResult.getDoubt());
        Assert.assertEquals(stage.getNumber(), stageResult.getNumber());
    }

    @Test
    public void shouldTrowExceptionIfStageNumberAlredyExists() {
        Stage stage = new Stage("solution", 3, "doubt");
        Stage stageRepeated = new Stage("solution not repeated", 3, "doubt not repeated");
        StageRepository stageRepository = new StageRepository();

        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("The stage number already exist.");

        StageService stageService = new StageService(stageRepository);
        stageService.save(stage);
        stageService.save(stageRepeated);
    }

    @Test
    public void shouldTrowExceptionIfSolutionNull() {
        Stage stage = new Stage(null, 3, "doubt");

        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("The stage solution cannot be null.");

        StageRepository stageRepository = new StageRepository();
        StageService stageService = new StageService(stageRepository);
        stageService.save(stage);
    }

    @Test
    public void shouldTrowExceptionIfDoubtNull(){
        Stage stage = new Stage("solution", 3, null);

        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("The stage doubt cannot be null.");

        StageRepository stageRepository = new StageRepository();
        StageService stageService = new StageService(stageRepository);
        stageService.save(stage);
    }

    @Test
    public void shouldTrowExceptionIfSolutionStartsWithSpace(){
        Stage stage = new Stage(" ", 3, "doubt");

        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("The stage solution cannot starts with space.");

        StageRepository stageRepository = new StageRepository();
        StageService stageService = new StageService(stageRepository);
        stageService.save(stage);
    }
}
