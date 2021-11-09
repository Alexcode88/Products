package com.codingdojo.app.repositories;

import org.springframework.data.repository.CrudRepository;

import com.codingdojo.app.models.Association;

public interface AssociationRepository extends CrudRepository<Association, Long>{

}
