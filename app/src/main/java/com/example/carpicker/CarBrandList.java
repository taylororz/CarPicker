package com.example.carpicker;

import java.util.ArrayList;

public class CarBrandList {
    ArrayList<CarBrand> cbList = new ArrayList<>();

    public CarBrandList(){
        cbList.add(new CarBrand("Toyota", new ArrayList<>()));
        cbList.add(new CarBrand("VW", new ArrayList<>()));
        cbList.add(new CarBrand("Nissan", new ArrayList<>()));

        addModel("Toyota","Yaris");
        addModel("Toyota","Auris");
        addModel("Toyota","RAV14");

        addModel("VW","Golf");
        addModel("VW","Polo");
    }

    public void addModel(String brand, String model){
        for (int i = 0; i<cbList.size(); i++){
            if(cbList.get(i).isBrand(brand))
                cbList.get(i).addModel(model);
        }
    }

    public ArrayList<String> getModels(String s) {
        ArrayList<String> models = new ArrayList<>();
        for (int i = 0; i < cbList.size(); i++) {
            if (cbList.get(i).isBrand(s)) {
                models = cbList.get(i).getModels();
                break;
            }
        }
        return models;

    }

}


