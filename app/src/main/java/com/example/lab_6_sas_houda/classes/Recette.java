package com.example.lab_6_sas_houda.classes;


public class Recette {
    private static long AUTO_ID = 1;

    private long id;
    private String titre;
    private double tarif;
    private int photoRes;
    private String tempsPrep;
    private String composition;
    private String resume;
    private String preparation;

    public Recette() {
        this.id = AUTO_ID++;
    }

    public Recette(String titre, double tarif, int photoRes, String tempsPrep,
                   String composition, String resume, String preparation) {
        this.id = AUTO_ID++;
        this.titre = titre;
        this.tarif = tarif;
        this.photoRes = photoRes;
        this.tempsPrep = tempsPrep;
        this.composition = composition;
        this.resume = resume;
        this.preparation = preparation;
    }

    public long getId() { return id; }
    public String getTitre() { return titre; }
    public void setTitre(String titre) { this.titre = titre; }
    public double getTarif() { return tarif; }
    public void setTarif(double tarif) { this.tarif = tarif; }
    public int getPhotoRes() { return photoRes; }
    public void setPhotoRes(int photoRes) { this.photoRes = photoRes; }
    public String getTempsPrep() { return tempsPrep; }
    public void setTempsPrep(String tempsPrep) { this.tempsPrep = tempsPrep; }
    public String getComposition() { return composition; }
    public void setComposition(String composition) { this.composition = composition; }
    public String getResume() { return resume; }
    public void setResume(String resume) { this.resume = resume; }
    public String getPreparation() { return preparation; }
    public void setPreparation(String preparation) { this.preparation = preparation; }

    @Override
    public String toString() {
        return titre + " - " + tarif + " €";
    }
}