package api;

import java.util.List;

import Modele.Authentification;
import Modele.Utilisateur;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface AccountService {

    @GET("api/util")
    Call<List<Utilisateur>> Query();

    @GET("api/util/authentification/{email}/{password}")
    Call<Utilisateur> GetIdByAuthentification(@Path("email") String email,@Path("password") String password);

}
