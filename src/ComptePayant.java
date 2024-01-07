
public class ComptePayant extends Compte {
    private static final double TAUX_OPERATION = 5;

    public ComptePayant(double solde, Client proprietaire, Agence agence) {
        super(solde, proprietaire, agence);
    }

    @Override
    public void deposer(double montant) {
        super.deposer(montant - TAUX_OPERATION);
    }

    @Override
    public void retirer(double montant) {
        super.retirer(montant + TAUX_OPERATION);
    }
    @Override
    public String toString() {
        return "ComptePayant [code=" + getCode() + ", solde=" + getSolde() + ", proprietaire=" + proprietaire + "]";
    }
}
