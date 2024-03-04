package fr.semtree.FileTreatement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

@Service
public class DatabaseInitializer {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void initializeDatabase(String filePath) throws FileNotFoundException, IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            StringBuilder sqlStatementBuilder = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                // Check if line is empty or a comment
                if (!line.trim().isEmpty() && !line.trim().startsWith("--")) {
                    sqlStatementBuilder.append(line.trim());
                    // If line ends with semicolon, execute the statement
                    if (line.trim().endsWith(";")) {
                        System.out.println("SQL Builder is " + sqlStatementBuilder);
                        try {
                            jdbcTemplate.execute(sqlStatementBuilder.toString());
                        } catch (Exception e) {
                            System.err.println("Error executing SQL statement: " + e.getMessage());
                        }
                        sqlStatementBuilder.setLength(0);
                    }
                }
            }
            System.out.println("I'm out of the loop ");
        }
    }
}
