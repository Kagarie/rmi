package serveur;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public interface CalculateurFonctionsImp extends Remote {
    /**
     *
     * @param listeNombre
     * @return
     * @throws RemoteException
     */
    public ArrayList<BigInteger> calculNombrePremier(List<BigInteger> listeNombre)throws RemoteException;
}
