package com.thoughtworks.aceleradora.service;

import com.thoughtworks.aceleradora.domain.Area;
import com.thoughtworks.aceleradora.repository.AreaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AreaService {
    private AreaRepository areaRepository;

    @Autowired
    public AreaService(AreaRepository areaRepository){
        this.areaRepository = areaRepository;
    }

    public List<Area> getAreas(){
        return areaRepository.findAll();
    }

    public Optional<Area> getAreaById(Long id){
        return areaRepository.findById(id);
    }
}
