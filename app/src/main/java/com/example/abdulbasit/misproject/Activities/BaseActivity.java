package com.example.abdulbasit.misproject.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.abdulbasit.misproject.Constants.AppConstants;
import com.example.abdulbasit.misproject.DataCenter.DatabaseHelper;
import com.example.abdulbasit.misproject.DataCenter.PreferenceHelper;
import com.example.abdulbasit.misproject.Fragments.BaseFragment;
import com.example.abdulbasit.misproject.R;

/**
 * Created by Abdul basit on 5/6/2017.
 */

public abstract class BaseActivity extends AppCompatActivity {
    DatabaseHelper databaseHelper;
    PreferenceHelper preferenceHelper;

    public abstract int getDockFrameLayoutId();

    //public PreferencesHelper prefHelper;
   // public DatabaseHelper dbHelper;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        InitializeVariable();
    }

    private void InitializeVariable(){
        preferenceHelper = new PreferenceHelper(this);
        databaseHelper = new DatabaseHelper(this);
    }

    public PreferenceHelper getPrefHelper() {
        return preferenceHelper;
    }

    public DatabaseHelper getDbHelper() {
        return databaseHelper;
    }



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
