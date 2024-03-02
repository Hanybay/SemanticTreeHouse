package fr.semtree.repositories;

import org.springframework.data.repository.CrudRepository;

import fr.semtree.entities.Album;

public interface AlbumRepo extends CrudRepository<Album,Long>{
    
}
