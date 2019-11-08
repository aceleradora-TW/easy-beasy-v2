package com.thoughtworks.aceleradora.service;

import com.thoughtworks.aceleradora.domain.Question;
import com.thoughtworks.aceleradora.domain.Stage;
import com.thoughtworks.aceleradora.repository.QuestionRepository;
import com.thoughtworks.aceleradora.repository.StageRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class StageService {
    private StageRepository repository;
    private QuestionRepository questionRepository;

    public StageService(StageRepository repository, QuestionRepository questionRepository) {
        this.repository = repository;
        this.questionRepository = questionRepository;
    }

    public List<Question> getQuestions() {
        return questionRepository.getAllQuestions();
    }

    public Question getQuestion(int index) {
        return getQuestions().get(index);
    }

    public List<Stage> save(Stage stage) {
        validation(stage);
        return repository.save(stage);
    }

    public List<Stage> getStages() {
        return repository.getStages();
    }

    public Stage getStageById(Long id) {
        return repository.getStageById(id);
    }

    public Stage deleteStage(int number) {
        List<Stage> stages = getStages();

        for (Stage auxStage : stages) {
            if (auxStage.getNumber() == number) {
                return repository.deleteStage(auxStage);
            }
        }
        throw new IllegalArgumentException("This stage number does not exist.");
    }

    private void validation(Stage stage) {
        List<Stage> stages = repository.getStages();

        if (StringUtils.isEmpty(stage.getSolution())) {
            throw new IllegalArgumentException("The stage solution cannot be null.");
        }

        if (StringUtils.isEmpty(stage.getDoubt())) {
            throw new IllegalArgumentException("The stage doubt cannot be null.");
        }
        if (stage.getSolution().startsWith(" ")) {
            throw new IllegalArgumentException("The stage solution cannot starts with space.");
        }

        if (stage.getDoubt().startsWith(" ")) {
            throw new IllegalArgumentException("The stage doubt cannot starts with space.");
        }

        for (Stage auxStage : stages) {
            if (stage.getNumber() == auxStage.getNumber()) {
                throw new IllegalArgumentException("The stage number already exist.");
            }
        }
    }
}
