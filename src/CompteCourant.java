public class CompteCourant extends Compte {
    private double decouvert;

    public CompteCourant(double solde, Personne proprietaire, double decouvert) {
        super(proprietaire, solde);
        this.decouvert = decouvert;
    }

    public CompteCourant(double decouvert) {
        super();
        this.decouvert = decouvert;
    }

    public @Override void retirer(double montant) {
        if ((this.getSolde() - montant) > decouvert) {
            this.setSolde(this.getSolde() - montant);
        } else {
            System.out.println("Solde insuffisant");
        }
    }

    public void setDecouvert(double decouvert) {
        this.decouvert = decouvert;
    }

    public double getDecouvert() {
        return this.decouvert;
    }

}