package com.example.vd.aacdemo.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.example.vd.aacdemo.db.dao.CurrencyDao;
import com.example.vd.aacdemo.model.Currency;

@Database(entities = {Currency.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    private static AppDatabase sInstance;

    //Visible for testing purposes
    public static final String DATABASE_NAME = "basic-db";

    public abstract CurrencyDao currencyDao();

    public static AppDatabase getInstance(Context context) {
        if (sInstance == null) {
            synchronized (AppDatabase.class) {
                if (sInstance == null) {
                    sInstance = buildDatabase(context);
                }
            }
        }
        return sInstance;
    }

    private static AppDatabase buildDatabase(Context context) {
        return Room.databaseBuilder(context.getApplicationContext(),
                AppDatabase.class, DATABASE_NAME).fallbackToDestructiveMigration().build();
    }

}
