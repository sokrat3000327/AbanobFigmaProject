package com.example.abanobfinalorangeproject.screens.activites;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.abanobfinalorangeproject.R;


public class SignInScreen extends AppCompatActivity {
    EditText edt1;
    EditText edt2;
    Button login;
    TextView signUpText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.signin_screen);
        String password;
        edt1=findViewById(R.id.signin_email);
        edt2=findViewById(R.id.signin_password);
        login=findViewById(R.id.lgn);
        signUpText=findViewById(R.id.signuptext);

        login.setOnClickListener(
                view->{
                    checkEmailAndPassword(edt1,edt2);
                }
        );
        signUpText.setOnClickListener(
                view->{
                    Intent i5=new Intent(SignInScreen.this, SignUpActivity.class);
                    startActivity(i5);
                }
        );

    }
    // this function check the email is valid and check the password is empty or not
    boolean checkEmailAndPassword(EditText email,EditText pass){
        String emailInput = email.getText().toString().trim();
        String passInput = pass.getText().toString().trim();
        if ((!emailInput.isEmpty() || Patterns.EMAIL_ADDRESS.matcher(emailInput).matches()) && !passInput.isEmpty()) {
            Toast.makeText(getApplicationContext(),"Succesed",Toast.LENGTH_LONG).show();
            Intent intent2=new Intent(SignInScreen.this, MainScreen.class);
            startActivity(intent2);
            return true;
        } else {
            Toast.makeText(getApplicationContext(),"Failed",Toast.LENGTH_LONG).show();

            return false;
        }
    }

}