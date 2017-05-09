package com.example.abdulbasit.misproject.Activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.abdulbasit.misproject.R;

/**
 * Created by Abdul basit on 5/6/2017.
 */

public class LoginScreen extends BaseActivity implements View.OnClickListener {
    EditText etEmail,etPassword;
    Button btnLogin,btnSignup;

    @Override
    public int getDockFrameLayoutId() {
        return 0;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        InitializeVariable();
        setListener();
    }

    private void setListener() {
        btnLogin.setOnClickListener(this);
        btnSignup.setOnClickListener(this);
    }

    private void InitializeVariable() {
        etEmail = (EditText) findViewById(R.id.etUsername);
        etPassword = (EditText) findViewById(R.id.etPassword);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        btnSignup = (Button) findViewById(R.id.btnSign);
    }


    @Override
    public void onClick(View view) {
        int id = view.getId();
        if(id == R.id.btnLogin){
            if (etEmail.getText().toString().equalsIgnoreCase(getPrefHelper().getValueByKey("KEY_EMAIL")) &&
                    etPassword.getText().toString().equalsIgnoreCase(getPrefHelper().getValueByKey("KEY_PASSWORD"))){

            }
            changeActivity(HomeActivity.class,true);

        }
        else if(id == R.id.btnSign){
            changeActivity(SignUpScreen.class,false);
        }
    }
}
