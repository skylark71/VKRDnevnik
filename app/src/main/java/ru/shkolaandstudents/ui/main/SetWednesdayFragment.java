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

public class SetWednesdayFragment extends Fragment implements OnBackPressedListener {

    Button btnThurs,btnHelp;
    EditText etW1,etW2,etW3,etW4,etW5,etW6,etW7,etW8;
    SharedPreferences SP;
    SharedPreferences.Editor SPEditor;
    TextView title;
    DatabaseReference reff;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View v = inflater.inflate(R.layout.fragment_set_wednesday, container, false);

        btnHelp = v.findViewById(R.id.btnWHelp);
        btnThurs = v.findViewById(R.id.btnWAccess);
        etW1 = v.findViewById(R.id.etW1);
        etW2 = v.findViewById(R.id.etW2);
        etW3 = v.findViewById(R.id.etW3);
        etW4 = v.findViewById(R.id.etW4);
        etW5 = v.findViewById(R.id.etW5);
        etW6 = v.findViewById(R.id.etW6);
        etW7 = v.findViewById(R.id.etW7);
        etW8 = v.findViewById(R.id.etW8);
        SP = PreferenceManager.getDefaultSharedPreferences(getActivity());
        SPEditor = SP.edit();
        title = v.findViewById(R.id.tvWRasp);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        reff = database.getReference("Users").child(FirebaseAuth.getInstance().getCurrentUser().getUid());
        reff.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                String sW1 = String.valueOf(snapshot.child("SubW1").getValue());
                String sW2 = String.valueOf(snapshot.child("SubW2").getValue());
                String sW3 = String.valueOf(snapshot.child("SubW3").getValue());
                String sW4 = String.valueOf(snapshot.child("SubW4").getValue());
                String sW5 = String.valueOf(snapshot.child("SubW5").getValue());
                String sW6 = String.valueOf(snapshot.child("SubW6").getValue());
                String sW7 = String.valueOf(snapshot.child("SubW7").getValue());
                String sW8 = String.valueOf(snapshot.child("SubW8").getValue());

                if (snapshot.child("SubW1").exists()) {
                    etW1.setText(sW1);
                }
                else
                {
                    etW1.setText("");
                }

                if (snapshot.child("SubW2").exists()) {
                    etW2.setText(sW2);
                }
                else
                {
                    etW2.setText("");
                }

                if (snapshot.child("SubW3").exists()) {
                    etW3.setText(sW3);
                }
                else
                {
                    etW3.setText("");
                }

                if (snapshot.child("SubW4").exists()) {
                    etW4.setText(sW4);
                }
                else
                {
                    etW4.setText("");
                }

                if (snapshot.child("SubW5").exists()) {
                    etW5.setText(sW5);
                }
                else
                {
                    etW5.setText("");
                }

                if (snapshot.child("SubW6").exists()) {
                    etW6.setText(sW6);
                }
                else
                {
                    etW6.setText("");
                }

                if (snapshot.child("SubW7").exists()) {
                    etW7.setText(sW7);
                }
                else
                {
                    etW7.setText("");
                }

                if (snapshot.child("SubW8").exists()) {
                    etW8.setText(sW8);
                }
                else
                {
                    etW8.setText("");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                etW1.setText("");
                etW2.setText("");
                etW3.setText("");
                etW4.setText("");
                etW5.setText("");
                etW6.setText("");
                etW7.setText("");
                etW8.setText("");
            }
        });

        /*String sW1 = SP.getString("W1", "");
        etW1.setText(sW1);
        String sW2 = SP.getString("W2", "");
        etW2.setText(sW2);
        String sW3 = SP.getString("W3", "");
        etW3.setText(sW3);
        String sW4 = SP.getString("W4", "");
        etW4.setText(sW4);
        String sW5 = SP.getString("W5", "");
        etW5.setText(sW5);
        String sW6 = SP.getString("W6", "");
        etW6.setText(sW6);
        String sW7 = SP.getString("W7", "");
        etW7.setText(sW7);
        String sW8 = SP.getString("W8", "");
        etW8.setText(sW8);


        etW1.setText(sW1);
        etW2.setText(sW2);
        etW3.setText(sW3);
        etW4.setText(sW4);
        etW5.setText(sW5);
        etW6.setText(sW6);
        etW7.setText(sW7);
        etW8.setText(sW8);*/


        btnHelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new TapTargetSequence(getActivity())
                        .targets(
                                TapTarget.forView(v.findViewById(R.id.etW1),getResources().getString(R.string.notfirst_click_TapTargetView),getResources().getString(R.string.click_TapTargetView))
                                        .titleTextSize(20)
                                        .titleTextColor(R.color.colorWhite)
                                        .descriptionTextColor(R.color.colorWhite)
                                        .cancelable(false)
                                        .tintTarget(false)
                                        .targetRadius(30)
                                        .transparentTarget(true)
                                        .outerCircleColor(R.color.colorTuesday),
                                TapTarget.forView(v.findViewById(R.id.btnWAccess), getResources().getString(R.string.accept_click_TapTargetView), getResources().getString(R.string.click_TapTargetView))
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

        btnThurs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String W1 = etW1.getText().toString();
                String W2 = etW2.getText().toString();
                String W3 = etW3.getText().toString();
                String W4 = etW4.getText().toString();
                String W5 = etW5.getText().toString();
                String W6 = etW6.getText().toString();
                String W7 = etW7.getText().toString();
                String W8 = etW8.getText().toString();

                reff = FirebaseDatabase.getInstance().getReference("Users").child(FirebaseAuth.getInstance().getCurrentUser().getUid());
                if(W1.length()!=0) {
                    reff.child("SubW1").setValue(W1);
                }
                else
                {
                    reff.child("SubW1").removeValue();
                }

                if(W2.length()!=0) {
                    reff.child("SubW2").setValue(W2);
                }
                else
                {
                    reff.child("SubW2").removeValue();
                }

                if(W3.length()!=0) {
                    reff.child("SubW3").setValue(W3);
                }
                else
                {
                    reff.child("SubW3").removeValue();
                }

                if(W4.length()!=0) {
                    reff.child("SubW4").setValue(W4);
                }
                else
                {
                    reff.child("SubW4").removeValue();
                }

                if(W5.length()!=0) {
                    reff.child("SubW5").setValue(W5);
                }
                else
                {
                    reff.child("SubW5").removeValue();
                }

                if(W6.length()!=0) {
                    reff.child("SubW6").setValue(W6);
                }
                else
                {
                    reff.child("SubW6").removeValue();
                }

                if(W7.length()!=0) {
                    reff.child("SubW7").setValue(W7);
                }
                else
                {
                    reff.child("SubW7").removeValue();
                }

                if(W8.length()!=0) {
                    reff.child("SubW8").setValue(W8);
                }
                else
                {
                    reff.child("SubW8").removeValue();
                }

                /*SPEditor.putString("W1",W1);
                SPEditor.apply();
                SPEditor.putString("W2",W2);
                SPEditor.commit();
                SPEditor.putString("W3",W3);
                SPEditor.commit();
                SPEditor.putString("W4",W4);
                SPEditor.commit();
                SPEditor.putString("W5",W5);
                SPEditor.commit();
                SPEditor.putString("W6",W6);
                SPEditor.commit();
                SPEditor.putString("W7",W7);
                SPEditor.commit();
                SPEditor.putString("W8",W8);
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