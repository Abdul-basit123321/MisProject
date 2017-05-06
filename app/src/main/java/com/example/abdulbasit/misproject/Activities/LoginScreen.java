package com.example.abdulbasit.misproject.Activities;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.example.abdulbasit.misproject.R;

/**
 * Created by Abdul basit on 5/6/2017.
 */

public class LoginScreen extends BaseActivity {
    @Override
    public int getDockFrameLayoutId() {
        return 0;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }
}
