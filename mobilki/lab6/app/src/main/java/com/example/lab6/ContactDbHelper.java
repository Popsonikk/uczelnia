package com.example.lab6;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class ContactDbHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME="contact_db";
    public static final int DATABASE_VERSION=1;
    public static final String CREATE_TABLE= "create table "+ContactContract.ContactEntry.TABLE_NAME+"("+ContactContract.ContactEntry.NAME+" text,"+ContactContract.ContactEntry.COST+" number);";
    public static final String DROP_TABLE="drop table if exists "+ContactContract.ContactEntry.TABLE_NAME;

    public ContactDbHelper( Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(DROP_TABLE);
        onCreate(sqLiteDatabase);
    }
    public void addContact(int cost,String name,SQLiteDatabase database)
    {
        ContentValues contentValues=new ContentValues();
        contentValues.put(ContactContract.ContactEntry.NAME,name);
        contentValues.put(ContactContract.ContactEntry.COST,cost);
        database.insert(ContactContract.ContactEntry.TABLE_NAME,null,contentValues);
    }
    public Cursor readCotacts(SQLiteDatabase database)
    {
        String [] projections={ContactContract.ContactEntry.NAME,ContactContract.ContactEntry.COST};
        Cursor cursor=database.query(ContactContract.ContactEntry.TABLE_NAME,projections,null,null,null,null,null);
        return cursor;
    }
    public Cursor sumCotacts(SQLiteDatabase database)
    {
        String [] projections={ContactContract.ContactEntry.COST};
        Cursor cursor=database.query(ContactContract.ContactEntry.TABLE_NAME,projections,null,null,null,null,null);
        return cursor;
    }
}
