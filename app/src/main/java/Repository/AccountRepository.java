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

    public LiveData<List<Utilisateur>> getListUtilisateur(final String token){

        final MutableLiveData<List<Utilisateur>> utilisateurListMutableLiveData = new MutableLiveData<>();

        getAccountService().Query(token).enqueue(new Callback<List<Utilisateur>>() {
            @Override
            public void onResponse(Call<List<Utilisateur>> call, Response<List<Utilisateur>> response) {
                utilisateurListMutableLiveData.postValue(response.body());
                Log.i("CallAPIUtilisateur", "onResponse: "+response.body());
            }

            @Override
            public void onFailure(Call<List<Utilisateur>> call, Throwable t) {
                Log.i("CallAPIUtilisateur", "onResponse: "+t.getMessage());

            }
        });
        return utilisateurListMutableLiveData;
    }

    public LiveData<Utilisateur> updateUtilisateur(final String token,int id,Utilisateur utilisateur){

        final MutableLiveData<Utilisateur> utilisateurUpdateMutableLiveData = new MutableLiveData<>();

        getAccountService().Update(token,id,utilisateur).enqueue(new Callback<Utilisateur>() {
            @Override
            public void onResponse(Call<Utilisateur> call, Response<Utilisateur> response) {
                utilisateurUpdateMutableLiveData.postValue(response.body());
                Log.i("CallAPIUtilisateur", "onResponse: "+response.code());
            }

            @Override
            public void onFailure(Call<Utilisateur> call, Throwable t) {
                Log.i("CallAPIUtilisateur", "onResponse: "+t.getMessage());

            }
        });
        return utilisateurUpdateMutableLiveData;
    }
}
