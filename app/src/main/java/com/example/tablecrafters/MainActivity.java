package com.example.tablecrafters;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.tablecrafters.screens.LoginScreen;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Pantalla principal, pasa directamente al Login para el TEA2
        Intent i = new Intent(this, LoginScreen.class);
        startActivity(i);
    }

}
