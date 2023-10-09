package com.example.hackuta2023;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Html;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.CheckBox;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Objects;

public class LoginActivity extends AppCompatActivity {

    private TextInputLayout usernameLayout, passwordLayout;
    public Button loginButton;
    public TextView registerTV, forgotpassTV;
    private ProgressBar loadingBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.Theme_HackUTA2023);
        setContentView(R.layout.activity_login);
        TextInputEditText userEdit = findViewById(R.id.idEditUser);
        TextInputEditText passwordEdit = findViewById(R.id.idEditPassword);
        loginButton = findViewById(R.id.idLoginButton);
        registerTV = findViewById(R.id.idTVRegister);
        forgotpassTV = findViewById(R.id.idTVforgotPassword);
        loadingBar = findViewById(R.id.idProgressBarLoad);
        usernameLayout = findViewById(R.id.idTempUser);
        passwordLayout = findViewById(R.id.idTempPassword);

        getSupportActionBar().hide();

        Bundle extra = getIntent().getExtras();
        if(extra != null) {
            userEdit.setText(extra.getString("username"));
            //if user has logged in, set profile text to username in DB
        }

        loginButton.setOnClickListener(view -> login());

    }


    protected void login() {
        //display loading bar when logging while authorizing with firebase and DB
        loadingBar.setVisibility(View.VISIBLE);
        String username = Objects.requireNonNull(usernameLayout.getEditText()).getText().toString().trim();
        String password = Objects.requireNonNull(passwordLayout.getEditText()).getText().toString().trim();

        Toast.makeText(LoginActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
        Intent i = new Intent(LoginActivity.this, DesktopActivity.class);
        //if sign in with firebase is correct, notify user login is successful and go to homepage class
        startActivity(i);
        finish();
    }
}