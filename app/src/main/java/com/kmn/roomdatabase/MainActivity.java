package com.kmn.roomdatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.kmn.roomdatabase.database.Album;
import com.kmn.roomdatabase.database.MusicDao;
import com.kmn.roomdatabase.database.MusicDatabase;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Button mAddBtn;
    private Button mGetBtn;

    /**
     *  добавить базу данных Room --- done
     *  вставить данные / извлечь данные  ---done
     *  добавить контент провайдер над Room
     *
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
        Итак, мы написали три таблицы в нашей базе данных. Один дал объект для работ с иными таблицами,
        и один class - MusicDatabase, чтобы получить доступ к нашей базе данных.
         */

        // Как получить доступ к баззе данных - создадим класс AppDelegate


        final MusicDao musicDao = ((AppDelegate) getApplicationContext()).getMusicDatabase().getMusicDao();

        mAddBtn = ((Button) findViewById(R.id.add));
        mAddBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                musicDao.insertAlbums(createAlbums());
            }
        });

        mGetBtn = findViewById(R.id.get);
        mGetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToast(musicDao.getAlbums() );
            }
        });

    }

    private void showToast(List<Album> albums) {
        StringBuilder builder = new StringBuilder();
        for(int i=0, size = albums.size(); i< size; i++){
            builder.append(albums.get(i).toString()).append("\n");
        }
        Toast.makeText(this, builder.toString(), Toast.LENGTH_SHORT).show();
    }

    private List<Album> createAlbums() {

        List<Album> albums = new ArrayList<>();
        for (int i=0; i<10; i++){
            albums.add(new Album(i, "album " + i, "release " + System.currentTimeMillis() ));
        }

        return albums;
    }
}