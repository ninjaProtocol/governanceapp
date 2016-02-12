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
        TextView tvPlotCoordsLat = (TextView) view.findViewById(R.id.text_plotCoords_lat);
        TextView tvPlotCoordsLong = (TextView) view.findViewById(R.id.text_plotCoords_long);

        Long pid = cursor.getLong(cursor.getColumnIndexOrThrow("_id"));
        String name = cursor.getString(cursor.getColumnIndexOrThrow("NAME"));
        double lat = cursor.getDouble(cursor.getColumnIndexOrThrow("CP_COORD_LATITUDE"));
        double lon = cursor.getDouble(cursor.getColumnIndexOrThrow("CP_COORD_LONGITUDE"));
        cursor.moveToNext();
        //TODO stop the first item from repeating

        tvPlotID.setText(String.valueOf(pid));
        tvPlotName.setText(name);
        tvPlotCoordsLat.setText(String.valueOf(lat));
        tvPlotCoordsLong.setText(String.valueOf(lon));

    }
}
