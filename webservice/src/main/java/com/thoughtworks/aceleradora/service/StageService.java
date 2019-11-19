package com.thoughtworks.aceleradora.service;

import com.thoughtworks.aceleradora.domain.Question;
import com.thoughtworks.aceleradora.domain.Stage;
import com.thoughtworks.aceleradora.repository.StageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class StageService {
    private StageRepository repository;


    @Autowired
    public StageService(StageRepository repository) {
        this.repository = repository;
    }

    public List<Question> getQuestionsFormStage(Long id) {
        return getStageById(id).getQuestions();
    }

    public Stage save(Stage stage) {
        validation(stage);
        return repository.save(stage);
    }

    public List<Stage> getStages() {
        return repository.findAll();
    }

    public Stage getStageById(Long id) {
        return repository.findById(id).orElseThrow(IllegalArgumentException::new);
    }

    public Stage deleteStage(int stageNumber) {
        List<Stage> stages = getStages();

        for (Stage auxStage : stages) {
            if (auxStage.getNumber() == stageNumber) {
                repository.delete(auxStage);
            }
        }
        throw new IllegalArgumentException("This stage number does not exist.");
    }

    private void validation(Stage stage) {


        if (StringUtils.isEmpty(stage.getSolution())) {
            throw new IllegalArgumentException("The stage solution cannot be null.");
        }

        if (StringUtils.isEmpty(stage.getHint())) {
            throw new IllegalArgumentException("The stage doubt cannot be null.");
        }
        if (stage.getSolution().startsWith(" ")) {
            throw new IllegalArgumentException("The stage solution cannot starts with space.");
        }

        if (stage.getHint().startsWith(" ")) {
            throw new IllegalArgumentException("The stage doubt cannot starts with space.");
        }

        for (Stage auxStage : getStages()) {
            if (stage.getNumber() == auxStage.getNumber()) {
                throw new IllegalArgumentException("The stage number already exist.");
            }
        }
    }
}
