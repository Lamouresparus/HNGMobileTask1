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
        String display = preferences.getString("display", "");

        TextView displayInfo = (TextView) findViewById(R.id.userName);
        displayInfo.setText(display);
    }
}

