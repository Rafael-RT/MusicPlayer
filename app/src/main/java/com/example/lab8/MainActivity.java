package com.example.lab8;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.os.Bundle;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.util.Log;
import android.view.View;

import java.util.Random;


public class MainActivity extends AppCompatActivity {

    private Intent serviceIntent;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        serviceIntent = new Intent(this, MyService.class);
    }


    public void startService(View view)
    {
        serviceIntent.putExtra("Song", R.raw.song0);
        ContextCompat.startForegroundService(this, serviceIntent);
    }

    public void nextActivity(View view)
    {
        stopService(serviceIntent);
        Random rand = new Random();
        int maxNumber = 10;

        int randomNumber = rand.nextInt(maxNumber) + 1;
        String s = "song" + randomNumber;

        Resources res = this.getResources();
        int soundId = res.getIdentifier(s, "raw", this.getPackageName());

        serviceIntent.putExtra("Song", soundId);
        startService(serviceIntent);
    }

    public void stopService(View view)
    {
        stopService(serviceIntent);
    }
}