package com.example.mycountries3;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface CountryDao {

    @Query("select * from country_table")
    LiveData<List<CountryDbEntity>> getCounties();

    @Query("select * from country_table order by population desc")
    LiveData<List<CountryDbEntity>> getCountiesSortedByPopulation();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<CountryDbEntity> countries);

    @Query("select * from country_table WHERE borders LIKE '%' || :alpha3 || '%' ")
    LiveData<List<CountryDbEntity>> getNeighbours(String alpha3);

    @Query("select * from country_table order by area desc")
    LiveData<List<CountryDbEntity>> getCountriesSortedByAreaDesc();
}
