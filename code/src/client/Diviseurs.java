package client;

import serveur.CalculateurFonctionsImp;

import java.math.BigInteger;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;


public class Diviseurs  {
    private final int port;
    private final ArrayList<BigInteger> liste;

    /**
     *
     * @param list
     * @param port
     * @throws ClassNotFoundException
     */
    public Diviseurs(ArrayList<BigInteger> list,int port) throws ClassNotFoundException {
        this.liste = list;
        this.port=port;
    }

    /**
     *
     * @return ArrayList BigInteger
     */
    public ArrayList<BigInteger> lancementCalcul() {
        ArrayList<BigInteger> res = new ArrayList<>();
        try {
            //On récupére le registre sur le port pour avoir accés au méthode du serveur
            Registry registry = LocateRegistry.getRegistry(this.port);
            CalculateurFonctionsImp stub = (CalculateurFonctionsImp) registry.lookup("PROJET_RMI");
            //Puis on envoit les calculs sur le serveurs et on return le résultat
            res = stub.calculNombrePremier(this.liste);

        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (NotBoundException e) {
            e.printStackTrace();
        }
        return res;
    }

}
