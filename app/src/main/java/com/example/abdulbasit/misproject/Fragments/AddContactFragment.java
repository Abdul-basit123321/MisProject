package com.example.abdulbasit.misproject.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.abdulbasit.misproject.Entities.Contact;
import com.example.abdulbasit.misproject.Entities.User;
import com.example.abdulbasit.misproject.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Abdul basit on 5/6/2017.
 */

public class AddContactFragment extends BaseFragment  implements View.OnClickListener{
    View parentView;
    EditText etName,etNumber,etEmail;
    Button btnSave;
    Contact userToStore;

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
        userToStore = new Contact();
        etName = (EditText) parentView.findViewById(R.id.etUsername);
        etNumber = (EditText) parentView.findViewById(R.id.etnumber);
        etEmail = (EditText) parentView.findViewById(R.id.etEmail);
        btnSave = (Button) parentView.findViewById(R.id.btnSave);
    }

    @Override
    public void onClick(View view) {
        int id=  view.getId();
        if (id == R.id.btnSave){
            Random rand = new Random();
            int diceRoll = rand.nextInt();
            userToStore.setId(String.valueOf(diceRoll));
            userToStore.setEmail(etEmail.getText().toString());
            userToStore.setName(etName.getText().toString());
            userToStore.setNumber(etNumber.getText().toString());
            getHomeActivity().getDbHelper().insertUser(userToStore);

            List<Contact> list = new ArrayList<>();
            list = getHomeActivity().getDbHelper().getAllUsers();



        }
    }
}
