package com.example.borshan.tracker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.app.Activity;
import android.graphics.Color;

import android.view.View;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button signin_button;
    EditText signin_email,signin_password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        signin_button = (Button) findViewById(R.id.signin_button);
        signin_email = (EditText)findViewById(R.id.signin_email);
        signin_password = (EditText)findViewById(R.id.signin_password);

        TextView signin_create_account = (TextView)findViewById(R.id.signin_createaccount);
        //TextView signup_option_signin = (TextView)findViewById(R.id.signup_option_signin);
        //


            signin_button.setOnClickListener(this);
            signin_create_account.setOnClickListener(this);



    }


            @Override
            public void onClick(View view) {
            switch (view.getId()){
                case R.id.signin_button:
                    signin_button();
                    break;

                case R.id.signin_createaccount:
                    signin_create_account();
                    break;
                default:
                    break;
            }


        }


    public void signin_button(){
        if(signin_email.getText().toString().equals("admin") && signin_password.getText().toString().equals("admin")) {
            Toast.makeText(getApplicationContext(), "Redirecting...",Toast.LENGTH_SHORT).show();
            //setContentView(R.layout.signup_option);
//            Intent signupActivityIntent=new Intent(getApplicationContext(),SignupOptionActivity.class);
//            startActivity(signupActivityIntent);
            Intent dashboardIntent=new Intent(getApplicationContext(),dashboard.class);
            startActivity(dashboardIntent);
        }
        else
        {
            Toast.makeText(getApplicationContext(), "Wrong Credentials",Toast.LENGTH_SHORT).show();

        }
    }

    public void signin_create_account(){
        Intent signupOptionActivityIntent=new Intent(getApplicationContext(),SignupOptionActivity.class);
        startActivity(signupOptionActivityIntent);

    }


}