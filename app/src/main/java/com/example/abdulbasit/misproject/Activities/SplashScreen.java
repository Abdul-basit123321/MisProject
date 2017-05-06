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

            /*
             * Showing splash screen with a timer. This will be useful when you
             * want to show case your app logo / company
             */

            @Override
            public void run() {
                // This method will be executed once the timer is over
                // Start your app main activity
                Intent i = new Intent(SplashScreen.this, LoginScreen.class);
                startActivity(i);

                // close this activity
                finish();
            }
        }, SPLASH_TIME_OUT);
    }


    public int getDockFrameLayoutId() {
        return 0;
    }
}
