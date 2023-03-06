package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.os.Handler;

public class MainActivity extends AppCompatActivity {
    SoundPool sp ;
    int sonido_de_reproduccion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sp = new SoundPool(1 , AudioManager.STREAM_MUSIC , 1);
        sonido_de_reproduccion = sp.load( this , R.raw.nuevo_sonido , 1);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run(){
                sp.play(sonido_de_reproduccion , 1 , 1 , 1 , 0 , 0);
                startActivity(new Intent(MainActivity.this , MainActivity2.class));
                finish();
            }

        }, 4000);
    }
}