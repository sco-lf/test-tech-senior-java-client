package lesfurets.exclusionfilters;

import java.util.List;

import lesfurets.backends.common.model.EFormules;
import lesfurets.funnel.Project;

public class ExclusionFiltersRegistry {
    private static final ExclusionFiltersRegistry INSTANCE = new ExclusionFiltersRegistry();

    private ExclusionFiltersRegistry(){};

    public static ExclusionFiltersRegistry getInstance() {
        return INSTANCE;
    }

    /**
     * La méthode appellée par l'Orchestrator pour faire le tri parmi
     * les Formules, selon certaines caractéristiques du Project
     *
     * @param projet
     * @param formules
     * @return
     */
    public static List<EFormules> getUnfilteredFormules(Project projet, List<EFormules> formules) {
        //C'EST ICI QUE VOUS POURREZ CODER l'APPLICATION DES PREDICATES
        return formules;
    }
}
