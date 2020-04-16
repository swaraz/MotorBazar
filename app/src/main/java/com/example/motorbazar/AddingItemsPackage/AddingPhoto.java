package com.example.motorbazar.AddingItemsPackage;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.provider.Settings;
import android.view.View;
import android.webkit.PermissionRequest;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.PermissionChecker;

import com.example.motorbazar.R;

public class AddingPhoto extends AppCompatActivity {
    ImageView image1, image2, image3, image4;
    Button add_btn;
    private static final int PERMISSION_REQUEST = 0;
    private static final int RESULT_LOAD_IMAGE = 1;
    private int imagePosition;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.adding_photos);
        uiInitialize();
        fetchImage();
        handlePermission();
        add_btn_clicked();
    }
    public void uiInitialize(){
        image1 = findViewById(R.id.image1);
        image2 = findViewById(R.id.image2);
        image3 = findViewById(R.id.image3);
        image4 = findViewById(R.id.image4);
        add_btn = findViewById(R.id.add_image);
    }
    public void fetchImage(){
        image1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //selectImage();
                imagePosition=1;
                openGallery();
            }
        });
        image2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imagePosition=2;
                openGallery();
            }
        });
        image3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imagePosition=3;
                openGallery();
            }
        });
        image4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imagePosition=4;
                openGallery();
            }
        });
    }
    public void openGallery(){
        Intent i = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(i, RESULT_LOAD_IMAGE);
    }
    public void handlePermission(){
        if(Build.VERSION.SDK_INT > Build.VERSION_CODES.M && checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED){
            requestPermissions(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},PERMISSION_REQUEST);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode){
            case PERMISSION_REQUEST:
                if (grantResults[0]==PackageManager.PERMISSION_GRANTED){
                    Toast.makeText(this, "Permission granted", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(this, "Permission not granted", Toast.LENGTH_SHORT).show();
                    finish();
                }
        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (imagePosition) {
            case 1:
                switch (requestCode) {
                    case RESULT_LOAD_IMAGE:
                        if (resultCode == RESULT_OK && requestCode == RESULT_LOAD_IMAGE) {
                            final Uri selectedImage = data.getData();
                            image1.setImageURI(selectedImage);
                        }
                }
                break;
            case 2:
                switch (requestCode) {
                    case RESULT_LOAD_IMAGE:
                        if (resultCode == RESULT_OK && requestCode == RESULT_LOAD_IMAGE) {
                            final Uri selectedImage = data.getData();
                            image2.setImageURI(selectedImage);
                        }
                }
                break;
            case 3:
                switch (requestCode) {
                    case RESULT_LOAD_IMAGE:
                        if (resultCode == RESULT_OK && requestCode == RESULT_LOAD_IMAGE) {
                            final Uri selectedImage = data.getData();
                            image3.setImageURI(selectedImage);
                        }
                }
                break;
            case 4:
                switch (requestCode) {
                    case RESULT_LOAD_IMAGE:
                        if (resultCode == RESULT_OK && requestCode == RESULT_LOAD_IMAGE) {
                            final Uri selectedImage = data.getData();
                            image4.setImageURI(selectedImage);
                        }
                }
                break;
        }
    }
    public void add_btn_clicked(){
        add_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(image4.getDrawable()==null){
                    //Toast.makeText(AddingPhoto.this, "Incomplete", Toast.LENGTH_SHORT).show();
                    AlertDialog alertDialog = new AlertDialog.Builder(AddingPhoto.this).create();
                    alertDialog.setTitle("Incomplete input");
                    alertDialog.setMessage("Please enter four photos.");
                    alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "OK", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            //Toast.makeText(getApplicationContext(), "You clicked on OK", Toast.LENGTH_SHORT).show();
                        }
                    });
                    alertDialog.show();
                }
            }
        });
    }

}
