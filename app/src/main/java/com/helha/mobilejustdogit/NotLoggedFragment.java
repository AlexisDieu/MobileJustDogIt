package com.helha.mobilejustdogit;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import Modele.Authentificator;
import Modele.Utilisateur;

/**
 * A simple {@link Fragment} subclass.
 */
public class NotLoggedFragment extends Fragment implements View.OnClickListener {

    public NotLoggedFragment() {
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
        View rootView = inflater.inflate(R.layout.fragment_logout, container, false);
       // Button btn = (Button) rootView.findViewById(R.id.btn_deconnexion);

       // btn.setOnClickListener(this);
        return rootView;
    }

    @Override
    public void onClick(View v) {

        Toast.makeText(NotLoggedFragment.this.getContext(), "Déconnexion réussie", Toast.LENGTH_LONG).show();
        SharedPreferences loginusers = getContext().getSharedPreferences("user", Context.MODE_PRIVATE);
        SharedPreferences.Editor userEditor = loginusers.edit();
        SharedPreferences.Editor userEditors = loginusers.edit();
        userEditors.clear();
        userEditor.apply();

        getActivity().onBackPressed();
    }
}