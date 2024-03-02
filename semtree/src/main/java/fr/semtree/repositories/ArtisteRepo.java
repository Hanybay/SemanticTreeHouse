package fr.semtree.repositories;

import org.springframework.data.repository.CrudRepository;
import fr.semtree.entities.Artiste;

public interface ArtisteRepo extends CrudRepository<Artiste,Long>{

}
