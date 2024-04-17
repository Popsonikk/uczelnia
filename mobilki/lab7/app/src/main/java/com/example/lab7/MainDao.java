package com.example.lab7;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import static androidx.room.OnConflictStrategy.REPLACE;

@Dao
public interface MainDao {

    //utwórz zpaytanie
    @Insert(onConflict = REPLACE)
    void insert(MainData mainData);

    //usun zapytanie
    @Delete
    void delete(MainData mainData);

    //Usuń wszystko
    @Delete
    void reset(List<MainData> mainData);

    @Query("UPDATE table_name SET text = :sText WHERE ID = :sID")
    void update(int sID, String sText);

    @Query("SELECT * FROM table_name")
    List <MainData> getAll();

}