package com.example.ojas.governanceapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.d("TAG_SPLASH_MESSAGE", "SplashActivity onCreate starts now");

        //get handle to shared pref file to activity
        SharedPreferences sharedPreferences = this.getSharedPreferences(getString(R.string.prefFile_login),MODE_PRIVATE);

        //check if pref file contains "saveData" key, if yes then this isn't the first run of app
        //check in pref file whether user wants to be remembered (i.e. saveData is true)
        //check in pref file whether user is logged in
        if (sharedPreferences.contains(getString(R.string.prefFile_key_saveData)))
        {
            if (sharedPreferences.getBoolean(getString(R.string.prefFile_key_isUserLoggedIn),false)) {
                AuthenticateUser authenticatorObject = new AuthenticateUser(
                        sharedPreferences.getString(getString(R.string.prefFile_key_currentUser), ""),
                        sharedPreferences.getString(getString(R.string.prefFile_key_currentPassword), "")
                );

                switch (authenticatorObject.getErrorLevel()) {

                    case 0:
                        Log.d("TAG_AUTH_MESSAGE", "Login successful");
                        //proceed to user screen
                        Intent toWelcome = new Intent(SplashActivity.this, WelcomeActivity.class);
                        startActivity(toWelcome);
                        finish();
                        break;

                    case 1: //message - wrong password
                        Log.d("TAG_AUTH_EXCEPTION", "wrong password");
                        break;

                    case 2: //message - wrong email
                        Log.d("TAG_AUTH_MESSAGE", "wrong email ID");
                        break;

                    default: //message - exception, do nothing
                        Log.d("TAG_AUTH_EXCEPTION", "Authenticator threw an exception");
                }
            } else {

                Intent toLogin = new Intent(SplashActivity.this, LoginActivity.class);

                if (sharedPreferences.getBoolean(getString(R.string.prefFile_key_saveData), false)){
                    Log.d("TAG_SPLASH_MESSAGE","User data saved but user not logged in");
                    //proceed to login screen
                    startActivity(toLogin);
                    finish();
                } else {
                    //if you're here then that means that it's likely that the user didn't save data.
                    Log.d("TAG_SPLASH_MESSAGE","User hasn't saved data, possible new user");

                    //hold up for 3 seconds so that user sees splash
                    try {
                        synchronized (this) {
                            wait(3000);
                        }
                    } catch (Exception e){
                        Log.d("TAG_SPLASH_EXCEPTION","wait() threw an exception");
                    }
                    //proceed to login screen
                    startActivity(toLogin);
                    finish();
                }
            }
        } else{

            Log.d("TAG_SPLASH_MESSAGE","PrefFile likely doesn't exist");

            //init pref file
            Log.d("TAG_SPLASH_MESSAGE","Initialising sharedPreferences file");
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putBoolean(getString(R.string.prefFile_key_saveData), false);
            editor.putString(getString(R.string.prefFile_key_currentUser), "");
            editor.putString(getString(R.string.prefFile_key_currentPassword), "");
            editor.putString(getString(R.string.prefFile_key_savedUser), "");
            editor.putString(getString(R.string.prefFile_key_savedPassword), "");
            editor.putBoolean(getString(R.string.prefFile_key_isUserLoggedIn), false);
            if (editor.commit())
                Log.d("TAG_FILE_MESSAGE","Successfully wrote to pref file");
            else
                Log.d("TAG_FILE_ERROR","Could not commit to pref file");

            Intent toLogin = new Intent(SplashActivity.this, LoginActivity.class);
            startActivity(toLogin);
            finish();
        }
    }
}
