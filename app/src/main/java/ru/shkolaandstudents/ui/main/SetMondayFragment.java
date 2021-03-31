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
import android.widget.Toast;

import com.getkeepsafe.taptargetview.TapTarget;
import com.getkeepsafe.taptargetview.TapTargetSequence;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import ru.shkolaandstudents.LoginAndRegist.DashboardActivity;
import ru.shkolaandstudents.LoginAndRegist.SignUpActivity;
import ru.shkolaandstudents.LoginAndRegist.User;
import ru.shkolaandstudents.OnBackPressedListener;
import ru.shkolaandstudents.R;

import static android.content.ContentValues.TAG;


public class SetMondayFragment extends Fragment implements OnBackPressedListener {

    Button btnTuesday,btnHelp;
    EditText etM1,etM2,etM3,etM4,etM5,etM6,etM7,etM8;
    SharedPreferences SP;
    SharedPreferences.Editor SPEditor;
    TextView title;
    DatabaseReference reff;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View v = inflater.inflate(R.layout.fragment_set_monday, container, false);
        btnTuesday = v.findViewById(R.id.btnMAccess);
        btnHelp = v.findViewById(R.id.btnMHelp);
        etM1 = v.findViewById(R.id.etM1);
        etM2 = v.findViewById(R.id.etM2);
        etM3 = v.findViewById(R.id.etM3);
        etM4 = v.findViewById(R.id.etM4);
        etM5 = v.findViewById(R.id.etM5);
        etM6 = v.findViewById(R.id.etM6);
        etM7 = v.findViewById(R.id.etM7);
        etM8 = v.findViewById(R.id.etM8);
        title = v.findViewById(R.id.tvMRasp);
        title.setText(getResources().getString(R.string.change_rasp_m));
        SP = PreferenceManager.getDefaultSharedPreferences(getActivity());
        SPEditor = SP.edit();

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        reff = database.getReference("Users").child(FirebaseAuth.getInstance().getCurrentUser().getUid());
        reff.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                String sM1 = String.valueOf(snapshot.child("SubM1").getValue());
                String sM2 = String.valueOf(snapshot.child("SubM2").getValue());
                String sM3 = String.valueOf(snapshot.child("SubM3").getValue());
                String sM4 = String.valueOf(snapshot.child("SubM4").getValue());
                String sM5 = String.valueOf(snapshot.child("SubM5").getValue());
                String sM6 = String.valueOf(snapshot.child("SubM6").getValue());
                String sM7 = String.valueOf(snapshot.child("SubM7").getValue());
                String sM8 = String.valueOf(snapshot.child("SubM8").getValue());

                if (snapshot.child("SubM1").exists()) {
                    etM1.setText(sM1);
                }
                else
                {
                    etM1.setText("");
                }

                if (snapshot.child("SubM2").exists()) {
                    etM2.setText(sM2);
                }
                else
                {
                    etM2.setText("");
                }

                if (snapshot.child("SubM3").exists()) {
                    etM3.setText(sM3);
                }
                else
                {
                    etM3.setText("");
                }

                if (snapshot.child("SubM4").exists()) {
                    etM4.setText(sM4);
                }
                else
                {
                    etM4.setText("");
                }

                if (snapshot.child("SubM5").exists()) {
                    etM5.setText(sM5);
                }
                else
                {
                    etM5.setText("");
                }

                if (snapshot.child("SubM6").exists()) {
                    etM6.setText(sM6);
                }
                else
                {
                    etM6.setText("");
                }

                if (snapshot.child("SubM7").exists()) {
                    etM7.setText(sM7);
                }
                else
                {
                    etM7.setText("");
                }
                
