package com.example.borshan.tracker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import org.json.JSONException;
import org.json.JSONObject;

public class SignupOptionActivity extends AppCompatActivity implements View.OnClickListener {

    LoginButton loginButton;
    CallbackManager callbackManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup_option);

        Button signup_button = (Button) findViewById(R.id.signup_option_facebook);
        Button signup_option_email = (Button) findViewById(R.id.signup_option_email);

        TextView signup_option_signin = (TextView) findViewById(R.id.signup_option_signin);

        signup_button.setOnClickListener(this);
        signup_option_email.setOnClickListener(this);
        signup_option_signin.setOnClickListener(this);

        loginButton = (LoginButton) findViewById(R.id.login_button);

        loginButton.setReadPermissions("email", "public_profile");

        callbackManager = CallbackManager.Factory.create();
        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {

                String userid = loginResult.getAccessToken().getUserId();

                GraphRequest graphRequest = GraphRequest.newMeRequest(loginResult.getAccessToken(), new GraphRequest.GraphJSONObjectCallback() {
                    @Override
                    public void onCompleted(JSONObject object, GraphResponse response) {
                        displayUserInfo(object);
                    }
                });

                Bundle parameters = new Bundle();
                parameters.putString("fields", "first_name, last_name, email, id");
                graphRequest.setParameters(parameters);
                graphRequest.executeAsync();

            }

            @Override
            public void onCancel() {

            }

            @Override
            public void onError(FacebookException error) {

            }
        });
    }

    public void displayUserInfo(JSONObject object) {
        String first_name = "", last_name = "", email = "", id = "";


        try {
            first_name = object.getString("first_name");
            last_name = object.getString("last_name");
            email = object.getString("email");
            id = object.getString("id");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        TextView tv_name, tv_email, tv_id;
        tv_name = (TextView)findViewById(R.id.tv_name);
        tv_email = (TextView)findViewById(R.id.tv_email);
        tv_id = (TextView)findViewById(R.id.tv_id);

        tv_name.setText(first_name+ " "+ last_name);
        tv_email.setText("email: "+ email);
        tv_id.setText("ID: "+ id);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        callbackManager.onActivityResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);
    }


    public void signup_option_facebook(){
        com.facebook.login.widget.LoginButton btn = new LoginButton(this);
        btn.performClick();
    }

    public void signup_option_email(){
        Intent signupActivityIntent=new Intent(getApplicationContext(),SignupActivity.class);
        startActivity(signupActivityIntent);
    }

    public void signup_option_signin(){
        Intent MainActivityIntent=new Intent(getApplicationContext(),MainActivity.class);
        startActivity(MainActivityIntent);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.signup_option_facebook:
                signup_option_facebook();
                break;

            case R.id.signup_option_email:
                signup_option_email();
                break;
            case R.id.signup_option_signin:
                signup_option_signin();
                break;
            default:
                break;
        }
    }
}
