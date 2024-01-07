
public class Compte {
    private static int nbComptes = 0;
    private String code;
    protected double solde;
    protected Client proprietaire;
    protected Agence lAgence;

    public Compte(double solde, Client proprietaire, Agence lagence) {
        this.code = "Compte:" + (++nbComptes);
        this.solde = solde;
        this.setProprietaire(proprietaire);
        this.lAgence = lagence;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void deposer(double montant) {
        solde += montant;
    }

    public void retirer(double montant) {
        solde -= montant;
    }

    public double getSolde() {
        return solde;
    }
    @Override
    public String toString() {
        return "Compte [code=" + code + ", solde=" + solde + ", proprietaire=" + getProprietaire() + "]";
    }

	public Client getProprietaire() {
		return proprietaire;
	}

	public void setProprietaire(Client proprietaire) {
		this.proprietaire = proprietaire;
	}
}
