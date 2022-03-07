package serveur;

import java.math.BigInteger;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

public class CalculateurFonctions implements calculateurFonctionsImp {

    /**
     * @param listeNombre
     * @return
     * @throws RemoteException
     */
    @Override
    public ArrayList<BigInteger> calculNombrePremier(List<BigInteger> listeNombre) throws RemoteException {
        ArrayList<BigInteger> resNombrePremiers = new ArrayList<>();
        //On va vérifier un à un tous les nombres de notre liste
        for (BigInteger nombre : listeNombre) {
            //Test rapide si le nombre et 2 (cas d'execption)
            if (BigInteger.valueOf(2).equals(nombre))
                resNombrePremiers.add(nombre);
            else {
                //Boolean qui défini si un nombre et premier ou non
                boolean notPrimeNumber = false;
                //Calcul de la racine carré du nombre qui nous servira de limite
                int limite = (int) (Math.sqrt(nombre.doubleValue()) + 1);
                /*On test tous les nombres jusqu'à la limite (la racine)
                / On s'arrête à la racine car au dessus on est sur qu'il est premier
                 */
                for (int i = 3; i < limite; i++) {
                    //Si on obtiens un divisions sans reste le nombre n'est pas premiers donc il ne sera pas ajouté
                    if (nombre.mod(BigInteger.valueOf(i)).compareTo(BigInteger.valueOf(0)) == 0) {
                        notPrimeNumber = true;
                    }
                }
                //Si le nombre n'est pas premier on le retient pas
                if (!notPrimeNumber)
                    resNombrePremiers.add(nombre);
            }
        }
        return resNombrePremiers;
    }
}
