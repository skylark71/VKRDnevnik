package ru.shkolaandstudents.RecyclerViewTeacher;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import java.util.ArrayList;
import ru.shkolaandstudents.R;

public class TeacherActivityCreateClassAndSubList extends AppCompatActivity {

    ArrayList<ExampleItem> mExampleList = null;
    private RecyclerView mRecyclerView;
    private ExampleAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private ExampleAdapter.RecyclerViewClickListener listener;
    String school;
    DatabaseReference ref;
    String value_line_1;
    String value_line_2;
    Boolean flag = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        setContentView(R.layout.teacher_activity_create_class_and_sub_list);

        SharedPreferences sharedPreferences = getSharedPreferences("Settings", MODE_PRIVATE);
        String text = sharedPreferences.getString("school", "");
        school = text;

        final ArrayAdapter arrayAdapter = new ArrayAdapter(TeacherActivityCreateClassAndSubList.this
                ,android.R.layout.simple_spinner_item
                ,getResources().getStringArray(R.array.School_subject));

        final Spinner spinner = findViewById(R.id.spinner_line_1);

        arrayAdapter.setDropDownViewResource(android.R.layout.simple_selectable_list_item);
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent,
                                       View itemSelected, int selectedItemPosition, long selectedId) {

                String[] choose = getResources().getStringArray(R.array.School_subject);
                value_line_1 = choose[selectedItemPosition];
            }
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        ref = database.getReference(school);
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                int cnt = 1;
                int i = 0;
                for (DataSnapshot ds : snapshot.getChildren()){
                    String line1 = ds.getKey();
                    cnt ++;
                }

                final String[] arrClass = new String[cnt];
                arrClass[0] = "Выберите класс";
                for (DataSnapshot ds : snapshot.getChildren()) {
                    String str_school = ds.getKey();
                    arrClass[i + 1] = str_school;
                    i++;
                }

                final ArrayAdapter arrayAdapter = new ArrayAdapter(TeacherActivityCreateClassAndSubList.this
                        , android.R.layout.simple_spinner_item
                        , arrClass);

                final Spinner spinner = findViewById(R.id.spinner_line_2);

                arrayAdapter.setDropDownViewResource(android.R.layout.simple_selectable_list_item);
                spinner.setAdapter(arrayAdapter);
                spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    public void onItemSelected(AdapterView<?> parent,
                                               View itemSelected, int selectedItemPosition, long selectedId) {

                        value_line_2 = arrClass[selectedItemPosition];
                    }

                    public void onNothingSelected(AdapterView<?> parent) {
                    }
                });


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

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

        buildRecyclerView();

        setInsertButton();
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
                flag = true;
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


    private void setInsertButton() {
        Button buttonInsert = findViewById(R.id.button_insert);
        buttonInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(value_line_2.equals("Выберите класс"))
                {
                    Toast toast = Toast.makeText(getApplicationContext(), "Не выбран класс", Toast.LENGTH_SHORT);
                    toast.show();
                } else if (value_line_1.equals("Выберите предмет"))
                {
                    Toast toast = Toast.makeText(getApplicationContext(), "Не выбран предмет", Toast.LENGTH_SHORT);
                    toast.show();
                }
                else
                {
                    /***/
                    String sub = value_line_1.replaceAll("^\"+|\"+$", "");
                    String clas = value_line_2.replaceAll("^\"+|\"+$", "");
                    FirebaseDatabase database = FirebaseDatabase.getInstance();
                    final DatabaseReference ref = database.getReference("Users").child(FirebaseAuth.getInstance().getCurrentUser().getUid());
                    String key = ref.push().getKey();
                    ref.child("Value").child(key).child("Sub").setValue(sub);
                    ref.child("Value").child(key).child("Class").setValue(clas);
                    /***/
                    insertItem(sub, clas);
                }
            }
        });
    }

    private void insertItem(String line1, String line2) {
        mExampleList.add(new ExampleItem(line1, line2));
        mAdapter.notifyItemInserted(mExampleList.size());
    }

    public void removeItem(int position) {

            mExampleList.remove(position);
            mAdapter.notifyItemRemoved(position);
            final int pos = position;
            /****/
            ref.child("Value").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    int i=0;
                    if(flag) {
                        mExampleList.clear();
                        for (DataSnapshot ds : snapshot.getChildren()) {
                            if (i == pos) {
                                ds.getRef().removeValue();
                            }
                            String line1 = ds.child("Class").getValue(String.class);
                            String line2 = ds.child("Sub").getValue(String.class);
                            mExampleList.add(new ExampleItem(line1, line2));
                            i++;
                        }
                        mAdapter.notifyDataSetChanged();
                        flag = false;
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });


        /****/
    }
}