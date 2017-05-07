package com.example.abdulbasit.misproject.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.abdulbasit.misproject.Entities.Contact;
import com.example.abdulbasit.misproject.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by Ashar on 5/6/2017.
 */

public class CustomAdapter extends ArrayAdapter<Contact>{
    private List<Contact> dataSet;
    Context mContext;

    public CustomAdapter(List<Contact> data, Context context) {
        super(context, R.layout.row_list, data);
        this.dataSet = data;
        this.mContext=context;

    }

    private static class ViewHolder {
        TextView txtName;
        TextView txtEmail;
        TextView txtphone;
        ImageView person_Image;
    }


    public View getView(int position, View convertView, ViewGroup parent) {
        Contact contact=getItem(position);
        ViewHolder viewHolder;
        final View result;
        if (convertView==null)
        {
            viewHolder = new ViewHolder();
            LayoutInflater inflater=LayoutInflater.from(getContext());
            convertView=inflater.inflate(R.layout.row_list, parent, false);
            viewHolder.txtName = (TextView) convertView.findViewById(R.id.person_name);
            viewHolder.txtEmail = (TextView) convertView.findViewById(R.id.Email);
            viewHolder.txtphone = (TextView) convertView.findViewById(R.id.phone_number);
            viewHolder.person_Image = (ImageView) convertView.findViewById(R.id.Person_image);
            result=convertView;
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            result=convertView;
        }
        viewHolder.txtName.setText(contact.getName());
        viewHolder.txtEmail.setText(contact.getEmail());
        viewHolder.txtphone.setText(contact.getNumber());
        viewHolder.person_Image.setTag(position);
        // Return the completed view to render on screen
        return convertView;
    }

    public void filter(String charText,List<Contact> dataList) {
        charText = charText.toLowerCase(Locale.getDefault());
        dataSet.clear();
        if (charText.length() == 0) {
            dataSet.addAll(dataList);
        }
        else{
            for (Contact contact : dataList){
                if (contact.getName().toLowerCase(Locale.getDefault()).contains(charText)){
                    dataSet.add(contact);
                }
            }
        }
        notifyDataSetChanged();
    }



}
