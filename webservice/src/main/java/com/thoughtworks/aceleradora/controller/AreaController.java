package com.thoughtworks.aceleradora.controller;


import com.thoughtworks.aceleradora.domain.Area;
import com.thoughtworks.aceleradora.service.AreaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/area")
public class AreaController {

    private AreaService areaService;

    public AreaController(AreaService areaService){
        this.areaService = areaService;
    }

    @GetMapping(path = "")
    public List<Area> getAreas(){
        return areaService.getAreas();
    }

}
