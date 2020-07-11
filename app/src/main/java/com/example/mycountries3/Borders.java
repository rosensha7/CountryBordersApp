package com.example.mycountries3;

import java.util.List;

public class Borders{
    private List<String> borders;

    public Borders(List<String> borders) {
        this.borders = borders;
    }

    public List<String> getBorders() {
        return borders;
    }

    public void setBorders(List<String> borders) {
        this.borders = borders;
    }
}