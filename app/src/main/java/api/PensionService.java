package api;

import java.util.List;

import Modele.Pension;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

public interface PensionService {

    @GET("api/pension")
    Call<List<Pension>> Query(@Header ("Authorization") String authToken);

}
