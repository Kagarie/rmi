package test;

import serveur.CalculateurFonctions;


import java.math.BigInteger;
import java.rmi.RemoteException;
import java.util.ArrayList;


public class TestCalculateurFonctions {
    public static void main(String[] args) throws RemoteException {
        CalculateurFonctions cf = new CalculateurFonctions();

        //On créait une liste dans laquelle on ajoute différente valeurs
        ArrayList<BigInteger> listBigInteger = new ArrayList<>();
        for (int i = 2; i <100 ; i++) {
            listBigInteger.add(BigInteger.valueOf(i));
        }

        //On vient tester la fonction "calculNombrePremier"
        ArrayList<BigInteger> res = cf.calculNombrePremier(listBigInteger);
        for(BigInteger nbr : res)
            System.out.println(nbr);
    }
}
