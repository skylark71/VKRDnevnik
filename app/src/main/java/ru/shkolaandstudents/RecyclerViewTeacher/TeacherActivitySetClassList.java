package ru.shkolaandstudents.RecyclerViewTeacher;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

import ru.shkolaandstudents.R;

public class TeacherActivitySetClassList extends AppCompatActivity {

    ArrayList<ExampleItem> mExampleList;
    private RecyclerView mRecyclerView;
    private ClassAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private ClassAdapter.RecyclerViewClickListener listener;
    DatabaseReference ref;
    String school;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.teacher_activity_set_class_list);

        //loadData();

        SharedPreferences sharedPreferences = getSharedPreferences("Settings", MODE_PRIVATE);
        String text = sharedPreferences.getString("school", "");
        school = text;

        mRecyclerView = findViewById(R.id.recyclerview1);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        ref = database.getReference(school);

        mExampleList = new ArrayList<>();
        mAdapter = new ClassAdapter(mExampleList,listener);

        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                mExampleList.clear();
                for (DataSnapshot ds : snapshot.getChildren()){

                    String line1 = ds.getKey();
                    String line2 = "";
                    mExampleList.add(new ExampleItem(line1, line2));
                }
                mAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        mRecyclerView.setAdapter(mAdapter);

        mAdapter.setOnItemClickListener(new ClassAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Intent intent = new Intent(getApplicationContext(), TeacherActivityClassList.class);
                intent.putExtra("class", mExampleList.get(position).getLine1());
                intent.putExtra("school", school);
                startActivity(intent);
            }

        });
    }
}

