package com.thoughtworks.aceleradora.repository;

import com.thoughtworks.aceleradora.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

}
