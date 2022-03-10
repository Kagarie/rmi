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

    public Diviseurs(ArrayList<BigInteger> list,int port) throws ClassNotFoundException {
        this.liste = list;
        this.port=port;
    }

    public ArrayList<BigInteger> lancementCalcul() {
        ArrayList<BigInteger> res = new ArrayList<>();
        try {
            Registry registry = LocateRegistry.getRegistry(this.port);
            CalculateurFonctionsImp stub = (CalculateurFonctionsImp) registry.lookup("PROJET_RMI");
            res = stub.calculNombrePremier(this.liste);

        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (NotBoundException e) {
            e.printStackTrace();
        }
        return res;
    }

}
