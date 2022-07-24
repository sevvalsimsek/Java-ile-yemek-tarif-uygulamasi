package com.example.restaurant;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
//import com.google.firebase.installations.internal.FidListener;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tvKayıtOl;
    private EditText Email , Sifre;
    private Button giris;
    private TextView sifremiunuttum;
    private Button btnGiris;

    private FirebaseAuth mAuth;
    private ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvKayıtOl = findViewById(R.id.tvKayıtOl);
        tvKayıtOl.setOnClickListener(this);

        giris = (Button)findViewById(R.id.btnGiris);
        giris.setOnClickListener(this);

        Email = (EditText) findViewById(R.id.etEmail);
        Sifre = (EditText) findViewById(R.id.etŞifre);

        sifremiunuttum = findViewById(R.id.sifremiunuttum);
        sifremiunuttum.setOnClickListener(this);
        sifremiunuttum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Doğrulama E-Postanız bulunamadı", Toast.LENGTH_SHORT).show();
            }
        });

        btnGiris = findViewById(R.id.btnGiris);
        btnGiris.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(MainActivity.this,Yemekler.class);
                startActivity(i);
            }
        });






        progressBar = (ProgressBar) findViewById(R.id.progressBar);

       mAuth = FirebaseAuth.getInstance();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.tvKayıtOl:
                startActivity(new Intent(this,Kayit.class));
                break;

            case R.id.btnGiris:
                userLogin();
                break;

        }
    }


    private void userLogin() {
        String email = Email.getText().toString().trim();
        String sifre = Sifre.getText().toString().trim();

        if (email.isEmpty()){
            Email.setError("Email gereklidir");
            Email.requestFocus();
            return;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            Email.setError("Lütfen geçerli eposta adresini giriniz!");
            Email.requestFocus();
            return;
        }
        if (sifre.isEmpty()){
            Sifre.setError("Şifre gereklidir");
            Sifre.requestFocus();
            return;
        }
        if (sifre.length() < 6){
            Sifre.setError("Şifreniz en az 6 karakterli olmalı");
            Sifre.requestFocus();
            return;
        }



       progressBar.setVisibility(View.VISIBLE);
        mAuth.signInWithEmailAndPassword(email,sifre).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    startActivity(new Intent(MainActivity.this,MainActivity.class));
                }
                else{
                    Toast.makeText(MainActivity.this, "Giriş yapılamadı ! Lütfen kimlik bilgilerinizi kontrol edin", Toast.LENGTH_SHORT).show();
                    progressBar.setVisibility(View.GONE);

                }
            }
        });

    }


}