package com.example.hngmobiletask1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    final EditText loginEmail = (EditText) findViewById(R.id.loginEmail);
    final EditText loginPassword = (EditText) findViewById(R.id.loginPassword);
    Button loginButton = (Button) findViewById(R.id.signIn);
    final Button registerButton = (Button) findViewById(R.id.createAcct);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userLoginEmail = loginEmail.getText().toString();
                String userLoginPassword = registerButton.getText().toString();

                SharedPreferences preferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);

                String userDetails = preferences.getString(userLoginEmail + userLoginPassword + "data", "Username or Password is incorrect!");
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("display", userDetails);
                editor.commit();


                Intent loginDirectly = new Intent (MainActivity.this, display.class);
                startActivity(loginDirectly);
            }
        });

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent loginDirectly = new Intent (MainActivity.this, register.class);
                startActivity(loginDirectly);
            }
        });

    }}
