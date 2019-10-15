package com.thoughtworks.aceleradora.repository;

import com.thoughtworks.aceleradora.domain.Question;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class QuestionRepository {
    private static ArrayList<Question> classQuestions = new ArrayList<>(Arrays.asList(new Question("Você está bem?"), new Question("Qual sua idade?")));

    public List<Question> getAllClassQuestions() {
        return classQuestions;
    }

    public void addQuestion(Question question) {
        classQuestions.add(question);
    }

    public Question deleteQuestion(int index) {
        return classQuestions.remove(index);
    }
}
