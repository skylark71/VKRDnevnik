package ru.shkolaandstudents.ui.main;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.getkeepsafe.taptargetview.TapTarget;
import com.getkeepsafe.taptargetview.TapTargetSequence;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import ru.shkolaandstudents.OnBackPressedListener;
import ru.shkolaandstudents.R;

public class SetTuesdayFragment extends Fragment implements OnBackPressedListener {

    Button btnWend,btnHelp;
    EditText etT1,etT2,etT3,etT4,etT5,etT6,etT7,etT8;
    SharedPreferences SP;
    SharedPreferences.Editor SPEditor;
    TextView title;
    DatabaseReference reff;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View v = inflater.inflate(R.layout.fragment_set_tuesday, container, false);

        btnHelp = v.findViewById(R.id.btnTHelp);
        btnWend = v.findViewById(R.id.btnTAccess);
        etT1 = v.findViewById(R.id.etT1);
        etT2 = v.findViewById(R.id.etT2);
        etT3 = v.findViewById(R.id.etT3);
        etT4 = v.findViewById(R.id.etT4);
        etT5 = v.findViewById(R.id.etT5);
        etT6 = v.findViewById(R.id.etT6);
        etT7 = v.findViewById(R.id.etT7);
        etT8 = v.findViewById(R.id.etT8);
        title = v.findViewById(R.id.tvTRasp);
        title.setText(getResources().getString(R.string.change_rasp_t));
        SP = PreferenceManager.getDefaultSharedPreferences(getActivity());
        SPEditor = SP.edit();

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        reff = database.getReference("Users").child(FirebaseAuth.getInstance().getCurrentUser().getUid());
        reff.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                String sT1 = String.valueOf(snapshot.child("SubT1").getValue());
                String sT2 = String.valueOf(snapshot.child("SubT2").getValue());
                String sT3 = String.valueOf(snapshot.child("SubT3").getValue());
                String sT4 = String.valueOf(snapshot.child("SubT4").getValue());
                String sT5 = String.valueOf(snapshot.child("SubT5").getValue());
                String sT6 = String.valueOf(snapshot.child("SubT6").getValue());
                String sT7 = String.valueOf(snapshot.child("SubT7").getValue());
                String sT8 = String.valueOf(snapshot.child("SubT8").getValue());

                if (snapshot.child("SubT1").exists()) {
                    etT1.setText(sT1);
                }
                else
                {
                    etT1.setText("");
                }

                if (snapshot.child("SubT2").exists()) {
                    etT2.setText(sT2);
                }
                else
                {
                    etT2.setText("");
                }

                if (snapshot.child("SubT3").exists()) {
                    etT3.setText(sT3);
                }
                else
                {
                    etT3.setText("");
                }

                if (snapshot.child("SubT4").exists()) {
                    etT4.setText(sT4);
                }
                else
                {
                    etT4.setText("");
                }

                if (snapshot.child("SubT5").exists()) {
                    etT5.setText(sT5);
                }
                else
                {
                    etT5.setText("");
                }

                if (snapshot.child("SubT6").exists()) {
                    etT6.setText(sT6);
                }
                else
                {
                    etT6.setText("");
                }

                if (snapshot.child("SubT7").exists()) {
                    etT7.setText(sT7);
                }
                else
                {
                    etT7.setText("");
                }

