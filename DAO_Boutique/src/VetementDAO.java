import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VetementDAO {

    private Connection connexion = null;

    public void initialisation() {
        try {
            // Identifiants de connexion et nom de la base
            String nomUtilisateur = "root";
            String motDePasse = "pass";
            String nomBase = "tablesindependantes";

            // Préparation de la commande de connexion
            String connec = "jdbc:mariadb://localhost:3307/";
            connec += nomBase + "?user=" + nomUtilisateur;
            connec += "&password=" + motDePasse;

            // Connexion
            this.connexion = DriverManager.getConnection(connec);

            // Creer l'inventoire s'il y a un besoin
            createInventoire();

        } catch (Exception e) {
            System.out.println("Exception : " + e.getMessage());
        }
    }

    public void createInventoire() {
        try {
            Statement statement = connexion.createStatement();
            // Ecriture de la requête SQL
            String requete = "CREATE TABLE IF NOT EXISTS inventoire_vetements (\n" +
                    "  ID int(11) NOT NULL AUTO_INCREMENT,\n" +
                    "  nom varchar(255) NOT NULL,\n" +
                    "  saison varchar(255) NOT NULL,\n" +
                    "  couleur varchar(255) NOT NULL,\n" +
                    "  taille varchar(255) NOT NULL,\n" +
                    "  prix DOUBLE UNSIGNED,\n" +
                    "  quantite TINYINT UNSIGNED,\n" +
                    "  PRIMARY KEY (`ID`)\n" +
                    ")";
            statement.executeQuery(requete);
        }
        catch (Exception e) {
            System.out.println("Exception : " + e.getMessage());
        }
    }
    public void cloture() {
        try {
            connexion.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void afficherTousLesVetements() {
        try {

            Statement statement = connexion.createStatement();

            // Ecriture de la requête SQL
            String requete = "SELECT * FROM inventoire_vetements;";

            // Récupération du résultat de la requête
            ResultSet rs = statement.executeQuery(requete);

            // Traitement du résultat
            while (rs.next()) {
                System.out.println(
                        rs.getString("nom") + "," + rs.getString("saison") + "," +
                                rs.getString("couleur") + "," + rs.getString("taille") + "," +
                                rs.getDouble("prix") + "," + rs.getInt("quantite"));
            }

        } catch (Exception e) {
            System.out.println("Exception : " + e.getMessage());
        }
    }

    public void ajouterVetement(Vetement vetement) {

        try {

            Statement statement = connexion.createStatement();

            // Ecriture de la requête SQL
            String requete = "INSERT INTO inventoire_vetements VALUES(DEFAULT,'";
            requete += vetement.getNom();
            requete += "','";
            requete += vetement.getSaison();
            requete += "','";
            requete += vetement.getCouleur();
            requete += "','";
            requete += vetement.getTaille();
            requete += "',";
            requete += vetement.getPrix();
            requete += ",";
            requete += vetement.getQuantite();
            requete += ");";

            System.out.println(requete);

            statement.executeUpdate(requete);

        } catch (Exception e) {
            System.out.println("Exception : " + e.getMessage());
        }
    }

    public List<Vetement> retournerTousLesVetements() {

        List<Vetement> inventoireVetements = new ArrayList<>();

        try {

            Statement statement = connexion.createStatement();

            // Ecriture de la requête SQL
            String requete = "SELECT * FROM inventoire_vetements;";

            // Récupération du résultat de la requête
            ResultSet rs = statement.executeQuery(requete);

            // Traitement du résultat
            while (rs.next()) {
                Vetement vetementEnCoursDeRecuperation = new Vetement(rs.getString("nom"), rs.getString("saison")
                        ,rs.getString("couleur"), rs.getString("taille")
                        , rs.getDouble("prix"), rs.getInt("quantite"));
                inventoireVetements.add(vetementEnCoursDeRecuperation);
            }

        } catch (Exception e) {
            System.out.println("Exception : " + e.getMessage());
        }

        return inventoireVetements;

    }
}
