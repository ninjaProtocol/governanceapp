package com.example.ojas.governanceapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.content.Intent;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.d("TAG_LOGIN_MESSAGE", "LoginActivity onCreate starts now");

        setContentView(R.layout.activity_login);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        SharedPreferences sharedPreferences = this.getSharedPreferences(getString(R.string.prefFile_login), MODE_PRIVATE);
        final CheckBox checkBox = (CheckBox) findViewById(R.id.checkBox_remember);
        final EditText emailHint = (EditText) findViewById(R.id.editText_email);
        final EditText passwordHint = (EditText) findViewById(R.id.editText_password);

        //setCheckbox state
        if (sharedPreferences.getBoolean(getString(R.string.prefFile_key_saveData),true)){
            checkBox.setChecked(true);
            emailHint.setHint(sharedPreferences.getString("savedUser",""));
            passwordHint.setHint("********");
        } else {
            checkBox.setChecked(false);
        }
    }

    private void handoffMethod (String email, String password) {

        SharedPreferences sharedPreferences = this.getSharedPreferences(getString(R.string.prefFile_login), MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        final CheckBox checkBox = (CheckBox) findViewById(R.id.checkBox_remember);

        //update user data
        editor.putBoolean(getString(R.string.prefFile_key_isUserLoggedIn), true);
        editor.putString(getString(R.string.prefFile_key_currentUser), email);
        editor.putString(getString(R.string.prefFile_key_currentPassword), password);
        if (checkBox.isChecked()) {
            Log.d("TAG_LOGIN_MESSAGE", "Checkbox is checked, saving user data");
            editor.putString(getString(R.string.prefFile_key_savedUser), email);
            editor.putString(getString(R.string.prefFile_key_savedPassword), password);
            editor.putBoolean(getString(R.string.prefFile_key_saveData), true);
        } else {
            editor.putBoolean(getString(R.string.prefFile_key_saveData), false);
            editor.putString(getString(R.string.prefFile_key_savedUser), "");
            editor.putString(getString(R.string.prefFile_key_savedPassword), "");
        }
        if (editor.commit())
            Log.d("TAG_FILE_MESSAGE","Successfully wrote to pref file");
        else
            Log.d("TAG_FILE_ERROR","Could not commit to pref file");

        Intent I = new Intent(this, WelcomeActivity.class); //proceed to user screen
        startActivity(I);
        finish();
    }

    public void onClickMethod (View view) {

        Context context = getApplicationContext();
        Toast toast;
        SharedPreferences sharedPreferences = this.getSharedPreferences(getString(R.string.prefFile_login), MODE_PRIVATE);

        String emailText, passwordText;

        if (sharedPreferences.getBoolean(getString(R.string.prefFile_key_saveData),true)){

            emailText = sharedPreferences.getString(getString(R.string.prefFile_key_savedUser),"");
            passwordText = sharedPreferences.getString(getString(R.string.prefFile_key_savedPassword),"");

        } else {

            final EditText getEmailText = (EditText) findViewById(R.id.editText_email);
            emailText = getEmailText.getText().toString();
            final EditText getPasswordText = (EditText) findViewById(R.id.editText_password);
            passwordText = getPasswordText.getText().toString();
        }

        AuthenticateUser authenticatorObject = new AuthenticateUser(emailText,passwordText);

        switch (authenticatorObject.getErrorLevel()) {

            case 0:
                Log.d("TAG_AUTH_MESSAGE", "Login successful");
                handoffMethod(emailText, passwordText);
                break;

            case 1: //message - wrong password
                Log.d("TAG_AUTH_EXCEPTION", "wrong password");
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