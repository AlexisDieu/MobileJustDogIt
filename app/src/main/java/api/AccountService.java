package api;

import java.util.List;

import Modele.Authentificator;
import Modele.Utilisateur;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface AccountService {

    @GET("api/util")
    Call<List<Utilisateur>> Query();

    @POST("api/util/authentification")
    Call<Utilisateur> GetIdByAuthentification(@Body Authentificator authentificator);

    @POST("api/util")
    Call<Utilisateur> Create(@Body Utilisateur utilisateur);

}
