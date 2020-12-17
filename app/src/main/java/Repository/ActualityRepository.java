package Repository;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

import Modele.Actuality;
import Modele.Pension;
import api.AccountService;
import api.ActualityService;
import api.ApiClient;
import api.PensionService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ActualityRepository {

    public ActualityService actualityApi() {
        return ApiClient.GetRetrofit().create(ActualityService.class);
    }

    public LiveData<List<Actuality>> showActualityList(final String token) {

        final MutableLiveData<List<Actuality>> pensionMutableLiveData = new MutableLiveData<>();

        actualityApi().Query(token).enqueue(new Callback<List<Actuality>>() {
            @Override
            public void onResponse(Call<List<Actuality>> call, Response<List<Actuality>> response) {
                pensionMutableLiveData.postValue(response.body());
                Log.i("CallAPIactualityRepo", "onResponse: " + response.body());
            }

            @Override
            public void onFailure(Call<List<Actuality>> call, Throwable t) {
                Log.i("CallAPIactualityRepo", "onError " + t.getMessage());
            }
        });

        return pensionMutableLiveData;
    }
}
