package Repository;

import android.accounts.Account;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

import Modele.Utilisateur;
import api.AccountService;
import api.ApiClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AccountRepository {

    private AccountService getAccountService(){
        return ApiClient.GetRetrofit().create(AccountService.class);
    }

    public LiveData<List<Utilisateur>> getUtilisateur(){

        final MutableLiveData<List<Utilisateur>> utilisateurMutableLiveData = new MutableLiveData<>();

        getAccountService().Query().enqueue(new Callback<List<Utilisateur>>() {
            @Override
            public void onResponse(Call<List<Utilisateur>> call, Response<List<Utilisateur>> response) {
                utilisateurMutableLiveData.postValue(response.body());
                Log.i("CallAPIUtilisateur", "onResponse: "+response.body());
            }

            @Override
            public void onFailure(Call<List<Utilisateur>> call, Throwable t) {
                Log.i("CallAPIUtilisateur", "onResponse: "+t.getMessage());

            }
        });
        return utilisateurMutableLiveData;
    }
}
