package fr.semtree.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;

import lombok.Data;


@Entity
@Table(name = "ContenuAlbum")
@Data
public class ContenuAlbum {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_Alb")
    private Album album;

    @Column(name = "Num_Track")
    private int numTrack;

    @Column(name = "Titre_Track")
    private String titreTrack;

    public ContenuAlbum(){
        
    }

}