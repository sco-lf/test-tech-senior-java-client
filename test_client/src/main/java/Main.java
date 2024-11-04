import java.time.LocalDate;
import java.util.List;
import lesfurets.backends.common.model.TarificationResponse;
import lesfurets.funnel.*;
import lesfurets.orchestrator.Orchestrator;

public class Main {
    public static void main(String[] args) {

        //Le service d'Orchestration est instancié
        Orchestrator orchestator = Orchestrator.getInstance();

        //Le projet est instancié. Il est normalement constitué par notre Formulaire d'Assurance auto
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

        //L'orchestrateur est utilisé pour interroger les Web Services de tarification de tous les partenaires pour toutes les
        // formules d'assurance elligibles. Il collecte le tout dans une liste d'objets TarificationResponse;
        List<TarificationResponse> response =
                orchestator.computeQuotation(project);


        //Vous devriez remarquer que l'execution de ce Main bloque, car le Web Service réel n'est pas correctement connecté
        // Peut être faut-il se baser davantage sur des tests ?
        System.out.println("Nombre de reponses :" + response.size());
        response.forEach(t -> {
                System.out.println("Code :" + t.getReturnCode());
                System.out.println("Payload :" + t.getPayload());
                System.out.println("Prime :" + t.getPrime().toString());
                }
        );

    }
}
