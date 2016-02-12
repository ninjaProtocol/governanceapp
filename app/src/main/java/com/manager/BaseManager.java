package com.manager;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.model.DaoMaster;
import com.example.model.DaoSession;

public class BaseManager {

    public static final String LOG_TAG = "BaseManager";

    public static DaoSession getDBSessoin(Context context) {
        long startTime = System.currentTimeMillis();
        if (context != null) {
            DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(context, "governance.sqlite", null);
            SQLiteDatabase db = helper.getWritableDatabase();
            DaoMaster daoMaster = new DaoMaster(db);
            DaoSession daoSession = daoMaster.newSession();
            if (daoSession != null) {
                return daoSession;
            } else {
                Log.i(LOG_TAG, "getDBSessoin:  - Application context is null");
                return null;
            }
        }
        Log.i(LOG_TAG,"getDBSessoin: Execution time - "+(System.currentTimeMillis() - startTime));
        return null;
    }

    public void closeDatabase(Context context) {
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(
                context, "governance.sqlite", null);
        helper.close();
    }

}

