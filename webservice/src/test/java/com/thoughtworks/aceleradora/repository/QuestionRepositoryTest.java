package com.thoughtworks.aceleradora.repository;

import com.thoughtworks.aceleradora.domain.Question;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.List;

public class QuestionRepositoryTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void shouldReturnOKIfISaveAValidQuestion() {
        // Insumos
        Question questionExpected = new Question("Você controla seus testes?");
        // ação
        QuestionRepository questionRepository = new QuestionRepository();
        questionRepository.addQuestion(questionExpected);
        List<Question> questions = questionRepository.getAllQuestions();

        // validação
        Question questionResult = questions.get(questions.size()-1);
        Assert.assertEquals(questionExpected.getDescription(), questionResult.getDescription());
    }

    @Test
    public void shouldReturnErrorIfISaveAQuestionWithouDescription() {
        Question questionExpected = new Question( null);
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("The question description cannot be null.");

        QuestionRepository questionRepository = new QuestionRepository();
        questionRepository.addQuestion(questionExpected);
    }

}
