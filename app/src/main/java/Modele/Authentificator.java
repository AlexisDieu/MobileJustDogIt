package Modele;

public class Authentificator {

    private String email;
    private String mdp;

    public Authentificator(String email, String mdp) {
        this.email = email;
        this.mdp = mdp;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return mdp;
    }

    public void setPassword(String password) {
        this.mdp = password;
    }

    @Override
    public String toString() {
        return "Authentificator{" +
                "email='" + email + '\'' +
                ", password='" + mdp + '\'' +
                '}';
    }
}
