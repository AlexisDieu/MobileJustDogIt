package com.helha.mobilejustdogit;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import Modele.Authentificator;
import Modele.Utilisateur;
import Repository.AuthentificateRepository;

/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment implements View.OnClickListener {

    final AuthentificateRepository authentificateRepository = new AuthentificateRepository();
    EditText email;
    EditText password;

    public LoginFragment() {
        // Constructeur vide
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_login, container, false);

        Button btn = (Button) rootView.findViewById(R.id.btn_login);
        TextView MdpOublie = rootView.findViewById(R.id.MdpOublie);


        email = rootView.findViewById(R.id.Login_email);
        password = rootView.findViewById(R.id.MotDePasse);


        btn.setOnClickListener(this);

        MdpOublie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), mdpoublie.class);
                getActivity().startActivity(i);
            }
        });

        return rootView;
    }

    @Override
    public void onClick(View v) {
        Authentificator authentificator = new Authentificator(email.getText().toString(), password.getText().toString());
        authentificateRepository.checkUtil(authentificator).observe(getViewLifecycleOwner(), new Observer<Utilisateur>() {
            @Override
            public void onChanged(Utilisateur utilisateur) {
                if (utilisateur != null) {
                    Toast.makeText(LoginFragment.this.getContext(), "Connexion réussie", Toast.LENGTH_LONG).show();
                    getActivity().onBackPressed();

                    //create a token when login
                    SharedPreferences loginuser = getContext().getSharedPreferences("user", Context.MODE_PRIVATE);
                    SharedPreferences.Editor userEditor = loginuser.edit();
                    userEditor.putString("loginKey", utilisateur.getJWTBearer());
                    userEditor.putInt("idKey", utilisateur.getId());
                    userEditor.putString("roleKey", utilisateur.getRole());
                    userEditor.apply();


                } else {
                    Toast.makeText(LoginFragment.this.getContext(), "utilisateur invalide", Toast.LENGTH_LONG).show();
                }

            }

        });

    }
}