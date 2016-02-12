package com.example.testdata;

import android.content.Context;

import com.example.model.Plot;
import com.manager.PlotManager;

/**
 * Created by ojas on 11-Feb-16.
 */
public class TestData {

    public void createData(Context context){
        Plot plot1 = new Plot();

        plot1.setName("Plot A");


        PlotManager pm = new PlotManager(context);
        pm.addPlot(plot1);
    }
}
