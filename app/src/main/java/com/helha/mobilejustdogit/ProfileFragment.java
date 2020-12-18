package com.helha.mobilejustdogit;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;

import com.google.android.material.textfield.TextInputEditText;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import Adapter.PensionAdapter;
import Modele.Actuality;
import Modele.Habitat;
import Modele.Pension;
import Modele.Utilisateur;
import Repository.AccountRepository;

public class ProfileFragment extends Fragment /*implements View.OnClickListener*/{

    final AccountRepository accountRepository = new AccountRepository();

    private TextInputEditText textOldPassword, textNewPassword, textConfirmPassword, textPseudo, textEmail, textVille, textCp, textNumero, textRue;
    private String oldPassword, newPassword, confirmPassword, firstname, lastname;
    //private Button btnProfile, btnPassword;

    private ProgressDialog loading;
    private AlertDialog dialog;

    private List<Utilisateur> utilisateurList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.profile_fragment, container, false);

        //Get back the token
        SharedPreferences loginUser = root.getContext().getSharedPreferences("user", Context.MODE_PRIVATE);

        String loginToken = loginUser.getString("loginKey","oui");
        final int idUser = loginUser.getInt("idKey",0);


       /* btnPassword = (Button) root.findViewById(R.id.btn_update_password);
        btnPassword.setOnClickListener(this);

        btnProfile = (Button) root.findViewById(R.id.btn_update_profile);
        btnProfile.setOnClickListener(this);*/

        textOldPassword = (TextInputEditText) root.findViewById(R.id.AncienMotDePasse);
        textVille = (TextInputEditText) root.findViewById(R.id.Ville);
        textCp = (TextInputEditText) root.findViewById(R.id.cp);
        textNumero = (TextInputEditText) root.findViewById(R.id.Numero);
        textRue = (TextInputEditText) root.findViewById(R.id.rue);
        textNewPassword = (TextInputEditText) root.findViewById(R.id.Nouveau_MotDePasse);
        textConfirmPassword = (TextInputEditText) root.findViewById(R.id.ConfirmerMotDePasse);

        textPseudo= (TextInputEditText) root.findViewById(R.id.text_pseudo);
        textEmail = (TextInputEditText) root.findViewById(R.id.text_email);

        utilisateurList = new ArrayList<>();

 /*       accountRepository.getListUtilisateur(loginToken)
                .observe(this.getViewLifecycleOwner(), new Observer<List<Utilisateur>>() {
                    @Override
                    public void onChanged(List<Utilisateur> utilisateurs) {
                        for (Utilisateur u : utilisateurs) {
                            if (u.getId() == idUser)
                                utilisateurList.add(u);
                        }
                        Log.i("idcheck", idUser +""+ utilisateurList.toString());
                    }
                });*/



        // fetch user and show profile data
        return root;
    }

/*    @Override
    public void onClick(View v) {
        SharedPreferences loginUser = v.getContext().getSharedPreferences("user", Context.MODE_PRIVATE);

        String loginToken = loginUser.getString("loginKey","oui");
        final int idUser = loginUser.getInt("idKey",0);


        Log.i("idcheck", idUser +""+ utilisateurList.toString());

        switch (v.getId()){
            case R.id.btn_update_password:

                accountRepository.updateUtilisateur(loginToken,idUser,utilisateurList.get(0))
                        .observe(this.getViewLifecycleOwner(), new Observer<Utilisateur>() {
                            @Override
                            public void onChanged(Utilisateur utilisateurs) {
                                utilisateurList.get(0).setMdp(textNewPassword.getText().toString());
                            }
                        });

                break;
            case R.id.btn_update_profile:

                break;
            default:
                break;

        }

    }*/
}
