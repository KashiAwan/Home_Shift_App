package com.example.home_shift_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class UserDashboard extends AppCompatActivity {

    TextView pickuploc, dropofloc;




    //String signinemaill;
    //SharedPreferences sharedPreferences = getSharedPreferences("saveemail", MODE_PRIVATE);
    //signinemaill = sharedPreferences.getString("saveemaail", String.valueOf(MODE_PRIVATE));
    //signnamee.setText(signinemaill);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_dashboard);

        pickuploc = findViewById(R.id.pickuploc);
        dropofloc = findViewById(R.id.drpofloc);



    }
}
