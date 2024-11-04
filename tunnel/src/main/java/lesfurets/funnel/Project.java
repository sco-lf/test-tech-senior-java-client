package lesfurets.funnel;

import java.time.LocalDate;

/**
 * Classe représentant un formulaire LesFurets duement rempli
 * <p>
 * Celle-ci stocke toutes les réponses aux questions au formulaire :
 * INFORMATIONS PERSONNELLES :
 * Quel est votre nom ? (champs Texte)
 * Quel est votre prénom ? (champs Texte)
 * Quel est votre date de naissance ? (champs DatePicker)
 * Civilité : (champs Liste déroulante)
 *
 * PROFESSION
 * Quelle est votre profession ? (champs Liste déroulante)
 *
 * VEHICULE
 * Quel vehicule souhaitez vous assurer ? (Champs Vehiculier = selection via mini-formulaire en popup)
 *
 * COORDONNEES
 * Veuillez saisir votre adresse (Champs texte Auto-complété et validé)
 *
 * TYPE D'ASSURANCE:
 * Quel type d'assurance cherchez-vous ? (champs Liste déroulante)
 * Quest est votre niveau de Bonus ? (champs Liste déroulante)
 * </p>
 * */
public class Project {

    private String nom;
    private String prenom;
    private LocalDate dateDeNaissance;
    private ECivilite civilite;

    private EStatutProfessionnel statutProfessionnel;

    private int inSRA;
    private LocalDate dateMiseEnCirculation;

    private String adresse;
    private String Commune;
    private String codePostal;
    private String mail;

    private ETypeCouverture typeCouverture;
    private double bonus;


    public Project(String nom, String prenom, LocalDate dateDeNaissance, ECivilite civilite,
            EStatutProfessionnel statutProfessionnel, int inSRA,
            LocalDate dateMiseEnCirculation, String adresse,
            String commune, String codePostal, String mail, ETypeCouverture typeCouverture, double bonus) {
        this.nom = nom;
        this.prenom = prenom;
        this.dateDeNaissance = dateDeNaissance;
        this.civilite = civilite;
        this.statutProfessionnel = statutProfessionnel;
        this.inSRA = inSRA;
        this.dateMiseEnCirculation = dateMiseEnCirculation;
        this.adresse = adresse;
        Commune = commune;
        this.codePostal = codePostal;
        this.mail = mail;
        this.typeCouverture = typeCouverture;
        this.bonus = bonus;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public LocalDate getDateDeNaissance() {
        return dateDeNaissance;
    }

    public ECivilite getCivilite() {
        return civilite;
    }

    public EStatutProfessionnel getStatutProfessionnel() {
        return statutProfessionnel;
    }

    public int getInSRA() {
        return inSRA;
    }

    public LocalDate getDateMiseEnCirculation() {
        return dateMiseEnCirculation;
    }

    public String getAdresse() {
        return adresse;
    }

    public String getCommune() {
        return Commune;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public String getMail() {
        return mail;
    }

    public ETypeCouverture getTypeCouverture() {
        return typeCouverture;
    }

    public double getBonus() {
        return bonus;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setDateDeNaissance(LocalDate dateDeNaissance) {
        this.dateDeNaissance = dateDeNaissance;
    }

    public void setCivilite(ECivilite civilite) {
        this.civilite = civilite;
    }

    public void setStatutProfessionnel(EStatutProfessionnel statutProfessionnel) {
        this.statutProfessionnel = statutProfessionnel;
    }

    public void setInSRA(int inSRA) {
        this.inSRA = inSRA;
    }

    public void setDateMiseEnCirculation(LocalDate dateMiseEnCirculation) {
        this.dateMiseEnCirculation = dateMiseEnCirculation;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setCommune(String commune) {
        Commune = commune;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setTypeCouverture(ETypeCouverture typeCouverture) {
        this.typeCouverture = typeCouverture;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }
}
