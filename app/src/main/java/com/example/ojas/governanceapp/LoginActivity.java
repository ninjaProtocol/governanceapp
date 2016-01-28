package com.example.ojas.governanceapp;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.content.Intent;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    public void onClickMethod (View view) {

        Context context = getApplicationContext();
        Toast toast;

        final EditText getEmailText = (EditText) findViewById(R.id.editText_email);
        String emailText = getEmailText.getText().toString();
        final EditText getPasswordText = (EditText) findViewById(R.id.editText_password);
        String passwordText = getPasswordText.getText().toString();

        AuthenticateUser authenticatorObject = new AuthenticateUser(emailText,passwordText);

        switch (authenticatorObject.getErrorLevel()) {

            case 0:
                Intent I = new Intent(this, WelcomeActivity.class); //proceed to user screen
                startActivity(I);
                finish();
                break;

            case 1: //message - wrong password
                Log.d("TAG__AUTH_EXCEPTION", "wrong password");
                toast = Toast.makeText(context,"Wrong Password",Toast.LENGTH_LONG);
                toast.show();
                break;

            case 2: //message - wrong email
                Log.d("TAG_AUTH_MESSAGE", "wrong email ID");
                toast = Toast.makeText(context,"Wrong Email ID",Toast.LENGTH_LONG);
                toast.show();
                break;

            default: //message - exception, do nothing
                Log.d("TAG_AUTH_EXCEPTION", "Authenticator threw an exception");
        }
    }
}