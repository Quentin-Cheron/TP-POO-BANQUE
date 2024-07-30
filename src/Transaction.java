public class Transaction {
    private TypesActions actions;
    private double montant;

    public Transaction(TypesActions actions, double montant) {
       this.actions = actions;
       this.montant = montant;
    }

    public String toString() {
        return "MyClass{montant=" + montant + " type=" + actions + "}";
    }

    enum TypesActions {
        VIREMENT,
        CREDITER,
        RETIRER,
        SOLDE
    }
}
