package com.semantictreehouse.FileReader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import lombok.Data;

@Data
public class SqlReader {

    void CreateDatabaseFromSQL(String fileName){
        String url = "jdbc:sqlite:artists.db";
        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement();
             BufferedReader br = new BufferedReader(new FileReader(fileName))) {

            String line;
            StringBuilder sqlContent = new StringBuilder();

            // Lecture du contenu du fichier SQL
            while ((line = br.readLine()) != null) {
                sqlContent.append(line).append("\n");
            }

            // Execution des instructions SQL pour créer la base de données des artistes
            stmt.executeUpdate(sqlContent.toString());
            
            System.out.println("Base de données créée avec succès.");
        } catch (SQLException | java.io.IOException e) {
            e.printStackTrace();
        }
    }
}
