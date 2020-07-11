package com.example.mycountries3;

import java.util.ArrayList;
import java.util.List;

public class Converter {
    public static List<CountryDbEntity> convertWebToDb(List<CountryWebEntity> webs){
        List<CountryDbEntity> dbs = new ArrayList<>();
        for (CountryWebEntity web : webs) {
            CountryDbEntity db = new CountryDbEntity(web);
            dbs.add(db);
        }

        return dbs;
    }
}
