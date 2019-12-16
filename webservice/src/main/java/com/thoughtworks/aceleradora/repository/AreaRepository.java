package com.thoughtworks.aceleradora.repository;

import com.thoughtworks.aceleradora.domain.Area;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AreaRepository extends CrudRepository<Area, Long> {

    List<Area> findAll();
    Optional<Area> findById(Long id);
}
