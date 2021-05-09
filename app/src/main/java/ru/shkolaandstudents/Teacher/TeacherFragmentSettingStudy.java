package ru.shkolaandstudents.Teacher;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import ru.shkolaandstudents.OnBackPressedListener;
import ru.shkolaandstudents.R;
import ru.shkolaandstudents.Utilities;

public class TeacherFragmentSettingStudy extends Fragment implements OnBackPressedListener {

    Utilities utils = new Utilities(getActivity());

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View v = inflater.inflate(R.layout.teacher_fragment_setting_study, container, false);

        Button btnSetMonday = v.findViewById(R.id.btnSetMondayTeacher);
        btnSetMonday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //utils.switchFragment(getActivity(), new TeacherFragmentSetMonday());
                Intent intent = new Intent(getActivity(), TeacherActivitySetMon.class);
                startActivity(intent);
            }
        });

        Button btnSetTuesday = v.findViewById(R.id.btnSetTuesdayTeacher);
        btnSetTuesday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //utils.switchFragment(getActivity(), new TeacherFragmentSetTuesday());
                Intent intent = new Intent(getActivity(), TeacherActivitySetTue.class);
                startActivity(intent);
            }
        });

        Button btnSetWenesday = v.findViewById(R.id.btnSetWenesdayTeacher);
        btnSetWenesday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //utils.switchFragment(getActivity(), new TeacherFragmentSetWend());
                Intent intent = new Intent(getActivity(), TeacherActivitySetWedn.class);
                startActivity(intent);
            }
        });

        Button btnSetThursday = v.findViewById(R.id.btnSetThursdayTeacher);
        btnSetThursday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //utils.switchFragment(getActivity(), new TeacherFragmentSetThur());
                Intent intent = new Intent(getActivity(), TeacherActivitySetThur.class);
                startActivity(intent);
            }
        });

        Button btnSetFriday = v.findViewById(R.id.btnSetFridayTeacher);
        btnSetFriday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //utils.switchFragment(getActivity(), new TeacherFragmentSetFri());
                Intent intent = new Intent(getActivity(), TeacherActivitySetFri.class);
                startActivity(intent);
            }
        });

        Button btnSetSaturday = v.findViewById(R.id.btnSetSaturdayTeacher);
        btnSetSaturday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //utils.switchFragment(getActivity(), new TeacherFragmentSetSat());
                Intent intent = new Intent(getActivity(), TeacherActivitySetSat.class);
                startActivity(intent);
            }
        });

        return v;
    }

    @Override
    public void onBackPressed() {
        utils.switchFragment(getActivity(), new TeacherFragmentSettings());
    }
}