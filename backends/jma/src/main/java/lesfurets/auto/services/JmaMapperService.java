package lesfurets.auto.services;

import java.time.LocalDate;
import java.time.Period;

import com.google.gson.Gson;

import lesfurets.auto.model.*;
import lesfurets.backends.common.model.*;
import lesfurets.backends.common.services.AbstractMapperService;
import lesfurets.funnel.*;

public class JmaMapperService extends AbstractMapperService {

    private static final JmaMapperService INSTANCE = new JmaMapperService();

    private JmaMapperService(){};

    public static JmaMapperService getInstance() {
        return INSTANCE;
    }

    @Override
    public String mappingTarificationIn(Tarification tarification) {
        Project projet = tarification.getProjet();

        //on mappe l'age
        int age = Period.between(projet.getDateDeNaissance(), LocalDate.now()).getYears();

        //On mappe la profession
        String profession;
        EStatutProfessionnel proStatus = projet.getStatutProfessionnel();
        switch(proStatus) {
            case CHOMAGE, ETUDIANT : profession = "sans_activite";break;
            case SALARIE, ARTISAN : profession = "en_activite";break;
            default: profession = "inconnu";
        }

        //On cast le code Postal :
        int codePostal = Integer.parseInt(projet.getCodePostal());

        //on mappe le souscripteur
        Souscripteur souscripteur = new Souscripteur(age, profession, codePostal, projet.getBonus());

        //on mappe l'age du vehicule
        int ageVehicule = Period.between(projet.getDateMiseEnCirculation(), LocalDate.now()).getYears();

        //on mappe le vehicule
        Vehicule vehicule = new Vehicule(projet.getInSRA(), ageVehicule);

        //on mappe la couverture
        String couverture;
        ETypeCouverture couvertureType = projet.getTypeCouverture();
        switch(couvertureType) {
            case TIERS : couverture = "tout_risque";break;
            case TOUTRISQUE, VOL_INCENDIE : couverture = "eco";break;
            default: couverture = "eco";
        }

        String idFormule = tarification.getFormule().getCodeAsString();

        Demande demande = new Demande(souscripteur, vehicule, couverture, idFormule);
        Gson gson = new Gson();
        String jsonString = gson.toJson(demande);

        return jsonString;
    }

    @Override
    public TarificationResponse mappingTarificationOut(String responseJson) {
        // Convert json Output of partner's Service in TarifList Object
        Gson gson = new Gson();
        TarifList tarifList = gson.fromJson(responseJson, TarifList.class);

        TarificationResponse tarificationResponse = new TarificationResponse(tarifList.getCode(), tarifList.getMessage());

        //if service response is OK, parsing Prime and store in TarificationResponse
        if(tarifList.getCode() == 200) {
            Prime prime = gson.fromJson(responseJson, Prime.class);
            tarificationResponse.setPrime(prime);
        }

        return tarificationResponse;
    }
}