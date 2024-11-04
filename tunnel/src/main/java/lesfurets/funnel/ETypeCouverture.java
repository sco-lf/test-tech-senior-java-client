package lesfurets.funnel;

/**
 * Classe représentant les type de couverture d'assurance
 * <p>
 * Cette classe fournit 3 type de couvertures
 * </p>
 * */
public enum ETypeCouverture {
    TOUTRISQUE("Tout risque"),
    TIERS("Au tiers"),
    VOL_INCENDIE("Vol & Incendie");

    /** L'intitulé du niveau de garantie de la formule d'assurance
     * Au tiers : couvre les dégâts infligés
     * Tous risques : couvre les dégâts causés aussi bien que subits
     * Vol et Incendie : une formule au Tiers ocurant également contre le vol et l'incendie*/
    private String intitulé;

    ETypeCouverture(String intitulé) {
        this.intitulé = intitulé;
    }
}
