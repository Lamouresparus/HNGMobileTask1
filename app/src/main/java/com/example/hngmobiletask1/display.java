package com.example.hngmobiletask1;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class display extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display);

        SharedPreferences preferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        String fn = preferences.getString("fn", "");
        String ls = preferences.getString("ls", "");


        String email = preferences.getString("email", "");
        String dob = preferences.getString("dob", "");
        String phone = preferences.getString("phone", "");





        TextView name = findViewById(R.id.userName);
        TextView userEmail = findViewById(R.id.userEmail);
        TextView userPhone = findViewById(R.id.userPhone);
        TextView birthday = findViewById(R.id.userDob);





        name.setText("user name : "+fn+" "+ls);
        userEmail.setText("Email :"+email);
        userPhone.setText("Phone Number "+phone);
        birthday.setText("birthday : "+dob);

    }
}

