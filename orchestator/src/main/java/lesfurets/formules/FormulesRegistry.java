package lesfurets.formules;

import java.util.*;

import lesfurets.auto.formules.EFormulesJMA;
import lesfurets.backends.common.model.EFormules;

public class FormulesRegistry {
    private static final FormulesRegistry INSTANCE = new FormulesRegistry();

    private FormulesRegistry(){};

    public static FormulesRegistry getInstance() {
        return INSTANCE;
    }


    public static List<EFormules> getRegisteredFormules() {
        ArrayList<EFormules> allFormules = new ArrayList<>();
        allFormules.addAll(Arrays.asList(EFormulesJMA.values()));
        //Il est possible d'ajouter un autre backend ...
        return allFormules;
    };

}
