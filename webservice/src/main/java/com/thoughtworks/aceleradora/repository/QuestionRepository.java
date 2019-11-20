package com.thoughtworks.aceleradora.repository;

import com.thoughtworks.aceleradora.domain.Question;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends CrudRepository<Question, Long> {

    List<Question>findAll();

}
