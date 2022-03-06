package test;

import bdd.BDD;

import java.sql.SQLException;


public class TestBDD {
    public static void main(String[] args) throws ClassNotFoundException, SQLException, SQLException {
        BDD bdd = new BDD();
        //On plusieurs données à n'autre table
        System.out.println("Insertion des valeurs de 1 a 100");
        for (int i = 0; i < 100; i += 1)
            bdd.insert(i + 1);

        //Test d'affichage des résultats
        System.out.println("Affichage de toutes les valeurs :");
        bdd.showAll();

        //Test d'insertion d'une valeur déjà présente
        System.out.println("\nInsertion d'un nombre déjà présent :");
        bdd.insert(5);

        //Puis on efface la table
        System.out.println("\nEffacement de la table");
        bdd.truncateTable();

        //On ferme la connexion
        System.out.println("\nFermeture de la connexion");
        bdd.endConnection();
    }
}
