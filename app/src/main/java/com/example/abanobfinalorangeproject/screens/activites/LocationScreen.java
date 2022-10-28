package com.example.abanobfinalorangeproject.screens.activites;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.abanobfinalorangeproject.R;

// in this screen you write your location

public class LocationScreen extends AppCompatActivity {
    EditText edt1,edt2;
    Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_screen);
        edt1=findViewById(R.id.location_edt1);
        edt2=findViewById(R.id.location_edt2);
        b1=findViewById(R.id.location_btn);
        //this fun lead to go to signin screen
        b1.setOnClickListener(
                view->{
                    if(!edt1.getText().toString().isEmpty() && !edt2.getText().toString().isEmpty()){
                        Intent intent=new Intent(LocationScreen.this,SignInScreen.class);
                    }
                }
        );
    }
}