package lesfurets.auto.services;

import lesfurets.backends.common.model.*;
import lesfurets.backends.common.services.AbstractBackendService;

public class JmaBackendService extends AbstractBackendService {

    private static final JmaBackendService INSTANCE = new JmaBackendService();

    private JmaMapperService mapper = JmaMapperService.getInstance();

    private final String TARIFICATION_URL = "http://api.jma-services/webapi/tarification";

    private JmaBackendService(){};

    public static JmaBackendService getInstance() {
        return INSTANCE;
    }

    @Override
    public TarificationResponse doQuotation(Tarification tarification) {
        String payload = mapper.mappingTarificationIn(tarification);
        TarificationResponse response = sendToJMARestAPI(payload);
        if(response.getReturnCode() == 200){
            return mapper.mappingTarificationOut(response.getPayload());
        } else {
            //We don't manage http errors here cause it's a simplified version of the application
            return null;
        }
    }

    /**
     * Cette méthode doit coder la connexion réelle au WebSerice Rest du partenaire.
     * Pour les besoins de ce test technique, nous ne pousserons pas plus loin cette connexion réelle.
     *
     **************************************************************************
     * NE DOIT PAS ETE MODIFIEE. REMPLACE L'APPEL REEL AU FLUX DU PARTENAIRE **
     **************************************************************************
     *
     * @param payload : le body JSON a envoyer au service du partenaire
     * @return un objet TarificationResponse, contenant le code et le texte de la reponse Http du service partenaire
     */
    private TarificationResponse sendToJMARestAPI(String payload) {
        return new TarificationResponse(200, "The real Web Service cannot be reach through this Technical Test. Try to use unit tests ?");
    }
}