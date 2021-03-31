package ru.shkolaandstudents;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddPersonFragment extends Fragment {

    private EditText edName, edLastName, edSchool, edClass, edEMail, edPassword;
    private DatabaseReference mDatabse;
    private String USER_KEY = "Schoolman";
    Button btn_save;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View v = inflater.inflate(R.layout.fragment_add_person, container, false);

        edName = v.findViewById(R.id.edit_name);
        edLastName = v.findViewById(R.id.edit_last_name);
        edSchool = v.findViewById(R.id.edit_school);
        edClass = v.findViewById(R.id.edit_class);
        edEMail = v.findViewById(R.id.add_email);
        edPassword = v.findViewById(R.id.add_password);
        mDatabse = FirebaseDatabase.getInstance().getReference(USER_KEY);
        btn_save = v.findViewById(R.id.btn_save_data);
        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = mDatabse.getKey();
                String name = edName.getText().toString();
                String lastname = edLastName.getText().toString();
                String school = edSchool.getText().toString();
                Integer school_class = Integer.valueOf(edClass.getText().toString());
                Schoolman user = new Schoolman(id, name, lastname, school, school_class);

                if(!TextUtils.isEmpty(lastname) && !TextUtils.isEmpty(name))
                {
                    mDatabse.push().setValue(user);
                }
                else
                {
                    Toast.makeText(getActivity(), "Пустое поле", Toast.LENGTH_SHORT).show();
                }
            }
        });

        return v;
    }
}