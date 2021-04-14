package ru.shkolaandstudents.RecyclerViewTeacher;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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

import static android.content.Context.MODE_PRIVATE;

public class TeacherFragmentJournalList extends Fragment {

    ArrayList<ExampleItem> mExampleList;
    private RecyclerView mRecyclerView;
    private SubjectAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private SubjectAdapter.RecyclerViewClickListener listener;
    DatabaseReference ref;
    String school;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View v = inflater.inflate(R.layout.teacher_fragment_class_list, container, false);

        //loadData();

        mRecyclerView = v.findViewById(R.id.recyclerview2);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        ref = database.getReference("Users").child(FirebaseAuth.getInstance().getCurrentUser().getUid());

        mExampleList = new ArrayList<>();
        mAdapter = new SubjectAdapter(mExampleList,listener);

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

        DatabaseReference reff1 = database.getReference("Users").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child("Account");

        reff1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                school = String.valueOf(snapshot.child("str_class").getValue());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        mRecyclerView.setAdapter(mAdapter);

        mAdapter.setOnItemClickListener(new SubjectAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Intent intent = new Intent(getActivity(), TeacherActivityJournal.class);
                intent.putExtra("Subject", mExampleList.get(position).getLine2());
                intent.putExtra("Class", mExampleList.get(position).getLine1());
                intent.putExtra("School", school);
                startActivity(intent);
            }

        });


        /*mRecyclerView = v.findViewById(R.id.recyclerview2);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        ref = database.getReference("Users").child(FirebaseAuth.getInstance().getCurrentUser().getUid());

        mExampleList = new ArrayList<>();
        mAdapter = new SubjectAdapter(mExampleList,listener);

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

        mAdapter.setOnItemClickListener(new SubjectAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Intent intent = new Intent(getActivity(), TeacherActivityJournal.class);
                intent.putExtra("Subject", mExampleList.get(position).getLine2());
                intent.putExtra("Class", mExampleList.get(position).getLine1());
                startActivity(intent);
            }

        });*/

        return v;
    }

    private void loadData() {
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("shared preferences", MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString("task list", null);
        Type type = new TypeToken<ArrayList<ExampleItem>>() {}.getType();
        mExampleList = gson.fromJson(json, type);
        if (mExampleList == null) {
            mExampleList = new ArrayList<>();
        }
    }

}