package com.example.abdulbasit.misproject.DataCenter;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.abdulbasit.misproject.Constants.AppConstants;
import com.example.abdulbasit.misproject.Entities.Contact;
import com.example.abdulbasit.misproject.Helper.Utilities;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Abdul basit on 5/6/2017.
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    Context context;
    private static final String TABLE_USERS = "cn_user";


    private static final String KEY_ID = "cn_id";
    private static final String KEY_NAME = "cn_name";
    private static final String KEY_EMAIL = "cn_email";
    private static final String KEY_NUMBER = "cn_number";


    String CREATE_USERS_TABLE = "CREATE TABLE "
            + TABLE_USERS + "("
            + KEY_ID + " VARCHAR PRIMARY KEY,"
            + KEY_NAME + " VARCHAR,"
            + KEY_EMAIL + " VARCHAR,"
            + KEY_NUMBER + " VARCHAR )";

    public DatabaseHelper(Context context) {
        super(context, AppConstants.CROWDSOURCING_DB_NAME, null, AppConstants.CROWDSOURCING_DB_VERSION);
        this.context = context;

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        createTables(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    private void createTables(SQLiteDatabase db) {
        db.execSQL(CREATE_USERS_TABLE);
    }

    public List<Contact> getAllUsers() {
        List<Contact> users = new ArrayList<Contact>();
        String selectQuery = generateSelectQuery(TABLE_USERS);

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                Contact user = new Contact();
                user.setId(cursor.getString(0));
                user.setName(cursor.getString(1));
                user.setEmail(cursor.getString(2));
                user.setNumber(cursor.getString(3));
                users.add(user);
            } while (cursor.moveToNext());
        }
        return users;
    }

    private String generateSelectQuery(String table){
        String selectQuery = "SELECT  * FROM " + table;
        return selectQuery;
    }

    public void insertUser(Contact user) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(TABLE_USERS, null, getContentValues(user));
        db.close();
    }

    private ContentValues getContentValues(Contact user) {
        ContentValues values = new ContentValues();
        if (user!=null){
            if (!Utilities.isEmptyOrNull(user.getId())) {
                values.put(KEY_ID, user.getId());
            }
            if (!Utilities.isEmptyOrNull(user.getName())) {
                values.put(KEY_NAME, user.getName());
            }
            if (!Utilities.isEmptyOrNull(user.getEmail())) {
                values.put(KEY_EMAIL, user.getEmail());
            }
            if (!Utilities.isEmptyOrNull(user.getNumber())) {
                values.put(KEY_NUMBER, user.getNumber());
            }
        }
        return values;

    }

    public void deleteUser(String id){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_USERS, KEY_ID + "= ?", new String[]{id});
    }





    public Contact updateUser(Contact user, String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        String selection = KEY_ID + " = ?";
        String[] selectionArgs = {String.valueOf(id)};
        db.update(TABLE_USERS, updateUserContentValues(user), selection, selectionArgs);
        db.close();
        return user;
    }
    // add id and number below add refactor above code

    private ContentValues updateUserContentValues(Contact user) {
        ContentValues values = new ContentValues();
        if (!Utilities.isEmptyOrNull(user.getName())) {
            values.put(KEY_NAME, user.getName());
        }
        if (!Utilities.isEmptyOrNull(user.getEmail())) {
            values.put(KEY_EMAIL, user.getEmail());
        }
        if (!Utilities.isEmptyOrNull(user.getNumber())) {
            values.put(KEY_NUMBER, user.getNumber());
        }
        return values;
    }
}
