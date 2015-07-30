package com.akvasov.android.paintbolltrainermvp;

import android.annotation.TargetApi;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import static android.view.View.*;


public class FullscreenActivity extends Activity implements OnClickListener{

    private ImageView barrier1;
    private ImageView barrier2;
    private ImageView barrier3;
    private ImageView barrier4;
    private ImageView barrier5;
    private ImageView barrier6;

    private TextView textView;

    private Game game = new Game();

    private Integer points = 0;
    private Integer currentState = 0;

    private Boolean gameOver = false;

    private void findAllObjects() {
        barrier1 = (ImageView) findViewById(R.id.imageView1);
        barrier1.setOnClickListener(this);
        barrier2 = (ImageView) findViewById(R.id.imageView2);
        barrier2.setOnClickListener(this);
        barrier3 = (ImageView) findViewById(R.id.imageView3);
        barrier3.setOnClickListener(this);
        barrier4 = (ImageView) findViewById(R.id.imageView4);
        barrier4.setOnClickListener(this);
        barrier5 = (ImageView) findViewById(R.id.imageView5);
        barrier5.setOnClickListener(this);
        barrier6 = (ImageView) findViewById(R.id.imageView6);
        barrier6.setOnClickListener(this);

        textView = (TextView) findViewById(R.id.textView);
        textView.setOnClickListener(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fullscreen);

        findAllObjects();
    }

    private void drawBarrierCatch(Integer state) {
        textView.setText("Найди " + state.toString());
    }

    private void catchBarrier(Integer index) {
        if (gameOver) return;
        points++;
        if (currentState == index) {
            if (game.isOver()) {
                gameOver = true;
                Toast.makeText(this, "Молодчик!! Выйграл", Toast.LENGTH_SHORT).show();
                textView.setText("У вас " + points.toString() + " очков");
            } else {
                currentState = game.getNewBarrier();
                drawBarrierCatch(currentState);
                Toast.makeText(this, "Молодчик!! Давай дальше", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "Мазила, попробуй снова!", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onClick(View v) {
        if (gameOver) return;
        switch (v.getId()) {
            case R.id.imageView1:
                catchBarrier(1);
                break;
            case R.id.imageView2:
                catchBarrier(2);
                break;
            case R.id.imageView3:
                catchBarrier(3);
                break;
            case R.id.imageView4:
            case R.id.imageView5:
            case R.id.imageView6:
                Toast.makeText(this, "Это вражеский объект!!!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.textView:
                if (currentState == 0) {
                    currentState = game.getNewBarrier();
                    drawBarrierCatch(currentState);
                }
                break;
        }
    }
}
