package fr.semtree.RdfParser;

import java.io.FileOutputStream;
import java.io.OutputStream;

import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Property;
import org.apache.jena.rdf.model.RDFNode;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.rdf.model.Statement;
import org.apache.jena.rdf.model.StmtIterator;
import org.apache.jena.vocabulary.RDF;
import org.springframework.stereotype.Component;

import fr.semtree.ColorfulError;
import lombok.Getter;

@Component
public class RdfParser implements ColorfulError{

    @Getter
    Model headerModel = ModelFactory.createDefaultModel();
    @Getter
    String exNS = "http://www.w3.org/1999/02/22-rdf-syntax-ns#";


    public Model CreateRDFHeader(){
        

        // Préfixes pour les namespaces RDF
        headerModel.setNsPrefix("rdf", "http://www.w3.org/1999/02/22-rdf-syntax-ns#");
        headerModel.setNsPrefix("rdfs", "http://www.w3.org/2000/01/rdf-schema#");

        return headerModel;
    }


    public void writeModelInFile(Model model, String filename,String type) {
        try (OutputStream outputStream = new FileOutputStream(filename)) {
            model.write(outputStream, type);
        } catch (Exception e) {
            ColorfulError.printError("IN METHOD : writeModelInFile");
            e.printStackTrace();
        }
    }
    
    public void FillRdf(){
         Model model = ModelFactory.createDefaultModel();

        // Définir le préfixe
        String exNS = "http://localhost:8080/";
        model.setNsPrefix("ex", exNS);

        // Créer les ressources et ajouter les triples RDF
        Resource album1 = model.createResource(exNS + "album1")
                .addProperty(RDF.type, model.createResource(exNS + "Album"))
                .addProperty(model.createProperty(exNS + "nomAlbum"), "Thriller")
                .addProperty(model.createProperty(exNS + "artiste"), "Michael Jackson");

        // Écrire le modèle RDF
        model.write(System.out, "Turtle");
    }
    
    
    public void printRdf(String rdfFile){
        Model model = ModelFactory.createDefaultModel();
        model.read(rdfFile);
        // Parcourir les triplets pour extraire les relations
        StmtIterator iter = model.listStatements();
        while (iter.hasNext()) {
            Statement stmt = iter.nextStatement();
            Resource subject = stmt.getSubject();
            Property predicate = stmt.getPredicate();
            RDFNode object = stmt.getObject();
            // Afficher la relation entre les ressources
            ColorfulError.printAnyInColor(subject.toString() + " -- " + predicate.toString() + " --> " + object.toString());
        }
    }
}
