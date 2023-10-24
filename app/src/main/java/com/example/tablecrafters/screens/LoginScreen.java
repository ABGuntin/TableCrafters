package com.example.tablecrafters.screens;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tablecrafters.R;
import com.example.tablecrafters.models.Login;
import com.example.tablecrafters.services.impl.ApiUtils;
import com.example.tablecrafters.services.interfaces.ApiLogin;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginScreen extends AppCompatActivity {

    //para test
    final String user_test = "al";
    final String pass_test = "123";

    // para recuperar el text entrado por el usuario
    private EditText userEditText;
    private EditText passwordEditText;

    private TextView mResponseTv;
    private ApiLogin mAPILogin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);

        //para obtener la referencia del EditText y asignarla a la variable privada
        userEditText = findViewById(R.id.user_edittext);
        passwordEditText = findViewById(R.id.password_edittext);
        mResponseTv = findViewById(R.id.tv_response);

        mAPILogin = ApiUtils.getApiLogin();

        //Al apretar el button de login, comprueba en la API si el usuario existe y hace login,
        // sino existe el usuario o la contraseña es erronea, salta una aviso
        final Button button = findViewById(R.id.login_button);
        button.setOnClickListener(v -> {
            // Code here executes on main thread after Login presses button
            String email = userEditText.getText().toString().trim();
            String pass = passwordEditText.getText().toString().trim();
            if(!TextUtils.isEmpty(email) && !TextUtils.isEmpty(pass)) {
                sendPost(email, pass);
            }

            //para test
            //imprimirUserPass();
            //login();
        });
    }

    public void sendPost(String email, String pass) {
        mAPILogin.savePost(email, pass).enqueue(new Callback<Login>() {
            @Override
            public void onResponse(Call<Login> call, Response<Login> response) {
                if(response.isSuccessful()) {
                    showResponse(response.body().toString());
                    Log.i(TAG, "post submitted to API." + response.body().toString());
                }
            }
            @Override
            public void onFailure(Call<Login> call, Throwable t) {
                Log.e(TAG, "Unable to submit post to API.");
            }
        });
    }

    public void showResponse(String response) {
        if(mResponseTv.getVisibility() == View.GONE) {
            mResponseTv.setVisibility(View.VISIBLE);
        }
        mResponseTv.setText(response);

    }




    //to TEST
    public void imprimirUserPass(){
        String user = userEditText.getText().toString();
        String pass = passwordEditText.getText().toString();

        Toast.makeText(this, user, Toast.LENGTH_SHORT).show();
        Toast.makeText(this, pass, Toast.LENGTH_SHORT).show();
    }

    //to TEST
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
