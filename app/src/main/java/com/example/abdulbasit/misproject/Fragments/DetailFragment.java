package com.example.abdulbasit.misproject.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.abdulbasit.misproject.Entities.Contact;
import com.example.abdulbasit.misproject.R;

/**
 * Created by Abdul basit on 5/8/2017.
 */

public class DetailFragment extends BaseFragment implements View.OnClickListener {
    View parentView;
    Contact contact;
    EditText etName,etNumber,etEmail;
    Button btnSave,btnDel;

    public static DetailFragment NewInstance(Contact contact){
        DetailFragment detailFragment = new DetailFragment();
        detailFragment.contact = contact;
        return detailFragment;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        InitializeVariable();
        setUI();
        setListener();
    }

    private void setUI() {
        etEmail.setText(contact.getEmail());
        etName.setText(contact.getName());
        etNumber.setText(contact.getNumber());
    }

    private void setListener() {
        btnSave.setOnClickListener(this);
        btnDel.setOnClickListener(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        parentView = inflater.inflate(R.layout.detail_fragment,container,false);
        return parentView;
    }

    void InitializeVariable(){
        etName = (EditText) parentView.findViewById(R.id.etUsername);
        etNumber = (EditText) parentView.findViewById(R.id.etnumber);
        etEmail = (EditText) parentView.findViewById(R.id.etEmail);
        btnSave = (Button) parentView.findViewById(R.id.btnSave);
        btnDel = (Button) parentView.findViewById(R.id.btnDelete);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.btnSave){
            contact.setEmail(etEmail.getText().toString());
            contact.setName(etName.getText().toString());
            contact.setNumber(etNumber.getText().toString());
            getHomeActivity().getDbHelper().updateUser(contact,contact.getId());
            Toast.makeText(getContext(), "Contact update successfully", Toast.LENGTH_SHORT).show();
            getHomeActivity().addFragmentToStack(new HomeFragment());

        }else if (id == R.id.btnDelete){
            getHomeActivity().getDbHelper().deleteUser(contact.getId());
            Toast.makeText(getContext(), "Contact delete successfully", Toast.LENGTH_SHORT).show();
            getHomeActivity().addFragmentToStack(new HomeFragment());
        }
    }
}
