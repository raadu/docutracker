package com.example.borshan.tracker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class SignupActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);

        TextView signup_signin = (TextView)findViewById(R.id.signup_signin);
        Button signup_button = (Button) findViewById(R.id.signup_button);

        signup_signin.setOnClickListener(this);
        signup_button.setOnClickListener(this);
    }

    public void signup_signin(){
        Intent MainActivityIntent=new Intent(getApplicationContext(),MainActivity.class);
        startActivity(MainActivityIntent);
    }

    public void signup_button(){
        //Intent MainActivityIntent=new Intent(getApplicationContext(),MainActivity.class);
        //startActivity(MainActivityIntent);
        Toast.makeText(getApplicationContext(), "succssfully signed up",Toast.LENGTH_SHORT).show();
    }


    public void onClick(View view) {
        switch (view.getId()){
            case R.id.signup_signin:
                signup_signin();
                break;

            case R.id.signup_button:
                signup_button();
                break;
            default:
                break;
        }


    }
}
