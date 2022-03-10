package serveur;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;


public class Serveur {
    public static void main(int port) {
        try {
            CalculateurFonctionsImp skeleton = (CalculateurFonctionsImp) UnicastRemoteObject.exportObject(new CalculateurFonctions(), 10000);
            Registry registry = LocateRegistry.createRegistry(port);
            registry.rebind("PROJET_RMI", skeleton);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
