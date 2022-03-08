import serveur.CalculateurFonctionsImp;
import serveur.Serveur;

import java.math.BigInteger;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;

public class Client {
    public static void main(String[] args) throws ClassNotFoundException {
        //Initialisation connexion à la client.bdd
        //BDD bdd = new BDD();



        ArrayList<BigInteger> listBigInteger = new ArrayList<>();
        for (int i =2 ; i <20 ; i++) {
            listBigInteger.add(BigInteger.valueOf(i));
        }
        try {
            Registry registry = LocateRegistry.getRegistry(10000);
            CalculateurFonctionsImp stub = (CalculateurFonctionsImp) registry.lookup("PROJET_RMI");
            System.out.println("Lancement des calculs");
            ArrayList<BigInteger> res = stub.calculNombrePremier(listBigInteger);
            System.out.println("Sauvegarde des calculs dans la client.bdd");
            for(BigInteger nbr : res)
                System.out.println(nbr);
                //bdd.insert(nbr);
            System.out.println("Fin de la sauvegarde");
        }catch (Exception e) {
            e.printStackTrace();
        }


    }
}
