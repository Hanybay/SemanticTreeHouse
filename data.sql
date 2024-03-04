DROP TABLE IF EXISTS Artiste_Album;
DROP TABLE IF EXISTS ARTISTE;
DROP TABLE IF EXISTS ContenuAlbum;
DROP TABLE IF EXISTS Label;
DROP TABLE IF EXISTS ALBUM;

CREATE TABLE ALBUM (
    id_ALBUM INTEGER PRIMARY KEY,
    nom_ALBUM VARCHAR(50)
);

CREATE TABLE ContenuAlbum (
    id_Alb INT REFERENCES ALBUM(id_ALBUM),
    Num_Track INT,
    Titre_Track VARCHAR(40),
    PRIMARY KEY (id_Alb, Num_Track)
);

CREATE TABLE ARTISTE (
    Num_ART INTEGER PRIMARY KEY,
    Label VARCHAR(50) REFERENCES Label(Nom_Label),
    Nom VARCHAR(30),
    Prenom VARCHAR(30),
    DateNaissance Date,
    Sexe VARCHAR(1)
);

CREATE TABLE Label(
    Nom_Label VARCHAR(50) PRIMARY KEY,
    Nom_Directeur VARCHAR(30),
    Prenom_Directeur VARCHAR(30)
);

CREATE TABLE Artiste_Album (
    id_Alb INT REFERENCES ALBUM(id_ALBUM),
    id_Art INT REFERENCES ARTISTE(Num_ART),
    PRIMARY KEY (id_Alb, id_Art)
);


INSERT INTO ALBUM (nom_ALBUM) VALUES ('Thriller');
INSERT INTO ALBUM (nom_ALBUM) VALUES ('The Dark Side of the Moon');
INSERT INTO ALBUM (nom_ALBUM) VALUES ('Album 3');
INSERT INTO ALBUM (nom_ALBUM) VALUES ('Album 4');
INSERT INTO ALBUM (nom_ALBUM) VALUES ('Album 5');
INSERT INTO ALBUM (nom_ALBUM) VALUES ('Album 6');
INSERT INTO ALBUM (nom_ALBUM) VALUES ('Album 7');
INSERT INTO ALBUM (nom_ALBUM) VALUES ('Album 8');
INSERT INTO ALBUM (nom_ALBUM) VALUES ('Album 9');
INSERT INTO ALBUM (nom_ALBUM) VALUES ('Album 10');
INSERT INTO ALBUM (nom_ALBUM) VALUES ('Album 11');
INSERT INTO ALBUM (nom_ALBUM) VALUES ('Album 12');
INSERT INTO ALBUM (nom_ALBUM) VALUES ('Album 13');
INSERT INTO ALBUM (nom_ALBUM) VALUES ('Album 14');
INSERT INTO ALBUM (nom_ALBUM) VALUES ('Album 15');
INSERT INTO ALBUM (nom_ALBUM) VALUES ('Album 16');
INSERT INTO ALBUM (nom_ALBUM) VALUES ('Album 17');
INSERT INTO ALBUM (nom_ALBUM) VALUES ('Album 18');
INSERT INTO ALBUM (nom_ALBUM) VALUES ('Album 19');




INSERT INTO ContenuAlbum (id_ALBUM, Num_Track, Titre_Track) VALUES ('1,1,TITRE1');
INSERT INTO ContenuAlbum (id_ALBUM, Num_Track, Titre_Track) VALUES ('1,2,TITRE2');
INSERT INTO ContenuAlbum (id_ALBUM, Num_Track, Titre_Track) VALUES ('1,3,TITRE3');
INSERT INTO ContenuAlbum (id_ALBUM, Num_Track, Titre_Track) VALUES ('1,4,TITRE4');
INSERT INTO ContenuAlbum (id_ALBUM, Num_Track, Titre_Track) VALUES ('1,5,TITRE5');
INSERT INTO ContenuAlbum (id_ALBUM, Num_Track, Titre_Track) VALUES ('1,6,TITRE6');
INSERT INTO ContenuAlbum (id_ALBUM, Num_Track, Titre_Track) VALUES ('1,7,TITRE7');
INSERT INTO ContenuAlbum (id_ALBUM, Num_Track, Titre_Track) VALUES ('1,8,TITRE8');
INSERT INTO ContenuAlbum (id_ALBUM, Num_Track, Titre_Track) VALUES ('1,9,TITRE9');
INSERT INTO ContenuAlbum (id_ALBUM, Num_Track, Titre_Track) VALUES ('1,10,TITRE10');
INSERT INTO ContenuAlbum (id_ALBUM, Num_Track, Titre_Track) VALUES ('1,11,TITRE11');




