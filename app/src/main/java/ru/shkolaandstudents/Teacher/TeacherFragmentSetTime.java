package ru.shkolaandstudents.Teacher;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

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
import ru.shkolaandstudents.ui.main.SettingsFragment;
import ru.shkolaandstudents.ui.main.SettingsStudyMenuFragment;

import static android.content.Context.MODE_PRIVATE;

public class TeacherFragmentSetTime extends Fragment implements OnBackPressedListener {

    EditText etTime11,etTime12,etTime13,etTime14,etTime21,etTime22,etTime23,etTime24,etTime31,etTime32,etTime33,etTime34,etTime41,etTime42,etTime43,etTime44,etTime51,etTime52,etTime53,etTime54,etTime61,etTime62,etTime63,etTime64,etTime71,etTime72,etTime73,etTime74,etTime81,etTime82,etTime83,etTime84;
    Button btnNext, btnHelp;
    SharedPreferences SP;
    SharedPreferences.Editor SPEditor;
    DatabaseReference reff;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View v = inflater.inflate(R.layout.fragment_set_time, container, false);

        etTime11 = v.findViewById(R.id.etTime11); etTime21 = v.findViewById(R.id.etTime21); etTime31 = v.findViewById(R.id.etTime31); etTime41 = v.findViewById(R.id.etTime41); etTime51 = v.findViewById(R.id.etTime51); etTime61 = v.findViewById(R.id.etTime61); etTime71 = v.findViewById(R.id.etTime71); etTime81 = v.findViewById(R.id.etTime81);
        etTime12 = v.findViewById(R.id.etTime12); etTime22 = v.findViewById(R.id.etTime22); etTime32 = v.findViewById(R.id.etTime32); etTime42 = v.findViewById(R.id.etTime42); etTime52 = v.findViewById(R.id.etTime52); etTime62 = v.findViewById(R.id.etTime62); etTime72 = v.findViewById(R.id.etTime72); etTime82 = v.findViewById(R.id.etTime82);
        etTime13 = v.findViewById(R.id.etTime13); etTime23 = v.findViewById(R.id.etTime23); etTime33 = v.findViewById(R.id.etTime33); etTime43 = v.findViewById(R.id.etTime43); etTime53 = v.findViewById(R.id.etTime53); etTime63 = v.findViewById(R.id.etTime63); etTime73 = v.findViewById(R.id.etTime73); etTime83 = v.findViewById(R.id.etTime83);
        etTime14 = v.findViewById(R.id.etTime14); etTime24 = v.findViewById(R.id.etTime24); etTime34 = v.findViewById(R.id.etTime34); etTime44 = v.findViewById(R.id.etTime44); etTime54 = v.findViewById(R.id.etTime54); etTime64 = v.findViewById(R.id.etTime64); etTime74 = v.findViewById(R.id.etTime74); etTime84 = v.findViewById(R.id.etTime84);
        btnNext = v.findViewById(R.id.btnNext);
        btnHelp = v.findViewById(R.id.btnTimeHelp);

