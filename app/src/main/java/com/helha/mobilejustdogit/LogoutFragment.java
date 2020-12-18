package com.helha.mobilejustdogit;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.

 */
public class LogoutFragment extends Fragment {


    public LogoutFragment() {
        // Constructeur vide
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.fragment_logout, container, false);

        //Quand on se déconnecte, on deconnexte l'utilisateur
        SharedPreferences loginusers = getContext().getSharedPreferences("user", Context.MODE_PRIVATE);
        SharedPreferences.Editor userEditor = loginusers.edit();
        Toast.makeText(LogoutFragment.this.getContext(), "Déconnexion réussie", Toast.LENGTH_LONG).show();
        userEditor.clear();
        userEditor.apply();
        getActivity().onBackPressed();

        return view;
    }
}