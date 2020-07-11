package com.example.mycountries3;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

@Entity(tableName = "country_table")
public class CountryDbEntity {

    private String name;

    @PrimaryKey
    @NonNull
    private String alpha3Code;
    private int population;
    private double area;
    private String nativeName;
    private String flag;

    @TypeConverters(BorderConverter.class)
    private Borders borders;

    public CountryDbEntity() {

    }

    public CountryDbEntity(CountryWebEntity web) {
        name = web.getName();
        alpha3Code = web.getAlpha3Code();
        population = web.getPopulation();
        area = web.getArea();
        nativeName = web.getNativeName();
        flag = web.getFlag();
        borders = new Borders(web.getBorders());
    }

    public String getName() {
        return name;
    }

    public String getAlpha3Code() {
        return alpha3Code;
    }

    public int getPopulation() {
        return population;
    }

    public double getArea() {
        return area;
    }

    public String getNativeName() {
        return nativeName;
    }

    public String getFlag() {
        return flag;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setAlpha3Code(String alpha3Code) {
        this.alpha3Code = alpha3Code;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public void setNativeName(String nativeName) {
        this.nativeName = nativeName;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }


    public Borders getBorders() {
        return borders;
    }

    public void setBorders(Borders borders) {
        this.borders = borders;
    }




}
