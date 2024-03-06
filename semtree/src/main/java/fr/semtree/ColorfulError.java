package fr.semtree;

public interface ColorfulError {
    // Codes de couleur ANSI
    String ANSI_RESET = "\u001B[0m";
    String ANSI_RED = "\u001B[31m";
    String ANSI_GREEN = "\u001B[32m";
    String ANSI_YELLOW = "\u001B[33m";
    String ANSI_BLUE = "\u001B[34m";
    String ANSI_PURPLE = "\u001B[35m";
    String ANSI_CYAN = "\u001B[36m";
    String ANSI_WHITE = "\u001B[37m";

    static void printError(String message) {
        System.out.println(ANSI_RED + "Erreur: " + message + ANSI_RESET);
    }

    static void printInfo(String message) {
        System.out.println(ANSI_GREEN + "Information: " + message + ANSI_RESET);
    }

    static void printAnyInColor(String message) {
        System.out.println(ANSI_GREEN + message + ANSI_RESET);
    }
}
