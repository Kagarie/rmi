import java.math.BigInteger;
import java.sql.SQLException;
import java.util.ArrayList;

import client.BDD;
import serveur.Serveur;
import client.Diviseurs;

public class Client {
    public static void main(String[] args) {

        //Initialisation connexion à la client.bdd
        BDD bdd = null;
        try {
            bdd = new BDD();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.exit(1);
        }

        // On lance le serveur
        int port = 10000;
        Serveur.main(port);
        System.out.println("Serveur lancé");

        //On créait une Liste de BigInteger
        ArrayList<BigInteger> listBigInteger = new ArrayList<>();
        int limite = 10000;
        System.out.println("Génération d'une liste de BigInteger jusqu'à : " + limite);
        for (int i = 2; i < limite; i++) {
            listBigInteger.add(BigInteger.valueOf(i));
        }

        Diviseurs divid = null;
        try {
            divid = new Diviseurs(listBigInteger,port);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("Lancement des calculs");
        ArrayList<BigInteger> listRes= divid.lancementCalcul();;

        System.out.println("Sauvegarde des calculs dans la bdd");
        for(BigInteger nbr : listRes)
            bdd.insert(nbr);

        System.out.println("Fin de la sauvegarde");

        //Fermeture de la connexion à la bdd
        System.out.println("Fin de la connexion à la bdd");
        try {
            bdd.endConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //Arrêt du programme
        System.out.println("Arrêt du programme");
        System.exit(0);
    }
}
