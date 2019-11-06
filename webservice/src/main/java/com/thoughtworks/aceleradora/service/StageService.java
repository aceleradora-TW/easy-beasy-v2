package com.thoughtworks.aceleradora.service;

import com.thoughtworks.aceleradora.domain.Stage;
import com.thoughtworks.aceleradora.repository.StageRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StageService {
    private StageRepository repository;

    public StageService(StageRepository repository) {
        this.repository = repository;
    }

    public List<Stage> getStages() {
        return repository.getStages();
    }

    public Stage getStage(int index) {
        return getStages().get(index);
    }


}