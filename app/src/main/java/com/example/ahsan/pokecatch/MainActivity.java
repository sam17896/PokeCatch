package com.example.ahsan.pokecatch;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button m1;
    MediaPlayer mp ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        m1 = (Button) findViewById(R.id.button);
        m1.setOnClickListener(this);
        mp = MediaPlayer.create(this, R.raw.play);
        mp.start();
    }

    @Override
    public void onClick(View v) {
        mp.release();
        Intent i = new Intent(this , Game.class);
        startActivity(i);
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        mp.release();
        finish();
    }
}
