package com.example.restaurant;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.UUID;


public class Kayit extends AppCompatActivity{

   private FirebaseAuth auth;
    private EditText email ,password,name,surname,tc,telefon;
    private Button registerButton;
    private TextView tvGirişYap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kayit);

        auth = FirebaseAuth.getInstance();
        initViews();

    }

    private void initViews(){
        name = findViewById(R.id.name);
        surname = findViewById(R.id.surname);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        registerButton = findViewById(R.id.registerButton);
        tc=findViewById(R.id.tc);

        telefon =findViewById(R.id.telefon);

        tvGirişYap =findViewById(R.id.tvGirişYap);



        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Kayit(email.getText().toString(), password.getText().toString());
            }
        });

        tvGirişYap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Kayit.this,MainActivity.class);
                startActivity(intent);
            }
        });

    }

    private void Kayit(String email, String password){
       auth.createUserWithEmailAndPassword(email, password)
               .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            kullanıcıVeritabanınaKayıtEt();
                            Toast.makeText(Kayit.this, "Hoşgeldiniz", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(Kayit.this,MainActivity.class);
                            startActivity(intent);

                        } else {
                            Toast.makeText(Kayit.this, "Kayıt İşlemi başarısız", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }


    private void kullanıcıVeritabanınaKayıtEt() {

        String ad = name.getText().toString();
        String soyad = surname.getText().toString();
        String eposta = email.getText().toString();
        String tcNumarası = tc.getText().toString();
        String ktelefon = telefon.getText().toString();


       user user = new user(auth.getCurrentUser().getUid(),ad,soyad,eposta,tcNumarası,ktelefon);
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        db.collection("users")
                .add(user)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {

                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(Kayit.this, "Kullanıcıyı veritabanına kayıt ederken bir sorun oluştu.", Toast.LENGTH_SHORT).show();
                    }
                });
    }

}