INSERT INTO ARTISTE (Num_ART, Label, Nom, Prenom, DateNaissance, Sexe) VALUES (1, 'Label1', 'John', 'Doe', '1990-01-01', 'M');
INSERT INTO ARTISTE (Num_ART, Label, Nom, Prenom, DateNaissance, Sexe) VALUES (2, 'Label2', 'Jane', 'Smith', '1985-05-15', 'F');
INSERT INTO ARTISTE (Num_ART, Label, Nom, Prenom, DateNaissance, Sexe) VALUES (3, 'Sony Music', 'Dupont', 'Jean', '1990-05-15', 'M');
INSERT INTO ARTISTE (Num_ART, Label, Nom, Prenom, DateNaissance, Sexe) VALUES (4, 'Universal Music', 'Martin', 'Sophie', '1985-12-10', 'F');
INSERT INTO ARTISTE (Num_ART, Label, Nom, Prenom, DateNaissance, Sexe) VALUES (5, 'Warner Music', 'Dubois', 'Pierre', '1982-08-25', 'M');
INSERT INTO ARTISTE (Num_ART, Label, Nom, Prenom, DateNaissance, Sexe) VALUES (6, 'EMI Music', 'Lefevre', 'Marie', '1995-03-20', 'F');
INSERT INTO ARTISTE (Num_ART, Label, Nom, Prenom, DateNaissance, Sexe) VALUES (7, 'Capitol Music', 'Garcia', 'Luc', '1988-07-08', 'M');
INSERT INTO ARTISTE (Num_ART, Label, Nom, Prenom, DateNaissance, Sexe) VALUES (8, 'Virgin Records', 'Leroy', 'Julie', '1992-11-02', 'F');
INSERT INTO ARTISTE (Num_ART, Label, Nom, Prenom, DateNaissance, Sexe) VALUES (9, 'RCA Records', 'Moreau', 'Thomas', '1980-01-18', 'M');
INSERT INTO ARTISTE (Num_ART, Label, Nom, Prenom, DateNaissance, Sexe) VALUES (10, 'Atlantic Records', 'Petit', 'Camille', '1993-09-12', 'F');
INSERT INTO ARTISTE (Num_ART, Label, Nom, Prenom, DateNaissance, Sexe) VALUES (11, 'Columbia Records', 'Roux', 'Emma', '1987-06-30', 'F');
INSERT INTO ARTISTE (Num_ART, Label, Nom, Prenom, DateNaissance, Sexe) VALUES (12, 'Island Records', 'Girard', 'Nicolas', '1984-04-05', 'M');
INSERT INTO ARTISTE (Num_ART, Label, Nom, Prenom, DateNaissance, Sexe) VALUES (13, 'Polydor', 'Lemoine', 'Alice', '1991-10-22', 'F');
INSERT INTO ARTISTE (Num_ART, Label, Nom, Prenom, DateNaissance, Sexe) VALUES (14, 'Republic Records', 'Fernandez', 'Antoine', '1983-02-14', 'M');
INSERT INTO ARTISTE (Num_ART, Label, Nom, Prenom, DateNaissance, Sexe) VALUES (15, 'Interscope Records', 'Muller', 'Laura', '1989-09-08', 'F');
INSERT INTO ARTISTE (Num_ART, Label, Nom, Prenom, DateNaissance, Sexe) VALUES (16, 'Epic Records', 'Sanchez', 'Paul', '1994-06-12', 'M');
INSERT INTO ARTISTE (Num_ART, Label, Nom, Prenom, DateNaissance, Sexe) VALUES (17, 'MCA Records', 'Hernandez', 'Julien', '1986-12-28', 'M');



