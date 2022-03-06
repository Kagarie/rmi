package serveur;

import java.math.BigInteger;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

public class CalculateurFonctions implements calculateurFonctionsImp {

    /**
     *
     * @param listeNombre
     * @return
     * @throws RemoteException
     */
    @Override
    public ArrayList<BigInteger> calculNombrePremier(List<BigInteger> listeNombre) throws RemoteException {
        ArrayList<BigInteger> resNombrePremiers = new ArrayList<BigInteger>();
        //On va vérifier un à un tous les nombres de notre liste
        for (BigInteger nombre : listeNombre) {
            //Test rapide si le nombre et 2 ou 5 (cas d'execption)
            if (BigInteger.valueOf(2).equals(nombre) || BigInteger.valueOf(5).equals(nombre))
                resNombrePremiers.add(nombre);
            else {

                /** On boucle sur la fonction tant que le résultat obtenu n'est pas plus petit que 10
                * La méthode compare tout renvoi -1 0 1 respectivement pour inférieur, égale et supérieur
                * Si on passe 54321 le résultat sera 6
                * */
                while (nombre.compareTo(BigInteger.valueOf(10)) > 0)
                    nombre = this.sommeBitInteger(nombre);
                //On reprends le nombre obtenu précédement et on l'ajoute s'il respecte bien les régles pour un nombre premier
                if (BigInteger.valueOf(1).equals(nombre) || BigInteger.valueOf(3).equals(nombre) || BigInteger.valueOf(7).equals(nombre) || BigInteger.valueOf(9).equals(nombre))
                    resNombrePremiers.add(nombre);
            }
        }
        return resNombrePremiers;
    }

    /**
     *Permet de faire la somme des nombres présent dans un btiInteger ex : 54321 => 15
     */
    public BigInteger sommeBitInteger(BigInteger nombre) {
        return BigInteger.valueOf(0).equals(nombre) ? BigInteger.valueOf(0) : nombre.mod(BigInteger.valueOf(10)).add(sommeBitInteger(nombre.divide(BigInteger.valueOf(10))));
    }
}
