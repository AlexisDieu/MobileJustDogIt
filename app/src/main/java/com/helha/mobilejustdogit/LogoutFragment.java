package com.helha.mobilejustdogit;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.helha.mobilejustdogit.R;

/**
 * A simple {@link Fragment} subclass.

 */
public class LogoutFragment extends Fragment {


    public LogoutFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.fragment_logout, container, false);

        //When deconnected == do an editor.clear to reset the user
        SharedPreferences loginusers = getContext().getSharedPreferences("user", Context.MODE_PRIVATE);
        SharedPreferences.Editor userEditor = loginusers.edit();
        userEditor.clear();
        userEditor.apply();

        getActivity().onBackPressed();

        return view;
    }
}