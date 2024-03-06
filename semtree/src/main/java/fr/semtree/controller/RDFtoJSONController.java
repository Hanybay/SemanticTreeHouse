package fr.semtree.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.semtree.FileTreatement.FileStorageService;

import java.nio.file.Files;
import java.nio.file.Paths;

import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.rdf.model.StmtIterator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/api")
public class RDFtoJSONController {

    @Autowired
    FileStorageService fileStorer;
    
    @GetMapping("/rdf-to-json")
    public String convertRDFtoJSON() {
        // Charger le fichier RDF/XML

        String tmp = fileStorer.getRdfFilePath();
        String jsonPath = fileStorer.changeFileExtension(tmp, "jsonld");

        try {
        // Lire le contenu du fichier JSON-LD
        String jsonLDString = new String(Files.readAllBytes(Paths.get(jsonPath)));
        return jsonLDString;
    } catch (Exception e) {
        // Gérer les erreurs de lecture de fichier
        e.printStackTrace();
        return null;
    }
        // Model model = ModelFactory.createDefaultModel();
        // model.read(rdfFile, "TURTLE");

        // JSONObject json = new JSONObject();

        // // Parcourir chaque ressource dans le modèle RDF
        //  StmtIterator iter = model.listStatements();
        // while (iter.hasNext()) {
        //     Resource subject = iter.nextStatement().getSubject();
        //     String subjectURI = subject.getURI();

        //     // Créer un objet JSON pour chaque ressource
        //     JSONObject resourceJSON = new JSONObject();
            

        //     // Ajouter chaque triple au JSON
        //     JSONArray jsonArray = new JSONArray();
        //     StmtIterator stmtIter = model.listStatements(subject, null, (String) null);
        //     while (stmtIter.hasNext()) {
        //         jsonArray.add(stmtIter.nextStatement().toString());
        //     }
        //     resourceJSON.put("triples", jsonArray);

        //     // Ajouter la ressource au JSON global
        //     json.put(subjectURI, resourceJSON);
        // }

    }
    
}
