package lesfurets.funnel;

/**
 * Classe représentant des catégories socio-professionnelles
 * <p>
 * */
public enum EStatutProfessionnel {
    SALARIE("Salarié"),
    INDEP("Travailleur indépendant"),
    ARTISAN("Artisan"),
    CHOMAGE("Sans emploi"),
    ETUDIANT("Etudiant");

    /** l'intitulé de la catégorie Pro */
    private String libelle;

    EStatutProfessionnel(String libelle) {
        this.libelle = libelle;
    }
}
