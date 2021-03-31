package ru.shkolaandstudents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ActivitySchoolManMenu extends AppCompatActivity {

    Button btnCreatePasp;
    SharedPreferences prefs = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_school_man_menu);

        prefs = getSharedPreferences("com.mycompany.myAppName", MODE_PRIVATE);

        btnCreatePasp = findViewById(R.id.btnCreateRasp);

        btnCreatePasp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openChoose1();
            }
        });
    }

    public void openChoose1()
    {
        Intent intent = new Intent(this, ActivitySetMonday.class);
        startActivity(intent);
    }
}