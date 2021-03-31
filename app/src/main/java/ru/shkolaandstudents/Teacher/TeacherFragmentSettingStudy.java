package ru.shkolaandstudents.Teacher;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import ru.shkolaandstudents.OnBackPressedListener;
import ru.shkolaandstudents.R;
import ru.shkolaandstudents.Utilities;
import ru.shkolaandstudents.ui.main.SetFridayFragment;
import ru.shkolaandstudents.ui.main.SetMondayFragment;
import ru.shkolaandstudents.ui.main.SetSaturdayFragment;
import ru.shkolaandstudents.ui.main.SetThursdayFragment;
import ru.shkolaandstudents.ui.main.SetTuesdayFragment;
import ru.shkolaandstudents.ui.main.SetWednesdayFragment;
import ru.shkolaandstudents.ui.main.SettingsFragment;

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
                utils.switchFragment(getActivity(), new TeacherFragmentSetMonday());
            }
        });

        Button btnSetTuesday = v.findViewById(R.id.btnSetTuesdayTeacher);
        btnSetTuesday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                utils.switchFragment(getActivity(), new TeacherFragmentSetTuesday());
            }
        });

        Button btnSetWenesday = v.findViewById(R.id.btnSetWenesdayTeacher);
        btnSetWenesday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                utils.switchFragment(getActivity(), new TeacherFragmentSetWend());
            }
        });

        Button btnSetThursday = v.findViewById(R.id.btnSetThursdayTeacher);
        btnSetThursday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                utils.switchFragment(getActivity(), new TeacherFragmentSetThur());
            }
        });

        Button btnSetFriday = v.findViewById(R.id.btnSetFridayTeacher);
        btnSetFriday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                utils.switchFragment(getActivity(), new TeacherFragmentSetFri());
            }
        });

        Button btnSetSaturday = v.findViewById(R.id.btnSetSaturdayTeacher);
        btnSetSaturday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                utils.switchFragment(getActivity(), new TeacherFragmentSetSat());
            }
        });

        return v;
    }

    @Override
    public void onBackPressed() {
        utils.switchFragment(getActivity(), new TeacherFragmentSettings());
    }
}