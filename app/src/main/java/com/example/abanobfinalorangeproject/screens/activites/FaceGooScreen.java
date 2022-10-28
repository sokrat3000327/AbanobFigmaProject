package com.example.abanobfinalorangeproject.screens.activites;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.abanobfinalorangeproject.R;


/*
this screen indicates to google or facebook sign screen
 */
public class FaceGooScreen extends AppCompatActivity {
    Button l1,l2;
    Intent i3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.face_goo_screen);
        l1=findViewById(R.id.fg_log1);
        l2=findViewById(R.id.fg_log2);
        l1.setOnClickListener(
                view->{
                    i3=new Intent(FaceGooScreen.this,SignInScreen.class);
                    startActivity(i3);
                }
        );
        l2.setOnClickListener(
                view->{
                    i3=new Intent(FaceGooScreen.this, SignInScreen.class);
                    startActivity(i3);
                }
        );
    }
}