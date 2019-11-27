package com.thoughtworks.aceleradora.repository;

import com.thoughtworks.aceleradora.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    Optional<User> findById(Long id);
}
