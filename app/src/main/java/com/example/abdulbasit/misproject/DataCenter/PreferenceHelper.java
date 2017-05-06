package com.example.abdulbasit.misproject.DataCenter;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.example.abdulbasit.misproject.Entities.User;
import com.example.abdulbasit.misproject.Helper.Utilities;

/**
 * Created by Abdul basit on 5/6/2017.
 */

public class PreferenceHelper {
    Context context;
    private static final String KEY_USER = "cn_user";
    private static final String KEY_EMAIL = "cn_email";
    private static final String KEY_PASSWORD = "cn_password";


    public PreferenceHelper(Context context) {
        this.context = context;
    }

    public void saveUserCredentials(User user) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor values = preferences.edit();
        values.putString(KEY_USER,user.getUserName());
        values.putString(KEY_EMAIL,user.getEmail());
        values.putString(KEY_PASSWORD, user.getPassword());
        values.apply();
    }

    public boolean isUserLogin() {
        if (Utilities.isEmptyOrNull(getValueByKey(KEY_USER))) {
            return false;
        }
        return true;
    }

    public String getValueByKey(String key) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        String value = preferences.getString(key, "");
        return value;
    }

    public void resetData() {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = preferences.edit();
        editor.clear();
        editor.commit();
    }

}
