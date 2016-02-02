package com.example.ojas.governanceapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.d("TAG_WELCOME_MESSAGE", "WelcomeActivity onCreate starts now");

        setContentView(R.layout.activity_welcome);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    public void onClickLogoutMethod (View view) {

        Log.d("TAG_LOGOUT_MESSAGE", "User logging out, noting in prefFile");
        SharedPreferences sharedPreferences = this.getSharedPreferences(getString(R.string.prefFile_login), MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putBoolean(getString(R.string.prefFile_key_isUserLoggedIn), false);
        editor.putString(getString(R.string.prefFile_key_currentUser), "");
        editor.putString(getString(R.string.prefFile_key_currentPassword), "");

        if (editor.commit())
            Log.d("TAG_FILE_MESSAGE", "Successfully wrote to pref file");
        else
            Log.d("TAG_FILE_ERROR","Could not commit to pref file");

        Intent I = new Intent(this,LoginActivity.class);
        startActivity(I);
        finish();
    }

    public void onClickViewPlots (View view) {
        Intent I = new Intent(this,ViewPlotActivity.class);
        startActivity(I);
        finish();
    }

    public void onClickAddPlot (View view) {

    }
}
