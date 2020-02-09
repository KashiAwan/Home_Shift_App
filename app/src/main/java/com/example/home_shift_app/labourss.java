package com.example.home_shift_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class labourss extends AppCompatActivity {

    Button twolabours,fivelabours,tenlabours;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_labourss);

        twolabours = findViewById(R.id.twolabours);
        fivelabours = findViewById(R.id.fivelabours);
        tenlabours = findViewById(R.id.tenlabours);

        twolabours.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String signinemaill;
                SharedPreferences sharedPreferences = getSharedPreferences("saveemail", MODE_PRIVATE);
                signinemaill = sharedPreferences.getString("saveemaail", String.valueOf(MODE_PRIVATE));

                FirebaseDatabase database=FirebaseDatabase.getInstance();
                DatabaseReference myRef= database.getReference("We Shift list");

                myRef.child(signinemaill).child("Labours").setValue("Two Labours");
                minlocfujkkkl();
            }
        });

        fivelabours.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String signinemaill;
                SharedPreferences sharedPreferences = getSharedPreferences("saveemail", MODE_PRIVATE);
                signinemaill = sharedPreferences.getString("saveemaail", String.valueOf(MODE_PRIVATE));

                FirebaseDatabase database=FirebaseDatabase.getInstance();
                DatabaseReference myRef= database.getReference("We Shift list");

                myRef.child(signinemaill).child("Labours").setValue("Five Labours");
                minlocfujkkkl();
            }
        });
        tenlabours.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String signinemaill;
                SharedPreferences sharedPreferences = getSharedPreferences("saveemail", MODE_PRIVATE);
                signinemaill = sharedPreferences.getString("saveemaail", String.valueOf(MODE_PRIVATE));

                FirebaseDatabase database=FirebaseDatabase.getInstance();
                DatabaseReference myRef= database.getReference("We Shift list");

                myRef.child(signinemaill).child("Labours").setValue("Ten Labours");
                minlocfujkkkl();
            }
        });

    }

    public void minlocfujkkkl(){
        Intent intent = new Intent(this, Finall_layyout.class);
        startActivity(intent);
    }
}
