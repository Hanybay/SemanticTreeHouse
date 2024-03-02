package fr.semtree.FileTreatement;

import java.sql.ResultSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
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

    public boolean handleSqlUpload(String filePath) {
        try {
            dbInitializer.initializeDatabase(filePath);
            dbAccess.connect("/home/hany/FAC/M1/S8/Interoperabilite/Projet/semtree/artists.db");
            if(dbAccess.getConnection() != null){
                System.err.println("Connection établie");
            }
            ResultSet resultSet = dbAccess.executeQuery("SELECT * FROM ALBUM");
            
            while (resultSet.next()) {
                // Traitement des données récupérées
                int id = resultSet.getInt("id_ALBUM");
                String nom = resultSet.getString("nom_ALBUM");

                System.err.println("On rentre ");
                System.out.println(id + "    " + nom);

            }
            dbAccess.close();
            return true;
        }
        catch (Exception e) {
            e.getMessage();
            return false; 
        }
    }
}

