package com.thoughtworks.aceleradora.service;

import com.thoughtworks.aceleradora.domain.Stage;
import com.thoughtworks.aceleradora.repository.StageRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class StageService {
    private StageRepository repository;

    public StageService(StageRepository repository) {
        this.repository = repository;
    }

    public List<Stage> save(Stage stage) {
        return repository.save(stage);
    }

    public List<Stage> getStages() {
        return repository.getStages();
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

    public void saveVerification(Stage stage) {
        if (StringUtils.isEmpty(stage.getSolution())) {
            throw new IllegalArgumentException("The stage solution cannot be null.");
        } else if (StringUtils.isEmpty(stage.getDoubt())) {
            throw new IllegalArgumentException("The stage doubt cannot be null.");
        }
        for (Stage auxStage : repository.getStages()) {
            if (stage.getNumber() == auxStage.getNumber()) {
                throw new IllegalArgumentException("The stage number already exist.");
            }
        }
        save(stage);
    }
}
