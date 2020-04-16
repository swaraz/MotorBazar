
package com.example.motorbazar.AddingItemsPackage;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.motorbazar.R;

public class AddingVehicle extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Button nxt_btn;

    String [] category = {"-----SELECT CATEGORY----","Cars", "Bikes"};
    String [] brand = {"-----SELECT BRAND----","Yamaha", "Hero","Bajaj","Benelli"};
    String [] model = {"-----SELECT MODEL----","R15 V3", "FZ-25","Pulsar NS","Gixer"};
    String [] engine = {"-----SELECT ENGINE----","100", "125","150","155","180","200","220","250","300"};
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.adding_vehicle);
        uiInitialize();
        onNextPressed();
        //Getting the instance of Spinner and applying OnItemSelectedListener on it
        Spinner spin_category = (Spinner) findViewById(R.id.spinner_category);
        spin_category.setOnItemSelectedListener(this);
        Spinner spin_brand = (Spinner) findViewById(R.id.spinner_brand);
        spin_brand.setOnItemSelectedListener(this);
        Spinner spin_model = (Spinner) findViewById(R.id.spinner_model);
        spin_model.setOnItemSelectedListener(this);
        Spinner spin_engine = (Spinner) findViewById(R.id.spinner_engine);
        spin_engine.setOnItemSelectedListener(this);
        //Creating the ArrayAdapter instance having the category name list
        ArrayAdapter ca = new ArrayAdapter(this,android.R.layout.simple_spinner_item,category);
        ca.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        spin_category.setAdapter(ca);
        //Creating the ArrayAdapter instance having the category name list
        ArrayAdapter ba = new ArrayAdapter(this,android.R.layout.simple_spinner_item,brand);
        ba.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        spin_brand.setAdapter(ba);
        ArrayAdapter ma = new ArrayAdapter(this,android.R.layout.simple_spinner_item,model);
        ma.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin_model.setAdapter(ma);
        ArrayAdapter ea = new ArrayAdapter(this,android.R.layout.simple_spinner_item,engine);
        ea.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin_engine.setAdapter(ea);
        String category = spin_category.getSelectedItem().toString();
    }
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
//        if (i>0){
//        Toast.makeText(getApplicationContext(), category[i], Toast.LENGTH_LONG).show();
//        }
    }
    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
    public void uiInitialize(){
        nxt_btn = findViewById(R.id.next);
    }
    public void onNextPressed(){
        nxt_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AddingVehicle.this,AddingPhoto.class));
            }
        });
    }
}
