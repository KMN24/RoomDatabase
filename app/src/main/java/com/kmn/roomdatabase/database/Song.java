package com.kmn.roomdatabase.database;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Song {

    @PrimaryKey
    @ColumnInfo(name = "id")
    private int mID;

    @ColumnInfo(name = "name")
    private String mName;

    @ColumnInfo(name = "duration")
    private String mDuration;

    public Song() {
    }

    public Song(int ID, String name, String duration) {
        mID = ID;
        mName = name;
        mDuration = duration;
    }

    public int getID() {
        return mID;
    }

    public void setID(int ID) {
        mID = ID;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getDuration() {
        return mDuration;
    }

    public void setDuration(String duration) {
        mDuration = duration;
    }
}
