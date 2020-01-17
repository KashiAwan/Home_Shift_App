package com.example.home_shift_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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

                String emailstring = emailll.getText().toString();

                myRef.child(emailstring).child("Email").setValue(emailstring);
                myRef.child(emailstring).child("Name").setValue(namee.getText().toString());
                myRef.child(emailstring).child("Password").setValue(passs.getText().toString());

                Toast.makeText(Signupclass.this, "Signup Successfull", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(Signupclass.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }
}
