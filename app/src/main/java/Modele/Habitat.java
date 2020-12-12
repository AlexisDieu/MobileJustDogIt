package Modele;

public class Habitat {

    public int id ;
    public String rue;
    public int cp;
    public String numero ;
    public String boite ;
    public String ville ;

    public Habitat(int id, String rue, int cp, String numero, String boite, String ville) {
        this.id = id;
        this.rue = rue;
        this.cp = cp;
        this.numero = numero;
        this.boite = boite;
        this.ville = ville;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public int getCp() {
        return cp;
    }

    public void setCp(int cp) {
        this.cp = cp;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getBoite() {
        return boite;
    }

    public void setBoite(String boite) {
        this.boite = boite;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    @Override
    public String toString() {
        return "Habitat{" +
                "id=" + id +
                ", rue='" + rue + '\'' +
                ", cp=" + cp +
                ", numero='" + numero + '\'' +
                ", boite='" + boite + '\'' +
                ", ville='" + ville + '\'' +
                '}';
    }
}
