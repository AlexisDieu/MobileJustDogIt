package com.helha.mobilejustdogit;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.helha.mobilejustdogit.ui.home.HomeFragment;

import java.util.ArrayList;
import java.util.List;

import Modele.Utilisateur;
import Repository.AccountRepository;
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
         email = rootView.findViewById(R.id.Login_email);
         password = rootView.findViewById(R.id.MotDePasse);

        btn.setOnClickListener(this);

        return rootView;
    }

    @Override
    public void onClick(View v) {
        authentificateRepository.checkUtil(email.getText().toString(),password.getText().toString()).observe(getViewLifecycleOwner(), new Observer<Utilisateur>() {
            @Override
            public void onChanged(Utilisateur utilisateur) {
                if(utilisateur !=null) {
                    Toast.makeText(LoginFragment.this.getContext(), "Connexion réussie", Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(LoginFragment.this.getContext(),"utilisateur invalide",Toast.LENGTH_LONG).show();
                }

            }

        });
/*       Fragment fragment = null;
        switch (v.getId()) {
            case R.id.btn_login:
                fragment = new HomeFragment();
                replaceFragment(fragment);
                break;
        }*/
    }

/*    private void replaceFragment(Fragment fragment) {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.nav_host_fragment, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
*/
}