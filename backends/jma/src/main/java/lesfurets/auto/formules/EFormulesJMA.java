package lesfurets.auto.formules;

import lesfurets.backends.common.model.EFormules;
import lesfurets.funnel.ESite;

public enum EFormulesJMA implements EFormules {
    PREMIUM(1,"Offre Premium", false, "JMC", 200000.00, 100.00, true, true),
    STANDARD(3, "Offre Standard", false, "JMC", 50000.00, 1000.00, true, true),
    ECO_PLUS(5, "Offre Economique PLUS", true, "JMC", 50000.00, 1000.00, false, false),
    ECO_STANDARD(8, "Offre Economique PLUS", true, "JMC", 0.00, 0.00, false, false);

    private int code;
    private String label;
    private boolean tiersOnly;
    private String porteurDeRisque;
    private Double plafondDeRemboursement;
    private Double montantDeFranchise;
    private boolean assistanceAuVehicule;
    private boolean pretDeVehicule;

    EFormulesJMA(int code, String label, boolean tiersOnly, String porteurDeRisque, Double plafondDeRemboursement,
            Double montantDeFranchise, boolean assistanceAuVehicule, boolean pretDeVehicule) {
        this.code = code;
        this.label = label;
        this.tiersOnly = tiersOnly;
        this.porteurDeRisque = porteurDeRisque;
        this.plafondDeRemboursement = plafondDeRemboursement;
        this.montantDeFranchise = montantDeFranchise;
        this.assistanceAuVehicule = assistanceAuVehicule;
        this.pretDeVehicule = pretDeVehicule;
    }

    @Override
    public ESite getESite() {
        return ESite.JMA;
    }

    @Override
    public String getCodeAsString() {
        return String.valueOf(code);
    }
}
