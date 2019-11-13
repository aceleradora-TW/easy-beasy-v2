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
    private Stage stage;

    @Before
    public  void setup(){
        stage = new Stage("solution", 1, "hint", asList(new Question("question")));
    }

    @Test
    public void shouldReturnOKIfAddValidStage() {

        when(stageRepository.findAll()).thenReturn(asList());
        when(stageRepository.save(stage)).thenReturn(stage);

        Stage stages = stageService.save(stage);

        Assert.assertEquals(stage.getSolution(), stages.getSolution());
        Assert.assertEquals(stage.getHint(), stages.getHint());
        Assert.assertEquals(stage.getNumber(), stages.getNumber());

        Mockito.verify(stageRepository, Mockito.times(1)).findAll();
        Mockito.verify(stageRepository, Mockito.times(1)).save(stage);
    }

    @Test
    public void shouldTrowExceptionIfStageNumberAlreadyExists() {
        when(stageRepository.findAll()).thenReturn(asList(stage));

        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("The stage number already exist.");

        stageService.save(stage);

        Mockito.verify(stageRepository, Mockito.times(1)).findAll();
    }

    @Test
    public void shouldTrowExceptionIfSolutionNull() {
        Stage stage = new Stage(null, 1, "hint", asList(new Question("question")));

        when(stageRepository.findAll()).thenReturn(asList(stage));

        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("The stage solution cannot be null.");

        stageService.save(stage);
        Mockito.verify(stageRepository, Mockito.times(1)).findAll();
    }

    @Test
    public void shouldTrowExceptionIfDoubtNull() {
        Stage stage = new Stage("solution", 1, null, asList(new Question("question")));

        when(stageRepository.findAll()).thenReturn(asList(stage));

        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("The stage doubt cannot be null.");

        stageService.save(stage);
        Mockito.verify(stageRepository, Mockito.times(1)).findAll();
    }

    @Test
    public void shouldTrowExceptionIfSolutionStartsWithSpace() {
        Stage stage = new Stage(" solution", 1, "doubt", asList(new Question("question")));

        when(stageRepository.findAll()).thenReturn(asList(stage));

        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("The stage solution cannot starts with space.");

        stageService.save(stage);
        Mockito.verify(stageRepository, Mockito.times(1)).findAll();
    }

    @Test
    public void shouldTrowExceptionIfDoubtStartsWithSpace() {
        Stage stage = new Stage("solution", 1, " hint", asList(new Question("question")));

        when(stageRepository.findAll()).thenReturn(asList(stage));

        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("The stage doubt cannot starts with space.");

        stageService.save(stage);
        Mockito.verify(stageRepository, Mockito.times(1)).findAll();
    }

    @Test
    public void shouldReturnExceptionIfTryToDeleteAnNonexistentStage() {
        when(stageRepository.findAll()).thenReturn(asList());

        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("This stage number does not exist.");

        stageService.deleteStage(5);
        Mockito.verify(stageRepository, Mockito.times(1)).findAll();
    }

    @Test
    public void shouldReturnOKIfReturnAllQuestions() {
        Question question = new Question("question");

        Mockito.when(questionRepository.getAllQuestions()).thenReturn(asList(question));

        List<Question> questions = stageService.getQuestions();

        Assert.assertEquals(questions.get(0), question);
        Mockito.verify(questionRepository, Mockito.times(1)).getAllQuestions();
    }

    @Test
    public void shouldReturnOKIfReturnOneQuestion() {
        Question question = new Question("question");

        Mockito.when(questionRepository.getAllQuestions()).thenReturn(asList(question));

        Question questionResult = stageService.getQuestion(0);

        Assert.assertEquals(question, questionResult);
        Mockito.verify(questionRepository, Mockito.times(1)).getAllQuestions();
    }
}
