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

public class SetFridayFragment extends Fragment implements OnBackPressedListener {

    Button btnSat,btnHelp;
    EditText etFr1,etFr2,etFr3,etFr4,etFr5,etFr6,etFr7,etFr8;
    SharedPreferences SP;
    SharedPreferences.Editor SPEditor;
    TextView title;
    DatabaseReference reff;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View v = inflater.inflate(R.layout.fragment_set_friday, container, false);

        btnHelp = v.findViewById(R.id.btnFrHelp);
        btnSat = v.findViewById(R.id.btnFrAccess);
        etFr1 = v.findViewById(R.id.etFr1);
        etFr2 = v.findViewById(R.id.etFr2);
        etFr3 = v.findViewById(R.id.etFr3);
        etFr4 = v.findViewById(R.id.etFr4);
        etFr5 = v.findViewById(R.id.etFr5);
        etFr6 = v.findViewById(R.id.etFr6);
        etFr7 = v.findViewById(R.id.etFr7);
        etFr8 = v.findViewById(R.id.etFr8);
        title = v.findViewById(R.id.tvFrRasp);
        title.setText(getResources().getString(R.string.change_rasp_f));

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        reff = database.getReference("Users").child(FirebaseAuth.getInstance().getCurrentUser().getUid());
        reff.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                String sFr1 = String.valueOf(snapshot.child("SubFr1").getValue());
                String sFr2 = String.valueOf(snapshot.child("SubFr2").getValue());
                String sFr3 = String.valueOf(snapshot.child("SubFr3").getValue());
                String sFr4 = String.valueOf(snapshot.child("SubFr4").getValue());
                String sFr5 = String.valueOf(snapshot.child("SubFr5").getValue());
                String sFr6 = String.valueOf(snapshot.child("SubFr6").getValue());
                String sFr7 = String.valueOf(snapshot.child("SubFr7").getValue());
                String sFr8 = String.valueOf(snapshot.child("SubFr8").getValue());

                if (snapshot.child("SubFr1").exists()) {
                    etFr1.setText(sFr1);
                }
                else
                {
                    etFr1.setText("");
                }

                if (snapshot.child("SubFr2").exists()) {
                    etFr2.setText(sFr2);
                }
                else
                {
                    etFr2.setText("");
                }

                if (snapshot.child("SubFr3").exists()) {
                    etFr3.setText(sFr3);
                }
                else
                {
                    etFr3.setText("");
                }

                if (snapshot.child("SubFr4").exists()) {
                    etFr4.setText(sFr4);
                }
                else
                {
                    etFr4.setText("");
                }

                if (snapshot.child("SubFr5").exists()) {
                    etFr5.setText(sFr5);
                }
                else
                {
                    etFr5.setText("");
                }

                if (snapshot.child("SubFr6").exists()) {
                    etFr6.setText(sFr6);
                }
                else
                {
                    etFr6.setText("");
                }

                if (snapshot.child("SubFr7").exists()) {
                    etFr7.setText(sFr7);
                }
                else
                {
                    etFr7.setText("");
                }

