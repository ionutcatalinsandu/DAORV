package com.example.torridas.daorv.utility;

import android.app.Application;
import android.content.Context;

import com.example.torridas.daorv.city.model.DaoMaster;
import com.example.torridas.daorv.city.model.DaoSession;

import org.greenrobot.greendao.database.Database;

/**
 * Created by Torridas on 10-Jul-17.
 */

public class Connections {
    private static Connections ourInstance;

    private DaoMaster.DevOpenHelper helper;
    private Database db;
    private DaoSession daoSession;

    public DaoSession getDaoSession() {
        return daoSession;
    }

    public static synchronized Connections getInstance(Context context) {

        if( ourInstance == null){
            ourInstance = new Connections(context);
        }
        return ourInstance;
    }

    public static synchronized Connections getInstance() {
        if( ourInstance != null )
            return ourInstance;
        else
            return null;
    }

    private Connections(Context context) {
        helper =  new DaoMaster.DevOpenHelper(context, "db_locations");
        db = helper.getWritableDb();
        daoSession = new DaoMaster(db).newSession();
    }
}
