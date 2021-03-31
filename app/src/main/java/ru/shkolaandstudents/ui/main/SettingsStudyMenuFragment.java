package ru.shkolaandstudents.ui.main;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import ru.shkolaandstudents.OnBackPressedListener;
import ru.shkolaandstudents.R;


public class SettingsStudyMenuFragment extends Fragment implements OnBackPressedListener {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.settings_study_menu_fragment, container, false);

        Button btnSetMonday = v.findViewById(R.id.btnSetMonday);
        btnSetMonday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.container, new SetMondayFragment());
                transaction.commit();
            }
        });

        Button btnSetTuesday = v.findViewById(R.id.btnSetTuesday);
        btnSetTuesday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.container, new SetTuesdayFragment());
                transaction.commit();
            }
        });

        Button btnSetWenesday = v.findViewById(R.id.btnSetWenesday);
        btnSetWenesday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.container, new SetWednesdayFragment());
                transaction.commit();
            }
        });

        Button btnSetThursday = v.findViewById(R.id.btnSetThursday);
        btnSetThursday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.container, new SetThursdayFragment());
                transaction.commit();
            }
        });

        Button btnSetFriday = v.findViewById(R.id.btnSetFriday);
        btnSetFriday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.container, new SetFridayFragment());
                transaction.commit();
            }
        });

        Button btnSetSaturday = v.findViewById(R.id.btnSetSaturday);
        btnSetSaturday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.container, new SetSaturdayFragment());
                transaction.commit();
            }
        });


        return v;
    }

    @Override
    public void onBackPressed() {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.container, new SettingsFragment());
        transaction.commit();
    }
}