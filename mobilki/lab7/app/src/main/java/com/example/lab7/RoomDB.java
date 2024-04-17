package com.example.lab7;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {MainData.class}, version = 1, exportSchema = false)


public abstract class RoomDB extends RoomDatabase {
    //Stworzenie instancji bazy danych
    private static RoomDB database;
    //Zdefiniowanie nazwy
    private static String DATABASE_NAME = "database";

    public synchronized static RoomDB getInstance(Context context){

        //Sprawdzenie warunków
        if(database == null){
            //Kiedy database jest nullem
            //Inicjalizuj database

            database = Room.databaseBuilder(context.getApplicationContext(),
                    RoomDB.class,DATABASE_NAME).allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();



        }

        return database;


    }

    public abstract MainDao mainDao();
}
