package com.aos.repository;

import org.springframework.data.repository.CrudRepository;

import com.aos.entities.PersonModel;

public interface PersonRepository extends CrudRepository<PersonModel, Integer> {

}
