import java.util.ArrayList;

abstract class Compte {
    private Personne proprietaire;
    private long numero;
    private double solde;
    private static int compteur;
    private ArrayList<Transaction> historique;

    public Compte(Personne proprietaire, double solde) {
        compteur++;
        this.proprietaire = proprietaire;
        this.numero = compteur;
        this.solde = solde;
        this.historique = new ArrayList<>();

    }

    public Compte() {
        this.proprietaire = proprietaire;
        this.numero = numero;
        this.solde = solde;
        this.historique = new ArrayList<>();
    }

    public void virement(Compte destination, double montant) {
        this.solde -= montant;
        destination.solde += montant;
        this.historique.add(new Transaction(Transaction.TypesActions.VIREMENT, 50));
    }

    public void retirer(double montant) {
        if ((solde - montant) > 0) {
            double total = this.solde -= montant;
            this.solde = total;
            this.historique.add(new Transaction(Transaction.TypesActions.RETIRER, 100));
        } else {
            System.out.println("Solde insuffisant");
        }
    }

    public void crediter(double montant) {
        this.solde += montant;
        this.historique.add(new Transaction(Transaction.TypesActions.CREDITER, 200));
    }

    public void setProprietaire(Personne proprietaire) {
        this.proprietaire = proprietaire;
    }

    public void setNumero(long numero) {
        this.numero = numero;
    }

    public void setSolde(double solde) {
        double total = this.solde - solde;
        this.solde = solde;
        this.historique.add(new Transaction(Transaction.TypesActions.SOLDE, 200));
    }

    public Personne getProprietaire() {
        return this.proprietaire;
    }

    public long getNumero() {
        return this.numero;
    }

    public double getSolde() {
        return this.solde;
    }

    public ArrayList<Transaction> getHistorique() {
        return this.historique;
    }
}
