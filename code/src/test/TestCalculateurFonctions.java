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
        listBigInteger.add(BigInteger.valueOf(2));
        listBigInteger.add(BigInteger.valueOf(3));
        listBigInteger.add(BigInteger.valueOf(5));
        listBigInteger.add(BigInteger.valueOf(7));
        listBigInteger.add(BigInteger.valueOf(6));
        listBigInteger.add(BigInteger.valueOf(999));
        listBigInteger.add(BigInteger.valueOf(997));
        listBigInteger.add(BigInteger.valueOf(2000));
        listBigInteger.add(BigInteger.valueOf(2003));

        //On vient tester la fonction "calculNombrePremier"
        ArrayList<BigInteger> res = cf.calculNombrePremier(listBigInteger);
        for(BigInteger nbr : res)
            System.out.println(nbr);
    }
}
