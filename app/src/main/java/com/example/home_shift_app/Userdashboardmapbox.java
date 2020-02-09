package com.example.home_shift_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.mapbox.mapboxsdk.Mapbox;
import com.mapbox.mapboxsdk.geometry.LatLng;
import com.mapbox.mapboxsdk.maps.MapView;
import com.mapbox.mapboxsdk.maps.MapboxMap;
import com.mapbox.mapboxsdk.maps.OnMapReadyCallback;
import com.mapbox.mapboxsdk.maps.Style;


public class Userdashboardmapbox extends AppCompatActivity implements MapboxMap.OnMapClickListener {

    private MapView mapView;
    EditText pickupp,droppofff;
    Button pickdone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Mapbox.getInstance(this, "pk.eyJ1Ijoia2FzaGlmYXdhbjc4NiIsImEiOiJjano1NHRzODMwNDRpM2xtZjQ5emJjdzFsIn0.pWxRIgH74b_KwvQZsZS6sg");
        setContentView(R.layout.activity_userdashboardmapbox);
        mapView = findViewById(R.id.mapView);
        pickupp=findViewById(R.id.pickuppp);
        droppofff=findViewById(R.id.droppofff);
        pickdone=findViewById(R.id.pickupppdone);
        mapView.onCreate(savedInstanceState);
        mapView.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(@NonNull MapboxMap mapboxMap) {
                mapboxMap.setStyle(Style.MAPBOX_STREETS, new Style.OnStyleLoaded() {
                    @Override
                    public void onStyleLoaded(@NonNull Style style) {

// Map is set up and the style has loaded. Now you can add data or make other map adjustments.


                    }
                });
            }
        });

        pickdone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String signinemaill;
                SharedPreferences sharedPreferences = getSharedPreferences("saveemail", MODE_PRIVATE);
                signinemaill = sharedPreferences.getString("saveemaail", String.valueOf(MODE_PRIVATE));

                FirebaseDatabase database=FirebaseDatabase.getInstance();
                DatabaseReference myRef= database.getReference("We Shift list");

                myRef.child(signinemaill).child("Pickup Location").setValue(pickupp.getText().toString());
                myRef.child(signinemaill).child("Dropoff Location").setValue(droppofff.getText().toString());

                minlocfun11();

            }
        });
    }

    public void minlocfun11(){
        Intent intent = new Intent(this, Vehiclelabour.class);
        startActivity(intent);
    }

    @Override
    public boolean onMapClick(@NonNull LatLng point) {


        return true;
    }

        @Override
    public void onStart() {
        super.onStart();
        mapView.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();
        mapView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mapView.onPause();
    }

    @Override
    public void onStop() {
        super.onStop();
        mapView.onStop();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapView.onLowMemory();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mapView.onSaveInstanceState(outState);
    }


}
