package com.example.abdulbasit.misproject.Activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.abdulbasit.misproject.Entities.User;
import com.example.abdulbasit.misproject.Helper.Utilities;
import com.example.abdulbasit.misproject.R;

/**
 * Created by Abdul basit on 5/6/2017.
 */

public class SignUpScreen extends BaseActivity implements View.OnClickListener  {
    EditText etEmail,etPassword,etUsername;
    Button btnSignup;

    @Override
    public int getDockFrameLayoutId() {
        return 0;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        InitializeVariable();
        setListener();
    }

    private void setListener() {
        btnSignup.setOnClickListener(this);
    }

    private void InitializeVariable() {
        etUsername = (EditText) findViewById(R.id.etUsername);
        etEmail = (EditText) findViewById(R.id.etEmail);
        etPassword = (EditText) findViewById(R.id.etPassword);
        btnSignup = (Button) findViewById(R.id.btnSign);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if(id == R.id.btnSign){
            if (!Utilities.isEmptyOrNull(etUsername.getText().toString()) && !Utilities.isEmptyOrNull(etPassword.getText().toString()) &&
                    !Utilities.isEmptyOrNull(etEmail.getText().toString())){
                if(Utilities.isValidEmail(etEmail.getText().toString())){
                    User user = new User();
                    user.setEmail(etEmail.getText().toString());
                    user.setPassword(etPassword.getText().toString());
                    user.setUserName(etUsername.getText().toString());
                    preferenceHelper.saveUserCredentials(user);
                    changeActivity(HomeActivity.class,true);
                }else {
                    Toast.makeText(this, "Email address is invalid", Toast.LENGTH_SHORT).show();
                }

            }else{
                Toast.makeText(this, "Please fill input fields", Toast.LENGTH_SHORT).show();
            }


        }
    }
}
