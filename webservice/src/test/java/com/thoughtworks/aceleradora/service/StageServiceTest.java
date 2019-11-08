package com.thoughtworks.aceleradora.service;

import com.thoughtworks.aceleradora.domain.Question;
import com.thoughtworks.aceleradora.domain.Stage;
import com.thoughtworks.aceleradora.repository.StageRepository;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class StageServiceTest {

    @Mock
    private StageRepository stageRepository;

    @Mock
    private QuestionService questionService;

    @InjectMocks
    private StageService stageService;

    @Rule
    public ExpectedException
            expectedException = ExpectedException.none();

    @Test
    public void shouldReturnOKIfAddValidStage() {
        Stage stage = new Stage("solution", 1, "doubt");

        when(stageRepository.getStages()).thenReturn(Arrays.asList());
        when(stageRepository.save(stage)).thenReturn(Arrays.asList(stage));

        List<Stage> stages = stageService.save(stage);

        Stage stageResult = stages.get(0);
        Assert.assertEquals(stage.getSolution(), stageResult.getSolution());
        Assert.assertEquals(stage.getDoubt(), stageResult.getDoubt());
        Assert.assertEquals(stage.getNumber(), stageResult.getNumber());
    }

    @Test
    public void shouldTrowExceptionIfStageNumberAlreadyExists() {
        Stage stage = new Stage("solution not repeated", 4, "doubt not repeated");

        when(stageRepository.getStages()).thenReturn(Arrays.asList(new Stage("solutionadhudsahuda", 4, "doubtdsadisadhusa")));

        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("The stage number already exist.");

        stageService.save(stage);
    }

    @Test
    public void shouldTrowExceptionIfSolutionNull() {
        Stage stage = new Stage(null, 5, "doubt");

        when(stageRepository.getStages()).thenReturn(Arrays.asList(stage));

        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("The stage solution cannot be null.");

        stageService.save(stage);
    }

    @Test
    public void shouldTrowExceptionIfDoubtNull() {
        Stage stage = new Stage("solution", 6, null);

        when(stageRepository.getStages()).thenReturn(Arrays.asList(stage));

        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("The stage doubt cannot be null.");

        stageService.save(stage);
    }

    @Test
    public void shouldTrowExceptionIfSolutionStartsWithSpace() {
        Stage stage = new Stage(" ", 7, "doubt");

        when(stageRepository.getStages()).thenReturn(Arrays.asList(stage));

        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("The stage solution cannot starts with space.");

        stageService.save(stage);
    }

    @Test
    public void shouldTrowExceptionIfDoubtStartsWithSpace() {
        Stage stage = new Stage("solution", 8, " ");

        when(stageRepository.getStages()).thenReturn(Arrays.asList(stage));

        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("The stage doubt cannot starts with space.");

        stageService.save(stage);
    }

    @Test
    public void shouldReturnDeletedStageIfDeleteStageSuccessfully() {
        Stage stage = new Stage("solution", 9, "doubt");

        when(stageRepository.getStages()).thenReturn(Arrays.asList(stage));
        when(stageRepository.deleteStage(stage)).thenReturn(stage);

        Stage stageResult = stageService.deleteStage(9);

        Assert.assertEquals(stage, stageResult);
    }

    @Test
    public void shouldReturnExceptionIfTryToDeleteAnNonexistentStage() {
        when(stageRepository.getStages()).thenReturn(Arrays.asList());

        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("This stage number does not exist.");

        stageService.deleteStage(5);
    }

    @Test
    public void shouldReturnOKIfReturnJustOneStageByIndex() {
        Stage stage = new Stage("solution", 1, "doubt");
        Stage oneMoreStage = new Stage("solution", 2, "doubt");

        when(stageRepository.getStages()).thenReturn(Arrays.asList(stage, oneMoreStage));

        Stage stageResult = stageService.getStage(0);
        Stage oneMoreResult = stageService.getStage(1);

        Assert.assertEquals(stage, stageResult);
        Assert.assertEquals(oneMoreStage, oneMoreResult);
    }

    @Test
    public void shouldReturnOKIfReturnAllQuestions() {
        Question question = new Question("question");

        Mockito.when(questionService.getAllQuestions()).thenReturn(Arrays.asList(question));

        List<Question> questions = stageService.getQuestions();

        Assert.assertEquals(questions.get(0), question);
    }

    @Test
    public void shouldReturnOKIfReturnOneQuestion() {
        Question question = new Question("question");

        Mockito.when(questionService.getQuestion(0)).thenReturn(question);

        Question questionResult = stageService.getQuestion(0);

        Assert.assertEquals(question, questionResult);
    }
}
