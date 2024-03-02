package fr.semtree.FileTreatement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

@Service
public class DatabaseInitializer {

    @Autowired
    private DataSource dataSource;

    public void initializeDatabase(String filePath) {
        try {
            // Chargement du fichier SQL
            String sqlScript = new String(Files.readAllBytes(Paths.get(filePath)));
            System.err.println(sqlScript);

            // Connexion à la base de données
            try (Connection connection = dataSource.getConnection()) {
                // Exécution du script SQL
                System.err.println("Connection Db initializer");
                try {
                    Statement statement = connection.createStatement();
                    String message = (statement == null) ? "Statement est null" : "Statement n'est pas null";
                    System.out.println(message);
                    System.err.println("Create statement Db initializer");
                    boolean result = statement.execute(sqlScript);
                    if (!result) {
                        System.err.println("Erreur lors de l'exécution du script SQL");
                    }
                }
                catch (SQLException e) {
                    e.printStackTrace();
                }
                finally{

                }
            }
        } catch (IOException | SQLException e) {
            System.err.println("Dans le fichier initializer");
            e.printStackTrace();
        }
    }
}
