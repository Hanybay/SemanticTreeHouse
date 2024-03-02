package fr.semtree.FileTreatement;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Component
public class FileStorageService {
    
    @Getter
    private static final String UPLOAD_FOLDER = "../FileUploads";

    public String storeFile(MultipartFile file) {
        try {
            File directory = new File(UPLOAD_FOLDER);
            if (!directory.exists()) {
                directory.mkdirs();
            }

            
            String fileName = file.getOriginalFilename();

            Path filePath = Paths.get(UPLOAD_FOLDER + "/" + fileName);
            System.err.println(filePath);
            

            Files.write(filePath, file.getBytes());

            System.out.println("Fichier enregistré avec succès: " + fileName);
            return filePath.toString();
        } catch (IOException e) {
            System.err.println("Dans le fichier File storage");
            e.printStackTrace();
        }
        return "";
    }
}
