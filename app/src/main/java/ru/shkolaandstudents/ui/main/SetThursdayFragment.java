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

public class SetThursdayFragment extends Fragment implements OnBackPressedListener {

    Button btnFri,btnHelp;
    EditText etTh1,etTh2,etTh3,etTh4,etTh5,etTh6,etTh7,etTh8;
    SharedPreferences SP;
    SharedPreferences.Editor SPEditor;
    TextView title;
    DatabaseReference reff;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View v = inflater.inflate(R.layout.fragment_set_thursday, container, false);

        btnHelp = v.findViewById(R.id.btnThHelp);
        btnFri = v.findViewById(R.id.btnThAccess);
        etTh1 = v.findViewById(R.id.etTh1);
        etTh2 = v.findViewById(R.id.etTh2);
        etTh3 = v.findViewById(R.id.etTh3);
        etTh4 = v.findViewById(R.id.etTh4);
        etTh5 = v.findViewById(R.id.etTh5);
        etTh6 = v.findViewById(R.id.etTh6);
        etTh7 = v.findViewById(R.id.etTh7);
        etTh8 = v.findViewById(R.id.etTh8);
        title = v.findViewById(R.id.tvThRasp);
        title.setText(getResources().getString(R.string.change_rasp_th));
        SP = PreferenceManager.getDefaultSharedPreferences(getActivity());
        SPEditor = SP.edit();
        
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        reff = database.getReference("Users").child(FirebaseAuth.getInstance().getCurrentUser().getUid());
        reff.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                String sTh1 = String.valueOf(snapshot.child("SubTh1").getValue());
                String sTh2 = String.valueOf(snapshot.child("SubTh2").getValue());
                String sTh3 = String.valueOf(snapshot.child("SubTh3").getValue());
                String sTh4 = String.valueOf(snapshot.child("SubTh4").getValue());
                String sTh5 = String.valueOf(snapshot.child("SubTh5").getValue());
                String sTh6 = String.valueOf(snapshot.child("SubTh6").getValue());
                String sTh7 = String.valueOf(snapshot.child("SubTh7").getValue());
                String sTh8 = String.valueOf(snapshot.child("SubTh8").getValue());

                if (snapshot.child("SubTh1").exists()) {
                    etTh1.setText(sTh1);
                }
                else
                {
                    etTh1.setText("");
                }

                if (snapshot.child("SubTh2").exists()) {
                    etTh2.setText(sTh2);
                }
                else
                {
                    etTh2.setText("");
                }

                if (snapshot.child("SubTh3").exists()) {
                    etTh3.setText(sTh3);
                }
                else
                {
                    etTh3.setText("");
                }

                if (snapshot.child("SubTh4").exists()) {
                    etTh4.setText(sTh4);
                }
                else
                {
                    etTh4.setText("");
                }

                if (snapshot.child("SubTh5").exists()) {
                    etTh5.setText(sTh5);
                }
                else
                {
                    etTh5.setText("");
                }

                if (snapshot.child("SubTh6").exists()) {
                    etTh6.setText(sTh6);
                }
                else
                {
                    etTh6.setText("");
                }

                if (snapshot.child("SubTh7").exists()) {
                    etTh7.setText(sTh7);
                }
                else
                {
                    etTh7.setText("");
                }

