package com.helha.mobilejustdogit;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.helha.mobilejustdogit.ui.home.HomeFragment;

import java.util.ArrayList;
import java.util.List;

import Modele.Authentificator;
import Modele.Utilisateur;
import Repository.AccountRepository;
import Repository.AuthentificateRepository;

/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment implements View.OnClickListener {

    final AuthentificateRepository authentificateRepository = new AuthentificateRepository();
    EditText email;
    Menu menu;
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
        TextView MdpOublie = rootView.findViewById(R.id.MdpOublie) ;
        TextView creationCompte = rootView.findViewById(R.id.txt_creationCompte) ;


         email = rootView.findViewById(R.id.Login_email);
         password = rootView.findViewById(R.id.MotDePasse);


        btn.setOnClickListener(this);

        MdpOublie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent i = new Intent(v.getContext(),mdpoublie.class);
                getActivity().startActivity(i);
            }
        });
        creationCompte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Fragment fragment2= new InscriptionFragment();

                getFragmentManager().beginTransaction().
                        replace(R.id.txt_creationCompte, fragment2).
                        addToBackStack("frags").commit();
            }
        });

        return rootView;
    }

    @Override
    public void onClick(View v) {
        Authentificator authentificator= new Authentificator(email.getText().toString(),password.getText().toString());
        authentificateRepository.checkUtil(authentificator).observe(getViewLifecycleOwner(), new Observer<Utilisateur>() {
            @Override
            public void onChanged(Utilisateur utilisateur) {
                if(utilisateur !=null) {
                    Toast.makeText(LoginFragment.this.getContext(), "Connexion réussie", Toast.LENGTH_LONG).show();
                    /*menu = new NavigationActivity().getMenu();
                    menu.findItem(R.id.nav_logout).setVisible(true);
                    menu.findItem(R.id.nav_profile).setVisible(true);*/
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