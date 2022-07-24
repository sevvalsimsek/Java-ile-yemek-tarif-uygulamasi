package com.example.restaurant;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Yemekler extends AppCompatActivity {

    private TextView buttonHamur;
    private Button buttonCorba;
    private Button buttonEt;
    private Button buttonKurabiye;
    private Button btnAnasayfa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yemekler);

            buttonHamur=findViewById(R.id.buttonHamur);
            buttonHamur.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i= new Intent(Yemekler.this,Hamurisi.class);
                    startActivity(i);
                }
            });

            btnAnasayfa=findViewById(R.id.btnAnasayfa);
            btnAnasayfa.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i= new Intent(Yemekler.this,MainActivity.class);
                    startActivity(i);
                }
            });

        buttonCorba=findViewById(R.id.buttonCorba);
        buttonCorba.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(Yemekler.this,Corba.class);
                startActivity(i);
            }
        });

        buttonEt=findViewById(R.id.buttonEt);
        buttonEt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(Yemekler.this,Et.class);
                startActivity(i);
            }
        });


        buttonKurabiye=findViewById(R.id.buttonKurabiye);
        buttonKurabiye.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(Yemekler.this,Kurabiye.class);
                startActivity(i);
            }
        });



    }
}