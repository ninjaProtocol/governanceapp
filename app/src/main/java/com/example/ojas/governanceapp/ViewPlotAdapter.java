package com.example.ojas.governanceapp;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Ojas on 02-02-2016.
 */
public class ViewPlotAdapter extends CursorAdapter {

    public ViewPlotAdapter(Context context, Cursor cursor, int flags) {
        super(context, cursor, 0);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.plot_row_item,parent,false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        ImageView ivPlotImage = (ImageView) view.findViewById(R.id.imageView_plotImage);
        TextView tvPlotID = (TextView) view.findViewById(R.id.text_plotID);
        TextView tvPlotName = (TextView) view.findViewById(R.id.text_plotName);
        TextView tvPlotCoords = (TextView) view.findViewById(R.id.text_plotCoords);

        String pid = cursor.getString(cursor.getColumnIndexOrThrow("id"));
        String name = cursor.getString(cursor.getColumnIndexOrThrow("name"));
        String coords = cursor.getString(cursor.getColumnIndexOrThrow("Coordinates")); //TODO figure out how to handle an array

        tvPlotID.setText(pid);
        tvPlotName.setText(name);
        tvPlotCoords.setText(coords);
    }
}
