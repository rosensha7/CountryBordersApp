package com.example.mycountries3;

import java.util.List;

public class CountryWebEntity {

    private String name;

    private String alpha3Code;
    private int population;
    private double area;
    private String nativeName;
    private String flag;
    private List<String> borders;

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

    public List<String> getBorders() {
        return borders;
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

    public void setBorders(List<String> borders) {
        this.borders = borders;
    }

}
