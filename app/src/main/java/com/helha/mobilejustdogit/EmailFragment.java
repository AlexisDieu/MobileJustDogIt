package com.helha.mobilejustdogit;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class EmailFragment extends AppCompatActivity {

    private TextView mEditTextA;
    private EditText mEditTextSujet;
    private EditText mEditTextMessage;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_email);

        mEditTextA = findViewById(R.id.email_TextDe);
        mEditTextSujet = findViewById(R.id.email_Sujet);
        mEditTextMessage = findViewById(R.id.edit_Texte_Message);
        Button buttonEnvoyer = findViewById(R.id.button_Envoyer);
        buttonEnvoyer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendMail();
            }
        });
    }

    private void sendMail() {
        String List = mEditTextA.getText().toString();
        String[] elements = List.split(",");

        String sujet = mEditTextSujet.getText().toString();
        String message = mEditTextMessage.getText().toString();

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_EMAIL, elements);
        intent.putExtra(Intent.EXTRA_SUBJECT, sujet);
        intent.putExtra(Intent.EXTRA_TEXT, message);

        intent.setType("message/rfc822");
        startActivity(Intent.createChooser(intent, "choisir l'email du client"));


    }
}
