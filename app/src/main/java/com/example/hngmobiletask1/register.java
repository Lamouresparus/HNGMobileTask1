package com.example.hngmobiletask1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;


public class register extends AppCompatActivity {

    private SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        preferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);

        final EditText userFirstName = (EditText) findViewById(R.id.firstName);
        final EditText userLastName = (EditText) findViewById(R.id.lastName);
        final EditText email = (EditText) findViewById(R.id.email);
        final EditText phoneNumber = (EditText) findViewById(R.id.phone);
        final EditText doB = (EditText) findViewById(R.id.dob);
        final EditText password = (EditText) findViewById(R.id.password);
        Button registerBtn = (Button) findViewById(R.id.signUpReg);
        Button loginBtn = (Button) findViewById(R.id.loginReg);

        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String newUserFirstName = userFirstName.getText().toString();
                String newUserLastName = userLastName.getText().toString();
                String newUserEmail = email.getText().toString();
                String newUserPhone = phoneNumber.getText().toString();
                String newUserDob = doB.getText().toString();
                String newUserPassword = password.getText().toString();

                SharedPreferences.Editor editor = preferences.edit();

                editor.putString("fn",newUserFirstName);
                editor.putString("ln",newUserLastName);

                editor.putString("email",newUserEmail);
                editor.putString("phone",newUserPhone);

                editor.putString("dob",newUserDob);
                editor.putString("password",newUserPassword);


                editor.apply();


                Intent loginScreen = new Intent (register.this, MainActivity.class);
                startActivity(loginScreen);
            }
        });




    }
}
