package com.example.torridas.daorv.city.model;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.ToOne;
import org.greenrobot.greendao.DaoException;

/**
 * Created by Torridas on 10-Jul-17.
 */

@Entity
public class City {
    @Id(autoincrement = true )
    private Long id;

    private String name;

    @NotNull
    private Long countryOfProvenience;

    @ToOne(joinProperty = "countryOfProvenience")
    private City city;

    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    @Generated(hash = 448079911)
    private transient CityDao myDao;

    @Generated(hash = 1696970556)
    private transient Long city__resolvedKey;



    @Generated(hash = 1613983339)
    public City(Long id, String name, @NotNull Long countryOfProvenience) {
        this.id = id;
        this.name = name;
        this.countryOfProvenience = countryOfProvenience;
    }

    @Generated(hash = 750791287)
    public City() {
    }



    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Long getCountryOfProvenience() {
        return countryOfProvenience;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCountryOfProvenience(Long countryOfProvenience) {
        this.countryOfProvenience = countryOfProvenience;
    }

    /** To-one relationship, resolved on first access. */
    @Generated(hash = 1670801278)
    public City getCity() {
        Long __key = this.countryOfProvenience;
        if (city__resolvedKey == null || !city__resolvedKey.equals(__key)) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            CityDao targetDao = daoSession.getCityDao();
            City cityNew = targetDao.load(__key);
            synchronized (this) {
                city = cityNew;
                city__resolvedKey = __key;
            }
        }
        return city;
    }

    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 935631132)
    public void setCity(@NotNull City city) {
        if (city == null) {
            throw new DaoException(
                    "To-one property 'countryOfProvenience' has not-null constraint; cannot set to-one to null");
        }
        synchronized (this) {
            this.city = city;
            countryOfProvenience = city.getId();
            city__resolvedKey = countryOfProvenience;
        }
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#delete(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 128553479)
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.delete(this);
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#refresh(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 1942392019)
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.refresh(this);
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#update(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 713229351)
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.update(this);
    }

    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 293508440)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getCityDao() : null;
    }
}
