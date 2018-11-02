package com.jackseb.demo.Model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends CrudRepository<Person,Long> {
    List<Person> findAllByName(String name);

}
