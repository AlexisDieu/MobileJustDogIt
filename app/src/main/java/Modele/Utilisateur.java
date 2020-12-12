package Modele;

public class Utilisateur {

    public int id;
    public String pseudo ;
    public String email ;
    public String mdp ;
    public Habitat habitat ;
    public String tel ;
    public String tel2 ;

    public Utilisateur(int id, String pseudo, String email, String mdp, Habitat habitat, String tel, String tel2) {
        this.id = id;
        this.pseudo = pseudo;
        this.email = email;
        this.mdp = mdp;
        this.habitat = habitat;
        this.tel = tel;
        this.tel2 = tel2;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public Habitat getHabitat() {
        return habitat;
    }

    public void setHabitat(Habitat habitat) {
        this.habitat = habitat;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getTel2() {
        return tel2;
    }

    public void setTel2(String tel2) {
        this.tel2 = tel2;
    }


    @Override
    public String toString() {
        return "Utilisateur{" +
                "id=" + id +
                ", pseudo='" + pseudo + '\'' +
                ", email='" + email + '\'' +
                ", mdp='" + mdp + '\'' +
                ", habitat=" + habitat +
                ", tel='" + tel + '\'' +
                ", tel2='" + tel2 + '\'' +
                '}';
    }
}