        final SharedPreferences prefs = this.getActivity().getSharedPreferences("prefs2", MODE_PRIVATE);
        boolean firstStart = prefs.getBoolean("firstStart2", true);
        if(firstStart) {
            new TapTargetSequence(getActivity())
                    .targets(
                            TapTarget.forView(v.findViewById(R.id.tv11),getResources().getString(R.string.setStartTime_click_TapTargetView),getResources().getString(R.string.click_TapTargetView))
                                    .titleTextSize(20)
                                    .titleTextColor(R.color.colorWhite)
                                    .descriptionTextColor(R.color.colorWhite)
                                    .cancelable(false)
                                    .tintTarget(false)
                                    .targetRadius(70)
                                    .transparentTarget(true)
                                    .outerCircleColor(R.color.colorTuesday),
                            TapTarget.forView(v.findViewById(R.id.tv13), getResources().getString(R.string.setEndTime_click_TapTargetView), getResources().getString(R.string.click_TapTargetView))
                                    .titleTextSize(20)
                                    .titleTextColor(R.color.colorWhite)
                                    .descriptionTextColor(R.color.colorWhite)
                                    .cancelable(false)
                                    .tintTarget(false)
                                    .targetRadius(70)
                                    .transparentTarget(true)
                                    .outerCircleColor(R.color.colorTuesday),
                            TapTarget.forView(v.findViewById(R.id.btnNext), getResources().getString(R.string.setTime_click_TapTargetView), getResources().getString(R.string.click_TapTargetView))
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
                            SharedPreferences.Editor editor = prefs.edit();
                            editor.putBoolean("firstStart2", false);
                            editor.apply();
                        }

                        @Override
                        public void onSequenceStep(TapTarget lastTarget, boolean targetClicked) {

                        }

                        @Override
                        public void onSequenceCanceled(TapTarget lastTarget) {
                            // Boo
                        }
                    }).start();
        }


        btnHelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new TapTargetSequence(getActivity())
                        .targets(
                                TapTarget.forView(v.findViewById(R.id.tv11),getResources().getString(R.string.setStartTime_click_TapTargetView),getResources().getString(R.string.click_TapTargetView))
                                        .titleTextSize(20)
                                        .titleTextColor(R.color.colorWhite)
                                        .descriptionTextColor(R.color.colorWhite)
                                        .cancelable(false)
                                        .tintTarget(false)
                                        .targetRadius(80)
                                        .transparentTarget(true)
                                        .outerCircleColor(R.color.colorTuesday),
                                TapTarget.forView(v.findViewById(R.id.tv13), getResources().getString(R.string.setEndTime_click_TapTargetView), getResources().getString(R.string.click_TapTargetView))
                                        .titleTextSize(20)
                                        .titleTextColor(R.color.colorWhite)
                                        .descriptionTextColor(R.color.colorWhite)
                                        .cancelable(false)
                                        .tintTarget(false)
                                        .targetRadius(80)
                                        .transparentTarget(true)
                                        .outerCircleColor(R.color.colorTuesday),
                                TapTarget.forView(v.findViewById(R.id.btnNext), getResources().getString(R.string.setTime_click_TapTargetView), getResources().getString(R.string.click_TapTargetView))
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

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        reff = database.getReference("Users").child(FirebaseAuth.getInstance().getCurrentUser().getUid());
        reff.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                String sT11 = String.valueOf(snapshot.child("T11").getValue());
                String sT12 = String.valueOf(snapshot.child("T12").getValue());
                String sT13 = String.valueOf(snapshot.child("T13").getValue());
                String sT14 = String.valueOf(snapshot.child("T14").getValue());

                String sT21 = String.valueOf(snapshot.child("T21").getValue());
                String sT22 = String.valueOf(snapshot.child("T22").getValue());
                String sT23 = String.valueOf(snapshot.child("T23").getValue());
                String sT24 = String.valueOf(snapshot.child("T24").getValue());

                String sT31 = String.valueOf(snapshot.child("T31").getValue());
                String sT32 = String.valueOf(snapshot.child("T32").getValue());
                String sT33 = String.valueOf(snapshot.child("T33").getValue());
                String sT34 = String.valueOf(snapshot.child("T34").getValue());

                String sT41 = String.valueOf(snapshot.child("T41").getValue());
                String sT42 = String.valueOf(snapshot.child("T42").getValue());
                String sT43 = String.valueOf(snapshot.child("T43").getValue());
                String sT44 = String.valueOf(snapshot.child("T44").getValue());

                String sT51 = String.valueOf(snapshot.child("T51").getValue());
                String sT52 = String.valueOf(snapshot.child("T52").getValue());
                String sT53 = String.valueOf(snapshot.child("T53").getValue());
                String sT54 = String.valueOf(snapshot.child("T54").getValue());

                String sT61 = String.valueOf(snapshot.child("T61").getValue());
                String sT62 = String.valueOf(snapshot.child("T62").getValue());
                String sT63 = String.valueOf(snapshot.child("T63").getValue());
                String sT64 = String.valueOf(snapshot.child("T64").getValue());

                String sT71 = String.valueOf(snapshot.child("T71").getValue());
                String sT72 = String.valueOf(snapshot.child("T72").getValue());
                String sT73 = String.valueOf(snapshot.child("T73").getValue());
                String sT74 = String.valueOf(snapshot.child("T74").getValue());

                String sT81 = String.valueOf(snapshot.child("T81").getValue());
                String sT82 = String.valueOf(snapshot.child("T82").getValue());
                String sT83 = String.valueOf(snapshot.child("T83").getValue());
                String sT84 = String.valueOf(snapshot.child("T84").getValue());

                if (snapshot.child("T11").exists()) {
                    etTime11.setText(sT11);
                }
                else
                {
                    etTime11.setText("");
                }

                if (snapshot.child("T12").exists()) {
                    etTime12.setText(sT12);
                }
                else
                {
                    etTime12.setText("");
                }

                if (snapshot.child("T13").exists()) {
                    etTime13.setText(sT13);
                }
                else
                {
                    etTime13.setText("");
                }

                if (snapshot.child("T14").exists()) {
                    etTime14.setText(sT14);
                }
                else
                {
                    etTime14.setText("");
                }


                if (snapshot.child("T21").exists()) {
                    etTime21.setText(sT21);
                }
                else
                {
                    etTime21.setText("");
                }

                if (snapshot.child("T22").exists()) {
                    etTime22.setText(sT22);
                }
                else
                {
                    etTime22.setText("");
                }

                if (snapshot.child("T23").exists()) {
                    etTime23.setText(sT23);
                }
                else
                {
                    etTime23.setText("");
                }

                if (snapshot.child("T24").exists()) {
                    etTime24.setText(sT24);
                }
                else
                {
                    etTime24.setText("");
                }


                if (snapshot.child("T31").exists()) {
                    etTime31.setText(sT31);
                }
                else
                {
                    etTime31.setText("");
                }

                if (snapshot.child("T32").exists()) {
                    etTime32.setText(sT32);
                }
                else
                {
                    etTime32.setText("");
                }

                if (snapshot.child("T33").exists()) {
                    etTime33.setText(sT33);
                }
                else
                {
                    etTime33.setText("");
                }

                if (snapshot.child("T34").exists()) {
                    etTime34.setText(sT34);
                }
                else
                {
                    etTime34.setText("");
                }


                if (snapshot.child("T41").exists()) {
                    etTime41.setText(sT41);
                }
                else
                {
                    etTime41.setText("");
                }

                if (snapshot.child("T42").exists()) {
                    etTime42.setText(sT42);
                }
                else
                {
                    etTime42.setText("");
                }

                if (snapshot.child("T43").exists()) {
                    etTime43.setText(sT43);
                }
                else
                {
                    etTime43.setText("");
                }

                if (snapshot.child("T44").exists()) {
                    etTime44.setText(sT44);
                }
                else
                {
                    etTime44.setText("");
                }


                if (snapshot.child("T51").exists()) {
                    etTime51.setText(sT51);
                }
                else
                {
                    etTime51.setText("");
                }

                if (snapshot.child("T52").exists()) {
                    etTime52.setText(sT52);
                }
                else
                {
                    etTime52.setText("");
                }

                if (snapshot.child("T53").exists()) {
                    etTime53.setText(sT53);
                }
                else
                {
                    etTime53.setText("");
                }

                if (snapshot.child("T54").exists()) {
                    etTime54.setText(sT54);
                }
                else
                {
                    etTime54.setText("");
                }


                if (snapshot.child("T61").exists()) {
                    etTime61.setText(sT61);
                }
                else
                {
                    etTime61.setText("");
                }

                if (snapshot.child("T62").exists()) {
                    etTime62.setText(sT62);
                }
                else
                {
                    etTime62.setText("");
                }

                if (snapshot.child("T63").exists()) {
                    etTime63.setText(sT63);
                }
                else
                {
                    etTime63.setText("");
                }

                if (snapshot.child("T64").exists()) {
                    etTime64.setText(sT64);
                }
                else
                {
                    etTime64.setText("");
                }

                if (snapshot.child("T71").exists()) {
                    etTime71.setText(sT71);
                }
                else
                {
                    etTime71.setText("");
                }

                if (snapshot.child("T72").exists()) {
                    etTime72.setText(sT72);
                }
                else
                {
                    etTime72.setText("");
                }

                if (snapshot.child("T73").exists()) {
                    etTime73.setText(sT73);
                }
                else
                {
                    etTime73.setText("");
                }

                if (snapshot.child("T74").exists()) {
                    etTime74.setText(sT74);
                }
                else
                {
                    etTime74.setText("");
                }


                if (snapshot.child("T81").exists()) {
                    etTime81.setText(sT81);
                }
                else
                {
                    etTime81.setText("");
                }

                if (snapshot.child("T82").exists()) {
                    etTime82.setText(sT82);
                }
                else
                {
                    etTime82.setText("");
                }

                if (snapshot.child("T83").exists()) {
                    etTime83.setText(sT83);
                }
                else
                {
                    etTime83.setText("");
                }

                if (snapshot.child("T84").exists()) {
                    etTime84.setText(sT84);
                }
                else
                {
                    etTime84.setText("");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {

                String T11 = etTime11.getText().toString();
                String T12 = etTime12.getText().toString();
                String T13 = etTime13.getText().toString();
                String T14 = etTime14.getText().toString();
                String T21 = etTime21.getText().toString();
                String T22 = etTime22.getText().toString();
                String T23 = etTime23.getText().toString();
                String T24 = etTime24.getText().toString();
                String T31 = etTime31.getText().toString();
                String T32 = etTime32.getText().toString();
                String T33 = etTime33.getText().toString();
                String T34 = etTime34.getText().toString();
                String T41 = etTime41.getText().toString();
                String T42 = etTime42.getText().toString();
                String T43 = etTime43.getText().toString();
                String T44 = etTime44.getText().toString();
                String T51 = etTime51.getText().toString();
                String T52 = etTime52.getText().toString();
                String T53 = etTime53.getText().toString();
                String T54 = etTime54.getText().toString();
                String T61 = etTime61.getText().toString();
                String T62 = etTime62.getText().toString();
                String T63 = etTime63.getText().toString();
                String T64 = etTime64.getText().toString();
                String T71 = etTime71.getText().toString();
                String T72 = etTime72.getText().toString();
                String T73 = etTime73.getText().toString();
                String T74 = etTime74.getText().toString();
                String T81 = etTime81.getText().toString();
                String T82 = etTime82.getText().toString();
                String T83 = etTime83.getText().toString();
                String T84 = etTime84.getText().toString();

                reff = FirebaseDatabase.getInstance().getReference("Users").child(FirebaseAuth.getInstance().getCurrentUser().getUid());
                if(T11.length()!=0) {
                    reff.child("T11").setValue(T11);
                }
                else
                {
                    reff.child("T11").removeValue();
                }

                if(T12.length()!=0) {
                    reff.child("T12").setValue(T12);
                }
                else
                {
                    reff.child("T12").removeValue();
                }

                if(T13.length()!=0) {
                    reff.child("T13").setValue(T13);
                }
                else
                {
                    reff.child("T13").removeValue();
                }

                if(T14.length()!=0) {
                    reff.child("T14").setValue(T14);
                }
                else
                {
                    reff.child("T14").removeValue();
                }
                /***/
                if(T21.length()!=0) {
                    reff.child("T21").setValue(T21);
                }
                else
                {
                    reff.child("T21").removeValue();
                }

                if(T22.length()!=0) {
                    reff.child("T22").setValue(T22);
                }
                else
                {
                    reff.child("T22").removeValue();
                }

                if(T23.length()!=0) {
                    reff.child("T23").setValue(T23);
                }
                else
                {
                    reff.child("T23").removeValue();
                }

                if(T24.length()!=0) {
                    reff.child("T24").setValue(T24);
                }
                else
                {
                    reff.child("T24").removeValue();
                }
                /***/
                if(T31.length()!=0) {
                    reff.child("T31").setValue(T31);
                }
                else
                {
                    reff.child("T31").removeValue();
                }

                if(T32.length()!=0) {
                    reff.child("T32").setValue(T32);
                }
                else
                {
                    reff.child("T32").removeValue();
                }

                if(T33.length()!=0) {
                    reff.child("T33").setValue(T33);
                }
                else
                {
                    reff.child("T33").removeValue();
                }

                if(T34.length()!=0) {
                    reff.child("T34").setValue(T34);
                }
                else
                {
                    reff.child("T34").removeValue();
                }
                /***/
                if(T41.length()!=0) {
                    reff.child("T41").setValue(T41);
                }
                else
                {
                    reff.child("T41").removeValue();
                }

                if(T42.length()!=0) {
                    reff.child("T42").setValue(T42);
                }
                else
                {
                    reff.child("T42").removeValue();
                }

                if(T43.length()!=0) {
                    reff.child("T43").setValue(T43);
                }
                else
                {
                    reff.child("T43").removeValue();
                }

                if(T44.length()!=0) {
                    reff.child("T44").setValue(T44);
                }
                else
                {
                    reff.child("T44").removeValue();
                }
                /***/
                if(T51.length()!=0) {
                    reff.child("T51").setValue(T51);
                }
                else
                {
                    reff.child("T51").removeValue();
                }

                if(T52.length()!=0) {
                    reff.child("T52").setValue(T52);
                }
                else
                {
                    reff.child("T52").removeValue();
                }

                if(T53.length()!=0) {
                    reff.child("T53").setValue(T53);
                }
                else
                {
                    reff.child("T53").removeValue();
                }

                if(T54.length()!=0) {
                    reff.child("T54").setValue(T54);
                }
                else
                {
                    reff.child("T54").removeValue();
                }
                /***/
                if(T61.length()!=0) {
                    reff.child("T61").setValue(T61);
                }
                else
                {
                    reff.child("T61").removeValue();
                }

                if(T62.length()!=0) {
                    reff.child("T62").setValue(T62);
                }
                else
                {
                    reff.child("T62").removeValue();
                }

                if(T63.length()!=0) {
                    reff.child("T63").setValue(T63);
                }
                else
                {
                    reff.child("T63").removeValue();
                }

                if(T64.length()!=0) {
                    reff.child("T64").setValue(T64);
                }
                else
                {
                    reff.child("T64").removeValue();
                }
                /***/
                if(T71.length()!=0) {
                    reff.child("T71").setValue(T71);
                }
                else
                {
                    reff.child("T71").removeValue();
                }

                if(T72.length()!=0) {
                    reff.child("T72").setValue(T72);
                }
                else
                {
                    reff.child("T72").removeValue();
                }

                if(T73.length()!=0) {
                    reff.child("T73").setValue(T73);
                }
                else
                {
                    reff.child("T73").removeValue();
                }

                if(T74.length()!=0) {
                    reff.child("T74").setValue(T74);
                }
                else
                {
                    reff.child("T74").removeValue();
                }
                /***/
                if(T81.length()!=0) {
                    reff.child("T81").setValue(T81);
                }
                else
                {
                    reff.child("T81").removeValue();
                }

                if(T82.length()!=0) {
                    reff.child("T82").setValue(T82);
                }
                else
                {
                    reff.child("T82").removeValue();
                }

                if(T83.length()!=0) {
                    reff.child("T83").setValue(T83);
                }
                else
                {
                    reff.child("T83").removeValue();
                }

                if(T84.length()!=0) {
                    reff.child("T84").setValue(T84);
                }
                else
                {
                    reff.child("T84").removeValue();
                }
                /*SPEditor.putString("T11", T11);
                SPEditor.apply();
                SPEditor.putString("T12", T12);
                SPEditor.apply();
                SPEditor.putString("T13", T13);
                SPEditor.apply();
                SPEditor.putString("T14", T14);
                SPEditor.apply();
                SPEditor.putString("T21", T21);
                SPEditor.apply();
                SPEditor.putString("T22", T22);
                SPEditor.apply();
                SPEditor.putString("T23", T23);
                SPEditor.apply();
                SPEditor.putString("T24", T24);
                SPEditor.apply();
                SPEditor.putString("T31", T31);
                SPEditor.apply();
                SPEditor.putString("T32", T32);
                SPEditor.apply();
                SPEditor.putString("T33", T33);
                SPEditor.apply();
                SPEditor.putString("T34", T34);
                SPEditor.apply();
                SPEditor.putString("T41", T41);
                SPEditor.apply();
                SPEditor.putString("T42", T42);
                SPEditor.apply();
                SPEditor.putString("T43", T43);
                SPEditor.apply();
                SPEditor.putString("T44", T44);
                SPEditor.apply();
                SPEditor.putString("T51", T51);
                SPEditor.apply();
                SPEditor.putString("T52", T52);
                SPEditor.apply();
                SPEditor.putString("T53", T53);
                SPEditor.apply();
                SPEditor.putString("T54", T54);
                SPEditor.apply();
                SPEditor.putString("T61", T61);
                SPEditor.apply();
                SPEditor.putString("T62", T62);
                SPEditor.apply();
                SPEditor.putString("T63", T63);
                SPEditor.apply();
                SPEditor.putString("T64", T64);
                SPEditor.apply();
                SPEditor.putString("T71", T71);
                SPEditor.apply();
                SPEditor.putString("T72", T72);
                SPEditor.apply();
                SPEditor.putString("T73", T73);
                SPEditor.apply();
                SPEditor.putString("T74", T74);
                SPEditor.apply();
                SPEditor.putString("T81", T81);
                SPEditor.apply();
                SPEditor.putString("T82", T82);
                SPEditor.apply();
                SPEditor.putString("T83", T83);
                SPEditor.apply();
                SPEditor.putString("T84", T84);
                SPEditor.apply();*/

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
        transaction.replace(R.id.container, new TeacherFragmentSettings());
        transaction.commit();
    }
}
