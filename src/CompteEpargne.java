
public class CompteEpargne extends Compte {
    private double taux;

    public CompteEpargne(double solde, Client proprietaire, Agence agence) {
        super(solde, proprietaire, agence);
        this.taux = 6;
    }

    public double getTaux() {
        return taux;
    }

    public void setTaux(double taux) {
        this.taux = taux;
    }

    public void calculInteret() {
        double interet = getSolde() * (taux / 100);
        deposer(interet);
    }
    @Override
    public String toString() {
        return "CompteEpargne [code=" + getCode() + ", solde=" + getSolde() + ", proprietaire=" + getProprietaire() + ", taux=" + taux + "]";
    }
}
