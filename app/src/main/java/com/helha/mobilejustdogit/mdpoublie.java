package com.helha.mobilejustdogit;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import Repository.AuthentificateRepository;


public class mdpoublie extends AppCompatActivity implements View.OnClickListener {
    final AuthentificateRepository authentificateRepository = new AuthentificateRepository();
    EditText email;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mdp_oublie_activite);
        EditText email = findViewById(R.id.Mdp_oublie_email);

        Button btn1 = (Button) findViewById(R.id.btn_suivant);
        ImageView back = (ImageView) findViewById(R.id.back_mdpOublie);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), ChangePassword.class);
                startActivity(i);
                mdpoublie.this.finish();
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mdpoublie.this.finish();
            }
        });
    }


    @Override
    public void onClick(View view) {

        /*authentificateRepository.checkUtil(email.getText().toString(),password.getText().toString()).observe(getViewLifecycleOwner(), new Observer<Utilisateur>() {
            @Override
            public void onChanged(Utilisateur utilisateur) {

            }*/
    }
}
