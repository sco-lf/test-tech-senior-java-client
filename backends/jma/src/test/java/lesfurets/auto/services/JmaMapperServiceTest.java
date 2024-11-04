package lesfurets.auto.services;

import java.time.LocalDate;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

import lesfurets.auto.formules.EFormulesJMA;
import lesfurets.backends.common.model.Tarification;
import lesfurets.backends.common.services.MapperService;
import lesfurets.funnel.*;

public class JmaMapperServiceTest {
    private final MapperService mapperService = JmaMapperService.getInstance();
    private Tarification tarification;

    @Before
    public void setup() {
        Project project = new Project(
                "LeTest",
                "Pierre",
                LocalDate.parse("1996-03-24"),
                ECivilite.MR,
                EStatutProfessionnel.SALARIE,
                12343,
                LocalDate.parse("2013-06-12"),
                "14 avenue du test",
                "Bordeaux",
                "30072",
                "pierre.letest@lfmail.com",
                ETypeCouverture.TIERS,
                1.0);

        tarification = new Tarification(EFormulesJMA.PREMIUM, ESite.JMA, project);
    }

    @Test
    public void is_CHOMAGE_mapped_to_sans_activite(){
        tarification.getProjet().setStatutProfessionnel(EStatutProfessionnel.CHOMAGE);
        Assertions.assertThat(mapperService.mappingTarificationIn(tarification)).contains("\"profession\":\"sans_activite\"");
    }

    @Test
    public void is_ETUDIANT_mapped_to_sans_activite(){
        tarification.getProjet().setStatutProfessionnel(EStatutProfessionnel.ETUDIANT);
        Assertions.assertThat(mapperService.mappingTarificationIn(tarification)).contains("\"profession\":\"sans_activite\"");
    }

    @Test
    public void is_SALARIE_mapped_to_sans_activite(){
        tarification.getProjet().setStatutProfessionnel(EStatutProfessionnel.SALARIE);
        Assertions.assertThat(mapperService.mappingTarificationIn(tarification)).contains("\"profession\":\"en_activite\"");
    }

    @Test
    public void is_ARTISAN_mapped_to_sans_activite(){
        tarification.getProjet().setStatutProfessionnel(EStatutProfessionnel.ARTISAN);
        Assertions.assertThat(mapperService.mappingTarificationIn(tarification)).contains("\"profession\":\"en_activite\"");
    }

    @Test
    public void is_INDEP_mapped_to_sans_activite(){
        tarification.getProjet().setStatutProfessionnel(EStatutProfessionnel.INDEP);
        Assertions.assertThat(mapperService.mappingTarificationIn(tarification)).contains("\"profession\":\"inconnu\"");
    }
}