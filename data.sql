DROP TABLE IF EXISTS Artiste_Album;
DROP TABLE IF EXISTS ARTISTE;
DROP TABLE IF EXISTS ContenuAlbum;
DROP TABLE IF EXISTS Label;
DROP TABLE IF EXISTS ALBUM;

CREATE TABLE ALBUM (
    id_ALBUM INT PRIMARY KEY,
    nom_ALBUM VARCHAR(50)
);

CREATE TABLE ContenuAlbum (
    id_Alb INT REFERENCES ALBUM(id_ALBUM),
    Num_Track INT,
    Titre_Track VARCHAR(40),
    PRIMARY KEY (id_Alb, Num_Track)
);

CREATE TABLE ARTISTE (
    Num_ART INT PRIMARY KEY,
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


INSERT INTO ALBUM (id_ALBUM, nom_ALBUM) VALUES ('Thriller');
INSERT INTO ALBUM (id_ALBUM, nom_ALBUM) VALUES ('The Dark Side of the Moon');
INSERT INTO ALBUM (id_ALBUM, nom_ALBUM) VALUES ('Album 3');
INSERT INTO ALBUM (id_ALBUM, nom_ALBUM) VALUES ('Album 4');
INSERT INTO ALBUM (id_ALBUM, nom_ALBUM) VALUES ('Album 5');
INSERT INTO ALBUM (id_ALBUM, nom_ALBUM) VALUES ('Album 6');
INSERT INTO ALBUM (id_ALBUM, nom_ALBUM) VALUES ('Album 7');
INSERT INTO ALBUM (id_ALBUM, nom_ALBUM) VALUES ('Album 8');
INSERT INTO ALBUM (id_ALBUM, nom_ALBUM) VALUES ('Album 9');
INSERT INTO ALBUM (id_ALBUM, nom_ALBUM) VALUES ('Album 10');
INSERT INTO ALBUM (id_ALBUM, nom_ALBUM) VALUES ('Album 11');
INSERT INTO ALBUM (id_ALBUM, nom_ALBUM) VALUES ('Album 12');
INSERT INTO ALBUM (id_ALBUM, nom_ALBUM) VALUES ('Album 13');
INSERT INTO ALBUM (id_ALBUM, nom_ALBUM) VALUES ('Album 14');
INSERT INTO ALBUM (id_ALBUM, nom_ALBUM) VALUES ('Album 15');
INSERT INTO ALBUM (id_ALBUM, nom_ALBUM) VALUES ('Album 16');
INSERT INTO ALBUM (id_ALBUM, nom_ALBUM) VALUES ('Album 17');
INSERT INTO ALBUM (id_ALBUM, nom_ALBUM) VALUES ('Album 18');
INSERT INTO ALBUM (id_ALBUM, nom_ALBUM) VALUES ('Album 19');


/* INSERT INTO ContenuAlbum (id_ALBUM, Num_Track, Titre_Track) VALUES ('1,1,TITRE1');
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
*/
