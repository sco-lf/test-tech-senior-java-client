package lesfurets.exclusionfilters;

import lesfurets.auto.formules.EFormulesJMA;
import lesfurets.backends.common.model.EFormules;
import lesfurets.funnel.ESite;

public enum EExclusionFilter {
    JMA_ECOPLUS_IS_SENIOR(ESite.JMA, EFormulesJMA.ECO_PLUS, EExclusion.AGE_SUPERIEUR_A_70),
    JMA_ECO_IS_SENIOR(ESite.JMA, EFormulesJMA.ECO_STANDARD, EExclusion.AGE_SUPERIEUR_A_70),
    JMA_ECOPLUS_OLD_VEHICULE(ESite.JMA, EFormulesJMA.ECO_PLUS, EExclusion.VEHICULE_DEPLUS_DE_10ANS),
    JMA_ECO_OLD_VEHICULE(ESite.JMA, EFormulesJMA.ECO_STANDARD, EExclusion.VEHICULE_DEPLUS_DE_10ANS),
    JMA_PREMIUM_SANS_ACTIVITE(ESite.JMA, EFormulesJMA.PREMIUM, EExclusion.SANS_ACTIVITE_PROFESSIONELLE);

    private ESite partner;
    private EFormules formule;
    private final EExclusion exclusion;

    EExclusionFilter(ESite partner, EFormules formule, EExclusion exclusion) {
        this.partner = partner;
        this.formule = formule;
        this.exclusion = exclusion;
    }
}
