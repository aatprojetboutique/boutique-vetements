public class Vetement {
    private String nom;
    private String saison;
    private String couleur;
    private String taille;
    private double prix;
    private int quantite;
    private String description = "";

    @Override
    public String toString() {
        return "Vetement{" +
                "nom='" + nom + '\'' +
                ", saison='" + saison + '\'' +
                ", couleur='" + couleur + '\'' +
                ", taille='" + taille + '\'' +
                ", prix=" + prix +
                ", quantite=" + quantite +
                '}';
    }
    public Vetement(String nom, String saison, String couleur, String taille, double prix, int quantite) {
        this.nom = nom;
        this.saison = saison;
        this.couleur = couleur;
        this.taille = taille;
        this.prix = prix;
        this.quantite = quantite;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getSaison() {
        return saison;
    }

    public void setSaison(String saison) {
        this.saison = saison;
    }

    public String getCouleur() {
        return couleur;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    public String getTaille() {
        return taille;
    }

    public void setTaille(String taille) {
        this.taille = taille;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}