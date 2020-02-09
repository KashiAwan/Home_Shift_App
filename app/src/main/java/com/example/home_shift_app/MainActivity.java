package com.example.home_shift_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    EditText log_emaill, log_pass;
    Button loginbut;
    TextView createone;
    DatabaseReference refff;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        log_emaill = findViewById(R.id.Email);
        log_pass = findViewById(R.id.Passwrd);
        loginbut = findViewById(R.id.Loginbut);
        createone = findViewById(R.id.createone);


        loginbut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                refffunction();
            }
        });

        createone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, Signupclass.class);
                startActivity(intent);
            }
        });
    }

    public void refffunction() {

        refff = FirebaseDatabase.getInstance().getReference().child("We Shift").child(log_emaill.getText().toString());

        refff.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String Email1 = dataSnapshot.child("Email").getValue().toString();
                String Password1 = dataSnapshot.child("Password").getValue().toString();

                if (log_emaill.getText().toString().equals(Email1) && log_pass.getText().toString().equals(Password1)) {
                    minlocfun();
                } else if (!log_emaill.getText().toString().equals(Email1) && log_pass.getText().toString().equals(Password1)) {
                    Toast.makeText(MainActivity.this, "Enter Valid Email", Toast.LENGTH_SHORT).show();
                } else if (log_emaill.getText().toString().equals(Email1) && !log_pass.getText().toString().equals(Password1)) {
                    Toast.makeText(MainActivity.this, "Enter Valid Password", Toast.LENGTH_SHORT).show();
                } else if (!log_emaill.getText().toString().equals(Email1) && !log_pass.getText().toString().equals(Password1)) {
                    Toast.makeText(MainActivity.this, "Sign Up First or Enter Email & Password", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        sharedPreferences = getSharedPreferences("saveemail", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("saveemaail",log_emaill.getText().toString());
        editor.apply();
    }

    public void minlocfun(){
        Intent intent = new Intent(this, Userdashboardmapbox.class);
        startActivity(intent);
    }
}