import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<Compte> comptes = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            boolean continueProgram = true;
            while (continueProgram) {
                System.out.println("Voulez-vous créer un nouveau compte ou gérer un compte existant ? (nouveau/gérer/fin)");
                String choice = scanner.next();
                if (choice.equalsIgnoreCase("nouveau")) {
                    createAccount(scanner);
                } else if (choice.equalsIgnoreCase("gérer")) {
                    manageExistingAccount(scanner);
                } else if (choice.equalsIgnoreCase("fin")) {
                    continueProgram = false;
                } else {
                    System.out.println("Choix invalide.");
                }
            }
        } finally {
            scanner.close();
        }
        System.out.println("Fin du programme.");
    }

    private static void createAccount(Scanner scanner) {
        System.out.println("Quel est votre prénom ?");
        String firstname = scanner.next();

        System.out.println("Quel est votre nom ?");
        String lastname = scanner.next();

        Personne personne = new Personne();
        personne.setPrenom(firstname);
        personne.setNom(lastname);

        System.out.println("Quel type de compte voulez-vous créer ? Courant/Epargne");
        String compteType = scanner.next();

        System.out.println("Combien de solde voulez-vous ajouter ?");
        double solde = Double.parseDouble(scanner.next());

        if (compteType.equalsIgnoreCase("courant")) {
            CompteCourant compteCourant = new CompteCourant(100);
            compteCourant.setProprietaire(personne);
            compteCourant.setSolde(solde);
            comptes.add(compteCourant);
            manageAccount(scanner, compteCourant);
        } else if (compteType.equalsIgnoreCase("epargne")) {
            CompteEpargne compteEpargne = new CompteEpargne(0.02);
            compteEpargne.setProprietaire(personne);
            compteEpargne.setSolde(solde);
            comptes.add(compteEpargne);
            manageAccount(scanner, compteEpargne);
        } else {
            System.out.println("Type de compte inconnu.");
        }
    }

    private static void manageExistingAccount(Scanner scanner) {
        System.out.println("Liste des comptes disponibles :");
        for (int i = 0; i < comptes.size(); i++) {
            System.out.println(i + ". " + comptes.get(i).getProprietaire().getPrenom() + " " + comptes.get(i).getProprietaire().getNom() + " (" + (comptes.get(i) instanceof CompteCourant ? "Courant" : "Epargne") + ")");
        }
        System.out.println("Sélectionnez le compte à gérer :");
        int compteIndex = scanner.nextInt();
        if (compteIndex >= 0 && compteIndex < comptes.size()) {
            manageAccount(scanner, comptes.get(compteIndex));
        } else {
            System.out.println("Compte invalide.");
        }
    }

    private static void manageAccount(Scanner scanner, Compte compte) {
        boolean manage = true;
        while (manage) {
            System.out.println("Choisissez une opération : 1. Virement 2. Créditer 3. Retirer 4. Quitter");
            int operation = scanner.nextInt();

            switch (operation) {
                case 1:
                    System.out.println("Liste des comptes disponibles pour virement :");
                    for (int i = 0; i < comptes.size(); i++) {
                        if (comptes.get(i) != compte) {
                            System.out.println(i + ". " + comptes.get(i).getProprietaire().getPrenom() + " " + comptes.get(i).getProprietaire().getNom());
                        }
                    }
                    System.out.println("Sélectionnez le compte destinataire :");
                    int destIndex = scanner.nextInt();
                    if (destIndex >= 0 && destIndex < comptes.size() && comptes.get(destIndex) != compte) {
                        Compte destCompte = comptes.get(destIndex);
                        System.out.println("Montant du virement ?");
                        double montantVirement = Double.parseDouble(scanner.next());
                        compte.virement(destCompte, montantVirement);
                    } else {
                        System.out.println("Compte destinataire invalide.");
                    }
                    break;

                case 2:
                    System.out.println("Montant à créditer ?");
                    double montantCredit = Double.parseDouble(scanner.next());
                    compte.crediter(montantCredit);
                    break;

                case 3:
                    System.out.println("Montant à retirer ?");
                    double montantRetrait = Double.parseDouble(scanner.next());
                    compte.retirer(montantRetrait);
                    break;

                case 4:
                    manage = false;
                    break;

                default:
                    System.out.println("Opération inconnue.");
                    break;
            }

            System.out.println("Nouveau solde du compte : " + compte.getSolde());
        }
    }
}
