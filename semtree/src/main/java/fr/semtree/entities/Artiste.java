package fr.semtree.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.Data;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "ARTISTE")
@Data
public class Artiste {
    @Id
    @Column(name = "Num_ART")
    private Long numArtiste;

    @Column(name = "Nom")
    private String nom;

    @Column(name = "Prenom")
    private String prenom;

    @Column(name = "DateNaissance")
    private Date dateNaissance;

    @Column(name = "Sexe")
    private String sexe;

    @ManyToOne
    @JoinColumn(name = "Label")
    private Label label;


    @ManyToMany
    @JoinTable(
            name = "ArtisteAlbum",
            joinColumns = @JoinColumn(name = "id_Art"),
            inverseJoinColumns = @JoinColumn(name = "id_Alb")
    )
    private Set<Album> albums = new HashSet<>();
    public Artiste(){
        
    }

}