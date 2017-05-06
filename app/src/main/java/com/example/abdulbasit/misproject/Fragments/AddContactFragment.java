package com.example.abdulbasit.misproject.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.abdulbasit.misproject.R;

/**
 * Created by Abdul basit on 5/6/2017.
 */

public class AddContactFragment extends BaseFragment  implements View.OnClickListener{
    View parentView;
    EditText etName,etNumber,etEmail;
    Button btnSave;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        parentView = inflater.inflate(R.layout.add_contact,container,false);
        return parentView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        InitializeVariable();
        setListener();
    }

    private void setListener() {
        btnSave.setOnClickListener(this);
    }

    private void InitializeVariable() {
        btnSave = (Button) parentView.findViewById(R.id.btnSave);
    }

    @Override
    public void onClick(View view) {
        int id=  view.getId();
        if (id == R.id.btnSave){

        }
    }
}
