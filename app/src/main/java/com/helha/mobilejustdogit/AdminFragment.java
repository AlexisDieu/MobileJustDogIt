package com.helha.mobilejustdogit;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import Modele.ActualityInput;
import Modele.Pension;
import Repository.AdminRepository;


/**
 * A simple {@link Fragment} subclass.
 */
public class AdminFragment extends Fragment implements View.OnClickListener {

    final AdminRepository adminRepository = new AdminRepository();

    Spinner spinPension;
    TextView textViewUser;
    TextView textViewAnimal;
    TextView dateAdmin;
    TextView infoAdmin;

    List<Pension> pensionList;
    List<String> userList;
    List<String> animalList;
    Pension p1;


    public AdminFragment() {
        // Constructeur vide
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_admin, container, false);

        //Get back the token
        SharedPreferences loginUser = view.getContext().getSharedPreferences("user", Context.MODE_PRIVATE);

        String loginToken = loginUser.getString("loginKey", "oui");
        Log.i("CallAPI", loginToken);
        final int idUser = loginUser.getInt("idKey", 0);

        Button btn = (Button) view.findViewById(R.id.btn_admin);
        btn.setOnClickListener(this);

        spinPension = view.findViewById(R.id.sp_pension);
        textViewAnimal = view.findViewById(R.id.tv_admin_animal);
        textViewUser = view.findViewById(R.id.tv_admin_user);
        dateAdmin = view.findViewById(R.id.et_date_admin);
        infoAdmin = view.findViewById(R.id.et_description);


        pensionList = new ArrayList<>();
        animalList = new ArrayList<>();
        userList = new ArrayList<>();


        final ArrayAdapter<Pension> pensionArrayAdapter = new ArrayAdapter<>((getContext()), android.R.layout.simple_spinner_item, pensionList);

        spinPension.setAdapter(pensionArrayAdapter);

        adminRepository.getPension(loginToken)
                .observe(this.getViewLifecycleOwner(), new Observer<List<Pension>>() {

                    @Override
                    public void onChanged(List<Pension> pensions) {
                        for (Pension p : pensions) {
                            pensionArrayAdapter.add(p);
                            animalList.add(p.getAnimal().getNom());
                            userList.add(p.getUtilisateur().getPseudo());
                        }
                        pensionArrayAdapter.notifyDataSetChanged();
                        Log.i("CallAPIactualityFrag", "onChanged: " + pensions.toString());

                    }
                });

        spinPension.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                textViewAnimal.setText(animalList.get(position));
                textViewUser.setText(userList.get(position));
                p1 = pensionList.get(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        return view;
    }

    @Override
    public void onClick(View v) {
        //Get back the token
        SharedPreferences loginUser = v.getContext().getSharedPreferences("user", Context.MODE_PRIVATE);

        String loginToken = loginUser.getString("loginKey", "oui");

        if (dateAdmin.getText().toString().equals("") || infoAdmin.getText().toString().equals("")) {
            Toast.makeText(AdminFragment.this.getContext(), "Vous n'avez pas entrez toutes les informations requises", Toast.LENGTH_SHORT).show();

        } else {
            ActualityInput actuality = new ActualityInput(p1.getId(), dateAdmin.getText().toString(), infoAdmin.getText().toString());
            adminRepository.addActuality(loginToken, actuality)
                    .observe(getViewLifecycleOwner(), new Observer<ActualityInput>() {
                        @Override
                        public void onChanged(ActualityInput actuality) {
                            if (actuality != null) {
                                Toast.makeText(AdminFragment.this.getContext(), "Ajouter à la Base de donnée", Toast.LENGTH_LONG).show();
                            } else {
                                Toast.makeText(AdminFragment.this.getContext(), "L'objet voulu est null", Toast.LENGTH_LONG).show();
                            }

                        }

                    });
        }

    }
}