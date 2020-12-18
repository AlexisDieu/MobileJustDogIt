package api;

import java.util.List;

import Modele.Actuality;
import Modele.ActualityInput;
import Modele.Pension;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface AdminService {

    @GET("api/pension")
    Call<List<Pension>> Query(@Header("Authorization") String authToken);

    @POST("api/actualite")
    Call<ActualityInput> Create(@Header("Authorization") String authToken,@Body ActualityInput actualityInput);
}
