package com.example.model;

import de.greenrobot.dao.DaoException;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 
/**
 * Entity mapped to table "AEQ".
 */
public class aeq {

    private Long id;
    private String name;
    private String region;
    private String species;
    private Boolean volumetric;
    private Long plotID;

    /** Used to resolve relations */
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    private transient aeqDao myDao;

    private Plot plot;
    private Long plot__resolvedKey;


    public aeq() {
    }

    public aeq(Long id) {
        this.id = id;
    }

    public aeq(Long id, String name, String region, String species, Boolean volumetric, Long plotID) {
        this.id = id;
        this.name = name;
        this.region = region;
        this.species = species;
        this.volumetric = volumetric;
        this.plotID = plotID;
    }

    /** called by internal mechanisms, do not call yourself. */
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getAeqDao() : null;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public Boolean getVolumetric() {
        return volumetric;
    }

    public void setVolumetric(Boolean volumetric) {
        this.volumetric = volumetric;
    }

    public Long getPlotID() {
        return plotID;
    }

    public void setPlotID(Long plotID) {
        this.plotID = plotID;
    }

    /** To-one relationship, resolved on first access. */
    public Plot getPlot() {
        Long __key = this.plotID;
        if (plot__resolvedKey == null || !plot__resolvedKey.equals(__key)) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            PlotDao targetDao = daoSession.getPlotDao();
            Plot plotNew = targetDao.load(__key);
            synchronized (this) {
                plot = plotNew;
            	plot__resolvedKey = __key;
            }
        }
        return plot;
    }

    public void setPlot(Plot plot) {
        synchronized (this) {
            this.plot = plot;
            plotID = plot == null ? null : plot.getId();
            plot__resolvedKey = plotID;
        }
    }

    /** Convenient call for {@link AbstractDao#delete(Object)}. Entity must attached to an entity context. */
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }    
        myDao.delete(this);
    }

    /** Convenient call for {@link AbstractDao#update(Object)}. Entity must attached to an entity context. */
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }    
        myDao.update(this);
    }

    /** Convenient call for {@link AbstractDao#refresh(Object)}. Entity must attached to an entity context. */
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }    
        myDao.refresh(this);
    }

}
