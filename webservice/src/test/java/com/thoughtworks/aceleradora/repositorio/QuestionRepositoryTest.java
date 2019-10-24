package com.thoughtworks.aceleradora.repositorio;

import com.thoughtworks.aceleradora.dominio.Question;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class QuestionRepositoryTest {

    @Test
    public void shouldReturnOKIfISaveAValidQuestion() {
        // Insumos
        Question questionExpected = new Question(1, "Você controla seus testes?");
        // ação
        QuestionRepository questionRepository = new QuestionRepository();
        List<Question> questions = questionRepository.salvar(questionExpected);

        // validação
        Question questionResult = questions.get(0);
        Assert.assertEquals(questionExpected.getPriority(), questionResult.getPriority());
        Assert.assertEquals(questionExpected.getDescription(), questionResult.getDescription());
    }

    @Test
    public void shouldReturnErrorIfISaveAQuestionWithouDescription() {
        Question questionExpected = new Question(1, null);

        QuestionRepository questionRepository = new QuestionRepository();
        List<Question> questions = questionRepository.salvar(questionExpected);

        Assert.assertEquals(0, questions.size());
    }

}
