package com.thoughtworks.aceleradora.controladores;

import com.thoughtworks.aceleradora.dominio.Stage;
import com.thoughtworks.aceleradora.servicos.StageService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/estagio")
public class StageController {

    private StageService stageService;

    public StageController(StageService stageService) {
        this.stageService = stageService;
    }

    @GetMapping(path = "/solucao")
    public List<Stage> getStagesList() {
        return stageService.getStages();
    }

    @GetMapping(path = "/{index}")
    public Stage getStage(@PathVariable("index") int index) {
        return stageService.getStage(index);
    }

}
