package Repository;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import Modele.Utilisateur;
import api.AccountService;
import api.ApiClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CreateUserRepository {

    public AccountService createUser(){
        return ApiClient.GetRetrofit().create(AccountService.class);
    }

    public LiveData<Utilisateur> creaUtilisateurLiveData(Utilisateur utilisateur){

        final MutableLiveData<Utilisateur> utilisateurMutableLiveData = new MutableLiveData<>();

        createUser().Create(utilisateur).enqueue(new Callback<Utilisateur>() {
            @Override
            public void onResponse(Call<Utilisateur> call, Response<Utilisateur> response) {
                utilisateurMutableLiveData.postValue(response.body());
                Log.i("CallAPIid", "onResponse: "+response.body());
            }

            @Override
            public void onFailure(Call<Utilisateur> call, Throwable t) {
                Log.i("CallAPIid", "onResponse: "+t.getMessage());
            }
        });

        return utilisateurMutableLiveData;
    }

}
