package com.helha.mobilejustdogit;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import Modele.Habitat;
import Modele.Utilisateur;
import Repository.CreateUserRepository;

/**
 * A simple {@link Fragment} subclass.

 */
public class InscriptionFragment extends Fragment implements View.OnClickListener {

    final CreateUserRepository createUserRepository = new CreateUserRepository();

    EditText nickname;
    EditText email;
    EditText password;
    EditText phone1;
    EditText phone2;
    EditText street;
    EditText cp;
    EditText houseNumber;
    EditText box;
    EditText city;

    Habitat habitat;

    public InscriptionFragment() {

    }

    public static InscriptionFragment newInstance() {
        return new InscriptionFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_inscription, container, false);
        Button btn = (Button) rootView.findViewById(R.id.btn_register);
        btn.setOnClickListener(this);
        nickname = rootView.findViewById(R.id.et_nickname);
        email = rootView.findViewById(R.id.et_Email);
        password = rootView.findViewById(R.id.et_password);
        phone1 = rootView.findViewById(R.id.et_phonenumber1);
        phone2 = rootView.findViewById(R.id.et_phonenumber2);
        street = rootView.findViewById(R.id.et_street);
        cp = rootView.findViewById(R.id.et_cp);
        houseNumber = rootView.findViewById(R.id.et_number);
        box = rootView.findViewById(R.id.et_box);
        city = rootView.findViewById(R.id.et_city);

        return rootView;
    }

    @Override
    public void onClick(View v) {
        if (nickname.getText().toString().equals("") || email.getText().toString().equals("") || password.getText().toString().equals("")
                || phone1.getText().toString().equals("") || street.getText().toString().equals("") || cp.getText().toString().equals("")
                || houseNumber.getText().toString().equals("") || city.getText().toString().equals("")) {
            Toast.makeText(InscriptionFragment.this.getContext(), "Vous n'avez pas entrez toutes les informations requises", Toast.LENGTH_SHORT).show();

        }
        else {
            habitat = new Habitat(street.getText().toString(), Integer.parseInt(cp.getText().toString()), houseNumber.getText().toString(), box.getText().toString(), city.getText().toString());

            Utilisateur util = new Utilisateur(nickname.getText().toString(), email.getText().toString(), password.getText().toString(),
                    habitat, phone1.getText().toString(), phone2.getText().toString());
            createUserRepository.creaUtilisateurLiveData(util)
                    .observe(getViewLifecycleOwner(), new Observer<Utilisateur>() {
                        @Override
                        public void onChanged(Utilisateur utilisateur) {
                            if (utilisateur != null) {
                                Toast.makeText(InscriptionFragment.this.getContext(), "Ajouter à la Base de donnée", Toast.LENGTH_LONG).show();
                            } else {
                                Toast.makeText(InscriptionFragment.this.getContext(), "Il y a un champ vide", Toast.LENGTH_LONG).show();
                            }

                        }

                    });
        }
    }
}