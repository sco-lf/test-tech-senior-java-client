package lesfurets.backends.common.services;

import lesfurets.backends.common.model.*;

public abstract class AbstractMapperService implements MapperService {

    public String mappingTarificationIn(Tarification tarification){
        return null;
    }

    public TarificationResponse mappingTarificationOut(String responseJson) {
        return null;
    }
}
