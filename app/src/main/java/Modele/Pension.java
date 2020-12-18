package Modele;

import com.helha.mobilejustdogit.R;

public class Pension {

    private int id;
    private Utilisateur utilisateur;
    private Animal animal;
    private String dateEntree;
    private String dateSortie;
    private int prix;
    private int images;

    public Pension(int id, Utilisateur utilisateur, Animal animal, String dateEntree, String dateSortie, int prix) {
        this.id = id;
        this.images= R.mipmap.ic_launcher_foreground;
        this.utilisateur = utilisateur;
        this.animal = animal;
        this.dateEntree = dateEntree;
        this.dateSortie = dateSortie;
        this.prix = prix;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public String getDateEntree() {
        return dateEntree;
    }

    public void setDateEntree(String dateEntree) {
        this.dateEntree = dateEntree;
    }

    public String getDateSortie() {
        return dateSortie;
    }

    public void setDateSortie(String dateSortie) {
        this.dateSortie = dateSortie;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    @Override
    public String toString() {
        return "Pension{" +
                "id=" + id +
                ", utilisateur=" + utilisateur +
                ", animal=" + animal +
                ", image:" + images+
                ", dateEntree='" + dateEntree + '\'' +
                ", dateSortie='" + dateSortie + '\'' +
                ", prix=" + prix +
                '}';
    }

    public int getImages()
    {
        return images=R.mipmap.ic_launcher_foreground;
    }
}