                if (snapshot.child("SubFr8").exists()) {
                    etFr8.setText(sFr8);
                }
                else
                {
                    etFr8.setText("");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                etFr1.setText("");
                etFr2.setText("");
                etFr3.setText("");
                etFr4.setText("");
                etFr5.setText("");
                etFr6.setText("");
                etFr7.setText("");
                etFr8.setText("");
            }
        });

        btnHelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new TapTargetSequence(getActivity())
                        .targets(
                                TapTarget.forView(v.findViewById(R.id.etFr1),getResources().getString(R.string.notfirst_click_TapTargetView),getResources().getString(R.string.click_TapTargetView))
                                        .titleTextSize(20)
                                        .titleTextColor(R.color.colorWhite)
                                        .descriptionTextColor(R.color.colorWhite)
                                        .cancelable(false)
                                        .tintTarget(false)
                                        .targetRadius(30)
                                        .transparentTarget(true)
                                        .outerCircleColor(R.color.colorTuesday),
                                TapTarget.forView(v.findViewById(R.id.btnFrAccess), getResources().getString(R.string.accept_click_TapTargetView), getResources().getString(R.string.click_TapTargetView))
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

        SP = PreferenceManager.getDefaultSharedPreferences(getActivity());
        SPEditor = SP.edit();

        String sFr1 = SP.getString("Fr1", "");
        etFr1.setText(sFr1);
        String sFr2 = SP.getString("Fr2", "");
        etFr2.setText(sFr2);
        String sFr3 = SP.getString("Fr3", "");
        etFr3.setText(sFr3);
        String sFr4 = SP.getString("Fr4", "");
        etFr4.setText(sFr4);
        String sFr5 = SP.getString("Fr5", "");
        etFr5.setText(sFr5);
        String sFr6 = SP.getString("Fr6", "");
        etFr6.setText(sFr6);
        String sFr7 = SP.getString("Fr7", "");
        etFr7.setText(sFr7);
        String sFr8 = SP.getString("Fr8", "");
        etFr8.setText(sFr8);

        etFr1.setText(sFr1);
        etFr2.setText(sFr2);
        etFr3.setText(sFr3);
        etFr4.setText(sFr4);
        etFr5.setText(sFr5);
        etFr6.setText(sFr6);
        etFr7.setText(sFr7);
        etFr8.setText(sFr8);

        btnSat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String Fr1 = etFr1.getText().toString();
                String Fr2 = etFr2.getText().toString();
                String Fr3 = etFr3.getText().toString();
                String Fr4 = etFr4.getText().toString();
                String Fr5 = etFr5.getText().toString();
                String Fr6 = etFr6.getText().toString();
                String Fr7 = etFr7.getText().toString();
                String Fr8 = etFr8.getText().toString();

                reff = FirebaseDatabase.getInstance().getReference("Users").child(FirebaseAuth.getInstance().getCurrentUser().getUid());
                if(Fr1.length()!=0) {
                    reff.child("SubFr1").setValue(Fr1);
                }
                else
                {
                    reff.child("SubFr1").removeValue();
                }

                if(Fr2.length()!=0) {
                    reff.child("SubFr2").setValue(Fr2);
                }
                else
                {
                    reff.child("SubFr2").removeValue();
                }

                if(Fr3.length()!=0) {
                    reff.child("SubFr3").setValue(Fr3);
                }
                else
                {
                    reff.child("SubFr3").removeValue();
                }

                if(Fr4.length()!=0) {
                    reff.child("SubFr4").setValue(Fr4);
                }
                else
                {
                    reff.child("SubFr4").removeValue();
                }

                if(Fr5.length()!=0) {
                    reff.child("SubFr5").setValue(Fr5);
                }
                else
                {
                    reff.child("SubFr5").removeValue();
                }

                if(Fr6.length()!=0) {
                    reff.child("SubFr6").setValue(Fr6);
                }
                else
                {
                    reff.child("SubFr6").removeValue();
                }

                if(Fr7.length()!=0) {
                    reff.child("SubFr7").setValue(Fr7);
                }
                else
                {
                    reff.child("SubFr7").removeValue();
                }

                if(Fr8.length()!=0) {
                    reff.child("SubFr8").setValue(Fr8);
                }
                else
                {
                    reff.child("SubFr8").removeValue();
                }

                /*SPEditor.putString("Fr1",Fr1);
                SPEditor.commit();
                SPEditor.putString("Fr2",Fr2);
                SPEditor.commit();
                SPEditor.putString("Fr3",Fr3);
                SPEditor.commit();
                SPEditor.putString("Fr4",Fr4);
                SPEditor.commit();
                SPEditor.putString("Fr5",Fr5);
                SPEditor.commit();
                SPEditor.putString("Fr6",Fr6);
                SPEditor.commit();
                SPEditor.putString("Fr7",Fr7);
                SPEditor.commit();
                SPEditor.putString("Fr8",Fr8);
                SPEditor.commit();*/

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