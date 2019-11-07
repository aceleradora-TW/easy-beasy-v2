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

@RunWith(MockitoJUnitRunner.class)
public  class QuestionServiceTest {
    @Mock
    private QuestionRepository questionRepository;

    @InjectMocks
    private QuestionService questionService;

    @Test
    public void shouldReturnOKIfGetOneQuestion(){
        Question question = new Question("question");

        Mockito.when(questionService.getAllQuestions()).thenReturn(Arrays.asList(question));
        Mockito.when(questionRepository.getAllQuestions()).thenReturn(Arrays.asList(question));

        Question questionExpected = questionService.getQuestion(0);

        Assert.assertEquals(question.getDescription(), questionExpected.getDescription());
    }

}
