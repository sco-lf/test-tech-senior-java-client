package lesfurets.backends;

import lesfurets.auto.services.JmaBackendService;
import lesfurets.backends.common.services.BackendService;
import lesfurets.funnel.ESite;

public class BackendsRegistry {
    private static final BackendsRegistry INSTANCE = new BackendsRegistry();

    private BackendsRegistry(){};

    public static BackendsRegistry getInstance() {
        return INSTANCE;
    }

    public BackendService getBackendService(ESite partner) {
        switch (partner) {
            case JMA :
                return JmaBackendService.getInstance();
            default :
                return null;
        }
    };
}