                if (snapshot.child("SubM8").exists()) {
                    etM8.setText(sM8);
                }
                else
                {
                    etM8.setText("");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                etM1.setText("");
                etM2.setText("");
                etM3.setText("");
                etM4.setText("");
                etM5.setText("");
                etM6.setText("");
                etM7.setText("");
                etM8.setText("");
            }
        });

        /*String sM1 = SP.getString("M1", "");
        etM1.setText(sM1);
        String sM2 = SP.getString("M2", "");
        etM2.setText(sM2);
        String sM3 = SP.getString("M3", "");
        etM3.setText(sM3);
        String sM4 = SP.getString("M4", "");
        etM4.setText(sM4);
        String sM5 = SP.getString("M5", "");
        etM5.setText(sM5);
        String sM6 = SP.getString("M6", "");
        etM6.setText(sM6);
        String sM7 = SP.getString("M7", "");
        etM7.setText(sM7);
        String sM8 = SP.getString("M8", "");
        etM8.setText(sM8);

        etM1.setText(sM1);
        etM2.setText(sM2);
        etM3.setText(sM3);
        etM4.setText(sM4);
        etM5.setText(sM5);
        etM6.setText(sM6);
        etM7.setText(sM7);
        etM8.setText(sM8);*/

        btnHelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new TapTargetSequence(getActivity())
                        .targets(
                                TapTarget.forView(v.findViewById(R.id.etM1),getResources().getString(R.string.notfirst_click_TapTargetView),getResources().getString(R.string.click_TapTargetView))
                                        .titleTextSize(20)
                                        .titleTextColor(R.color.colorWhite)
                                        .descriptionTextColor(R.color.colorWhite)
                                        .cancelable(false)
                                        .tintTarget(false)
                                        .targetRadius(30)
                                        .transparentTarget(true)
                                        .outerCircleColor(R.color.colorTuesday),
                                TapTarget.forView(v.findViewById(R.id.btnMAccess), getResources().getString(R.string.accept_click_TapTargetView), getResources().getString(R.string.click_TapTargetView))
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


        btnTuesday.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

                String M1 = etM1.getText().toString();
                String M2 = etM2.getText().toString();
                String M3 = etM3.getText().toString();
                String M4 = etM4.getText().toString();
                String M5 = etM5.getText().toString();
                String M6 = etM6.getText().toString();
                String M7 = etM7.getText().toString();
                String M8 = etM8.getText().toString();

                /*
                SPEditor.putString("M1",M1);
                SPEditor.apply();
                SPEditor.putString("M2",M2);
                SPEditor.commit();
                SPEditor.putString("M3",M3);
                SPEditor.commit();
                SPEditor.putString("M4",M4);
                SPEditor.commit();
                SPEditor.putString("M5",M5);
                SPEditor.commit();
                SPEditor.putString("M6",M6);
                SPEditor.commit();
                SPEditor.putString("M7",M7);
                SPEditor.commit();
                SPEditor.putString("M8",M8);
                SPEditor.commit();*/

                reff = FirebaseDatabase.getInstance().getReference("Users").child(FirebaseAuth.getInstance().getCurrentUser().getUid());
                if(M1.length()!=0) {
                    reff.child("SubM1").setValue(M1);
                }
                else
                {
                    reff.child("SubM1").removeValue();
                }

                if(M2.length()!=0) {
                    reff.child("SubM2").setValue(M2);
                }
                else
                {
                    reff.child("SubM2").removeValue();
                }

                if(M3.length()!=0) {
                    reff.child("SubM3").setValue(M3);
                }
                else
                {
                    reff.child("SubM3").removeValue();
                }

                if(M4.length()!=0) {
                    reff.child("SubM4").setValue(M4);
                }
                else
                {
                    reff.child("SubM4").removeValue();
                }

                if(M5.length()!=0) {
                    reff.child("SubM5").setValue(M5);
                }
                else
                {
                    reff.child("SubM5").removeValue();
                }

                if(M6.length()!=0) {
                    reff.child("SubM6").setValue(M6);
                }
                else
                {
                    reff.child("SubM6").removeValue();
                }

                if(M7.length()!=0) {
                    reff.child("SubM7").setValue(M7);
                }
                else
                {
                    reff.child("SubM7").removeValue();
                }

                if(M8.length()!=0) {
                    reff.child("SubM8").setValue(M8);
                }
                else
                {
                    reff.child("SubM8").removeValue();
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