package api;

import java.util.List;

import Modele.Utilisateur;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface AccountService {

    @GET("api/util")
    Call<List<Utilisateur>> Query();

    @GET("api/util/authentification/{email}/{password}")
    Call<Utilisateur> GetIdByAuthentification(@Path("email") String email,@Path("password") String password);

    @POST("api/util")
    Call<Utilisateur> Create(@Body Utilisateur utilisateur);

}
