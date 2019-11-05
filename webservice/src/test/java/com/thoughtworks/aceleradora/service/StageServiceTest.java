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

}
