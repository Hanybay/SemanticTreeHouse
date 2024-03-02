# Données en entrée et sortie de chaque fonction
Les foncitons détaillées dans les sections ci-dessous sont présentes dans le schéma fourni ( Diagramme CPE ) 

## Fonction 1 : Analyse des données reçues
1. Données en entrée
    * Fichiers sous format PDF
    * Fichiers sous format SQL
    * Données depuis Wikidata
2. Données en sortie
    Deux types de fichiers sont données en sortie suite à l'analyse :
    * Fichier contenant des données valides, suite au filtrage qui a eu lieu après l'analyse des données, qui sera utilisé pour le traitement par la suite
    * Fichier contenant les données invalides, qui sera rejeté.

## Fonction 2 : Extraction et vérification des données reçues
1. Données en entrée
    * Le fichier valide donné en sortie par la fonction d'analyse des données reçues.
    * La base de donnée présente sous-format RDF.
2. Données en sortie
    * Un fichier contenant des données non-existantes encore dans la base de données RDF existante.
    * Un fichier contenant les données déjà présentes (doublons) dans la base de données RDF existante.

## Fonction 3 : Transformation des données en format RDF
1. Données en entrée
    * Le fichier valide donné en sortie par la fonction d'extraction des données reçues.
2. Données en sortie
    * Les données passées en entrée sont insérées dans la base de données sous forme de RDF.