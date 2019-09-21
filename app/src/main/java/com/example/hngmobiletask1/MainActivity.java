package com.example.hngmobiletask1;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private SharedPreferences preferences;
    private String vEmail, vPass;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        preferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);


        final EditText loginEmail = (EditText) findViewById(R.id.loginEmail);
        final EditText loginPassword = (EditText) findViewById(R.id.loginPassword);
        Button loginButton = (Button) findViewById(R.id.signIn);
        final Button registerButton = (Button) findViewById(R.id.createAcct);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userLoginEmail = loginEmail.getText().toString();
                String userLoginPassword = loginPassword.getText().toString();


                SharedPreferences.Editor editor = preferences.edit();


                vEmail = preferences.getString("email", "na");

                vPass = preferences.getString("password", "na");


                if (vEmail.equalsIgnoreCase(userLoginEmail) && vPass.equals(userLoginPassword)) {

                    Intent loginDirectly = new Intent(MainActivity.this, display.class);
                    startActivity(loginDirectly);

                } else {

                    Toast.makeText(MainActivity.this, userLoginEmail + " or " + userLoginPassword + " does not exits", Toast.LENGTH_SHORT).show();
                }


            }
        });

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent loginDirectly = new Intent(MainActivity.this, register.class);
                startActivity(loginDirectly);
            }
        });

    }
}