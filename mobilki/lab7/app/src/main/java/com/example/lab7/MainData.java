package com.example.lab7;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName =  "table_name")

class MainData implements Serializable {


    @PrimaryKey(autoGenerate = true)
    private int ID;


    @ColumnInfo(name = "text")
    private String text;




    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}