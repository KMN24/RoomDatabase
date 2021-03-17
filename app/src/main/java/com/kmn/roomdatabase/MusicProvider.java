package com.kmn.roomdatabase;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;

import androidx.room.Room;

import com.kmn.roomdatabase.database.MusicDao;
import com.kmn.roomdatabase.database.MusicDatabase;

public class MusicProvider extends ContentProvider {

    private static final String TAG = MusicProvider.class.getSimpleName();
    private static final String AUTHORITY = "com.kmn.roomdatabase.musicprovider";
    private static final String TABLE_ALBUM = "album"; // Одно название с нашей таблицей Album в Album.java

    private static final UriMatcher URI_MATCHER = new UriMatcher(UriMatcher.NO_MATCH);
    private static final int ALBUM_TABLE_CODE = 100;
    private static final int ALBUM_ROW_CODE = 101;

    static {
        URI_MATCHER.addURI(AUTHORITY, TABLE_ALBUM, ALBUM_TABLE_CODE);
        URI_MATCHER.addURI(AUTHORITY, TABLE_ALBUM + "/*", ALBUM_ROW_CODE); // * - это любое числовое значение
    }

    private MusicDao mMusicDao;

    public MusicProvider() {

    }

    @Override
    public boolean onCreate() {
        // TODO: Implement this to initialize your content provider on startup.

        // in onCreate we are getting access for database
        if(getContext() != null){ // created database
            mMusicDao = Room.databaseBuilder(getContext().getApplicationContext(), MusicDatabase.class, "music_database")
                    .build()
                    .getMusicDao();
            return true;
        }
        return false;
    }

    @Override
    public String getType(Uri uri) {
        // TODO: Implement this to handle requests for the MIME type of the data
        // at the given URI.

        switch (URI_MATCHER.match(uri)){
            case ALBUM_TABLE_CODE :
                return "vnd.android.cursor.dir/" + AUTHORITY + "."+TABLE_ALBUM;
            case ALBUM_ROW_CODE:
                return "vnd.android.cursor.item/" + AUTHORITY + "."+TABLE_ALBUM;
            default:
                throw new UnsupportedOperationException("not yet implemented");
        }
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection,
                        String[] selectionArgs, String sortOrder) {
        // TODO: Implement this to handle query requests from clients.

        int code = URI_MATCHER.match(uri);
        if (code != ALBUM_ROW_CODE && code != ALBUM_TABLE_CODE){
            return null;
        }

        Cursor cursor;
        if(code == ALBUM_TABLE_CODE){
            cursor = mMusicDao.getAlbumsCursor();
        }else {
            cursor = mMusicDao.getAlbumWithIDCursor ( (int) ContentUris.parseId(uri));
        }
        return cursor;
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        // TODO: Implement this to handle requests to insert a new row.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection,
                      String[] selectionArgs) {
        // TODO: Implement this to handle requests to update one or more rows.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        // Implement this to handle requests to delete one or more rows.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
