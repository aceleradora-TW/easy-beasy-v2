package com.thoughtworks.aceleradora.repository;

import com.thoughtworks.aceleradora.domain.Question;
import com.thoughtworks.aceleradora.domain.Stage;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

@RunWith(MockitoJUnitRunner.class)
public class StageRepositoryTest {

    @Mock
    private StageRepository stageRepository;

    @Test
    public void shouldReturnStageWithQuestions(){
        Stage stage = new Stage("solution", 1, "doubt", asList(
                new Question ("description"),
                new Question("anotherDescription")
        ));

        List<Stage> stages = asList(stage);

        Mockito.when(stageRepository.save(stage)).thenReturn(stages);
        Mockito.when(stageRepository.getStages()).thenReturn(stages);

        stageRepository.save(stage);

        List<Stage> stagesRestult = stageRepository.getStages();

        Assert.assertEquals(stagesRestult.get(0).getQuestions(), stage.getQuestions());
    }
}
