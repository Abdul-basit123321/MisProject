package com.example.abdulbasit.misproject.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;

import com.example.abdulbasit.misproject.Adapters.CustomAdapter;
import com.example.abdulbasit.misproject.Entities.Contact;
import com.example.abdulbasit.misproject.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by Abdul basit on 5/6/2017.
 */

public class HomeFragment extends BaseFragment implements View.OnClickListener {
    View parentView;
    ListView listView;
    CustomAdapter adapter;
    EditText inputSearch;
    List<Contact> data;
    FloatingActionButton fab;

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
        listView = (ListView) parentView.findViewById(R.id.listView);
        fab = (FloatingActionButton) parentView.findViewById(R.id.fab);
        data = new ArrayList<>();
        adapter = new CustomAdapter(getData(),getContext());
        inputSearch = (EditText) parentView.findViewById(R.id.search);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                getHomeActivity().addFragmentToStack(DetailFragment.NewInstance(data.get(i)));
            }
        });

        inputSearch.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence cs, int arg1, int arg2, int arg3) {
                //String text = inputSearch.getText().toString().toLowerCase(Locale.getDefault());
                //adapter.filter(text);
            }

            @Override
            public void afterTextChanged(Editable editable) {
                String text = inputSearch.getText().toString().toLowerCase(Locale.getDefault());
                adapter.filter(text,getData());

            }

            @Override
            public void beforeTextChanged(CharSequence arg0, int arg1, int arg2,
                                          int arg3) {


            }
        });

    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if(id == R.id.fab){
            getHomeActivity().addFragmentToStack(new AddContactFragment());
        }
    }

    public List<Contact> getData() {
        data = getHomeActivity().getDbHelper().getAllUsers();
        return data;
    }
}
