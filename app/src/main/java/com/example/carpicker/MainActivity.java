package com.example.carpicker;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RadioGroup rg;
    CarBrandList cbList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rg = findViewById(R.id.carModel);
        cbList = new CarBrandList();
    }

        public void pickBrand(View view){
           Spinner dropDown = findViewById((R.id.carBrand));
           String selectedBrand = String.valueOf(dropDown.getSelectedItem());
           ArrayList<String> models = cbList.getModels(selectedBrand);

           System.out.println(selectedBrand);
           System.out.println(models);


            if(models.isEmpty()){
                Toast.makeText(getApplicationContext(), R.string.toast_no_cars,Toast.LENGTH_LONG).show();
            }else {
                rg.removeAllViews();
                createRadioButtons(rg, models);
                rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                        RadioButton selected = findViewById(checkedId);
                        Toast.makeText(getApplicationContext(), selectedBrand + " " + selected.getText(),Toast.LENGTH_LONG).show();
                    }
                });
            }
        }

        public void createRadioButtons(RadioGroup rg, List<String> modelList){

            for(int i=0; i<modelList.size(); i++){
                RadioButton rb = new RadioButton(this);
                rb.setText(modelList.get(i));
                rb.setId(100+i);
                rg.addView(rb);
            }
        }
    }
