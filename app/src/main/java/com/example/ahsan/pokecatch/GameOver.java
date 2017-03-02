package com.example.ahsan.pokecatch;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GameOver extends Activity implements View.OnClickListener{
    TextView t1,t2,t3;
    Button m1button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gameover);
        t1 = (TextView) findViewById(R.id.tv1);
        t2 = (TextView) findViewById(R.id.tv2);
        t3 = (TextView) findViewById(R.id.tv3);
        m1button = (Button) findViewById(R.id.bt);
        Intent i = getIntent();
        int count = i.getIntExtra("count", 0);
        int highscore = i.getIntExtra("high",0);
        t2.setText("Score: " + count);
        t3.setText("Highest Score: "+ highscore);
        m1button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.bt:
                Intent i = new Intent(this , Game.class);
                startActivity(i);
                break;
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}
