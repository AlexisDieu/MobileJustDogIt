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
import android.widget.ImageView;
import android.widget.ListView;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

import Adapter.ActualityAdapter;
import Modele.Actuality;
import Modele.Animal;
import Modele.Pension;
import Repository.ActualityRepository;

/**
 * A simple {@link Fragment} subclass.
 */
public class ActualityFragment extends Fragment {

    final ActualityRepository actualityRepository = new ActualityRepository();

    List<Actuality> actualityList;

    private int images =R.mipmap.ic_launcher_foreground;


            ListView listViewActuality;


    public ActualityFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_actuality, container, false);

        SharedPreferences loginUser = view.getContext().getSharedPreferences("user", Context.MODE_PRIVATE);

        String loginToken = loginUser.getString("loginKey", "");
        final int idUser = loginUser.getInt("idKey", 0);

        listViewActuality = view.findViewById(R.id.lv_actuality);
        actualityList = new ArrayList<>();

        final ActualityAdapter actualityAdapter = new ActualityAdapter(getContext(), R.id.lv_actuality, actualityList);

        listViewActuality.setAdapter(actualityAdapter);

        actualityRepository.showActualityList(loginToken)
                .observe(this.getViewLifecycleOwner(), new Observer<List<Actuality>>() {

                    @Override
                    public void onChanged(List<Actuality> actualities) {
                        for (Actuality a : actualities) {
                            if (a.getPension().getUtilisateur().getId() == idUser)

                                actualityList.add(a);
                        }
                        actualityAdapter.notifyDataSetChanged();
                        Log.i("CallAPIactualityFrag", "onChanged: " + actualities.toString());

                    }
                });

        return view;
    }
}