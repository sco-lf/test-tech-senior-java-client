package lesfurets.auto.model;

public class Vehicule {
    private int vehiculeSRA;
    private int ageVehicule;

    public Vehicule(int vehiculeSRA, int ageVehicule) {
        this.vehiculeSRA = vehiculeSRA;
        this.ageVehicule = ageVehicule;
    }

    public int getVehiculeSRA() {
        return vehiculeSRA;
    }

    public int getAgeVehicule() {
        return ageVehicule;
    }
}
