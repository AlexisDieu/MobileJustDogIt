package com.helha.mobilejustdogit;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.textfield.TextInputEditText;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class ProfileFragment extends Fragment {

    private TextInputEditText textOldPassword, textNewPassword, textConfirmPassword, textFirstname, textLastname, textVille, textCp, textNumero, textRue;
    private String oldPassword, newPassword, confirmPassword, firstname, lastname;

    private ProgressDialog loading;
    private AlertDialog dialog;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.profile_fragment, container, false);


        textOldPassword = (TextInputEditText) root.findViewById(R.id.AncienMotDePasse);
        textVille = (TextInputEditText) root.findViewById(R.id.Ville);
        textCp = (TextInputEditText) root.findViewById(R.id.cp);
        textNumero = (TextInputEditText) root.findViewById(R.id.Numero);
        textRue = (TextInputEditText) root.findViewById(R.id.rue);
        textNewPassword = (TextInputEditText) root.findViewById(R.id.Nouveau_MotDePasse);
        textConfirmPassword = (TextInputEditText) root.findViewById(R.id.ConfirmerMotDePasse);

        textFirstname = (TextInputEditText) root.findViewById(R.id.text_firstname);
        textLastname = (TextInputEditText) root.findViewById(R.id.text_lastname);


        // fetch user and show profile data
        return root;
    }

    public void ChangerMotDePasse() {

    }

    public void MettreAJourProfile() {

    }


}
