package com.example.ojas.governanceapp;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ListView;

import com.manager.PlotManager;

//TODO implement the class lol
public class ViewPlotActivity extends AppCompatActivity {

    private ListView plotList;
    private ViewPlotAdapter plotAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_plot);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        plotList = (ListView) findViewById(R.id.listView_plots);

        PlotManager pm = new PlotManager(this);
        Cursor c = pm.getPlotsCursor();
        plotAdapter = new ViewPlotAdapter(this, c,0);

        plotList.setAdapter(plotAdapter);

    }

}
