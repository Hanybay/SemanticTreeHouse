package fr.semtree.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import java.util.HashSet;
import java.util.Set;


import lombok.Data;

@Entity
@Table(name = "ALBUM")
@Data
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_ALBUM;

    private String nom_ALBUM;

    @ManyToMany(mappedBy = "albums")
    private Set<Artiste> artistes = new HashSet<>();


    public Album(){
        
    }

}
