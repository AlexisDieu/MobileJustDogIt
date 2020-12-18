package Repository;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

import Modele.Animal;
import api.AnimalService;
import api.ApiClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AnimalRepository {

    public AnimalService animalApi() {
        return ApiClient.GetRetrofit().create(AnimalService.class);
    }

    public LiveData<List<Animal>> showAnimalList() {

        final MutableLiveData<List<Animal>> animalMutableLiveData = new MutableLiveData<>();

        animalApi().Query().enqueue(new Callback<List<Animal>>() {
            @Override
            public void onResponse(Call<List<Animal>> call, Response<List<Animal>> response) {
                if (response.isSuccessful()) {

                    animalMutableLiveData.postValue(response.body());
                    Log.i("CallAPIanimal", "onResponse: " + response.body());
                }
            }

            @Override
            public void onFailure(Call<List<Animal>> call, Throwable t) {
                Log.i("CallAPIanimal", "onError " + t.getMessage());
            }
        });

        return animalMutableLiveData;
    }
}
