package test;

import client.Diviseurs;
import serveur.Serveur;

import java.math.BigInteger;
import java.util.ArrayList;

public class TestDiviseurs {
    public static void main(String[] args) throws ClassNotFoundException {

        //Creation d'une liste de 100 éléments
        ArrayList<BigInteger> listBigInteger = new ArrayList<>();
        for (int i = 0; i <100 ; i++) {
            listBigInteger.add(BigInteger.valueOf(i));
        }

        // On lance le serveur
        int port = 10000;
        Serveur.main(port);
        System.out.println("Serveur lancé");

        Diviseurs divid = null;
        try {
            divid = new Diviseurs(listBigInteger,port);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
   

        //On lance les calculs
        System.out.println("Lancement des calculs");
        ArrayList<BigInteger> listRes= divid.lancementCalcul();;

        //On vérifie que tout c'est bien passé
        if (listRes.size() == 27)
            System.out.println("Longeur de la liste qui contient les résultats correcte");
        
        System.out.println("Affichage des résultats");
        for(BigInteger nbr : listRes)
           System.out.println(nbr);

        //Arrêt du programme
        System.out.println("Arrêt du programme");
        System.exit(0);
    }
}
