package api;

import java.util.List;

import Modele.Actuality;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

public interface AdminService {

    @GET("api/actualite")
    Call<List<Actuality>> Query(@Header("Authorization") String authToken);
}
