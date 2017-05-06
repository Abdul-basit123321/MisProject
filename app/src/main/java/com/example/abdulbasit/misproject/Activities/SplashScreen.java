package com.example.abdulbasit.misproject.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.abdulbasit.misproject.R;

/**
 * Created by Abdul basit on 5/6/2017.
 */

public class SplashScreen extends BaseActivity {


    private static int SPLASH_TIME_OUT = 3000;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (getPrefHelper().isUserLogin()){
                    changeActivity(HomeActivity.class,true);
                }else{
                    changeActivity(LoginScreen.class,true);
                }
            }
        }, SPLASH_TIME_OUT);
    }


    public int getDockFrameLayoutId() {
        return 0;
    }
}
