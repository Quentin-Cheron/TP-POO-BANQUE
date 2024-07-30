public class CompteEpargne extends Compte {
    private double interet;

    public CompteEpargne(double solde, Personne proprietaire, double interet) {
        super(proprietaire, solde);
        this.interet = interet;
    }

    public CompteEpargne(double decouvert) {
        super();
        this.interet = interet;
    }

    public double getInteret() {
        return this.interet;
    }

    public void setInteret(double interet) {
        this.interet = interet;
    }
}
