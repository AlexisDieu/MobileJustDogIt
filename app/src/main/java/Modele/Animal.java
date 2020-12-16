package Modele;

import java.util.Arrays;
import java.util.Date;

public class Animal {
    private int id ;
    private String typeAnimal ;
    private String photo ;
    private String dateNaissance ;
    private String race ;
    private String couleur ;
    private String nom ;
    private Boolean reserve ;

    public Animal(int id, String typeAnimal, String photo, String dateNaissance, String race, String couleur, String nom, Boolean reserve) {
        this.id = id;
        this.typeAnimal = typeAnimal;
        this.photo = photo;
        this.dateNaissance = dateNaissance;
        this.race = race;
        this.couleur = couleur;
        this.nom = nom;
        this.reserve = reserve;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTypeAnimal() {
        return typeAnimal;
    }

    public void setTypeAnimal(String typeAnimal) {
        this.typeAnimal = typeAnimal;
    }

     public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(String dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getCouleur() {
        return couleur;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Boolean getReserve() {
        return reserve;
    }

    public void setReserve(Boolean reserve) {
        this.reserve = reserve;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "id=" + id +
                ", typeAnimal='" + typeAnimal + '\'' +
                ", dateNaissance=" + dateNaissance +
                ", race='" + race + '\'' +
                ", couleur='" + couleur + '\'' +
                ", nom='" + nom + '\'' +
                ", reserve=" + reserve +
                '}';
    }
}
