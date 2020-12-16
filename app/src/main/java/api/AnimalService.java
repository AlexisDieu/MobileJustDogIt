package api;

import java.util.List;

import Modele.Animal;
import retrofit2.Call;
import retrofit2.http.GET;

public interface AnimalService {

    @GET("api/animal")
    Call<List<Animal>> Query();

}
