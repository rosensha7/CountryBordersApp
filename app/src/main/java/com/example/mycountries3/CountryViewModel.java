package com.example.mycountries3;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

import java.util.List;

public class CountryViewModel extends ViewModel {

    enum Sort
    {
        NAME, POPULATION, AREA;
    }

    private Repository repository;

    private MutableLiveData<Sort> sortLive = new MutableLiveData<>();

    private LiveData<List<CountryDbEntity>> switchLiveData;

    public LiveData<List<CountryDbEntity>> getCountries() {
        return switchLiveData;
    }

    public void setContext(Context context) {
        repository = new Repository(context);

        sortLive.setValue(Sort.NAME);

        switchLiveData = Transformations.switchMap(sortLive, (sort) -> {
            if (sort == Sort.NAME) {
                return repository.getCountries();
            } else if (sort == Sort.POPULATION) {
                return repository.getSortByPopulation();
            } else {//AREA
                return repository.getSortByArea();
            }
        });
    }

    public void sortByPopulation() {
        sortLive.setValue(Sort.POPULATION);
    }

    public void sortByName() {
        sortLive.setValue(Sort.NAME);
    }

    public void sortByArea() {
        sortLive.setValue(Sort.AREA);
    }

}
