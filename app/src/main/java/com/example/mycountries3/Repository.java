package com.example.mycountries3;

import android.content.Context;

import androidx.lifecycle.LiveData;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.mycountries3.Converter.convertWebToDb;


public class Repository {

    private final CountryDao dao;

    public LiveData<List<CountryDbEntity>> getSortByPopulation() {
        return dao.getCountiesSortedByPopulation();
    }

    public LiveData<List<CountryDbEntity>> getSortByArea() {
        return dao.getCountriesSortedByAreaDesc();
    }

    public LiveData<List<CountryDbEntity>> getCountries() {
        return dao.getCounties();
    }

    public Repository(Context context) {
        CountriesDatabase db = CountriesDatabase.getDatabase(context);
        dao = db.countryDao();

        refreshData();
    }

    private void refreshData() {
        CountryApiService service = RetrofitInstance.getRetrofitInstance().create(CountryApiService.class);
        Call<List<CountryWebEntity>> call = service.getCountries();

        call.enqueue(new Callback<List<CountryWebEntity>>() {
            @Override
            public void onResponse(Call<List<CountryWebEntity>> call, Response<List<CountryWebEntity>> response) {
                insert(response.body());
            }

            @Override
            public void onFailure(Call<List<CountryWebEntity>> call, Throwable t) {

            }
        });
    }

    private void insert(List<CountryWebEntity> webCountries) {
        List<CountryDbEntity> dbCountries = convertWebToDb(webCountries);
        CountriesDatabase.executor.execute(() -> {
            dao.insertAll(dbCountries);
        });
    }

    public LiveData<List<CountryDbEntity>> getNeighbours(String alpha3) {
        return dao.getNeighbours(alpha3);
    }
}
