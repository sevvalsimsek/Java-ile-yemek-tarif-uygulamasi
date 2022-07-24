package com.example.restaurant;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

public class Et extends AppCompatActivity {
    private CheckBox cbHeart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_et);
        cbHeart= findViewById(R.id.cbHeart);
        cbHeart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Et.this, "Favorilere Eklendi", Toast.LENGTH_SHORT).show();
            }
        });
    }
}