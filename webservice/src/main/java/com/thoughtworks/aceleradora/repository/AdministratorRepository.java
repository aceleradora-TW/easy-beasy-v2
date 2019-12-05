package com.thoughtworks.aceleradora.repository;

import com.thoughtworks.aceleradora.domain.Administrator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdministratorRepository extends JpaRepository<Administrator, Long> {
    Administrator findByUsername(String username);

}
