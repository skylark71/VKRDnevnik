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
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;

import ru.shkolaandstudents.LoginAndRegist.User_ui;
import ru.shkolaandstudents.R;

public class TeacherActivityClassList extends AppCompatActivity {

    ArrayList<ExampleItem> mExampleList;
    private RecyclerView mRecyclerView;
    private ExampleAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private ExampleAdapter.RecyclerViewClickListener listener;
    DatabaseReference ref;
    public int numberOfLines = 1;

    String class_name;
    String school;
    Boolean flag = false;
    Button btn_add;
    String[] stringsUid;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.teacher_activity_class_list);
        btn_add = findViewById(R.id.btn_add);
        Bundle arguments = getIntent().getExtras();
        class_name = arguments.get("class").toString();
        school = arguments.get("school").toString();

        mRecyclerView = findViewById(R.id.recyclerview1);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        ref = database.getReference(school).child(class_name);

        mExampleList = new ArrayList<>();
        mAdapter = new ExampleAdapter(mExampleList,listener);

        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                mExampleList.clear();
                int i=0;
                int k=0;
                for (DataSnapshot ds1 : snapshot.getChildren()){
                    String line1 = ds1.getKey();
                    i++;
                }
                numberOfLines = i;
                String[] strings1 = new String[i];
                String[] stringsFUid = new String[i];
                for (DataSnapshot ds : snapshot.getChildren()){
                    String LastName = ds.child("LastName").getValue(String.class);
                    String FirstName = ds.child("FirstName").getValue(String.class);
                    String firstFirstName = FirstName.substring(0, 1);
                    String Otchestvo = ds.child("Otchestvo").getValue(String.class);
                    String firstOtchestvo = Otchestvo.substring(0, 1);
                    String Uid = ds.child("Uid").getValue(String.class);

                    String full = LastName + firstFirstName+ "." + firstOtchestvo+ ".";
                    String FUid = LastName +Uid;
                    strings1[k] = full;
                    stringsFUid[k] = FUid;
                    k++;
                }

                Arrays.sort(strings1);
                Arrays.sort(stringsFUid);

                stringsUid = new String[i];

                for (int jjj = 0; jjj<stringsFUid.length; jjj++)
                {
                    String str = stringsFUid[jjj];
                    String[] strgs = str.split(" ");
                    stringsUid[jjj] = strgs[1];
                }

                for (int kk = 0; kk<strings1.length; kk++)
                {
                    String line1 = strings1[kk];
                    String line2 = stringsUid[kk];
                    mExampleList.add(new ExampleItem(line2, line1));
                }
                mAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        mRecyclerView.setAdapter(mAdapter);

        mAdapter.setOnItemClickListener(new ExampleAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Intent intent = new Intent(getApplicationContext(), User_ui.class);
                intent.putExtra("uid", mExampleList.get(position).getLine1());
                intent.putExtra("school", school);
                startActivity(intent);
            }

            @Override
            public void onDeleteClick(int position) {
                flag = true;
                removeItem(position);
            }
        });

        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), TeacherCreateStudies.class);
                intent.putExtra("class", class_name);
                intent.putExtra("school", school);
                startActivity(intent);
            }
        });
    }

    public void removeItem(final int position) {

        mExampleList.remove(position);
        mAdapter.notifyItemRemoved(position);
        FirebaseDatabase database = FirebaseDatabase.getInstance();

        DatabaseReference reff1 = database.getReference(school).child(class_name);
        reff1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(flag) {
                    mExampleList.clear();
                    int i=0;
                    int k=0;
                    for (DataSnapshot ds : snapshot.getChildren()){
                        if (i == position) {
                            ds.getRef().removeValue();
                        } else
                        {
                            i++;
                        }
                    }

                    numberOfLines = i;
                    String[] strings1 = new String[i];
                    String[] stringsFUid = new String[i];

                    for (DataSnapshot ds : snapshot.getChildren()){
                        String LastName = ds.child("LastName").getValue(String.class);
                        String FirstName = ds.child("FirstName").getValue(String.class);
                        String firstFirstName = FirstName.substring(0, 1);
                        String Otchestvo = ds.child("Otchestvo").getValue(String.class);
                        String firstOtchestvo = Otchestvo.substring(0, 1);
                        String Uid = ds.child("Uid").getValue(String.class);

                        String full = LastName + firstFirstName+ "." + firstOtchestvo+ ".";
                        String FUid = LastName + Uid;
                        strings1[k] = full;
                        stringsFUid[k] = FUid;
                        k++;
                    }

                    Arrays.sort(strings1);
                    Arrays.sort(stringsFUid);

                    stringsUid = new String[i];

                    for (int jjj = 0; jjj<stringsFUid.length; jjj++)
                    {
                        String str = stringsFUid[jjj];
                        String[] strgs = str.split(" ");
                        stringsUid[jjj] = strgs[1];
                    }

                    for (int kk = 0; kk<strings1.length; kk++)
                    {
                        String line1 = strings1[kk];
                        String line2 = stringsUid[kk];
                        mExampleList.add(new ExampleItem(line1, line2));
                    }
                    mAdapter.notifyDataSetChanged();
                    flag = false;
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }


}