package com.thoughtworks.aceleradora.repository;

import com.thoughtworks.aceleradora.domain.Question;
import com.thoughtworks.aceleradora.exceptions.NullQuestionDescriptionException;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class QuestionRepositoryTest {

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

    @Test(expected = NullQuestionDescriptionException.class)
    public void shouldReturnErrorIfISaveAQuestionWithouDescription() {
        Question questionExpected = new Question( null);

        QuestionRepository questionRepository = new QuestionRepository();
        questionRepository.addQuestion(questionExpected);
    }

}
