package com.example.abdulbasit.misproject.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.abdulbasit.misproject.R;

/**
 * Created by Abdul basit on 5/6/2017.
 */

public class HomeFragment extends BaseFragment implements View.OnClickListener {
    View parentView;
    FloatingActionButton fab ;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        parentView = inflater.inflate(R.layout.fragment_home,container,false);
        return parentView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        InitializeVariable();
        setListener();
    }

    private void setListener() {
        fab.setOnClickListener(this);
    }

    private void InitializeVariable() {
        fab = (FloatingActionButton) parentView.findViewById(R.id.fab);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if(id == R.id.fab){
            getHomeActivity().addFragmentToStack(new AddContactFragment());
        }
    }
}
