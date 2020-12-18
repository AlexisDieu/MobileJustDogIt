package com.helha.mobilejustdogit;

import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import Adapter.AnimalAdapter;
import Modele.Animal;
import Modele.Utilisateur;
import Repository.AnimalRepository;
import Repository.CreateUserRepository;

/**
 * A simple {@link Fragment} subclass.
 */
public class AdoptionFragment extends Fragment {


    final AnimalRepository animalRepository = new AnimalRepository();
    List<Animal> animals;
    ListView listAnimal;

    public AdoptionFragment() {
        // Required empty public constructor
    }

    public static AdoptionFragment newInstance() {
        return (new AdoptionFragment());
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_adoption, container, false);

        listAnimal = root.findViewById(R.id.lv_animal);
        animals = new ArrayList<>();

        final AnimalAdapter adapter = new AnimalAdapter(getContext(), R.id.lv_animal, animals);
        listAnimal.setAdapter(adapter);


        animalRepository.showAnimalList()
                .observe(this.getViewLifecycleOwner(), new Observer<List<Animal>>() {

                    @Override
                    public void onChanged(List<Animal> animal) {
                        animals.addAll(animal);
                        Log.i("CallAPIanimal", "onChanged: " + animals.toString());
                        adapter.notifyDataSetChanged();
                    }
                });

        return root;

    }
}