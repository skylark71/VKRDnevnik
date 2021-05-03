/*
package ru.shkolaandstudents;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class AccountFragment extends Fragment {

    TextView tv_name, tv_last_name, tv_school, tv_class;
    String USER_KEY = "Schoolman";
    private DatabaseReference mDatabse;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_account, container, false);

        tv_name = v.findViewById(R.id.tv_name);
        tv_last_name = v.findViewById(R.id.tv_last_name);
        tv_school = v.findViewById(R.id.tv_school);
        tv_class = v.findViewById(R.id.tv_class);
        mDatabse = FirebaseDatabase.getInstance().getReference(USER_KEY);

        ValueEventListener vListener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        };
        mDatabse.addValueEventListener(vListener);

        return v;
    }
}*/
