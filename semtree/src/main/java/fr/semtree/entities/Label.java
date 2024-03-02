package fr.semtree.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import lombok.Data;



@Entity
@Table(name = "Label1")
@Data
public class Label {
    @Id
    @Column(name = "Nom_Label")
    private String nom;

    @Column(name = "Nom_Directeur")
    private String nomDirecteur;

    @Column(name = "Prenom_Directeur")
    private String prenomDirecteur;

    public Label(){
        
    }

}