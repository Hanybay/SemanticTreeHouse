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
        Connection connection = null;
        try {
            // Load SQL script
            String sqlScript = new String(Files.readAllBytes(Paths.get(filePath)));
    
            // Get database connection
            connection = dataSource.getConnection();
            connection.setAutoCommit(false); // Start transaction
    
            // Execute SQL script
            try (Statement statement = connection.createStatement()) {
                statement.execute(sqlScript);
                connection.commit(); // Commit transaction if successful
                System.out.println("Database initialized successfully.");
            } catch (SQLException e) {
                connection.rollback(); // Rollback changes if there's an error
                System.err.println("Error executing SQL script: " + e.getMessage());
            }
        } catch (IOException e) {
            System.err.println("Error reading SQL script file: " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("Error establishing database connection: " + e.getMessage());
        } finally {
            try {
                if (connection != null) {
                    connection.setAutoCommit(true); // Reset auto-commit mode
                    connection.close();
                }
            } catch (SQLException e) {
                System.err.println("Error closing database connection: " + e.getMessage());
            }
        }
    }
    
}
