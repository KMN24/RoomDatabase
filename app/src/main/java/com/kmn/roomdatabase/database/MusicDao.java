package com.kmn.roomdatabase.database;

// Dao - Data Access Object

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface MusicDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE) // если уже есть такой альбом то новый альбом его заменит
    void insertAlbums(List<Album> albums);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertSongs(List<Song> songs);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void setLinksAlbumSongs(List<AlbumSong> linksAlbumSongs);

    // Мы данные уже вставили и мы можем вызввать обратно

    @Query("select * from album")
    List<Album> getAlbums();

    @Query("select * from song")
    List<Song> getSongs();

    @Delete
    void deleteAlbum(Album album);

    /*
    Написали мы query запрос, получить всё из таблицы песен, связанное с таблицей Album Song,
    по Id-шнику песен и в этой новой таблице, где Album Id равен Albumу Id, которому мы передали
     */
    @Query("select * from song inner join albumsong on song.id = albumsong.songID where albumID = :albumID")
    List<Song> getSongsFromAlbum(int albumID);


}
