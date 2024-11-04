package lesfurets.exclusionfilters;

import java.time.*;
import java.util.function.Predicate;

import lesfurets.funnel.EStatutProfessionnel;
import lesfurets.funnel.Project;

public enum EExclusion {
    AGE_SUPERIEUR_A_70(projet -> {
        if (projet.getDateDeNaissance() == null) return false;
        int age = Period.between(projet.getDateDeNaissance(), LocalDate.now()).getYears();
        return age > 70;
    }),
    VEHICULE_DEPLUS_DE_10ANS(projet -> {
        if (projet.getDateMiseEnCirculation() == null) return false;
        int age = Period.between(projet.getDateMiseEnCirculation(), LocalDate.now()).getYears();
        return age > 10;
    }),
    SANS_ACTIVITE_PROFESSIONELLE(projet -> {
        return (projet.getStatutProfessionnel().equals(EStatutProfessionnel.CHOMAGE) || projet.getStatutProfessionnel().equals(EStatutProfessionnel.ETUDIANT));
    });

    private final Predicate<Project> predicate;

    EExclusion(Predicate<Project> predicate) {
        this.predicate = predicate;
    }
}