                if (snapshot.child("SubTh8").exists()) {
                    etTh8.setText(sTh8);
                }
                else
                {
                    etTh8.setText("");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                etTh1.setText("");
                etTh2.setText("");
                etTh3.setText("");
                etTh4.setText("");
                etTh5.setText("");
                etTh6.setText("");
                etTh7.setText("");
                etTh8.setText("");
            }
        });

        btnHelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new TapTargetSequence(getActivity())
                        .targets(
                                TapTarget.forView(v.findViewById(R.id.etTh1),getResources().getString(R.string.notfirst_click_TapTargetView),getResources().getString(R.string.click_TapTargetView))
                                        .titleTextSize(20)
                                        .titleTextColor(R.color.colorWhite)
                                        .descriptionTextColor(R.color.colorWhite)
                                        .cancelable(false)
                                        .tintTarget(false)
                                        .targetRadius(30)
                                        .transparentTarget(true)
                                        .outerCircleColor(R.color.colorTuesday),
                                TapTarget.forView(v.findViewById(R.id.btnThAccess), getResources().getString(R.string.accept_click_TapTargetView), getResources().getString(R.string.click_TapTargetView))
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

        /*String sTh1 = SP.getString("Th1", "");
        etTh1.setText(sTh1);
        String sTh2 = SP.getString("Th2", "");
        etTh2.setText(sTh2);
        String sTh3 = SP.getString("Th3", "");
        etTh3.setText(sTh3);
        String sTh4 = SP.getString("Th4", "");
        etTh4.setText(sTh4);
        String sTh5 = SP.getString("Th5", "");
        etTh5.setText(sTh5);
        String sTh6 = SP.getString("Th6", "");
        etTh6.setText(sTh6);
        String sTh7 = SP.getString("Th7", "");
        etTh7.setText(sTh7);
        String sTh8 = SP.getString("Th8", "");
        etTh8.setText(sTh8);

        etTh1.setText(sTh1);
        etTh2.setText(sTh2);
        etTh3.setText(sTh3);
        etTh4.setText(sTh4);
        etTh5.setText(sTh5);
        etTh6.setText(sTh6);
        etTh7.setText(sTh7);
        etTh8.setText(sTh8);*/

        btnFri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String Th1 = etTh1.getText().toString();
                String Th2 = etTh2.getText().toString();
                String Th3 = etTh3.getText().toString();
                String Th4 = etTh4.getText().toString();
                String Th5 = etTh5.getText().toString();
                String Th6 = etTh6.getText().toString();
                String Th7 = etTh7.getText().toString();
                String Th8 = etTh8.getText().toString();

                reff = FirebaseDatabase.getInstance().getReference("Users").child(FirebaseAuth.getInstance().getCurrentUser().getUid());
                if(Th1.length()!=0) {
                    reff.child("SubTh1").setValue(Th1);
                }
                else
                {
                    reff.child("SubTh1").removeValue();
                }

                if(Th2.length()!=0) {
                    reff.child("SubTh2").setValue(Th2);
                }
                else
                {
                    reff.child("SubTh2").removeValue();
                }

                if(Th3.length()!=0) {
                    reff.child("SubTh3").setValue(Th3);
                }
                else
                {
                    reff.child("SubTh3").removeValue();
                }

                if(Th4.length()!=0) {
                    reff.child("SubTh4").setValue(Th4);
                }
                else
                {
                    reff.child("SubTh4").removeValue();
                }

                if(Th5.length()!=0) {
                    reff.child("SubTh5").setValue(Th5);
                }
                else
                {
                    reff.child("SubTh5").removeValue();
                }

                if(Th6.length()!=0) {
                    reff.child("SubTh6").setValue(Th6);
                }
                else
                {
                    reff.child("SubTh6").removeValue();
                }

                if(Th7.length()!=0) {
                    reff.child("SubTh7").setValue(Th7);
                }
                else
                {
                    reff.child("SubTh7").removeValue();
                }

                if(Th8.length()!=0) {
                    reff.child("SubTh8").setValue(Th8);
                }
                else
                {
                    reff.child("SubTh8").removeValue();
                }

                /*SPEditor.putString("Th1",Th1);
                SPEditor.apply();
                SPEditor.putString("Th2",Th2);
                SPEditor.commit();
                SPEditor.putString("Th3",Th3);
                SPEditor.commit();
                SPEditor.putString("Th4",Th4);
                SPEditor.commit();
                SPEditor.putString("Th5",Th5);
                SPEditor.commit();
                SPEditor.putString("Th6",Th6);
                SPEditor.commit();
                SPEditor.putString("Th7",Th7);
                SPEditor.commit();
                SPEditor.putString("Th8",Th8);
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