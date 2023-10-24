package com.example.tablecrafters.screens;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.tablecrafters.R;

public class LoginScreen extends AppCompatActivity {

    //para test
    final String user_test = "al";
    final String pass_test = "123";

    // para recuperar el text entrado por el usuario
    private EditText userEditText;
    private EditText passwordEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);

//para obtener la referencia del EditText y asignarla a la variable privada
        userEditText = findViewById(R.id.user_edittext);
        passwordEditText = findViewById(R.id.password_edittext);

        //Al apretar el button de login, comprueba en la API si el usuario existe y hace login,
        // sino existe el usuario o la contraseña es erronea, salta una aviso
        final Button button = findViewById(R.id.login_button);
        button.setOnClickListener(v -> {
            // Code here executes on main thread after user presses button
            //imprimirUserPass();
            login();
        });
    }

    public void imprimirUserPass(){
        String user = userEditText.getText().toString();
        String pass = passwordEditText.getText().toString();

        Toast.makeText(this, user, Toast.LENGTH_SHORT).show();
        Toast.makeText(this, pass, Toast.LENGTH_SHORT).show();
    }

    public void login(){

        String user = userEditText.getText().toString();
        String pass = passwordEditText.getText().toString();

        if ( (user.equals(user_test)) && (pass.equals(pass_test)) ){
            Intent i = new Intent(this, UserLogged.class);
            startActivity(i);
        } else {
            Toast.makeText(this, "USUARIO O PASS INCORRECTO", Toast.LENGTH_SHORT).show();
        }

    }

}
