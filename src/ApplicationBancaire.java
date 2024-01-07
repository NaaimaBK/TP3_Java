
public class ApplicationBancaire {
	public static void main(String[] args) {
		// a) Créer une seule agence bancaire.
		Agence agenceBancaire = new Agence("Adresse de l'agence");

		// b) Créer des clients avec différents types de comptes.
		Client[] clients = new Client[4];

		clients[0] = new Client("Nom1", "Prenom1", "Adresse1", agenceBancaire);
		clients[0].addCompte(new CompteEpargne(1000, clients[0], agenceBancaire));

		clients[1] = new Client("Nom2", "Prenom2", "Adresse2", agenceBancaire);
		clients[1].addCompte(new ComptePayant(2500, clients[1], agenceBancaire));

		clients[2] = new Client("Nom3", "Prenom3", "Adresse3", agenceBancaire);
		clients[2].addCompte(new ComptePayant(0, clients[2], agenceBancaire));
		clients[2].addCompte(new ComptePayant(3000, clients[2], agenceBancaire));

		clients[3] = new Client("Nom4", "Prenom4", "Adresse4", agenceBancaire);
		clients[3].addCompte(new CompteEpargne(2300, clients[3], agenceBancaire));
		clients[3].addCompte(new ComptePayant(0, clients[3], agenceBancaire));

		// e) Ajouter tous les clients à l'agence
		for (Client client : clients) {
			agenceBancaire.addClient(client);
		}

		// c) Déposer une somme quelconque dans le compte d'un client
		clients[0].getCompte(0).deposer(500);

		// d) Retirer une somme quelconque dans le compte d'un client
		clients[1].getCompte(0).retirer(100);

		// f) Appliquer la méthode CalculIntérêt sur tous les comptes d'épargne de
		// l'agence
		for (Client client : agenceBancaire.getClients()) {
		    if (client != null && client.getComptes() != null) {
		        for (Compte compte : client.getComptes()) {
		            if (compte instanceof CompteEpargne) {
		                ((CompteEpargne) compte).calculInteret();
		            }
		        }
		    }
		}

		// g) Afficher les informations
		System.out.println("Liste des clients avec leurs comptes :");
		for (Client client : agenceBancaire.getClients()) {
            System.out.println(client);
            if (client.getComptes() != null) {
                for (Compte compte : client.getComptes()) {
                    System.out.println("  " + compte);
                }
            }
        }

		System.out.println("\nListe des comptes d'épargne de l'agence :");
		for (Compte compte : agenceBancaire.getComptes()) {
			if (compte instanceof CompteEpargne) {
				System.out.println(compte);
			}
		}

		System.out.println("\nListe des comptes payants de l'agence :");
		for (Compte compte : agenceBancaire.getComptes()) {
			if (compte instanceof ComptePayant) {
				System.out.println(compte);
			}
		}

		System.out.println("\nSolde total des comptes d'un client :");
		for (Client client : agenceBancaire.getClients()) {
			double soldeTotal = 0;
			for (Compte compte : client.getComptes()) {
				soldeTotal += compte.getSolde();
			}
			System.out.println(client.getNom() + " " + client.getPrenom() + ": " + soldeTotal + "dh");
		}

		System.out.println("\nClassement des clients selon le solde total :");
		for (Client client : agenceBancaire.getClients()) {
			double soldeTotal = 0;
			for (Compte compte : client.getComptes()) {
				soldeTotal += compte.getSolde();
			}
			System.out.println(client.getNom() + " " + client.getPrenom() + ": " + soldeTotal + "dh");
		}
	}
}