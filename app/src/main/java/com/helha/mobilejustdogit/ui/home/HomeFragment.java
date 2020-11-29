package com.helha.mobilejustdogit.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.helha.mobilejustdogit.AdoptionFragment;
import com.helha.mobilejustdogit.PensionFragment;
import com.helha.mobilejustdogit.R;

public class HomeFragment extends Fragment implements View.OnClickListener {

    private HomeViewModel homeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        homeViewModel = ViewModelProviders.of(this).get(HomeViewModel.class);

        View root = inflater.inflate(R.layout.fragment_home, container, false);

        final TextView textView = root.findViewById(R.id.txt_title_home);
        final Button btn_goToAdoption = (Button) root.findViewById(R.id.btn_home_goAdoption);
        final Button btn_goToPension = (Button) root.findViewById(R.id.btn_home_goPension);

        btn_goToAdoption.setOnClickListener(this);
        btn_goToPension.setOnClickListener(this);

        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) { textView.setText(s); }
        });

        return root;
    }

    @Override
    public void onClick(View v) {
        Fragment fragment = null;

        switch (v.getId()) {
            case R.id.btn_home_goAdoption :
                fragment = new AdoptionFragment();
                replaceFragment(fragment);
                break;
            case R.id.btn_home_goPension :
                fragment = new PensionFragment();
                replaceFragment(fragment);
                break;
        }
    }

    private void replaceFragment(Fragment fragment) {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.nav_host_fragment, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}