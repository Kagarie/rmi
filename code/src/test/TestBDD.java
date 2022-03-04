package test;

import bdd.BDD;

import java.sql.SQLException;


public class TestBDD {
    public static void main(String[] args) throws ClassNotFoundException, SQLException, SQLException {
        BDD bdd = new BDD();
        //On plusieurs données à n'autre table
        for (int i = 0; i < 100; i += 1)
            bdd.insert(i);

        //Test d'affichage des résultats
        bdd.showAll();
        //Test d'insertion d'une valeur déjà présente
        bdd.insert(5);

        //Puis on efface la table
        bdd.truncateTable();

        //On ferme la connexion
        bdd.endConnection();
    }
}
