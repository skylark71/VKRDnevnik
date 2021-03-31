package ru.shkolaandstudents.RecyclerViewTeacher;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

import ru.shkolaandstudents.R;

public class TeacherCreateClassList extends AppCompatActivity {
    ArrayList<ExampleItem> mExampleList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.teacher_activity_create_class_list);

        SharedPreferences sharedPreferences = getSharedPreferences("shared preferences", MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString("task list", null);
        Type type = new TypeToken<ArrayList<ExampleItem>>() {}.getType();
        mExampleList = gson.fromJson(json, type);
        if (mExampleList == null) {
            mExampleList = new ArrayList<>();
        }

        String Fulltext = sharedPreferences.getString("task list", null);
        String s1 = "mLine1";
        String[] split = Fulltext.split(s1);
        int count = split.length - 1;

        ExampleItem crt;
        String it2;
        final String[] strClass = new String[count];

        /*for (int j = 1; j < count; j++)
        {
            crt = mExampleList.get(j);
            it2 = crt.getLine2();
            strClass[j] = it2;
        }*/


        LinearLayout ll = (LinearLayout)findViewById(R.id.li);
        Button btn1;
        for (int i = 0; i < count; i++) {
            crt = mExampleList.get(i);
            it2 = crt.getLine2();
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT);
            Button btn = new Button(this);
            btn.setId(i);
            final int id_ = btn.getId();
            btn.setText(it2 + " Класс ");
            //btn.setBackgroundColor(Color.rgb(70, 80, 90));
            btn.setWidth(100);
            btn.setHeight(60);
            params.setMargins(0, 30, 0, 0);
            ll.addView(btn, params);
            btn1 = ((Button) findViewById(id_));
            final String finalIt = it2;
            btn1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Toast.makeText(view.getContext(),
                            "Button clicked index = " + id_, Toast.LENGTH_SHORT)
                            .show();
                    Intent intent = new Intent(TeacherCreateClassList.this, TeacherSetClassList.class);
                    intent.putExtra("finalIt", finalIt);
                    startActivity(intent);
                }
            });
        }
    }
}