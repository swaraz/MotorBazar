package com.example.motorbazar.SplashScreenPackage;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.transition.ChangeBounds;
import android.transition.TransitionManager;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

import com.example.motorbazar.R;
import com.example.motorbazar.RegisterPackage.RegisterUser;
import com.example.motorbazar.User_Dashboard.UserDashboard;

public class SplashScreen extends AppCompatActivity {
    ConstraintLayout constraintLayout;
    EditText username, password;
    CheckBox cbrememberMe;
    Button directLogin, fbLogin;
    TextView forgotPassword, signup;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen_layout);
        animationControl();
        initializeUI();
        login();
        loginFb();
        forgotPassword();
        onSignup();
    }
    public void animationControl()
    {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.KITKAT) {
                    ConstraintSet constraintSet = new ConstraintSet();
                    constraintSet.clone(SplashScreen.this, R.layout.login_screen_layout);
                    ChangeBounds transition = new ChangeBounds();
                    transition.setDuration(500);
                    TransitionManager.beginDelayedTransition(constraintLayout, transition);
                    constraintSet.applyTo(constraintLayout);
                }
            }
        }, 2000);
    }
    public void initializeUI(){
        constraintLayout = findViewById(R.id.parent);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        cbrememberMe = findViewById(R.id.remember_me);
        directLogin = findViewById(R.id.loginBtn);
        fbLogin = findViewById(R.id.loginFacebookBtn);
        forgotPassword = findViewById(R.id.forgotPassword);
        signup = findViewById(R.id.signUp);
    }
    public void login(){
        directLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(SplashScreen.this, "login clicked", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(SplashScreen.this, UserDashboard.class));
            }
        });
    }
    public void loginFb(){
        fbLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(SplashScreen.this, "login with fb clicked", Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void forgotPassword(){
        forgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(SplashScreen.this, "forgot password clicked", Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void onSignup(){
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            startActivity(new Intent(SplashScreen.this, RegisterUser.class));
                //Toast.makeText(SplashScreen.this, "signup clicked.", Toast.LENGTH_SHORT).show();
            }
        });
    }

}
