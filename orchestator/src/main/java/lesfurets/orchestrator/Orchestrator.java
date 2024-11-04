package lesfurets.orchestrator;

import java.util.*;
import java.util.stream.Collectors;

import lesfurets.backends.BackendsRegistry;
import lesfurets.backends.common.model.*;
import lesfurets.backends.common.services.BackendService;
import lesfurets.exclusionfilters.ExclusionFiltersRegistry;
import lesfurets.formules.FormulesRegistry;
import lesfurets.funnel.Project;

public class Orchestrator {
    private static final Orchestrator INSTANCE = new Orchestrator();

    private Orchestrator(){};

    public static Orchestrator getInstance() {
        return INSTANCE;
    }

    public List<TarificationResponse> computeQuotation(Project projet) {
        List<Tarification> tarifications = new ArrayList<>();

        //Collecting All Active Formules
        List<EFormules> allFormules = FormulesRegistry.getRegisteredFormules();

        //Excluding all filtered Formules
        List<EFormules> unfilteredFormules = ExclusionFiltersRegistry.getUnfilteredFormules(projet,allFormules);

        //Completion of Tarifications List
        tarifications.addAll(unfilteredFormules.stream()
                                    .map(f -> new Tarification(f, f.getESite(), projet))
                                    .collect(Collectors.toList()));

        List<TarificationResponse> responses = tarifications.stream()
                .map(t -> doQuotation(t))
                .collect(Collectors.toList());

        return responses;
    }

    private TarificationResponse doQuotation(Tarification tarification) {
        BackendService backend =
                BackendsRegistry.getInstance().getBackendService(tarification.getPartner());
        return backend.doQuotation(tarification);
    }
}
