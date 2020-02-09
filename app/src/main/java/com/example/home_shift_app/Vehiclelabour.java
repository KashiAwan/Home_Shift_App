package com.example.home_shift_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Vehiclelabour extends AppCompatActivity {

    Button vehiclea,vehicleb,vehiclec;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehiclelabour);

        vehiclea = findViewById(R.id.pickupp);
        vehicleb = findViewById(R.id.minitruckk);
        vehiclec = findViewById(R.id.truckk);

        vehiclea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String signinemaill;
                SharedPreferences sharedPreferences = getSharedPreferences("saveemail", MODE_PRIVATE);
                signinemaill = sharedPreferences.getString("saveemaail", String.valueOf(MODE_PRIVATE));

                FirebaseDatabase database=FirebaseDatabase.getInstance();
                DatabaseReference myRef= database.getReference("We Shift list");

                myRef.child(signinemaill).child("Vehicle").setValue("Pickup");
                minlocfunhjj();
            }
        });

        vehicleb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String signinemaill;
                SharedPreferences sharedPreferences = getSharedPreferences("saveemail", MODE_PRIVATE);
                signinemaill = sharedPreferences.getString("saveemaail", String.valueOf(MODE_PRIVATE));

                FirebaseDatabase database=FirebaseDatabase.getInstance();
                DatabaseReference myRef= database.getReference("We Shift list");

                myRef.child(signinemaill).child("Vehicle").setValue("Mini Truck");
                minlocfunhjj();
            }
        });
        vehiclec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String signinemaill;
                SharedPreferences sharedPreferences = getSharedPreferences("saveemail", MODE_PRIVATE);
                signinemaill = sharedPreferences.getString("saveemaail", String.valueOf(MODE_PRIVATE));

                FirebaseDatabase database=FirebaseDatabase.getInstance();
                DatabaseReference myRef= database.getReference("We Shift list");

                myRef.child(signinemaill).child("Vehicle").setValue("Truck");
                minlocfunhjj();
            }
        });

    }

    public void minlocfunhjj(){
        Intent intent = new Intent(this, labourss.class);
        startActivity(intent);
    }
}
