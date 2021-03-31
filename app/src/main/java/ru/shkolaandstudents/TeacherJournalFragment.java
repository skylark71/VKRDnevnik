package ru.shkolaandstudents;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.Toast;

import java.util.Arrays;

public class TeacherJournalFragment extends Fragment {




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //View v = inflater.inflate(R.layout.fragment_teacher_journal, container, false);
         //final String[] TextGrid = new String[] { "1","2","3","4","5","6"};

        PixelGridView pixelGrid = new PixelGridView(getActivity());
        pixelGrid.setNumColumns(30);
        pixelGrid.setNumRows(30);

        return pixelGrid;
    }
}