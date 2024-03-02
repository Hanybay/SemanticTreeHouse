package fr.semtree.FileTreatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class DatabaseAccess {

    private Connection connection;

    // Méthode pour établir la connexion à la base de données
    public void connect(String dbFilePath) throws SQLException {
        connection = DriverManager.getConnection("jdbc:sqlite:" + dbFilePath);
    }

    // Méthode pour exécuter une requête de lecture (SELECT)
    public ResultSet executeQuery(String query, Object... params) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(query);
        setParameters(statement, params);
        return statement.executeQuery();
    }

    // Méthode pour exécuter une requête de modification (INSERT, UPDATE, DELETE)
    public int executeUpdate(String query, Object... params) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(query);
        setParameters(statement, params);
        return statement.executeUpdate();
    }

    // Méthode pour fermer la connexion à la base de données
    public void close() throws SQLException {
        if (connection != null) {
            connection.close();
        }
    }

    // Méthode utilitaire pour définir les paramètres d'une requête préparée
    private void setParameters(PreparedStatement statement, Object... params) throws SQLException {
        for (int i = 0; i < params.length; i++) {
            statement.setObject(i + 1, params[i]);
        }
    }
}
