package com.helha.mobilejustdogit;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.helha.mobilejustdogit.R;

public class ChangePassword  extends AppCompatActivity {

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_mdp);
        Button btn1 = (Button)findViewById(R.id.btn_mdp_confirm);
        ImageView back = (ImageView) findViewById(R.id.back_mdpNewcoord);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent i = new Intent(v.getContext(), ConfirmPassword.class);
                startActivity(i);
                ChangePassword.this.finish();
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent i = new Intent(v.getContext(), mdpoublie.class);
                startActivity(i);
            }
        });
    }
}
