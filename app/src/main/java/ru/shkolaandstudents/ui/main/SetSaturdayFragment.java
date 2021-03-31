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

public class SetSaturdayFragment extends Fragment implements OnBackPressedListener {

    Button btnSM,btnHelp;
    EditText etSat1,etSat2,etSat3,etSat4,etSat5,etSat6,etSat7,etSat8;
    SharedPreferences SP;
    SharedPreferences.Editor SPEditor;
    TextView title;
    DatabaseReference reff;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View v = inflater.inflate(R.layout.fragment_set_saturday, container, false);

        btnHelp = v.findViewById(R.id.btnSatHelp);
        btnSM = v.findViewById(R.id.btnSatAccess);
        etSat1 = v.findViewById(R.id.etSat1);
        etSat2 = v.findViewById(R.id.etSat2);
        etSat3 = v.findViewById(R.id.etSat3);
        etSat4 = v.findViewById(R.id.etSat4);
        etSat5 = v.findViewById(R.id.etSat5);
        etSat6 = v.findViewById(R.id.etSat6);
        etSat7 = v.findViewById(R.id.etSat7);
        etSat8 = v.findViewById(R.id.etSat8);
        title = v.findViewById(R.id.tvSatRasp);
        title.setText(getResources().getString(R.string.change_rasp_s));
        
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        reff = database.getReference("Users").child(FirebaseAuth.getInstance().getCurrentUser().getUid());
        reff.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                String sSat1 = String.valueOf(snapshot.child("SubSat1").getValue());
                String sSat2 = String.valueOf(snapshot.child("SubSat2").getValue());
                String sSat3 = String.valueOf(snapshot.child("SubSat3").getValue());
                String sSat4 = String.valueOf(snapshot.child("SubSat4").getValue());
                String sSat5 = String.valueOf(snapshot.child("SubSat5").getValue());
                String sSat6 = String.valueOf(snapshot.child("SubSat6").getValue());
                String sSat7 = String.valueOf(snapshot.child("SubSat7").getValue());
                String sSat8 = String.valueOf(snapshot.child("SubSat8").getValue());

                if (snapshot.child("SubSat1").exists()) {
                    etSat1.setText(sSat1);
                }
                else
                {
                    etSat1.setText("");
                }

                if (snapshot.child("SubSat2").exists()) {
                    etSat2.setText(sSat2);
                }
                else
                {
                    etSat2.setText("");
                }

                if (snapshot.child("SubSat3").exists()) {
                    etSat3.setText(sSat3);
                }
                else
                {
                    etSat3.setText("");
                }

                if (snapshot.child("SubSat4").exists()) {
                    etSat4.setText(sSat4);
                }
                else
                {
                    etSat4.setText("");
                }

                if (snapshot.child("SubSat5").exists()) {
                    etSat5.setText(sSat5);
                }
                else
                {
                    etSat5.setText("");
                }

                if (snapshot.child("SubSat6").exists()) {
                    etSat6.setText(sSat6);
                }
                else
                {
                    etSat6.setText("");
                }

                if (snapshot.child("SubSat7").exists()) {
                    etSat7.setText(sSat7);
                }
                else
                {
                    etSat7.setText("");
                }

