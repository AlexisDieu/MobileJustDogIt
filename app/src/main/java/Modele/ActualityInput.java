package Modele;

public class ActualityInput {



    private int idPension;
    private String dateActu;
    private String photo;
    private String descriptif;

    public ActualityInput(int idPension, String dateActu,String descriptif) {
        this.idPension = idPension;
        this.dateActu = dateActu;
        this.descriptif = descriptif;
    }

    public int getIdPension() {
        return idPension;
    }

    public void setIdPension(int idPension) {
        this.idPension = idPension;
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
        return "ActualityInput{" +
                "idPension=" + idPension +
                ", dateActu='" + dateActu + '\'' +
                ", photo='" + photo + '\'' +
                ", descriptif='" + descriptif + '\'' +
                '}';
    }
}
