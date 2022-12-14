package com.example.abanobfinalorangeproject.screens.activites;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;

import com.example.abanobfinalorangeproject.R;


public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);
        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
        );

     new Handler().postDelayed(new Runnable(){
                                   @Override
                                   public void run() {
                                       Intent intent=new Intent(SplashScreen.this, IntroScreen.class);
                                       startActivity(intent);
                                       finish();
                                   }
                               },3000);
    }
}
