package com.example.restaurant;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class splash_screen extends AppCompatActivity { //handler işleyişi import ettik.
    Handler h= new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        h.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i= new Intent(splash_screen.this,MainActivity.class);
                startActivity(i);
                finish();
            }
        },3000); // 3 saniye gözükmesi için 3000 milisaniye girdik.
    }
}