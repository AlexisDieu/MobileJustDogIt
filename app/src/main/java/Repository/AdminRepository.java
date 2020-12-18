package Repository;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

import Modele.Actuality;
import api.ActualityService;
import api.AdminService;
import api.ApiClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AdminRepository {

    public AdminService adminApi() {
        return ApiClient.GetRetrofit().create(AdminService.class);
    }

    public LiveData<List<Actuality>> showActualityList(final String token) {

        final MutableLiveData<List<Actuality>> adminActualityMutableLiveData = new MutableLiveData<>();

        adminApi().Query(token).enqueue(new Callback<List<Actuality>>() {
            @Override
            public void onResponse(Call<List<Actuality>> call, Response<List<Actuality>> response) {
                if(response.isSuccessful()) {
                    adminActualityMutableLiveData.postValue(response.body());
                    Log.i("CallAPIactualityRepo", "onResponse: " + response.body());
                }
            }

            @Override
            public void onFailure(Call<List<Actuality>> call, Throwable t) {
                Log.i("CallAPIactualityRepo", "onError " + t.getMessage());
            }
        });

        return adminActualityMutableLiveData;
    }

}
