package com.kmn.roomdatabase.database;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.RoomDatabase;

@Entity
public class Album { // Создали сущность альбом

    @PrimaryKey
    @ColumnInfo(name = "id")
    private int mID;

    @ColumnInfo(name = "name")
    private String mName;

    @ColumnInfo(name = "release")
    private String mReleaseDate;

    public Album() {
    }

    public Album(int ID, String name, String releaseDate) {
        mID = ID;
        mName = name;
        mReleaseDate = releaseDate;
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

    public String getReleaseDate() {
        return mReleaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        mReleaseDate = releaseDate;
    }

    @Override
    public String toString() {
        return "Album{" +
                "mID=" + mID +
                ", mName='" + mName + '\'' +
                ", mReleaseDate='" + mReleaseDate + '\'' +
                '}';
    }
}
