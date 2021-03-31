package ru.shkolaandstudents.RecyclerViewTeacher;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.play.core.tasks.Task;
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
import java.util.HashMap;

import ru.shkolaandstudents.R;

public class TeacherActivityCreateClassAndSubList extends AppCompatActivity {

    ArrayList<ExampleItem> mExampleList = null;
    private RecyclerView mRecyclerView;
    private ExampleAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private ExampleAdapter.RecyclerViewClickListener listener;

    DatabaseReference ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.teacher_activity_create_class_and_sub_list);

        //loadData();
        buildRecyclerView();
        setInsertButton();
    }

    private void saveData() {
        SharedPreferences sharedPreferences = getSharedPreferences("shared preferences", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(mExampleList);
        editor.putString("task list", json);
        editor.apply();
    }

    private void loadData() {
        SharedPreferences sharedPreferences = getSharedPreferences("shared preferences", MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString("task list", null);
        Type type = new TypeToken<ArrayList<ExampleItem>>() {}.getType();
        mExampleList = gson.fromJson(json, type);
        if (mExampleList == null) {
            mExampleList = new ArrayList<>();
        }
    }

    private void buildRecyclerView() {
        //setOnClickListener();
        mRecyclerView = findViewById(R.id.recyclerview);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        /***/

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        ref = database.getReference("Users").child(FirebaseAuth.getInstance().getCurrentUser().getUid());

        mExampleList = new ArrayList<>();
        mAdapter = new ExampleAdapter(mExampleList,listener);

        ref.child("Value").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                mExampleList.clear();
                for (DataSnapshot ds : snapshot.getChildren()){

                    String line1 = ds.child("Class").getValue(String.class);
                    String line2 = ds.child("Sub").getValue(String.class);
                    mExampleList.add(new ExampleItem(line1, line2));

                }
                mAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        mRecyclerView.setAdapter(mAdapter);
        /***/

        mAdapter.setOnItemClickListener(new ExampleAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                /*Intent intent = new Intent(getApplicationContext(), TeacherSetClassList.class);
                intent.putExtra("finalIt", mExampleList.get(position).getLine2());
                startActivity(intent);*/
            }

            @Override
            public void onDeleteClick(int position) {
                removeItem(position);
            }
        });
    }

    private void setOnClickListener() {
        listener = new ExampleAdapter.RecyclerViewClickListener() {
            @Override
            public void onClick(View v, int position){
                /** Здесь был код с интентом **/
            }
        };
    }

    private void setInsertButtonFB()
    {

    }


    private void setInsertButton() {
        Button buttonInsert = findViewById(R.id.button_insert);
        buttonInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText line1 = findViewById(R.id.edittext_line_1);
                EditText line2 = findViewById(R.id.edittext_line_2);
                /***/
                String sub = line1.getText().toString();
                String clas = line2.getText().toString();
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference ref = database.getReference("Users").child(FirebaseAuth.getInstance().getCurrentUser().getUid());
                String key = ref.push().getKey();
                ref.child("Value").child(key).child("Sub").setValue(sub);
                ref.child("Value").child(key).child("Class").setValue(clas);
                /***/
                insertItem(line1.getText().toString(), line2.getText().toString());
                saveData();
            }
        });
    }

    private void insertItem(String line1, String line2) {
        mExampleList.add(new ExampleItem(line1, line2));
        mAdapter.notifyItemInserted(mExampleList.size());
    }

    public void removeItem(final int position) {
        mExampleList.remove(position);
        mAdapter.notifyItemRemoved(position);
        //ref.child("Value").removeValue();
        /****/
        ref.child("Value").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                int i=0;
                mExampleList.clear();
                for (DataSnapshot ds : snapshot.getChildren()){
                    if(i==position)
                    {
                        ds.getRef().removeValue();
                    }
                    String line1 = ds.child("Class").getValue(String.class);
                    String line2 = ds.child("Sub").getValue(String.class);
                    mExampleList.add(new ExampleItem(line1, line2));
                    i++;
                }
                mAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        /****/
        saveData();
    }
}