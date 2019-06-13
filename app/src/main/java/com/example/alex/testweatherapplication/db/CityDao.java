package com.example.alex.testweatherapplication.db;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;

import java.util.List;

import retrofit2.http.Query;

@Dao
public interface CityDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(CityEntity city);

    // TODO: 13.06.2019  
//    @Query("SELECT * from city_table")
    List<CityEntity> getAllCities();
}
