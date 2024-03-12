package fr.semtree.FileTreatement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.Property;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.vocabulary.RDF;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.semtree.ColorfulError;
import fr.semtree.RdfParser.RdfParser;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Component
@NoArgsConstructor
public class SqlParser {

    
    @Autowired
    DatabaseInitializer dbInitializer;
    
    @Autowired
    DatabaseAccess dbAccess;

    @Autowired
    RdfParser rdfParser;

    @Autowired
    FileStorageService fileStorer;

    public void handleSqlUpload(String filePath) {
        try {
            dbInitializer.initializeDatabase(filePath);
            dbAccess.connect("/home/hany/FAC/M1/S8/Interoperabilite/Projet/semtree/artists.db");
            if(dbAccess.getConnection() != null){
                System.err.println("Connection établie");
            }
            ColorfulError.printInfo("\n" + filePath + "\n");

            ResultSet resAlbum = getAllFromTable(dbAccess.getConnection(), "SELECT * FROM ALBUM ORDER BY id_ALBUM ASC");
            
            // On crée l'en-tête du fichier RDF
            Model model = rdfParser.CreateRDFHeader();

            
            Property artisteProp = model.createProperty(rdfParser.getExNS() + "artiste");
            Property contenuProp = model.createProperty(rdfParser.getExNS() + "contenuAlbum");

            while (resAlbum.next()) {
                int albumId = resAlbum.getInt("id_ALBUM");
                String nomAlbum = resAlbum.getString("nom_ALBUM");
                ColorfulError.printInfo(nomAlbum);

                // On crée une ressource pour l'album
                Resource albumResource = model.createResource(rdfParser.getExNS() + "album/" + albumId)
                        .addProperty(RDF.type, model.createResource(rdfParser.getExNS() + "Album"))
                        .addProperty(model.createProperty(rdfParser.getExNS() + "nomAlbum"), nomAlbum);


                // On récupère les données de la table ContenuAlbum en utilisant l'ID d'album
                ResultSet contenuResultSet = getAllFromTable(dbAccess.getConnection(), "SELECT * FROM ContenuAlbum WHERE id_Alb = " + albumId);
                while (contenuResultSet.next()) {
                    int numTrack = contenuResultSet.getInt("Num_Track");
                    String titreTrack = contenuResultSet.getString("Titre_Track");


                    // On crée une ressource pour chaque piste et On l'ajoute au contenu de l'album
                    Resource trackResource = model.createResource(rdfParser.getExNS() + "track/" + albumId + "/" + numTrack)
                            .addProperty(RDF.type, model.createResource(rdfParser.getExNS() + "Track"))
                            .addProperty(model.createProperty(rdfParser.getExNS() + "titreTrack"), titreTrack);

                    albumResource.addProperty(contenuProp, trackResource);
                }


                // On récupère les données de la table Artiste_Album en utilisant l'ID d'album
                ResultSet artisteResultSet = getAllFromTable(dbAccess.getConnection(),"SELECT * FROM Artiste_Album WHERE id_Alb = " + albumId);
                while (artisteResultSet.next()) {
                    int artisteId = artisteResultSet.getInt("id_Art");

                    // On crée une ressource pour l'artiste et on l'ajoute comme artiste de l'album
                    Resource artisteResource = model.createResource(rdfParser.getExNS() + "artiste/" + artisteId)
                            .addProperty(RDF.type, model.createResource(rdfParser.getExNS() + "Artiste"))
                            .addProperty(model.createProperty(rdfParser.getExNS() + "idArtiste"), String.valueOf(artisteId));

                    albumResource.addProperty(artisteProp, artisteResource);
                }
            }

            String rdfFilePath = fileStorer.changeFileExtension(filePath, "rdf");
            fileStorer.setRdfFilePath(rdfFilePath);
            rdfParser.writeModelInFile(model, rdfFilePath, "RDF/XML");

            // Création d'un fichier jsonld du même nom 
            String jsonLdPath = fileStorer.changeFileExtension(filePath, "jsonld");
            rdfParser.writeModelInFile(model, jsonLdPath, "JSON-LD");
            
            // Création d'un fichier Turtle du même nom 
            String turtledPath = fileStorer.changeFileExtension(filePath, "ttl");
            rdfParser.writeModelInFile(model, turtledPath, "TURTLE");
            
            
            dbAccess.close();
            // rdfParser.printRdf(rdfFilePath);
        }
        catch (Exception e) {
            ColorfulError.printError("IN METHOD handleSqlUpload \n" + e.getMessage());
        }
    }

    public ResultSet getAllFromTable(Connection connexion, String query){
    try {
        return dbAccess.executeQuery(query);
    } 
    catch (SQLException e) {
        ColorfulError.printError("IN METHOD getAllFromTable");
        e.printStackTrace();
        return null; 
    }
}

    public boolean SqlAlbumToRDF(ResultSet result){
        try {
            while (result.next()) {
                // Traitement des données récupérées
                int id = result.getInt("id_ALBUM");
                String nom = result.getString("nom_ALBUM");

                System.out.println("ID = " + id + " Album name = " + nom);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}

