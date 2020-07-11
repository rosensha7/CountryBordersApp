package com.example.mycountries3;

import androidx.room.TypeConverter;

import java.util.Arrays;
import java.util.List;

public class BorderConverter {
    @TypeConverter
    public static String toString(Borders borders) {
        String ans ="";
        List<String> lst = borders.getBorders();
        for (String border:
        lst) {
            ans = ans + "__" + border;
        }

        return ans;
    }

    @TypeConverter
    public static Borders toBorders(String str){
        List<String> items = Arrays.asList(str.split("__"));
        Borders borders = new Borders(items);
        return borders;
    }

}
