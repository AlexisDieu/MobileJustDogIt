package Repository;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

import Modele.Actuality;
import Modele.ActualityInput;
import Modele.Pension;
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

    public LiveData<List<Pension>> getPension(final String token) {

        final MutableLiveData<List<Pension>> adminPensionMutableLiveData = new MutableLiveData<>();

        adminApi().Query(token).enqueue(new Callback<List<Pension>>() {
            @Override
            public void onResponse(Call<List<Pension>> call, Response<List<Pension>> response) {
                if(response.isSuccessful()) {
                    adminPensionMutableLiveData.postValue(response.body());
                    Log.i("CallAPIAdminRepo", "onResponse: " + response.body());
                }
            }

            @Override
            public void onFailure(Call<List<Pension>> call, Throwable t) {
                Log.i("CallAPIAdminRepo", "onError " + t.getMessage());
            }
        });

        return adminPensionMutableLiveData;
    }

    public LiveData<ActualityInput> addActuality(final String token,ActualityInput actuality) {

        Log.i("CallAPIAdminRepo", "onResponse:  testttttt" );
        final MutableLiveData<ActualityInput> adminPensionMutableLiveData = new MutableLiveData<>();

        adminApi().Create(token,actuality).enqueue(new Callback<ActualityInput>() {
            @Override
            public void onResponse(Call<ActualityInput> call, Response<ActualityInput> response) {

                    adminPensionMutableLiveData.postValue(response.body());
                    Log.i("CallAPIAdminRepo", "onResponse: " + response.body());

            }

            @Override
            public void onFailure(Call<ActualityInput> call, Throwable t) {
                Log.i("CallAPIAdminRepo", "onError " + t.getMessage());
            }
        });

        return adminPensionMutableLiveData;
    }

}
