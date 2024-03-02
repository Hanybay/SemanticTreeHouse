package fr.semtree.repositories;

import org.springframework.data.repository.CrudRepository;

import fr.semtree.entities.Label;

public interface LabelRepo extends CrudRepository<Label,String>{

    
}
