package client;

import serveur.CalculateurFonctionsImp;

import java.math.BigInteger;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;

public class Diviseurs extends Thread {
    private ArrayList<BigInteger> listeInitiale;
    private ArrayList<BigInteger> res;
    private int port;
    private BDD bdd;

    public Diviseurs(ArrayList<BigInteger> list, int port) throws ClassNotFoundException {
        this.listeInitiale = list;
        this.res = new ArrayList<>();

        //this.client.bdd = new BDD();
    }

    @Override
    public void run() {
        try {
            Registry registry = LocateRegistry.createRegistry(this.port);
            CalculateurFonctionsImp stub = (CalculateurFonctionsImp) registry.lookup("PROJET_RMI");
            System.out.println("Lancement des calculs sur le port :" + this.port);
            this.res = stub.calculNombrePremier(cutArray());
            System.out.println("Résultat du port : "+ this.port+" récupérer\nSauvegarde des calculs dans la bdd pour");
            for(BigInteger nbr : this.res)
                System.out.println(nbr);

        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (NotBoundException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<BigInteger> cutArray() {
        //On divise notre lsite initial en 4, chaque partie sera traité par un serveur
        ArrayList<BigInteger> listeCut = new ArrayList<>();
        int q1 = this.listeInitiale.size() / 4;
        int q2 = this.listeInitiale.size() / 4 * 2;
        int q3 = this.listeInitiale.size() / 4 * 3;
        int q4 = this.listeInitiale.size();
        for (int i = 0; i < this.listeInitiale.size(); i++) {
            if (i <= q1 && this.port == 10000)
                listeCut.add(this.listeInitiale.get(i));
            if (i > q1 && i <= q2 && this.port == 10001)
                listeCut.add(this.listeInitiale.get(i));
            if (i > q2 && i <= q3 && this.port == 10002)
                listeCut.add(this.listeInitiale.get(i));
            if (i > q3 && i <= q4 && this.port == 10003)
                listeCut.add(this.listeInitiale.get(i));
        }
        return listeCut;
    }
}
