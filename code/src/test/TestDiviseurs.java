package test;

import client.Diviseurs;
import serveur.Serveur;

import java.math.BigInteger;
import java.util.ArrayList;

public class TestDiviseurs {
    public static void main(String[] args) throws ClassNotFoundException {

        //Creation d'une liste de 100 éléments
        ArrayList<BigInteger> list = new ArrayList<>();
        for (int i = 0; i <100 ; i++) {
            list.add(BigInteger.valueOf(i));
        }


        // On lance nos 4 serveurs avec un port incrémenter 10 000 +i
        int port = 0;
        int [] serveurs=new int[4];
        for(int i = 0 ; i<serveurs.length;i++) {
            port = 10000 +i;
            Serveur.main(port);
            System.out.println("Serveur sur le port :" +port +" lancé");
        }
        //Creation de 4 objets diviseur qui vont faire office de tampon entre le client et le serveur
        ArrayList <Diviseurs> listServeur = new ArrayList<>();
        for(int i = 0 ; i<4;i++)
            port = 10000 +i;
            listServeur.add(new Diviseurs(list, port));

        //On lance les calculs à travers les objets diviseurs qui hérite de thread
        for (Diviseurs d : listServeur)
            d.start();
    }
}
