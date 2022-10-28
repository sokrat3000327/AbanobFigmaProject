package com.example.abanobfinalorangeproject.screens.activites;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;


import com.example.abanobfinalorangeproject.R;


/*
this is the second screen in figma and this screen lead to the FaceGooScreen
 */
public class IntroScreen extends AppCompatActivity {


    Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intro_screen);

        b=findViewById(R.id.intro_btn1);

        /*
        this screen lead to the FaceGooScreen
        */
        b.setOnClickListener(view->{
            Intent myIntent=new Intent(IntroScreen.this, FaceGooScreen.class);
            startActivity(myIntent);
        });

    }

}