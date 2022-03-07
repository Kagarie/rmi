package bdd;


import java.sql.*;
import java.util.Objects;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * Class BDD elle gère la connexion entre la class Diviseurs(le pc client) et la bdd
 */
public class BDD {
    private Connection co;
    private Statement stmt;
    private String sql;

    /**
     * @throws ClassNotFoundException
     */
    public BDD() throws ClassNotFoundException {

        //Demande des paramètres pour la connexion à la BDD
        Scanner sc = new Scanner(System.in);
        System.out.println("Nom de la Base de donnée:");
        String name = sc.nextLine();
        System.out.println("Port de la Base de donnée: (par défaut 5432)");
        String port = sc.nextLine();
        if (Objects.equals(port, "")) {
            System.out.println("5432");
            port = "5432";
        }
        System.out.println("Utilisateurs de la Base de donnée:");
        String user = sc.nextLine();
        System.out.println("Mot de passe de la Base de donnée:");
        String password = sc.nextLine();

        String url = "jdbc:postgresql://localhost:" + port + "/" + name;
        //Connexion à la BDD
        try {
            Class.forName("org.postgresql.Driver");
            this.co = DriverManager.getConnection(url, user, password);
            this.stmt = co.createStatement();
            System.out.println("Connexion réussis\n");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Fonction pour inssérer une valeur dans la table
     *
     * @param value
     */
    public void insert(int value) {
        try {
            this.sql = "INSERT INTO nombre_premier VALUES (" + value + ");";
            this.stmt.executeUpdate(this.sql);
        } catch (Exception e) {
            Pattern pattern = Pattern.compile("existe déjà.", Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(e.getMessage());
            boolean matchFound = matcher.find();
            if (matchFound)
                System.out.println("Erreur nombre " + value + " est déjà présent");
            else
                e.printStackTrace();
        }
    }
    public void truncateTable(){
        try {
            this.sql ="truncate table nombre_premier;";
            this.stmt.executeUpdate(this.sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Fonction qui retourne tous les enregistrements dans la table
     *
     * @return
     */
    public void showAll() {
        try {
            ResultSet res = this.stmt.executeQuery("SELECT * FROM nombre_premier");
            while (res.next())
                System.out.println(res.getString(1));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * @throws SQLException
     */
    public void endConnection() throws SQLException {
        this.co.close();
    }

}