                if (snapshot.child("SubT8").exists()) {
                    etT8.setText(sT8);
                }
                else
                {
                    etT8.setText("");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                etT1.setText("");
                etT2.setText("");
                etT3.setText("");
                etT4.setText("");
                etT5.setText("");
                etT6.setText("");
                etT7.setText("");
                etT8.setText("");
            }
        });

        /*String sT1 = SP.getString("T1", "");
        etT1.setText(sT1);
        String sT2 = SP.getString("T2", "");
        etT2.setText(sT2);
        String sT3 = SP.getString("T3", "");
        etT3.setText(sT3);
        String sT4 = SP.getString("T4", "");
        etT4.setText(sT4);
        String sT5 = SP.getString("T5", "");
        etT5.setText(sT5);
        String sT6 = SP.getString("T6", "");
        etT6.setText(sT6);
        String sT7 = SP.getString("T7", "");
        etT7.setText(sT7);
        String sT8 = SP.getString("T8", "");
        etT8.setText(sT8);

        etT1.setText(sT1);
        etT2.setText(sT2);
        etT3.setText(sT3);
        etT4.setText(sT4);
        etT5.setText(sT5);
        etT6.setText(sT6);
        etT7.setText(sT7);
        etT8.setText(sT8);*/


        btnHelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new TapTargetSequence(getActivity())
                        .targets(
                                TapTarget.forView(v.findViewById(R.id.etT1),getResources().getString(R.string.notfirst_click_TapTargetView),getResources().getString(R.string.click_TapTargetView))
                                        .titleTextSize(20)
                                        .titleTextColor(R.color.colorWhite)
                                        .descriptionTextColor(R.color.colorWhite)
                                        .cancelable(false)
                                        .tintTarget(false)
                                        .targetRadius(30)
                                        .transparentTarget(true)
                                        .outerCircleColor(R.color.colorTuesday),
                                TapTarget.forView(v.findViewById(R.id.btnTAccess), getResources().getString(R.string.accept_click_TapTargetView), getResources().getString(R.string.click_TapTargetView))
                                        .titleTextSize(20)
                                        .titleTextColor(R.color.colorWhite)
                                        .descriptionTextColor(R.color.colorWhite)
                                        .cancelable(false)
                                        .tintTarget(false)
                                        .targetRadius(50)
                                        .transparentTarget(true)
                                        .outerCircleColor(R.color.colorTuesday))
                        .listener(new TapTargetSequence.Listener() {
                            @Override
                            public void onSequenceFinish() {
                            }

                            @Override
                            public void onSequenceStep(TapTarget lastTarget, boolean targetClicked) {

                            }

                            @Override
                            public void onSequenceCanceled(TapTarget lastTarget) {
                            }
                        }).start();
            }
        });

        btnWend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String T1 = etT1.getText().toString();
                String T2 = etT2.getText().toString();
                String T3 = etT3.getText().toString();
                String T4 = etT4.getText().toString();
                String T5 = etT5.getText().toString();
                String T6 = etT6.getText().toString();
                String T7 = etT7.getText().toString();
                String T8 = etT8.getText().toString();


                /*SPEditor.putString("T1",T1);
                SPEditor.apply();
                SPEditor.putString("T2",T2);
                SPEditor.commit();
                SPEditor.putString("T3",T3);
                SPEditor.commit();
                SPEditor.putString("T4",T4);
                SPEditor.commit();
                SPEditor.putString("T5",T5);
                SPEditor.commit();
                SPEditor.putString("T6",T6);
                SPEditor.commit();
                SPEditor.putString("T7",T7);
                SPEditor.commit();
                SPEditor.putString("T8",T8);
                SPEditor.commit();*/

                reff = FirebaseDatabase.getInstance().getReference("Users").child(FirebaseAuth.getInstance().getCurrentUser().getUid());
                if(T1.length()!=0) {
                    reff.child("SubT1").setValue(T1);
                }
                else
                {
                    reff.child("SubT1").removeValue();
                }

                if(T2.length()!=0) {
                    reff.child("SubT2").setValue(T2);
                }
                else
                {
                    reff.child("SubT2").removeValue();
                }

                if(T3.length()!=0) {
                    reff.child("SubT3").setValue(T3);
                }
                else
                {
                    reff.child("SubT3").removeValue();
                }

                if(T4.length()!=0) {
                    reff.child("SubT4").setValue(T4);
                }
                else
                {
                    reff.child("SubT4").removeValue();
                }

                if(T5.length()!=0) {
                    reff.child("SubT5").setValue(T5);
                }
                else
                {
                    reff.child("SubT5").removeValue();
                }

                if(T6.length()!=0) {
                    reff.child("SubT6").setValue(T6);
                }
                else
                {
                    reff.child("SubT6").removeValue();
                }

                if(T7.length()!=0) {
                    reff.child("SubT7").setValue(T7);
                }
                else
                {
                    reff.child("SubT7").removeValue();
                }

                if(T8.length()!=0) {
                    reff.child("SubT8").setValue(T8);
                }
                else
                {
                    reff.child("SubT8").removeValue();
                }

                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.container, new SettingsStudyMenuFragment());
                transaction.commit();

            }
        });

        return v;
    }

    @Override
    public void onBackPressed() {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.container, new SettingsStudyMenuFragment());
        transaction.commit();
    }
}