package com.example.abdulbasit.misproject.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.abdulbasit.misproject.Constants.AppConstants;
import com.example.abdulbasit.misproject.Fragments.BaseFragment;
import com.example.abdulbasit.misproject.R;

/**
 * Created by Abdul basit on 5/6/2017.
 */

public abstract class BaseActivity extends AppCompatActivity {

    public abstract int getDockFrameLayoutId();

    //public PreferencesHelper prefHelper;
   // public DatabaseHelper dbHelper;

    public void addFragmentToStack(BaseFragment fragment) {
        android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(getDockFrameLayoutId(), fragment);
        fragmentTransaction.addToBackStack(getSupportFragmentManager().getBackStackEntryCount() == 0 ? AppConstants.KEY_FRAG_FIRST : null)
                .commit();
    }

    public <T> void changeActivity(Class<T> cls,boolean isFinish) {
        Intent resultIntent = new Intent(this, cls);
        resultIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(resultIntent);
        if (isFinish){
            finish();
        }
    }


}
