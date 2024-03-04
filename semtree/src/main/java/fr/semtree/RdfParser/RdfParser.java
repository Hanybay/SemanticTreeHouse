package fr.semtree.RdfParser;

import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.vocabulary.RDF;

public class RdfParser {

    public Model CreateRDFHeader(){
        Model headerModel = ModelFactory.createDefaultModel();

        // Définir les préfixes pour les namespaces utilisés dans l'en-tête
        String rdfNS = "http://www.w3.org/1999/02/22-rdf-syntax-ns#";
        headerModel.setNsPrefix("rdf", rdfNS);

        String exNS = "http://localhost:8080/";
        headerModel.setNsPrefix("ex", exNS);

        // Vous pouvez également ajouter d'autres préfixes ou métadonnées selon vos besoins

        return headerModel;
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
}
