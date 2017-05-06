package com.example.abdulbasit.misproject.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.abdulbasit.misproject.R;

/**
 * Created by Abdul basit on 5/6/2017.
 */

public class HomeFragment extends BaseFragment {
    View parentView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        parentView = inflater.inflate(R.layout.fragment_home,container,false);
        return parentView;
    }
}
