
public class Agence {
	private static final int MAX_CLIENTS = 100;
    private static final int MAX_COMPTES = 100;
	private static int nbAgences = 0;
	private String numero;
	private String adresse;
	private Client[] lesClients;
	private Compte[] lesComptes;
	private int nbClients;
	private int nbComptes;

	public Agence(String adresse) {
		this.numero = "Agence:" + (++nbAgences);
		this.adresse = adresse;
		this.lesClients = new Client[MAX_CLIENTS];
        this.lesComptes = new Compte[MAX_COMPTES];
		this.nbClients = 0;
		this.nbComptes = 0;
	}

	public Compte getCompte(int index) {
		return lesComptes[index];
	}

	public Client getClient(int index) {
		return lesClients[index];
	}

	public void addCompte(double solde, Client proprietaire) {
        if (nbComptes < MAX_COMPTES) {
            Compte compte = new Compte(solde, proprietaire, this);
            lesComptes[nbComptes++] = compte;
            proprietaire.addCompte(compte);
        }
    }

	public void addClient(Client client) {
        if (nbClients < MAX_CLIENTS) {
            lesClients[nbClients++] = client;
        }
    }
	public int getNbClients() {
	    int count = 0;
	    for (Client client : lesClients) {
	        if (client != null) {
	            count++;
	        }
	    }
	    return count;
	}
	public int getNbComptes() {
	    int count = 0;
	    for (Compte compte : lesComptes) {
	        if (compte != null) {
	            count++;
	        }
	    }
	    return count;
	}
	public Compte[] getComptes() {
        return lesComptes;
    }

    public Client[] getClients() {
        return lesClients;
    }
	//ToString
	@Override
    public String toString() {
        return "Agence [numero=" + numero + ", adresse=" + adresse + "]";
    }

}