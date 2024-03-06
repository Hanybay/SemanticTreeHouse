package fr.semtree.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import fr.semtree.FileTreatement.FileStorageService;
import fr.semtree.FileTreatement.SqlParser;
import fr.semtree.repositories.AlbumRepo;
import fr.semtree.repositories.ArtisteRepo;
import fr.semtree.repositories.ContenuAlbumRepo;
import fr.semtree.repositories.LabelRepo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


@Controller
public class indexController {
    
    @Autowired
    AlbumRepo albumRep;

    @Autowired
    ArtisteRepo artisteRep;

    @Autowired
    ContenuAlbumRepo contenuAlbumRep;

    @Autowired
    LabelRepo labelRep;

    @Autowired
    SqlParser sqlFileParser;

    @Autowired
    FileStorageService fileStorer;

    @RequestMapping("")
    public String root() {
        return "index";
    }
    
    @PostMapping("/upload")
    public String FileReception(@RequestParam("file") MultipartFile file) {
        if (!file.isEmpty()) {
            System.out.println("Fichier reçu");
            String filePath = fileStorer.storeFile(file);
            sqlFileParser.handleSqlUpload(filePath);
            return "redirect:/rdfVisualizer";
        } else {
             System.out.println("Aucun fichier reçu!");
        }
        return "index";
    }

    @GetMapping("/rdfVisualizer")
    public String RdfTree(){
        return "rdfTree";
    }
    

}
