package com.example.abdulbasit.misproject.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.abdulbasit.misproject.Fragments.HomeFragment;
import com.example.abdulbasit.misproject.R;

public class HomeActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        addFragmentToStack(new HomeFragment());
    }

    @Override
    public int getDockFrameLayoutId() {
        return R.id.frame;
    }
}
