package com.thoughtworks.aceleradora.service;

import com.thoughtworks.aceleradora.domain.Question;
import com.thoughtworks.aceleradora.repository.QuestionRepository;
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

import static java.util.Arrays.asList;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class QuestionServiceTest {

    @Mock
    private QuestionRepository repository;

    @InjectMocks
    private QuestionService questionService;

    @Rule
    public ExpectedException
            expectedException = ExpectedException.none();
    private Question expectedQuestion;

    @Before
    public  void setup(){
        expectedQuestion = new Question("description", 1L);
    }

    @Test
    public void shouldReturnOKIfAddValidStage() {

        when(repository.save(expectedQuestion)).thenReturn(expectedQuestion);

        Question questions = questionService.save(expectedQuestion);

        Assert.assertEquals(expectedQuestion.getDescription(), questions.getDescription());

        Mockito.verify(repository, Mockito.times(1)).save(expectedQuestion);
    }
}
