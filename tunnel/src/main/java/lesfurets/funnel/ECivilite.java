package lesfurets.funnel;

/**
 * Classe représentant les type de couverture d'assurance
 * <p>
 * Cette classe fournit 3 type de couvertures
 * </p>
 * */
public enum ECivilite {
    MR("Monsieur","M."),
    MME("Madame","Mme"),
    MLLE("Mademoiselle","Melle");

    private String intituléLong;
    private String intituléCourt;

    ECivilite(String intituléLong, String intituléCourt) {
        this.intituléLong = intituléLong;
        this.intituléCourt = intituléCourt;
    }
}
