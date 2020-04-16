package com.example.motorbazar;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;


import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.mikhaellopez.circularimageview.CircularImageView;


public class VehicleDetails extends AppCompatActivity {
    private static final int PERMISSION_REQUEST = 0;
    ViewPager viewPager;
    Button book_btn, addToWish_btn, ownerdetails_btn, locationDetailBtn;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vehicle_details);
        uiInitialize();
        //setLayout();
        ownerDetailsBtnClick();
        bookVehicle();
        locationClicked();

        SliderViewpagerAdapter viewPagerAdapter = new SliderViewpagerAdapter(this);
        viewPager.setAdapter(viewPagerAdapter);

    }

    public void uiInitialize() {
        viewPager = findViewById(R.id.slider_viewPager);
        ownerdetails_btn = findViewById(R.id.ownerDetails_btn);
        book_btn = findViewById(R.id.book_btn);
        locationDetailBtn = findViewById(R.id.locationDetail_btn);

    }

    public void ownerDetailsBtnClick() {
        ownerdetails_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handlePermission();
                final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(VehicleDetails.this);
                bottomSheetDialog.setContentView(R.layout.user_details_layout);
                bottomSheetDialog.setCanceledOnTouchOutside(false);

                CircularImageView userImage = bottomSheetDialog.findViewById(R.id.image_user);
                TextView txt_name = bottomSheetDialog.findViewById(R.id.user_name);
                ImageView cancelImage = bottomSheetDialog.findViewById(R.id.cancel_bottomsheet);
                TextView txt_address = bottomSheetDialog.findViewById(R.id.user_address);
                TextView txt_country = bottomSheetDialog.findViewById(R.id.user_country);
                TextView txt_email = bottomSheetDialog.findViewById(R.id.user_email);
                TextView txt_contact = bottomSheetDialog.findViewById(R.id.user_contact);
                Button call_btn = bottomSheetDialog.findViewById(R.id.call_user_btn);
                Button sms_btn = bottomSheetDialog.findViewById(R.id.sms_user_btn);
                //showing bottomsheet
                bottomSheetDialog.show();
                //for cross btn in buttom sheet
                cancelImage.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        bottomSheetDialog.cancel();
                    }
                });
                //for call button in button sheet
                call_btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        final String phone = "9804081619";

                        AlertDialog.Builder builder = new AlertDialog.Builder(VehicleDetails.this);
                        builder.setTitle("Make a Call");
                        builder.setMessage("Do you want to call the user?");

                        builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                            //@RequiresApi(api = Build.VERSION_CODES.M)
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                //Toast.makeText(PhoneCallActivity.this, "ok clicked", Toast.LENGTH_SHORT).show();
                                String s = "tel:" + phone;
                                Intent intent = new Intent(Intent.ACTION_CALL);
                                intent.setData(Uri.parse(s));

                                if(Build.VERSION.SDK_INT > Build.VERSION_CODES.M && checkSelfPermission(Manifest.permission.CALL_PHONE)
                                        != PackageManager.PERMISSION_GRANTED){
                                    requestPermissions(new String[]{Manifest.permission.CALL_PHONE},PERMISSION_REQUEST);
                                }
                                startActivity(intent);
                            }
                        });
                        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.cancel();
                            }
                        });
                        builder.create().show();
                    }

                });

                //for sms bottom clicked
                sms_btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        final String phone = "9804081619";
                        AlertDialog.Builder builder = new AlertDialog.Builder(VehicleDetails.this);
                        builder.setTitle("Send SMS");
                        builder.setMessage("Do you want to send SMS to the user?");

                        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                //Toast.makeText(PhoneCallActivity.this, "ok clicked", Toast.LENGTH_SHORT).show();
                                String s = "tel:" + phone;
                                Intent intent = new Intent(Intent.ACTION_VIEW);
                                intent.putExtra("address",phone);
                                intent.putExtra("sms_body","This is my number");
                                intent.setType("vnd.android-dir/mms-sms");
                                startActivity(intent);
                            }
                        });
                        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.cancel();
                            }
                        });
                        builder.create().show();
                    }
                });

            }
        });

    }

    public void bookVehicle() {
        book_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });
    }
    //permission for phone call
    public void handlePermission(){
        if(Build.VERSION.SDK_INT > Build.VERSION_CODES.M && checkSelfPermission(Manifest.permission.CALL_PHONE)
                != PackageManager.PERMISSION_GRANTED){
            requestPermissions(new String[]{Manifest.permission.CALL_PHONE},PERMISSION_REQUEST);
        }
    }
    public void locationClicked(){
        locationDetailBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(VehicleDetails.this, SingleVehicleMapInfo.class));
                //Toast.makeText(VehicleDetails.this, "fuck", Toast.LENGTH_SHORT).show();
            }
        });
    }





}
