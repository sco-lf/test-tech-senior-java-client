package lesfurets.backends.common.model;

import lesfurets.funnel.ESite;
import lesfurets.funnel.Project;

/**
 * Classe décrivant une tarification (en tant que Thread de l'orchestrateur), et liant formule,
 * partenaire et projet (données du formulaire Lesfurets
 */
public class Tarification {
    private EFormules formule;
    private ESite partner;
    private Project projet;

    public Tarification(EFormules formule, ESite partner, Project projet) {
        this.formule = formule;
        this.partner = partner;
        this.projet = projet;
    }

    public EFormules getFormule() {
        return formule;
    }

    public ESite getPartner() {
        return partner;
    }

    public Project getProjet() {
        return projet;
    }
}
