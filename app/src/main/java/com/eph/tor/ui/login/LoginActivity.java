package com.eph.tor.ui.login;

import android.app.Activity;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.appcompat.app.AppCompatActivity;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.eph.tor.MainActivity;
import com.eph.tor.R;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    EditText usernameEditText;
    EditText passwordEditText;
    ProgressBar loadingProgressBar;
    TextView usernameErrorText;
    TextView passwordErrorText;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        usernameEditText = findViewById(R.id.username);
        passwordEditText = findViewById(R.id.password);
        final Button loginButton = findViewById(R.id.login);
        loadingProgressBar = findViewById(R.id.loading);
        usernameErrorText = findViewById(R.id.username_error);
        passwordErrorText = findViewById(R.id.password_error);
        loginButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.login:
                LogIn();
        }
    }

    public void LogIn(){
        usernameErrorText.setText("");
        passwordErrorText.setText("");
        String username = usernameEditText.getText().toString();
        String password = passwordEditText.getText().toString();
        if(username.equals("")) {
            this.usernameErrorText.setText(R.string.enter_username_error);
        }
        if(password.equals("")) {
            this.passwordErrorText.setText(R.string.enter_password_error);
        }

        if(verifyAccount(username, password)) {
            Intent switchActivityIntent = new Intent(this, MainActivity.class);
            startActivity(switchActivityIntent);
            finish();
        }
    }

    private boolean verifyAccount(String username, String password) {
        return username.equals("Admin") && password.equals("admin");
    }
}