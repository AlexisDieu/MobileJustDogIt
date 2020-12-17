package Repository;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

import Modele.Pension;
import api.ApiClient;
import api.PensionService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PensionRepository {

    public PensionService pensionApi() {
        return ApiClient.GetRetrofit().create(PensionService.class);
    }

    public LiveData<List<Pension>> showPensionList(final String token) {

        final MutableLiveData<List<Pension>> pensionMutableLiveData = new MutableLiveData<>();

        pensionApi().Query(token).enqueue(new Callback<List<Pension>>() {
            @Override
            public void onResponse(Call<List<Pension>> call, Response<List<Pension>> response) {
                pensionMutableLiveData.postValue(response.body());
                Log.i("CallAPIpensionRepo", "onResponse: " + response.body());
            }

            @Override
            public void onFailure(Call<List<Pension>> call, Throwable t) {
                Log.i("CallAPIpensionRepo", "onError " + t.getMessage());
            }
        });

        return pensionMutableLiveData;
    }
}
