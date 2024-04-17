package com.example.pz_patryk_popek;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.ContactsContract;

import java.util.Date;

public class ContactDbHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "contact_db";
    public static final int DATABASE_VERSION = 1;
    public static final String CREATE_TABLE = "create table " + ContactContract.ContactEntry.TABLE_NAME + "(" + ContactContract.ContactEntry.NOTE_BODY + " text," + ContactContract.ContactEntry.NOTE_TITLE + " text);";
    public static final String CREATE_NOTI_TABLE = "create table " + ContactContract.ContactEntryNoti.TABLE_NAME + "(" + ContactContract.ContactEntryNoti.NOTI_TITLE + " text,"+ ContactContract.ContactEntryNoti.NOTI_TIME + " text);";
    public static final String DROP_TABLE = "drop table if exists " + ContactContract.ContactEntry.TABLE_NAME;
    public static final String DROP_NOTI_TABLE = "drop table if exists " + ContactContract.ContactEntryNoti.TABLE_NAME;

    public ContactDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL(CREATE_TABLE);
        sqLiteDatabase.execSQL(CREATE_NOTI_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(DROP_TABLE);
        sqLiteDatabase.execSQL(DROP_NOTI_TABLE);
        onCreate(sqLiteDatabase);

    }

    public void addContact(String title, String body, SQLiteDatabase database) {
        ContentValues contentValues = new ContentValues();

        contentValues.put(ContactContract.ContactEntry.NOTE_TITLE, title);
        contentValues.put(ContactContract.ContactEntry.NOTE_BODY, body);
        database.insert(ContactContract.ContactEntry.TABLE_NAME, null, contentValues);
    }

    public Cursor readCotacts(SQLiteDatabase database) {
        String[] projections = {ContactContract.ContactEntry.NOTE_TITLE, ContactContract.ContactEntry.NOTE_BODY};
        Cursor cursor = database.query(ContactContract.ContactEntry.TABLE_NAME, projections, null, null, null, null, null);
        return cursor;
    }

    public void updateContact(String title, String newTitle, String body, SQLiteDatabase database) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(ContactContract.ContactEntry.NOTE_TITLE, newTitle);
        contentValues.put(ContactContract.ContactEntry.NOTE_BODY, body);
        String selection = ContactContract.ContactEntry.NOTE_TITLE + " = " + "'" + title + "'";
        database.update(ContactContract.ContactEntry.TABLE_NAME, contentValues, selection, null);
    }

    public void deleteContact(String title, SQLiteDatabase database) {
        String selection = ContactContract.ContactEntry.NOTE_TITLE + " = " + "'" + title + "'";
        database.delete(ContactContract.ContactEntry.TABLE_NAME, selection, null);
    }

    public void addNotiContact(String title,String time,  SQLiteDatabase database) {
        ContentValues contentValues = new ContentValues();

        contentValues.put(ContactContract.ContactEntryNoti.NOTI_TITLE, title);
        contentValues.put(ContactContract.ContactEntryNoti.NOTI_TIME, time);
        database.insert(ContactContract.ContactEntryNoti.TABLE_NAME, null, contentValues);


    }
    public Cursor readNotiCotacts(SQLiteDatabase database)
    {
        String [] projections={ContactContract.ContactEntryNoti.NOTI_TITLE,ContactContract.ContactEntryNoti.NOTI_TIME};
        Cursor cursor=database.query(ContactContract.ContactEntryNoti.TABLE_NAME,projections,null,null,null,null,null);
        return cursor;
    }
    public void deleteNotiContact(String title, SQLiteDatabase database) {
        String selection = ContactContract.ContactEntryNoti.NOTI_TITLE + " = " + "'" + title + "'";
        database.delete(ContactContract.ContactEntryNoti.TABLE_NAME, selection, null);
    }
}
