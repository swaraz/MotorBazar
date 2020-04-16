
package com.example.motorbazar.AddingItemsPackage;

import android.content.Intent;
import android.graphics.ColorSpace;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.motorbazar.R;
import com.example.motorbazar.model.VehicleCategory;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AddingVehicle extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Button nxt_btn;

    List<String> categoryList = new ArrayList<String>();
    String [] brand = {"-----SELECT BRAND----","Yamaha", "Hero","Bajaj","Benelli"};
    String [] model = {"-----SELECT MODEL----","R15 V3", "FZ-25","Pulsar NS","Gixer"};
    String [] engine = {"-----SELECT ENGINE----","100", "125","150","155","180","200","220","250","300"};
    private List<VehicleCategory> vehicleCategoryList = new ArrayList<>();

    private Spinner spinnerCategory;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.adding_vehicle);
        uiInitialize();
        onNextPressed();
        //Getting the instance of Spinner and applying OnItemSelectedListener on it
        spinnerCategory = (Spinner) findViewById(R.id.spinner_category);
        spinnerCategory.setOnItemSelectedListener(this);
        Spinner spin_brand = (Spinner) findViewById(R.id.spinner_brand);
        spin_brand.setOnItemSelectedListener(this);
        Spinner spin_model = (Spinner) findViewById(R.id.spinner_model);
        spin_model.setOnItemSelectedListener(this);
        Spinner spin_engine = (Spinner) findViewById(R.id.spinner_engine);
        spin_engine.setOnItemSelectedListener(this);

        Log.d("DownloadCategory", "Start");
        downloadCategory();
        spinnerCategory.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Log.d("TAG", "Spinner selected ID : " + parent.getItemIdAtPosition(position));
                Log.d("TAG", "Spinner selected name : " + parent.getItemAtPosition(position));
                int selectedId = (int) parent.getItemIdAtPosition(position);
//                tv.setText(tv.getText() + parent.getItemAtPosition(position).toString());

                int selectedObjectId = vehicleCategoryList.get(selectedId).get_id();
                Log.d("TAG", "Spinner selected name : " + vehicleCategoryList.get(selectedId).get_id());
                if (selectedObjectId > 0) {
                    downloadBrand(selectedObjectId);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                //Another interface callback
            }
        });

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
    }

    private void populateCategorySpinner() {
        for (VehicleCategory item : vehicleCategoryList) {
            categoryList.add(item.get_name());
        }

        //Creating the ArrayAdapter instance having the category name list
        ArrayAdapter ca = new ArrayAdapter(this,android.R.layout.simple_spinner_item, categoryList);
        ca.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        spinnerCategory.setAdapter(ca);
    }

    private void downloadCategory() {
        final String mJSONURLString = "http://motorbazar.ghimiremilan.com.np/api/VehicleCategory";

        // Initialize a new RequestQueue instance
        RequestQueue requestQueue = Volley.newRequestQueue(this);

        // Initialize a new JsonArrayRequest instance
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(
                Request.Method.GET,
                mJSONURLString,
                null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        // Process the JSON
                        try{
                            // Loop through the array elements
                            for(int i=0;i<response.length();i++){
                                // Get current json object
                                JSONObject categories = response.getJSONObject(i);

                                // Get the current student (json object) data
                                int id = 0;
                                try {
                                    id = Integer.parseInt(categories.getString("id"));
                                } catch(NumberFormatException nfe) {
                                    System.out.println("Could not parse " + nfe);
                                }
                                String name = categories.getString("name");
                                String status = categories.getString("status");
                                if (status.equals("true")) {
                                    vehicleCategoryList.add(new VehicleCategory(id, name, true));
                                } else {
                                    vehicleCategoryList.add(new VehicleCategory(id, name, false));
                                }
                                Log.d("TAG", "Name is : " + name);
                            }
                            Log.d("TAG", "Array is : " + vehicleCategoryList.toString());
                            populateCategorySpinner();
                        }catch (JSONException e){
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener(){
                    @Override
                    public void onErrorResponse(VolleyError error){
                        Log.d("TAG", "Error occured " + error.toString());
                    }
                }
        );

        // Add JsonArrayRequest to the RequestQueue
        requestQueue.add(jsonArrayRequest);
    }

    private void  DownloadBrand(int categoryId){
        // ToDO download brand from here using volley as done above
        // here you need to pass parameter in   api/VehicleBrand/VehicleCategory/[categoryId]
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
