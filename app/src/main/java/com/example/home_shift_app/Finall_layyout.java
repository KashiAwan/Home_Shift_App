package com.example.home_shift_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

import java.util.Objects;

public class Finall_layyout extends AppCompatActivity {

    TextView pickuploc,dropoffloc,vehicle,labours;
    Button done;
    DatabaseReference refff;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finall_layyout);
        pickuploc = findViewById(R.id.pickupplocation);
        dropoffloc = findViewById(R.id.dropofflocation);
        vehicle = findViewById(R.id.Vehicleselected);
        labours = findViewById(R.id.labourselected);
        done = findViewById(R.id.donneenene);

        String signinemaill;
        SharedPreferences sharedPreferences = getSharedPreferences("saveemail", MODE_PRIVATE);
        signinemaill = sharedPreferences.getString("saveemaail", String.valueOf(MODE_PRIVATE));
        refff = FirebaseDatabase.getInstance().getReference().child("We Shift list").child(signinemaill);

        refff.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String pickk = Objects.requireNonNull(dataSnapshot.child("Pickup Location").getValue()).toString();
                String dropp = Objects.requireNonNull(dataSnapshot.child("Dropoff Location").getValue()).toString();
                String vehiicc= Objects.requireNonNull(dataSnapshot.child("Vehicle").getValue()).toString();
                String labourss = Objects.requireNonNull(dataSnapshot.child("Labours").getValue()).toString();

                pickuploc.setText(pickk);
                dropoffloc.setText(dropp);
                vehicle.setText(vehiicc);
                labours.setText(labourss);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        done.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        Intent intent = new Intent(Finall_layyout.this, Userdashboardmapbox.class);
                                        startActivity(intent);
                                    }
        }
        );
    }
}
