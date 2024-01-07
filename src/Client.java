
public class Client {
    private static final int MAX_COMPTES = 10;
	private static int nbClients = 0;
	private String code;
	private String nom;
	private String prenom;
	private String adresse;
	private Compte[] lesComptes;
	private Agence monAgence;

	public Client(String nom, String prenom, String adresse, Agence agence) {
		this.code = "Client:" + (++nbClients);
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.lesComptes = new Compte[MAX_COMPTES]; 
		this.monAgence = agence;
	}

	public Compte getCompte(int index) {
		return lesComptes[index];
	}

	public void addCompte(Compte compte) {
        lesComptes[getNbComptes()] = compte;
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
	@Override
    public String toString() {
        return "Client [code=" + code + ", nom=" + nom + ", prenom=" + prenom + ", adresse=" + adresse + "]";
    }

	public String getNom() {
		return nom;
	}

	public String getPrenom() {
		return prenom;
	}

	
}
