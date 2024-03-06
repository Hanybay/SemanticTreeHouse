package fr.semtree.FileTreatement;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.Setter;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Component
public class FileStorageService {
    
    @Getter
    private static final String UPLOAD_FOLDER = "../FileUploads";

    @Getter
    @Setter
    private String rdfFilePath = "";

    public String storeFile(MultipartFile file) {
        try {
            File directory = new File(UPLOAD_FOLDER);
            if (!directory.exists()) {
                directory.mkdirs();
            }

            
            String fileName = file.getOriginalFilename();

            Path filePath = Paths.get(UPLOAD_FOLDER + "/" + fileName);
            
            Files.write(filePath, file.getBytes());

            System.out.println("Fichier enregistré avec succès: " + fileName);
            return filePath.toString();
        } catch (IOException e) {
            System.err.println("Dans le fichier File storage");
            e.printStackTrace();
        }
        return "";
    }


    public String changeFileExtension(String filePath, String newExtension) {
        int lastDotIndex = filePath.lastIndexOf(".");
        if (lastDotIndex != -1) {
            // Construction du nouveau chemin avec la nouvelle extension
            String newPath = filePath.substring(0, lastDotIndex) + "." + newExtension;
            return newPath;
        } else {
            // Si le fichier n'a pas d'extension, on ajoute directement la nouvelle extension
            return filePath + "." + newExtension;
        }
    }
}
