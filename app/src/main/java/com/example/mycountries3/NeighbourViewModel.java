package com.example.mycountries3;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;


public class NeighbourViewModel extends ViewModel {
    private Context context;
    private Repository repository;

    public void setContext(Context context) {
        this.context = context;

        repository = new Repository(context);
    }

    public LiveData<List<CountryDbEntity>> getNeighbours(String alpha3){
        LiveData<List<CountryDbEntity>> neighbours = repository.getNeighbours(alpha3);
        return neighbours;
    }

}