                if (snapshot.child("SubSat8").exists()) {
                    etSat8.setText(sSat8);
                }
                else
                {
                    etSat8.setText("");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                etSat1.setText("");
                etSat2.setText("");
                etSat3.setText("");
                etSat4.setText("");
                etSat5.setText("");
                etSat6.setText("");
                etSat7.setText("");
                etSat8.setText("");
            }
        });
        
        btnHelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new TapTargetSequence(getActivity())
                        .targets(
                                TapTarget.forView(v.findViewById(R.id.etSat1),getResources().getString(R.string.notfirst_click_TapTargetView),getResources().getString(R.string.click_TapTargetView))
                                        .titleTextSize(20)
                                        .titleTextColor(R.color.colorWhite)
                                        .descriptionTextColor(R.color.colorWhite)
                                        .cancelable(false)
                                        .tintTarget(false)
                                        .targetRadius(30)
                                        .transparentTarget(true)
                                        .outerCircleColor(R.color.colorTuesday),
                                TapTarget.forView(v.findViewById(R.id.btnSatAccess), getResources().getString(R.string.accept_click_TapTargetView), getResources().getString(R.string.click_TapTargetView))
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

        String sSat1 = SP.getString("Sat1", "");
        etSat1.setText(sSat1);
        String sSat2 = SP.getString("Sat2", "");
        etSat2.setText(sSat2);
        String sSat3 = SP.getString("Sat3", "");
        etSat3.setText(sSat3);
        String sSat4 = SP.getString("Sat4", "");
        etSat4.setText(sSat4);
        String sSat5 = SP.getString("Sat5", "");
        etSat5.setText(sSat5);
        String sSat6 = SP.getString("Sat6", "");
        etSat6.setText(sSat6);
        String sSat7 = SP.getString("Sat7", "");
        etSat7.setText(sSat7);
        String sSat8 = SP.getString("Sat8", "");
        etSat8.setText(sSat8);

        etSat1.setText(sSat1);
        etSat2.setText(sSat2);
        etSat3.setText(sSat3);
        etSat4.setText(sSat4);
        etSat5.setText(sSat5);
        etSat6.setText(sSat6);
        etSat7.setText(sSat7);
        etSat8.setText(sSat8);



        btnSM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String Sat1 = etSat1.getText().toString();
                String Sat2 = etSat2.getText().toString();
                String Sat3 = etSat3.getText().toString();
                String Sat4 = etSat4.getText().toString();
                String Sat5 = etSat5.getText().toString();
                String Sat6 = etSat6.getText().toString();
                String Sat7 = etSat7.getText().toString();
                String Sat8 = etSat8.getText().toString();

                reff = FirebaseDatabase.getInstance().getReference("Users").child(FirebaseAuth.getInstance().getCurrentUser().getUid());
                if(Sat1.length()!=0) {
                    reff.child("SubSat1").setValue(Sat1);
                }
                else
                {
                    reff.child("SubSat1").removeValue();
                }

                if(Sat2.length()!=0) {
                    reff.child("SubSat2").setValue(Sat2);
                }
                else
                {
                    reff.child("SubSat2").removeValue();
                }

                if(Sat3.length()!=0) {
                    reff.child("SubSat3").setValue(Sat3);
                }
                else
                {
                    reff.child("SubSat3").removeValue();
                }

                if(Sat4.length()!=0) {
                    reff.child("SubSat4").setValue(Sat4);
                }
                else
                {
                    reff.child("SubSat4").removeValue();
                }

                if(Sat5.length()!=0) {
                    reff.child("SubSat5").setValue(Sat5);
                }
                else
                {
                    reff.child("SubSat5").removeValue();
                }

                if(Sat6.length()!=0) {
                    reff.child("SubSat6").setValue(Sat6);
                }
                else
                {
                    reff.child("SubSat6").removeValue();
                }

                if(Sat7.length()!=0) {
                    reff.child("SubSat7").setValue(Sat7);
                }
                else
                {
                    reff.child("SubSat7").removeValue();
                }

                if(Sat8.length()!=0) {
                    reff.child("SubSat8").setValue(Sat8);
                }
                else
                {
                    reff.child("SubSat8").removeValue();
                }

                /*SPEditor.putString("Sat1",Sat1);
                SPEditor.apply();
                SPEditor.putString("Sat2",Sat2);
                SPEditor.commit();
                SPEditor.putString("Sat3",Sat3);
                SPEditor.commit();
                SPEditor.putString("Sat4",Sat4);
                SPEditor.commit();
                SPEditor.putString("Sat5",Sat5);
                SPEditor.commit();
                SPEditor.putString("Sat6",Sat6);
                SPEditor.commit();
                SPEditor.putString("Sat7",Sat7);
                SPEditor.commit();
                SPEditor.putString("Sat8",Sat8);
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