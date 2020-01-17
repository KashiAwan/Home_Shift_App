package com.example.home_shift_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Signupclass extends AppCompatActivity {

    EditText namee, emailll,passs;
    Button signupnbut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signupclass);

        namee = findViewById(R.id.signNamee);
        emailll = findViewById(R.id.signEmail);
        passs = findViewById(R.id.signpasswrd);
        signupnbut = findViewById(R.id.signupbut);


        signupnbut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseDatabase database=FirebaseDatabase.getInstance();
                DatabaseReference myRef= database.getReference("We Shift");

                myRef.child("Userss").child("Email").setValue(emailll.getText().toString());
                myRef.child("Userss").child(emailll.getText().toString()).child("Name").setValue(passs.getText().toString());
                myRef.child("Userss").child(emailll.getText().toString()).child("Password").setValue(passs.getText().toString());
            }
        });

    }
}
