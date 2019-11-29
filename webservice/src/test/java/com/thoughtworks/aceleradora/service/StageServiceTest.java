package com.thoughtworks.aceleradora.service;

import com.thoughtworks.aceleradora.domain.Question;
import com.thoughtworks.aceleradora.domain.Stage;
import com.thoughtworks.aceleradora.repository.QuestionRepository;
import com.thoughtworks.aceleradora.repository.StageRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static java.util.Arrays.asList;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class StageServiceTest {

    @Mock
    private StageRepository stageRepository;

    @Mock
    private QuestionRepository questionRepository;

    @InjectMocks
    private StageService stageService;

    @Rule
    public ExpectedException
            expectedException = ExpectedException.none();
    private Stage expectedStage;

    @Before
    public  void setup(){
        expectedStage = new Stage("solution", 1, "hint", asList(new Question("question", 1L)));
    }

    @Test
    public void shouldReturnOKIfAddValidStage() {

        when(stageRepository.findAll()).thenReturn(asList());
        when(stageRepository.save(expectedStage)).thenReturn(expectedStage);

        Stage stages = stageService.save(expectedStage);

        Assert.assertEquals(expectedStage.getSolution(), stages.getSolution());
        Assert.assertEquals(expectedStage.getHint(), stages.getHint());
        Assert.assertEquals(expectedStage.getNumber(), stages.getNumber());

        Mockito.verify(stageRepository, Mockito.times(1)).findAll();
        Mockito.verify(stageRepository, Mockito.times(1)).save(expectedStage);
    }

    @Test
    public void shouldTrowExceptionIfStageNumberAlreadyExists() {
        when(stageRepository.findAll()).thenReturn(asList(expectedStage));

        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("The stage number already exist.");

        stageService.save(expectedStage);

        Mockito.verify(stageRepository, Mockito.times(1)).findAll();
    }

    @Test
    public void shouldTrowExceptionIfSolutionNull() {
        Stage stage = new Stage(null, 1, "hint", asList(new Question("question",1L)));

        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("The stage solution cannot be null.");

        stageService.save(stage);
        Mockito.verifyZeroInteractions(stageRepository);
    }

    @Test
    public void shouldTrowExceptionIfDoubtNull() {
        Stage stage = new Stage("solution", 1, null, asList(new Question("question",1L)));

        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("The stage doubt cannot be null.");

        stageService.save(stage);
        Mockito.verifyZeroInteractions(stageRepository);
    }

    @Test
    public void shouldTrowExceptionIfSolutionStartsWithSpace() {
        Stage stage = new Stage(" solution", 1, "doubt", asList(new Question("question",1L)));

        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("The stage solution cannot starts with space.");

        stageService.save(stage);
        Mockito.verifyZeroInteractions(stageRepository);
    }

    @Test
    public void shouldTrowExceptionIfDoubtStartsWithSpace() {
        Stage stage = new Stage("solution", 1, " hint", asList(new Question("question",1L)));

        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("The stage doubt cannot starts with space.");

        stageService.save(stage);
        Mockito.verifyZeroInteractions(stageRepository);
    }

    @Test
    public void shouldReturnOKIfReturnAllQuestions() {

        expectedException.expect(IllegalArgumentException.class);

        List<Question> questions = stageService.getStageById((long) 0).getQuestions();

        Assert.assertEquals(questions, expectedStage.getQuestions());
        Mockito.verify(questionRepository, Mockito.times(1)).findAll();
    }

    @Test
    public void shouldReturnOKIfReturnOneQuestion() {

        expectedException.expect(IllegalArgumentException.class);

        Question questionResult = stageService.getStageById((long) 0).getQuestions().get(0);

        Assert.assertEquals(expectedStage.getQuestions().get(0), questionResult);
        Mockito.verify(questionRepository, Mockito.times(1)).findAll();
    }
}
