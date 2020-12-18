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
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import Adapter.AnimalAdapter;
import Adapter.PensionAdapter;
import Modele.Pension;
import Repository.PensionRepository;

/**
 * A simple {@link Fragment} subclass.
 */
public class PensionFragment extends Fragment {

    final PensionRepository pensionRepository = new PensionRepository();
    List<Pension> pensionList;

    ListView listViewPension;

    public PensionFragment() {
        // Required empty public constructor
    }

    public static PensionFragment newInstance() {
        return (new PensionFragment());
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_pension, container, false);

        //Get back the token
        SharedPreferences loginUser = view.getContext().getSharedPreferences("user", Context.MODE_PRIVATE);

        String loginToken = loginUser.getString("loginKey","oui");
        Log.i("CallAPI", loginToken);
        final int idUser = loginUser.getInt("idKey",0);

        listViewPension = view.findViewById(R.id.lv_pension);
        pensionList = new ArrayList<>();

        final PensionAdapter adapter = new PensionAdapter(getContext(),R.id.lv_pension,pensionList);

        listViewPension.setAdapter(adapter);

        pensionRepository.showPensionList(loginToken)
                .observe(this.getViewLifecycleOwner(), new Observer<List<Pension>>() {

                    @Override
                    public void onChanged(List<Pension> pensions) {

                            for (Pension p : pensions) {
                                if (p.getUtilisateur().getId() == idUser)
                                    pensionList.add(p);
                            }
                            adapter.notifyDataSetChanged();
                            Log.i("CallAPIpensionFrag", "onChanged: " + pensions.toString());
                    }
                });

        return view;

    }
}