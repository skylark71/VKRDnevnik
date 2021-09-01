package ru.shkolaandstudents.Teacher;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import ru.shkolaandstudents.R;

public class TeacherActivitySignUpSchool extends AppCompatActivity {
    EditText etNameSchool;
    EditText etCitySchool;
    Button btnSetSchool;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.teacher_activity_sign_up_school);

        etNameSchool = findViewById(R.id.etNameSchool);
        etCitySchool = findViewById(R.id.etCitySchool);
        btnSetSchool = findViewById(R.id.btnSetSchool);

        btnSetSchool.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseReference ref;
                String name = etNameSchool.getText().toString();
                String city = etCitySchool.getText().toString();
                ref = FirebaseDatabase.getInstance().getReference("Schools");
                String key = ref.push().getKey();
                ref.child(key).child("NameSchool").setValue(name);
                ref.child(key).child("CitySchool").setValue(city);
            }
        });

    }
}