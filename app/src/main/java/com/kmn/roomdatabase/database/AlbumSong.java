package com.kmn.roomdatabase.database;

import android.app.AlertDialog;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

/*
у нас есть Album-ы, в которых есть песни, но я не могу в таблицу баз данных,
точнее, загнать список песен в одну запись Album-а, потому что в базах данных так нельзя.
Чтобы это обойти, мне нужно сделать еще одну сущность, которая будет связующим звеном,
еще одну таблицу, которая будет соответственно связывать песни и Album-ы. Назовем ее AlbumSong
 */

@Entity(foreignKeys = {
        @ForeignKey(entity = Album.class, parentColumns = "id", childColumns = "albumID"),
        @ForeignKey(entity = Song.class, parentColumns = "id", childColumns = "songID") })
public class AlbumSong {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private int mID;

    @ColumnInfo(name = "albumID")
    private  int mAlbumID;

    @ColumnInfo(name = "songID")
    private int mSongID;

    public AlbumSong() {
    }

    public AlbumSong(int ID, int albumID, int songID) {
        mID = ID;
        mAlbumID = albumID;
        mSongID = songID;
    }

    public int getID() {
        return mID;
    }

    public void setID(int ID) {
        mID = ID;
    }

    public int getAlbumID() {
        return mAlbumID;
    }

    public void setAlbumID(int albumID) {
        mAlbumID = albumID;
    }

    public int getSongID() {
        return mSongID;
    }

    public void setSongID(int songID) {
        mSongID = songID;
    }
}
