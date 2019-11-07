package com.thoughtworks.aceleradora.service;

import com.thoughtworks.aceleradora.domain.Question;
import com.thoughtworks.aceleradora.repository.QuestionRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class QuestionServiceTest {
    @Mock
    private QuestionRepository questionRepository;

    @InjectMocks
    private QuestionService questionService;

    @Test
    public void shouldReturnOKIfGetOneQuestion() {
        Question question = new Question("question");

        Mockito.when(questionService.getAllQuestions()).thenReturn(Arrays.asList(question));
        Mockito.when(questionRepository.getAllQuestions()).thenReturn(Arrays.asList(question));

        Question questionExpected = questionService.getQuestion(0);

        Assert.assertEquals(question.getDescription(), questionExpected.getDescription());
    }

    @Test
    public void shouldReturnOKIfGetAllQuestion() {
        Question question = new Question("question");
        Question question1 = new Question("question");

        Mockito.when((questionRepository.getAllQuestions())).thenReturn(Arrays.asList(question, question1));

        List<Question> questions = questionService.getAllQuestions();

        Assert.assertEquals(questions.get(0), question);
        Assert.assertEquals(questions.get(1), question1);
    }

}
