package com.example.vd.aacdemo.db.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.vd.aacdemo.model.Currency;

import java.util.List;

import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

@Dao
public interface CurrencyDao {

    @Insert(onConflict = REPLACE)
    void save(Currency user);

    @Query("SELECT * FROM currency")
    LiveData<List<Currency>> loadAll();

}
