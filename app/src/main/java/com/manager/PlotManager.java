package com.manager;

import android.content.Context;
import android.database.Cursor;

import com.example.model.DaoSession;
import com.example.model.Plot;
import com.example.model.PlotDao;

import java.util.List;

/**
 * Created by ojas on 11-Feb-16.
 */
public class PlotManager extends BaseManager {

    private Context mContext;

    public PlotManager(Context context) {
        super();
        mContext = context;
    }

    public void addPlot(Plot plot){
        DaoSession daoSession = getDBSessoin(mContext);
        PlotDao plotDao = daoSession.getPlotDao();
        plotDao.insertOrReplace(plot);
        daoSession.getDatabase().close();
    }

    public List<Plot> getPlot(Plot plot){
        DaoSession daoSession = getDBSessoin(mContext);
        PlotDao plotDao = daoSession.getPlotDao();
        try {
            List<Plot> plotList = null;
            plotList = plotDao.loadAll();
            return plotList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            plotDao.getDatabase().close();
        }
    }

    public Cursor getPlotsCursor(){
        DaoSession daoSession = getDBSessoin(mContext);
        PlotDao plotDao = daoSession.getPlotDao();
        String plotSelectQuery = "Select * from Plot;";

        Cursor c = daoSession.getDatabase().rawQuery(plotSelectQuery,null);
        return c;

    }
}
