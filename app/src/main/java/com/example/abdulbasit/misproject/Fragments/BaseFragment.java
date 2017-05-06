package com.example.abdulbasit.misproject.Fragments;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.example.abdulbasit.misproject.Activities.HomeActivity;

/**
 * Created by Abdul basit on 5/6/2017.
 */

public class BaseFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    protected HomeActivity getNavigationActivity() {
        return (HomeActivity) getActivity();
    }
}
