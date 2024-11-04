package lesfurets.backends.common.services;

import lesfurets.backends.common.model.*;

public interface BackendService {
    TarificationResponse doQuotation(Tarification tarification);
}
