package Modele;

public class Actuality {



    private int id;
    private Pension pension;
    private String dateActu;
    private String photo;
    private String descriptif;

    public Actuality(int id, Pension pension, String dateActu, String photo, String descriptif) {
        this.id = id;
        this.pension = pension;
        this.dateActu = dateActu;
        this.photo = photo;
        this.descriptif = descriptif;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Pension getPension() {
        return pension;
    }

    public void setPension(Pension pension) {
        this.pension = pension;
    }

    public String getDateActu() {
        return dateActu;
    }

    public void setDateActu(String dateActu) {
        this.dateActu = dateActu;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getDescriptif() {
        return descriptif;
    }

    public void setDescriptif(String descriptif) {
        this.descriptif = descriptif;
    }

    @Override
    public String toString() {
        return "Actuality{" +
                "id=" + id +
                ", pension=" + pension +
                ", dateActu='" + dateActu + '\'' +
                ", photo='" + photo + '\'' +
                ", descriptif='" + descriptif + '\'' +
                '}';
    }
}
