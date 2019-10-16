package com.thoughtworks.aceleradora.servicos;

import com.thoughtworks.aceleradora.dominio.Stage;
import com.thoughtworks.aceleradora.repositorio.StageRepository;
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
