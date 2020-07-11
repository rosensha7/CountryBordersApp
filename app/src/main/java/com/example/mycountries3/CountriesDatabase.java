package com.example.mycountries3;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


@Database(entities = {CountryDbEntity.class}, version = 1, exportSchema = false)
public abstract class CountriesDatabase extends RoomDatabase {

    public abstract CountryDao countryDao();

    private static CountriesDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = 1;
    public static final ExecutorService executor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    public static CountriesDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (CountriesDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            CountriesDatabase.class, "countries_database")
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}