INSERT INTO ARTISTE_ALBUM (Num_ART, nom_ALBUM) VALUES (3, 'Thriller');
INSERT INTO ARTISTE_ALBUM (Num_ART, nom_ALBUM) VALUES (3, 'The Dark Side of the Moon');
INSERT INTO ARTISTE_ALBUM (Num_ART, nom_ALBUM) VALUES (4, 'Album 3');
INSERT INTO ARTISTE_ALBUM (Num_ART, nom_ALBUM) VALUES (5, 'Album 4');
INSERT INTO ARTISTE_ALBUM (Num_ART, nom_ALBUM) VALUES (6, 'Album 5');
INSERT INTO ARTISTE_ALBUM (Num_ART, nom_ALBUM) VALUES (7, 'Album 6');
INSERT INTO ARTISTE_ALBUM (Num_ART, nom_ALBUM) VALUES (8, 'Album 7');
INSERT INTO ARTISTE_ALBUM (Num_ART, nom_ALBUM) VALUES (9, 'Album 8');
INSERT INTO ARTISTE_ALBUM (Num_ART, nom_ALBUM) VALUES (10, 'Album 9');
INSERT INTO ARTISTE_ALBUM (Num_ART, nom_ALBUM) VALUES (11, 'Album 10');
INSERT INTO ARTISTE_ALBUM (Num_ART, nom_ALBUM) VALUES (12, 'Album 11');
INSERT INTO ARTISTE_ALBUM (Num_ART, nom_ALBUM) VALUES (13, 'Album 12');
INSERT INTO ARTISTE_ALBUM (Num_ART, nom_ALBUM) VALUES (14, 'Album 13');
INSERT INTO ARTISTE_ALBUM (Num_ART, nom_ALBUM) VALUES (15, 'Album 14');
INSERT INTO ARTISTE_ALBUM (Num_ART, nom_ALBUM) VALUES (16, 'Album 15');
INSERT INTO ARTISTE_ALBUM (Num_ART, nom_ALBUM) VALUES (17, 'Album 16');



-- Add more artists as needed

INSERT INTO Label (Nom_Label, Nom_Directeur, Prenom_Directeur) VALUES ('Sony Music', 'Smith', 'John');
INSERT INTO Label (Nom_Label, Nom_Directeur, Prenom_Directeur) VALUES ('Universal Music', 'Johnson', 'Emma');
INSERT INTO Label (Nom_Label, Nom_Directeur, Prenom_Directeur) VALUES ('Warner Music', 'Williams', 'Michael');
INSERT INTO Label (Nom_Label, Nom_Directeur, Prenom_Directeur) VALUES ('EMI Music', 'Jones', 'Sarah');
INSERT INTO Label (Nom_Label, Nom_Directeur, Prenom_Directeur) VALUES ('Capitol Music', 'Brown', 'Sophie');
INSERT INTO Label (Nom_Label, Nom_Directeur, Prenom_Directeur) VALUES ('Virgin Records', 'Davis', 'David');
INSERT INTO Label (Nom_Label, Nom_Directeur, Prenom_Directeur) VALUES ('RCA Records', 'Miller', 'Laura');
INSERT INTO Label (Nom_Label, Nom_Directeur, Prenom_Directeur) VALUES ('Atlantic Records', 'Wilson', 'James');
INSERT INTO Label (Nom_Label, Nom_Directeur, Prenom_Directeur) VALUES ('Columbia Records', 'Taylor', 'Olivia');
INSERT INTO Label (Nom_Label, Nom_Directeur, Prenom_Directeur) VALUES ('Island Records', 'Anderson', 'William');
INSERT INTO Label (Nom_Label, Nom_Directeur, Prenom_Directeur) VALUES ('Polydor', 'Thomas', 'Charlotte');
INSERT INTO Label (Nom_Label, Nom_Directeur, Prenom_Directeur) VALUES ('Republic Records', 'Jackson', 'Emily');
INSERT INTO Label (Nom_Label, Nom_Directeur, Prenom_Directeur) VALUES ('Interscope Records', 'White', 'Daniel');
INSERT INTO Label (Nom_Label, Nom_Directeur, Prenom_Directeur) VALUES ('Epic Records', 'Clark', 'Sophia');
INSERT INTO Label (Nom_Label, Nom_Directeur, Prenom_Directeur) VALUES ('MCA Records', 'Allen', 'Ryan');


