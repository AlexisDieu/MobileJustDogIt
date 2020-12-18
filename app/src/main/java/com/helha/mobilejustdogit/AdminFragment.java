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
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import Modele.Actuality;
import Modele.Animal;
import Modele.Pension;
import Modele.Utilisateur;
import Repository.AdminRepository;
import api.AdminService;

/**
 * A simple {@link Fragment} subclass.
 */
public class AdminFragment extends Fragment {

    final AdminRepository adminRepository = new AdminRepository();

    Spinner spinPension;
    TextView textViewUser;
    TextView textViewAnimal;

    List<Pension> pensionList;
    List<String> userList;
    List<String> animalList;


    public AdminFragment() {
        // Required empty public constructor
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

        String loginToken = loginUser.getString("loginKey","oui");
        Log.i("CallAPI", loginToken);
        final int idUser = loginUser.getInt("idKey",0);

        spinPension = view.findViewById(R.id.sp_pension);
        textViewAnimal = view.findViewById(R.id.tv_admin_animal);
        textViewUser = view.findViewById(R.id.tv_admin_user);

        pensionList = new ArrayList<>();
        animalList = new ArrayList<>();
        userList = new ArrayList<>();


        final ArrayAdapter<Pension> pensionArrayAdapter = new ArrayAdapter<>((getContext()),android.R.layout.simple_spinner_item, pensionList);

        spinPension.setAdapter(pensionArrayAdapter);

        adminRepository.showActualityList(loginToken)
                .observe(this.getViewLifecycleOwner(), new Observer<List<Actuality>>() {

                    @Override
                    public void onChanged(List<Actuality> actualities) {
                        for (Actuality a:actualities) {
                                pensionArrayAdapter.add(a.getPension());
                                 animalList.add(a.getPension().getAnimal().getNom());
                                 userList.add(a.getPension().getUtilisateur().getPseudo());
                        }
                        pensionArrayAdapter.notifyDataSetChanged();
                        Log.i("CallAPIactualityFrag", "onChanged: "+actualities.toString());

                    }
                });

        spinPension.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                textViewAnimal.setText(animalList.get(position));
                textViewUser.setText(userList.get(position));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        return view;
    }
}