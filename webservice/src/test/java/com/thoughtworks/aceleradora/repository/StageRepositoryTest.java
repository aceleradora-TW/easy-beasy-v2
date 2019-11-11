package com.thoughtworks.aceleradora.repository;

import com.thoughtworks.aceleradora.domain.Question;
import com.thoughtworks.aceleradora.domain.Stage;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.stereotype.Repository;

import java.util.List;

import static java.util.Arrays.asList;

public class StageRepositoryTest {

    @Test
    public void shouldReturnStageWithQuestions(){
        StageRepository stageRepository = new StageRepository();

        Stage stage = new Stage("solution", 3, "doubt", asList(
                new Question ("description"),
                new Question("anotherDescription")
        ));

        stageRepository.save(stage);

        List<Stage> stagesResult = stageRepository.getStages();

        Assert.assertEquals(stagesResult.get(2).getQuestions(), stage.getQuestions());
    }
}
