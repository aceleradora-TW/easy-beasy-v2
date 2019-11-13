package com.thoughtworks.aceleradora.controller;

import com.thoughtworks.aceleradora.domain.Stage;
import com.thoughtworks.aceleradora.service.StageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/stage")
public class StageController {

    private StageService stageService;

    @Autowired
    public StageController(StageService stageService) {
        this.stageService = stageService;
    }

    @GetMapping(path = "")
    public List<Stage> getStagesList() {
        return stageService.getStages();
    }

    @GetMapping(path = "/{id}")
    public Stage getStage(@PathVariable("id") Long id) {
        return stageService.getStageById(id);
    }

}
