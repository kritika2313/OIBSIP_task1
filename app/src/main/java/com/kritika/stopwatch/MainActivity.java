package com.kritika.stopwatch;

import static android.os.SystemClock.elapsedRealtime;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;

public class MainActivity extends AppCompatActivity {
    Button B1,B2,B3;
    Chronometer C1;
    private long pauseoffset;
    private boolean isRunning=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        B1=findViewById(R.id.start);
        B2=findViewById(R.id.pause);
        B3=findViewById(R.id.stop);
        C1=findViewById(R.id.chronometer);
        B1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!isRunning){
                    C1.setBase(elapsedRealtime()-pauseoffset);
                    C1.start();
                    isRunning=true;
                    }
                }
                  });
        B2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isRunning){
                    C1.stop();
                    pauseoffset= SystemClock.elapsedRealtime()-C1.getBase();
                    isRunning=false;
                }

            }
        });
        B3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    C1.setBase(elapsedRealtime());
                    pauseoffset=0;
                    C1.stop();
                    isRunning=false;

            }
        });
    }

}