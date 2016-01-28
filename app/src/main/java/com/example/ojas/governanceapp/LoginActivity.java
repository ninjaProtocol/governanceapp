package com.example.ojas.governanceapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.content.Intent;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    public void onClickMethod (View view) {

        final EditText getEmailText = (EditText) findViewById(R.id.id_editText_email);
        String emailText = getEmailText.getText().toString();
        final EditText getPasswordText = (EditText) findViewById(R.id.id_editText_password);
        String passwordText = getPasswordText.getText().toString();

        AuthenticateUser authenticatorObject = new AuthenticateUser(emailText,passwordText);

        switch (authenticatorObject.getErrorLevel()) {

            case 0: Intent I = new Intent(this,WelcomeActivity.class); //proceed to user screen
                    startActivity(I);
                    break;

            case 1: //message - wrong password
                    break;

            case 2: //message - wrong email
                    break;

            default: //message - exception, do nothing
        }
    }
}