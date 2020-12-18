package com.helha.mobilejustdogit;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class ConfirmPassword extends AppCompatActivity {

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mdp_change);
        Button btn1 = (Button) findViewById(R.id.btn_mdp_quit);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ConfirmPassword.this.finish();

            }
        });

    }


}
