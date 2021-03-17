package com.kmn.roomdatabase;

import android.app.Application;

import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.kmn.roomdatabase.database.MusicDatabase;

public class AppDelegate extends Application {

    private MusicDatabase mMusicDatabase;

    @Override
    public void onCreate() {
        super.onCreate();

        mMusicDatabase = Room.databaseBuilder(getApplicationContext(), MusicDatabase.class, "music_database")
                /*
                    room по умолчанию работает в Found потоке, то есть извлечение и добавление данных должно
                    происходить в фоновом потоке. Я в ознакомительных целях, исключительно, поменяю это поведение,
                    Воспроизведите видео, начиная с :6:27, и следуйте текстовым инструкциям6:27
                    AllowMainTreadQueries с помощью этого метода. И теперь я смогу добавлять данные в базу данных,
                    в MainTread, но это, как вы уже знаете это плохая, плохая идея, не самая лучшая.
                 */
                .allowMainThreadQueries()
                .build();
        // создали базу данныз



    }

    public MusicDatabase getMusicDatabase() {
        return mMusicDatabase;
    }
}
