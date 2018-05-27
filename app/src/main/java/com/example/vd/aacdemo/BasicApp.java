package com.example.vd.aacdemo;

import android.app.Application;

import com.example.vd.aacdemo.db.AppDatabase;

public class BasicApp extends Application {

    private static BasicApp singleton;

    public static BasicApp getInstance(){
        return singleton;
    }
    @Override
    public void onCreate() {
        super.onCreate();
        singleton = this;
    }

    public AppDatabase getDatabase() {
        return AppDatabase.getInstance(this);
    }

}
