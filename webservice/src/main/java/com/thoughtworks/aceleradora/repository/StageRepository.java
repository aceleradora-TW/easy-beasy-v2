package com.thoughtworks.aceleradora.repository;

import com.thoughtworks.aceleradora.domain.Stage;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StageRepository  extends CrudRepository<Stage, Long> {


    List<Stage> findAll();
    Optional<Stage> findById(Long id);
}
