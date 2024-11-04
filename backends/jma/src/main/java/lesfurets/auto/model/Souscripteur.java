package lesfurets.auto.model;

public class Souscripteur {
    private int age;
    private String profession;
    private int codePostal;
    private Double bonus;

    public Souscripteur(int age, String profession, int codePostal, Double bonus) {
        this.age = age;
        this.profession = profession;
        this.codePostal = codePostal;
        this.bonus = bonus;
    }

    public int getAge() {
        return age;
    }

    public String getProfession() {
        return profession;
    }

    public int getCodePostal() {
        return codePostal;
    }

    public Double getBonus() {
        return bonus;
    }
}
