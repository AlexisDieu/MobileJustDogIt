package Repository;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;


import Modele.Authentificator;
import Modele.Utilisateur;
import api.AccountService;
import api.ApiClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AuthentificateRepository {

    public AccountService getAccountId(){
        return ApiClient.GetRetrofit().create(AccountService.class);
    }

    public LiveData<Utilisateur> checkUtil(Authentificator authentificator){

        final MutableLiveData<Utilisateur> utilisateurMutableLiveData = new MutableLiveData<>();

        getAccountId().GetIdByAuthentification(authentificator).enqueue(new Callback<Utilisateur>() {
            @Override
            public void onResponse(Call<Utilisateur> call, Response<Utilisateur> response) {

                if (response.isSuccessful()) {
                    utilisateurMutableLiveData.postValue(response.body());
                    Log.i("CallAPIid", "onResponse: " + response.body());

                }
                else{
                    utilisateurMutableLiveData.postValue(null);
                }
            }

            @Override
            public void onFailure(Call<Utilisateur> call, Throwable t) {
                Log.i("CallAPIid", "onFailure: "+t.getMessage());

            }
        });

        return utilisateurMutableLiveData;
    }
}
