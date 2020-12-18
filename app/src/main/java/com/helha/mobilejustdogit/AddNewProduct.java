package com.helha.mobilejustdogit;

import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;


public class AddNewProduct extends AppCompatActivity {


    private String Nom_categorie;
    private Button AJouterAnimal, Annuler;
    private EditText Description_animal, couleur_animal, race_animal, nom_animal, datenaiss_animal;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_animal);

        AJouterAnimal = (Button) findViewById(R.id.buttonSave);
        Annuler = (Button) findViewById(R.id.btn_annuler);
        Description_animal = (EditText) findViewById(R.id.Description_animal);
        couleur_animal = (EditText) findViewById(R.id.Couleur_animal);
        race_animal = (EditText) findViewById(R.id.Race_animal);
        nom_animal = (EditText) findViewById(R.id.Nom_animal);
        datenaiss_animal = (EditText) findViewById(R.id.DateNaiss);

    }

}

