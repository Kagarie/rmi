package test;

import serveur.CalculateurFonctions;

import java.math.BigInteger;

public class TestCalculateurFonctions {
    public static void main(String[] args) {
        CalculateurFonctions cf = new CalculateurFonctions();
        BigInteger nbr = new BigInteger("54321");
        BigInteger dix = new BigInteger("10");

        //Test de la fonction qui fait la somme des c'est chiffre
        while (nbr.compareTo(dix) > 0) {
            nbr = cf.sommeBitInteger(nbr);
            System.out.println(nbr);
        }
    }
}
