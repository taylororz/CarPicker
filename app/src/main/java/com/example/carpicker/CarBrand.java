package com.example.carpicker;

import java.util.ArrayList;

public class CarBrand {
    public ArrayList<String> getModels;
    String name;
    ArrayList<String> models = new ArrayList<>();

    public CarBrand(String n, ArrayList<String> m){
        name = n;
        models = m;
    }

    public void addModel(String m){
        models.add(m);
    }



    public ArrayList<String> getModels() {
        return models;
    }

    public boolean isBrand(String brand) {
        return name.equals(brand);
    }
}
