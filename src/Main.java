import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

//    Personne personne = new Personne();
//    personne.setPrenom("Martin");
//    personne.setNom("Dupont");
//    personne.setEtatCivil(Personne.Civil.CELIBATAIRE);
//    System.out.println(personne.toString());
//
//    CompteEpargne compteEpargne = new CompteEpargne(50);
//    compteEpargne.setProprietaire(personne);
//    compteEpargne.setSolde(1000.0);
//    compteEpargne.setInteret(0.02);
//
//    CompteCourant compteCourant = new CompteCourant(10);
//    compteCourant.setProprietaire(personne);
//    compteCourant.setSolde(1000.0);
//    compteCourant.setDecouvert(200.0);
//
//    CompteCourant personne_1 = new CompteCourant(500);
//
//    compteCourant.crediter(400);
//    compteCourant.virement(personne_1, 600);
//    compteCourant.retirer(10);
//
//    System.out.println(compteCourant.getHistorique());
//    System.out.println("Nouveau montant du Compte Courant :" + compteCourant.getSolde());

        Scanner scanner = new Scanner(System.in);
        try {
            createAccount(scanner);
        } finally {
            scanner.close();
        }
        System.out.println("Fin du programme.");

    }

    private static void createAccount(Scanner scanner) {
        System.out.println("Voulez vous vous créer un compte ? y/n");
        String createAccount = scanner.next();

        if (createAccount.equalsIgnoreCase("y")) {
            System.out.println("Quel est votre prénom ?");
            String firstname = scanner.next();

            System.out.println("Quel est votre nom ?");
            String lastname = scanner.next();

            Personne personne = new Personne();
            personne.setPrenom(firstname);
            personne.setNom(lastname);

            System.out.println("Quel type de compte voulez vous créer ? Courant/Epargne");
            String compteType = scanner.next();

            System.out.println("Combien de solde voulez vous ajouter ?");
            int solde = Integer.parseInt(scanner.next());

            if (compteType.equalsIgnoreCase("courant")) {
                CompteCourant compteCourant = new CompteCourant(100);
                compteCourant.setProprietaire(personne);
                compteCourant.setSolde(solde);

                System.out.println("Voulez vpus faire un virement ? y/n");
                String virement = scanner.next();

                if (virement == "y") {
                    System.out.println("à qui ?");
                    String virementCompte = scanner.next();
                }

            } else if (compteType.equalsIgnoreCase("epargne")) {
                CompteEpargne compteEpargne = new CompteEpargne(50);
                compteEpargne.setProprietaire(personne);
                compteEpargne.setSolde(solde);
            } else {
                System.out.println("Type de compte inconnu.");
            }
        }
    }
}