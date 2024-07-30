public class Personne {
    public String prenom;
    public String nom;
    private Civil etatCivil;


    enum Civil {
        CELIBATAIRE,
        MARIE,
        DIVORCE,
        VEUF
    }

    public Personne(String prenom, String nom) {
        this.prenom = prenom;
        this.nom = nom;
    }

    public Personne() {
        this.prenom = prenom;
        this.nom = nom;
    }

    public String toString() {
        return "MyClass{prenom=" + prenom + ", nom='" + nom + "'}";
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setEtatCivil(Civil etatCivil) {
        this.etatCivil = etatCivil;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getNom() {
        return nom;
    }

    public Civil getEtatCivil() {
        return etatCivil;
    }
}
