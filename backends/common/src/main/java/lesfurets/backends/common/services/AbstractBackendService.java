package lesfurets.backends.common.services;

import lesfurets.backends.common.model.*;

public abstract class AbstractBackendService implements BackendService {

    private MapperService mapperService;

    @Override
    public TarificationResponse doQuotation(Tarification tarification) {
        return null;
    }
}