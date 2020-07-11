package com.example.mycountries3;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CountryApiService {

    @GET("all")
    Call<List<CountryWebEntity>> getCountries();

}
