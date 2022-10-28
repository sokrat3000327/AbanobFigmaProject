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


public class SignUpActivity extends AppCompatActivity {
EditText edt1,edt2,edt3;
Button btn;
String password;
TextView t;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);


        t=findViewById(R.id.btn_1);
        edt1=findViewById(R.id.signup_username);
        edt2=findViewById(R.id.signup_email);
        edt3=findViewById(R.id.signup_password);
        btn=findViewById(R.id.signup_button);
        btn.setOnClickListener(
                view->{
                    checkEmail_Password_UserName(edt2,edt3,edt1);

                }
        );
        t.setOnClickListener(
                view->{
                    Intent intt=new Intent(SignUpActivity.this, SignInScreen.class);
                    startActivity(intt);
                }
        );
    }
    //this method check password, email,username
    boolean checkEmail_Password_UserName(EditText email,EditText pass, EditText user){
        String emailInput = email.getText().toString().trim();
        String passInput = pass.getText().toString().trim();
        String userName=user.getText().toString().trim();
        if ((!emailInput.isEmpty() || Patterns.EMAIL_ADDRESS.matcher(emailInput).matches()) && !passInput.isEmpty() && !userName.isEmpty()) {
            Toast.makeText(getApplicationContext(),"Succesed",Toast.LENGTH_LONG).show();
            Intent intent2=new Intent(SignUpActivity.this, SignInScreen.class);
            startActivity(intent2);
            return true;
        } else {
            Toast.makeText(getApplicationContext(),"Failed",Toast.LENGTH_LONG).show();
            return false;
        }
    }

}