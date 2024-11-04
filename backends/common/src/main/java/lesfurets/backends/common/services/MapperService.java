package lesfurets.backends.common.services;

import lesfurets.backends.common.model.*;

public interface MapperService {

    String mappingTarificationIn(Tarification tarification);

    TarificationResponse mappingTarificationOut(String responseJson) ;
}
