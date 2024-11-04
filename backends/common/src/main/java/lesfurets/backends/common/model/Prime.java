package lesfurets.backends.common.model;

/**
* Classe utilisée pour stocker les tarifs (primes) récupérés du Web Service partenaire
 */
public class Prime {
    private final boolean isMensuelOnly;
    private final Double primeMois;
    private final Double primeAnnee;
    private final String formuleCode;

    public Prime(boolean isMensuelOnly, Double primeMois, Double primeAnnee, String formuleCode) {
        this.isMensuelOnly = isMensuelOnly;
        this.primeMois = primeMois;
        this.primeAnnee = primeAnnee;
        this.formuleCode = formuleCode;
    }

    public boolean isMensuelOnly() {
        return isMensuelOnly;
    }

    public Double getPrimeMois() {
        return primeMois;
    }

    public Double getPrimeAnnee() {
        return primeAnnee;
    }

    public String getFormuleCode() {
        return formuleCode;
    }

    @Override
    public String toString() {
        return "Prime{" +
                "isMensuelOnly=" + isMensuelOnly +
                ", primeMois=" + primeMois +
                ", primeAnnee=" + primeAnnee +
                ", formuleCode='" + formuleCode + '\'' +
                '}';
    }
}
