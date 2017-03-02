package com.example.ahsan.pokecatch;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import java.net.HttpURLConnection;
import java.util.Random;

public class Game extends Activity implements View.OnTouchListener {
    Animate ourview;
    Bitmap p1,p2,p3,p4,p5,p6,p7,p8,p9,p10,p11,s,b,bo;
    boolean add = true;
    Bitmap[] se = new Bitmap[6];
    float x,y,sx,sy,p1x,p1y,p2x,p2y,p3x,p3y,p4x,p4y,p5x,p5y,p6x,p6y,p7x,p7y,p8x,p8y,p9x,p9y,p10x,p10y;
    int count=0;
    int[] dimen = new int[12];
    Random crazy;
    SoundPool sp;
    int exp1=0;
    int exp2=0;
    int poke=50;
    SharedPreferences pref;
    SharedPreferences.Editor editor;
    final static public String HIGHSCORE = "highscore";
    int HighScore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ourview = new Animate(this);
        ourview.setOnTouchListener(this);
        setContentView(ourview);
         pref = getSharedPreferences("HighScore", Context.MODE_PRIVATE);
         HighScore = pref.getInt(HIGHSCORE, 0);
        editor = pref.edit();

    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        x = event.getX()-120;
        y = event.getY()-300;
        return true;
    }

    public class Animate extends View {
        public Animate(Context context) {
            super(context);
            p1 = BitmapFactory.decodeResource(getResources(),R.drawable.a);
            p2 = BitmapFactory.decodeResource(getResources(),R.drawable.b);
            p3 = BitmapFactory.decodeResource(getResources(),R.drawable.c);
            p4 = BitmapFactory.decodeResource(getResources(),R.drawable.d);
            p5 = BitmapFactory.decodeResource(getResources(),R.drawable.e);
            p6 = BitmapFactory.decodeResource(getResources(),R.drawable.f);
            p7 = BitmapFactory.decodeResource(getResources(),R.drawable.chick);
            p8 = BitmapFactory.decodeResource(getResources(),R.drawable.balba);
            p9 = BitmapFactory.decodeResource(getResources(),R.drawable.chara);
            p10 = BitmapFactory.decodeResource(getResources(),R.drawable.pika);
            p11 = BitmapFactory.decodeResource(getResources(),R.drawable.bk);
            b = BitmapFactory.decodeResource(getResources(),R.drawable.ball);
            bo = BitmapFactory.decodeResource(getResources(),R.drawable.ballopen);
            crazy = new Random();
            x=-200;
            y=0;
            sx = getWidth()/2;
            sy = getHeight()-300;
            p1x=crazy.nextInt(500);
            p2x=crazy.nextInt(500);
            p3x=crazy.nextInt(500);
            p4x=crazy.nextInt(500);
            p5x=crazy.nextInt(500);
            p6x=crazy.nextInt(500);
            p7x=crazy.nextInt(500);
            p8x=crazy.nextInt(500);
            p9x=crazy.nextInt(500);
            p10x=crazy.nextInt(500);
            p1y=0;
            p2y=-1000;
            p3y=-2000;
            p4y=-3000;
            p5y=-4000;
            p6y=-5000;
            p7y=-6000;
            p8y=-7000;
            p9y=-8000;
            p10y=-9000;
            sp = new SoundPool(10, AudioManager.STREAM_MUSIC,0);
            exp1 = sp.load(context,R.raw.play1,1);
            exp2 = sp.load(context,R.raw.play2,2);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            canvas.drawBitmap(p11,0,0,null);
            Paint paint = new Paint();
            paint.setColor(Color.BLACK);
            paint.setTextAlign(Paint.Align.LEFT);
            paint.setTextSize(50);
            canvas.drawText("Score: " + count, 20, 50, paint);
            canvas.drawText("Pokemons: " + poke, getWidth() - 380, 50, paint);
            canvas.drawBitmap(p1, p1x, p1y, null);
            canvas.drawBitmap(p2, p2x, p2y, null);
            canvas.drawBitmap(p3, p3x, p3y, null);
            canvas.drawBitmap(p4, p4x, p4y, null);
            canvas.drawBitmap(p5,p5x,p5y,null);
            canvas.drawBitmap(p6,p6x,p6y,null);
            canvas.drawBitmap(p7,p7x,p7y,null);
            canvas.drawBitmap(p8,p8x,p8y,null);
            canvas.drawBitmap(p9,p9x,p9y,null);
            canvas.drawBitmap(p10,p10x,p10y,null);
            if(y>getHeight()*0.70) {
                sx=x;
                sy=y;
            }
            canvas.drawBitmap(bo, sx, sy, null);
            if(p1y>getHeight())
            {
                p1y=0;
                p1x=crazy.nextInt(getWidth()-120);
                if(p1x<30)
                {
                    p1x=p1x+150;
                }
                sp.play(exp1,1,1,0,0,1);
                poke--;

            }
            if(p2y>getHeight())
            {
                p2y=-1000;
                p2x=crazy.nextInt(getWidth()-220);
                if(p2x<30)
                {
                    p2x=p2x+150;
                }
                sp.play(exp1,1,1,0,0,1);
                poke--;

            }

            if(p3y>getHeight())
            {
                p3y=-2000;
                p3x=crazy.nextInt(getWidth()-320);
                if(p3x<30)
                {
                    p3x=p3x+150;
                }
                sp.play(exp1,1,1,0,0,1);
                poke--;

            }

            if(p4y>getHeight())
            {
                p4y=-3000;
                p4x=crazy.nextInt(getWidth()-370);
                if(p4x<30)
                {
                    p4x=p4x+150;
                }
                sp.play(exp1,1,1,0,0,1);
                poke--;

            }
            if(p5y>getHeight())
            {
                p5y=-4000;
                p5x=crazy.nextInt(getWidth()-420);
                if(p5x<30)
                {
                    p5x=p5x+150;
                }
                poke--;

                sp.play(exp1,1,1,0,0,1);
            }
            if(p6y>getHeight())
            {
                p6y=-6000;
                p6x=crazy.nextInt(getWidth()-470);
                if(p6x<30)
                {
                    p6x=p6x+150;
                }
                poke--;

                sp.play(exp1,1,1,0,0,1);
            }
            if(p7y>getHeight())
            {
                p7y=-7000;
                p7x=crazy.nextInt(getWidth()-470);
                if(p7x<30)
                {
                    p7x=p7x+150;
                }
                sp.play(exp1,1,1,0,0,1);
                poke--;

            }
            if(p8y>getHeight())
            {
                p8y=-8000;
                p8x=crazy.nextInt(getWidth()-470);
                if(p8x<30)
                {
                    p8x=p8x+150;
                }
                sp.play(exp1,1,1,0,0,1);
                poke--;

            }
            if(p9y>getHeight())
            {
                p9y=-9000;
                p9x=crazy.nextInt(getWidth()-470);
                if(p9x<30)
                {
                    p9x=p9x+150;
                }
                poke--;

                sp.play(exp1,1,1,0,0,1);
            }
            if(p10y>getHeight())
            {
                p10y=-10000;
                p10x=crazy.nextInt(getWidth()-470);
                if(p10x<30)
                {
                    p10x=p10x+150;
                }
                poke--;

                sp.play(exp1,1,1,0,0,1);
            }
            if(p1x>x&&p1x<(x+100)&&p1y>y&&p1y<(y+100))
            {
                p1y=-1000;
                p1x=crazy.nextInt(getWidth()-120);
                if(p1x<30)
                {
                    p1x=p1x+80;
                }
                sp.play(exp2,1,1,0,0,1);
                canvas.drawBitmap(b, x, y, null);
                poke--;

                count++;
            }
            if(p2x>x&&p2x<(x+100)&&p2y>y&&p2y<(y+100))
            {
                p2y=-2000;
                p2x=crazy.nextInt(getWidth()-170);
                if(p2x<30)
                {
                    p2x=p2x+80;
                }
                sp.play(exp2,1,1,0,0,1);
                canvas.drawBitmap(b, x, y, null);
                poke--;

                count++;
            }
            if(p3x>x&&p3x<(x+100)&&p3y>y&&p3y<(y+100))
            {
                p3y=-3000;
                p3x=crazy.nextInt(getWidth()-220);
                if(p3x<30)
                {
                    p3x=p3x+80;
                }
                sp.play(exp2,1,1,0,0,1);
                canvas.drawBitmap(b, x, y, null);
                poke--;

                count++;
            }
            if(p4x>x&&p4x<(x+100)&&p4y>y&&p4y<(y+100))
            {
                p4y=-4000;
                p4x=crazy.nextInt(getWidth()-320);
                if(p4x<30)
                {
                    p4x = p4x + 80;
                }
                canvas.drawBitmap(b, x, y, null);

                sp.play(exp2, 1, 1, 0, 0, 1);
                poke--;

                count++;
            }
            if(p5x>x&&p5x<(x+100)&&p5y>y&&p5y<(y+100))
            {
                p5y=-5000;
                p5x=crazy.nextInt(getWidth()-370);
                if(p5x<30)
                {
                    p5x=p5x+80;
                }
                canvas.drawBitmap(b,x,y,null);

                sp.play(exp2,1,1,0,0,1);
                poke--;

                count++;
            }
            if(p6x>x&&p6x<(x+100)&&p6y>y&&p6y<(y+100))
            {
                p6y=-6000;
                p6x=crazy.nextInt(getWidth()-420);
                if(p6x<30)
                {
                    p6x=p6x+80;
                }
                canvas.drawBitmap(b,x,y,null);

                sp.play(exp2,1,1,0,0,1);
                poke--;

                count++;
            }
            if(p7x>x&&p7x<(x+100)&&p7y>y&&p7y<(y+100))
            {
                p7y=-7000;
                p7x=crazy.nextInt(getWidth()-420);
                if(p7x<30)
                {
                    p7x=p7x+80;
                }
                canvas.drawBitmap(b,x,y,null);

                sp.play(exp2,1,1,0,0,1);
                poke--;

                count++;
            }
            if(p8x>x&&p8x<(x+100)&&p8y>y&&p8y<(y+100))
            {
                p8y=-8000;
                p8x=crazy.nextInt(getWidth()-420);
                if(p8x<30)
                {
                    p8x=p8x+80;
                }
                canvas.drawBitmap(b,x,y,null);

                sp.play(exp2,1,1,0,0,1);
                poke--;

                count++;
            }
            if(p9x>x&&p9x<(x+100)&&p9y>y&&p9y<(y+100))
            {
                p9y=-9000;
                p9x=crazy.nextInt(getWidth()-420);
                if(p9x<30)
                {
                    p9x=p9x+80;
                }
                canvas.drawBitmap(b,x,y,null);
                sp.play(exp2,1,1,0,0,1);
                poke--;
                count++;
            }
            if(p10x>x&&p10x<(x+100)&&p10y>y&&p10y<(y+100))
            {
                p10y=-6000;
                p10x=crazy.nextInt(getWidth()-420);
                if(p10x<30)
                {
                    p10x=p10x+80;
                }
                canvas.drawBitmap(b,x,y,null);
                sp.play(exp2,1,1,0,0,1);
                poke--;
                count++;
            }
            if(count<11)
            {
                p1y = p1y+10;
                p2y = p2y+10;
                p3y = p3y+10;
                p4y = p4y+10;
                p5y = p5y+10;
                p6y = p6y+10;
                p7y = p7y+10;
                p8y = p8y+10;
                p9y = p9y+10;
                p10y = p10y+10;
            }
            if(count>10)
            {
                p1y = p1y+12;
                p2y = p2y+12;
                p3y = p3y+12;
                p4y = p4y+12;
                p5y = p5y+12;
                p6y = p6y+12;
                p7y = p7y+12;
                p8y = p8y+12;
                p9y = p9y+12;
                p10y = p10y+12;
            }
            if(poke>0) {
                invalidate();
            }
            else {
                GameOver();
            }
        }

    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
    public void GameOver()
    {
        if(count>HighScore)
        {
            HighScore = count;
            editor.putInt(HIGHSCORE, HighScore);
        }
        editor.commit();
        Intent i = new Intent(this,GameOver.class);
        i.putExtra("count",count);
        i.putExtra("high",HighScore);
        startActivity(i);
        Toast.makeText(this, "GameOver", Toast.LENGTH_SHORT).show();
    }
}
