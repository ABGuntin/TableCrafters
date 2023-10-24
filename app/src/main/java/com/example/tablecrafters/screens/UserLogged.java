package com.example.tablecrafters.screens;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import com.example.tablecrafters.R;

public class UserLogged extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_logged);

        final Button button = findViewById(R.id.logout_button);
        button.setOnClickListener(v -> {
            // Code here executes on main thread after Login presses button
            //imprimirUserPass();
            Toast.makeText(this, "USUARIO DESCONECTADO DE LA APP", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(this, LoginScreen.class);
            startActivity(i);
        });
}};
