package lesfurets.auto.model;

public class Demande {
    private final Souscripteur souscripteur;
    private final Vehicule vehicule;
    private final String couverture;
    private final String idFormule;

    public Demande(Souscripteur souscripteur, Vehicule vehicule, String couverture, String idFormule) {
        this.souscripteur = souscripteur;
        this.vehicule = vehicule;
        this.couverture = couverture;
        this.idFormule = idFormule;
    }

    public Souscripteur getSouscripteur() {
        return souscripteur;
    }

    public Vehicule getVehicule() {
        return vehicule;
    }

    public String getCouverture() {
        return couverture;
    }

    public String getIdFormule() {
        return idFormule;
    }
}
