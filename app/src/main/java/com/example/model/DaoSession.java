package com.example.model;

import android.database.sqlite.SQLiteDatabase;

import java.util.Map;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.AbstractDaoSession;
import de.greenrobot.dao.identityscope.IdentityScopeType;
import de.greenrobot.dao.internal.DaoConfig;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see de.greenrobot.dao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig plotDaoConfig;
    private final DaoConfig aeqDaoConfig;

    private final PlotDao plotDao;
    private final aeqDao aeqDao;

    public DaoSession(SQLiteDatabase db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        plotDaoConfig = daoConfigMap.get(PlotDao.class).clone();
        plotDaoConfig.initIdentityScope(type);

        aeqDaoConfig = daoConfigMap.get(aeqDao.class).clone();
        aeqDaoConfig.initIdentityScope(type);

        plotDao = new PlotDao(plotDaoConfig, this);
        aeqDao = new aeqDao(aeqDaoConfig, this);

        registerDao(Plot.class, plotDao);
        registerDao(aeq.class, aeqDao);
    }
    
    public void clear() {
        plotDaoConfig.getIdentityScope().clear();
        aeqDaoConfig.getIdentityScope().clear();
    }

    public PlotDao getPlotDao() {
        return plotDao;
    }

    public aeqDao getAeqDao() {
        return aeqDao;
    }

}
