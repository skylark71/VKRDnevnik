package ru.shkolaandstudents.Teacher;


import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.getkeepsafe.taptargetview.TapTarget;
import com.getkeepsafe.taptargetview.TapTargetSequence;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import ru.shkolaandstudents.R;

public class TeacherFragmentRaspFri extends Fragment {

    TextView tvFr1,tvFr2,tvFr3,tvFr4,tvFr5,tvFr6,tvFr7,tvFr8,tvTimeFr11,tvTimeFr12,tvTimeFr13,tvTimeFr14,tvTimeFr15,tvTimeFr16,tvTimeFr17,tvTimeFr21,tvTimeFr22,tvTimeFr23,tvTimeFr24,tvTimeFr25,tvTimeFr26,tvTimeFr27,tvTimeFr31,tvTimeFr32,tvTimeFr33,tvTimeFr34,tvTimeFr35,tvTimeFr36,tvTimeFr37,tvTimeFr41,tvTimeFr42,tvTimeFr43,tvTimeFr44,tvTimeFr45,tvTimeFr46,tvTimeFr47,tvTimeFr51,tvTimeFr52,tvTimeFr53,tvTimeFr54,tvTimeFr55,tvTimeFr56,tvTimeFr57,tvTimeFr61,tvTimeFr62,tvTimeFr63,tvTimeFr64,tvTimeFr65,tvTimeFr66,tvTimeFr67,tvTimeFr71,tvTimeFr72,tvTimeFr73,tvTimeFr74,tvTimeFr75,tvTimeFr76,tvTimeFr77,tvTimeFr81,tvTimeFr82,tvTimeFr83,tvTimeFr84,tvTimeFr85,tvTimeFr86,tvTimeFr87;
    TextView tvFrClass11,tvFrClass22,tvFrClass33,tvFrClass44,tvFrClass55,tvFrClass66,tvFrClass77,tvFrClass88;
    TextView tvFrSub11,tvFrSub22,tvFrSub33,tvFrSub44,tvFrSub55,tvFrSub66,tvFrSub77,tvFrSub88;
    Button btnHelp;
    DatabaseReference ref_save;
    DatabaseReference ref_time;
    
    String Fr1Sub;
    String Fr2Sub;
    String Fr3Sub;
    String Fr4Sub;
    String Fr5Sub;
    String Fr6Sub;
    String Fr7Sub;
    String Fr8Sub;

    String Fr1Class;
    String Fr2Class;
    String Fr3Class;
    String Fr4Class;
    String Fr5Class;
    String Fr6Class;
    String Fr7Class;
    String Fr8Class;

    String T11;
    String T12;
    String T13;
    String T14;
    String T21;
    String T22;
    String T23;
    String T24;
    String T31;
    String T32;
    String T33;
    String T34;
    String T41;
    String T42;
    String T43;
    String T44;
    String T51;
    String T52;
    String T53;
    String T54;
    String T61;
    String T62;
    String T63;
    String T64;
    String T71;
    String T72;
    String T73;
    String T74;
    String T81;
    String T82;
    String T83;
    String T84;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View v = inflater.inflate(R.layout.teacher_fragment_rasp_fri, container, false);

        btnHelp = v.findViewById(R.id.btnFriHelp);

        btnHelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new TapTargetSequence(getActivity())
                        .targets(
                                TapTarget.forView(v.findViewById(R.id.tvFr1), getResources().getString(R.string.nomer_predmeta), getResources().getString(R.string.click_TapTargetView))
                                        .titleTextSize(20)
                                        .titleTextColor(R.color.colorWhite)
                                        .descriptionTextColor(R.color.colorWhite)
                                        .cancelable(false)
                                        .tintTarget(false)
                                        .targetRadius(10)
                                        .transparentTarget(true)
                                        .outerCircleColor(R.color.colorTuesday),
                                TapTarget.forView(v.findViewById(R.id.tvTimeFr12), getResources().getString(R.string.nachalo_uroka), getResources().getString(R.string.click_TapTargetView))
                                        .titleTextSize(20)
                                        .titleTextColor(R.color.colorWhite)
                                        .descriptionTextColor(R.color.colorWhite)
                                        .cancelable(false)
                                        .tintTarget(false)
                                        .targetRadius(20)
                                        .transparentTarget(true)
                                        .outerCircleColor(R.color.colorTuesday),
                                TapTarget.forView(v.findViewById(R.id.tvTimeFr16), getResources().getString(R.string.konec_uroka), getResources().getString(R.string.click_TapTargetView))
                                        .titleTextSize(20)
                                        .titleTextColor(R.color.colorWhite)
                                        .descriptionTextColor(R.color.colorWhite)
                                        .cancelable(false)
                                        .tintTarget(false)
                                        .targetRadius(20)
                                        .transparentTarget(true)
                                        .outerCircleColor(R.color.colorTuesday),
                                TapTarget.forView(v.findViewById(R.id.tvFrSub11), getResources().getString(R.string.predmet), getResources().getString(R.string.click_TapTargetView))
                                        .titleTextSize(20)
                                        .titleTextColor(R.color.colorWhite)
                                        .descriptionTextColor(R.color.colorWhite)
                                        .cancelable(false)
                                        .tintTarget(false)
                                        .targetRadius(30)
                                        .transparentTarget(true)
                                        .outerCircleColor(R.color.colorTuesday),
                                TapTarget.forView(v.findViewById(R.id.tvFrClass11), "Класс", getResources().getString(R.string.click_TapTargetView))
                                        .titleTextSize(20)
                                        .titleTextColor(R.color.colorWhite)
                                        .descriptionTextColor(R.color.colorWhite)
                                        .cancelable(false)
                                        .tintTarget(false)
                                        .targetRadius(30)
                                        .transparentTarget(true)
                                        .outerCircleColor(R.color.colorTuesday))
                        .listener(new TapTargetSequence.Listener() {
                            // This listener will tell us when interesting(tm) events happen in regards
                            // to the sequence
                            @Override
                            public void onSequenceFinish() {
                                // Yay
                            }

                            @Override
                            public void onSequenceStep(TapTarget lastTarget, boolean targetClicked) {

                            }

                            @Override
                            public void onSequenceCanceled(TapTarget lastTarget) {
                                // Boo
                            }
                        }).start();
                //showStartDialog();
            }
        });

        tvFr1 = v.findViewById(R.id.tvFr1);
        tvFr2 = v.findViewById(R.id.tvFr2);
        tvFr3 = v.findViewById(R.id.tvFr3);
        tvFr4 = v.findViewById(R.id.tvFr4);
        tvFr5 = v.findViewById(R.id.tvFr5);
        tvFr6 = v.findViewById(R.id.tvFr6);
        tvFr7 = v.findViewById(R.id.tvFr7);
        tvFr8 = v.findViewById(R.id.tvFr8);

        tvTimeFr11 = v.findViewById(R.id.tvTimeFr11);
        tvTimeFr12 = v.findViewById(R.id.tvTimeFr12);
        tvTimeFr13 = v.findViewById(R.id.tvTimeFr13);
        tvTimeFr14 = v.findViewById(R.id.tvTimeFr14);
        tvTimeFr15 = v.findViewById(R.id.tvTimeFr15);
        tvTimeFr16 = v.findViewById(R.id.tvTimeFr16);
        tvTimeFr17 = v.findViewById(R.id.tvTimeFr17);
        tvTimeFr21 = v.findViewById(R.id.tvTimeFr21);
        tvTimeFr22 = v.findViewById(R.id.tvTimeFr22);
        tvTimeFr23 = v.findViewById(R.id.tvTimeFr23);
        tvTimeFr24 = v.findViewById(R.id.tvTimeFr24);
        tvTimeFr25 = v.findViewById(R.id.tvTimeFr25);
        tvTimeFr26 = v.findViewById(R.id.tvTimeFr26);
        tvTimeFr27 = v.findViewById(R.id.tvTimeFr27);
        tvTimeFr31 = v.findViewById(R.id.tvTimeFr31);
        tvTimeFr32 = v.findViewById(R.id.tvTimeFr32);
        tvTimeFr33 = v.findViewById(R.id.tvTimeFr33);
        tvTimeFr34 = v.findViewById(R.id.tvTimeFr34);
        tvTimeFr35 = v.findViewById(R.id.tvTimeFr35);
        tvTimeFr36 = v.findViewById(R.id.tvTimeFr36);
        tvTimeFr37 = v.findViewById(R.id.tvTimeFr37);
        tvTimeFr41 = v.findViewById(R.id.tvTimeFr41);
        tvTimeFr42 = v.findViewById(R.id.tvTimeFr42);
        tvTimeFr43 = v.findViewById(R.id.tvTimeFr43);
        tvTimeFr44 = v.findViewById(R.id.tvTimeFr44);
        tvTimeFr45 = v.findViewById(R.id.tvTimeFr45);
        tvTimeFr46 = v.findViewById(R.id.tvTimeFr46);
        tvTimeFr47 = v.findViewById(R.id.tvTimeFr47);
        tvTimeFr51 = v.findViewById(R.id.tvTimeFr51);
        tvTimeFr52 = v.findViewById(R.id.tvTimeFr52);
        tvTimeFr53 = v.findViewById(R.id.tvTimeFr53);
        tvTimeFr54 = v.findViewById(R.id.tvTimeFr54);
        tvTimeFr55 = v.findViewById(R.id.tvTimeFr55);
        tvTimeFr56 = v.findViewById(R.id.tvTimeFr56);
        tvTimeFr57 = v.findViewById(R.id.tvTimeFr57);
        tvTimeFr61 = v.findViewById(R.id.tvTimeFr61);
        tvTimeFr62 = v.findViewById(R.id.tvTimeFr62);
        tvTimeFr63 = v.findViewById(R.id.tvTimeFr63);
        tvTimeFr64 = v.findViewById(R.id.tvTimeFr64);
        tvTimeFr65 = v.findViewById(R.id.tvTimeFr65);
        tvTimeFr66 = v.findViewById(R.id.tvTimeFr66);
        tvTimeFr67 = v.findViewById(R.id.tvTimeFr67);
        tvTimeFr71 = v.findViewById(R.id.tvTimeFr71);
        tvTimeFr72 = v.findViewById(R.id.tvTimeFr72);
        tvTimeFr73 = v.findViewById(R.id.tvTimeFr73);
        tvTimeFr74 = v.findViewById(R.id.tvTimeFr74);
        tvTimeFr75 = v.findViewById(R.id.tvTimeFr75);
        tvTimeFr76 = v.findViewById(R.id.tvTimeFr76);
        tvTimeFr77 = v.findViewById(R.id.tvTimeFr77);
        tvTimeFr81 = v.findViewById(R.id.tvTimeFr81);
        tvTimeFr82 = v.findViewById(R.id.tvTimeFr82);
        tvTimeFr83 = v.findViewById(R.id.tvTimeFr83);
        tvTimeFr84 = v.findViewById(R.id.tvTimeFr84);
        tvTimeFr85 = v.findViewById(R.id.tvTimeFr85);
        tvTimeFr86 = v.findViewById(R.id.tvTimeFr86);
        tvTimeFr87 = v.findViewById(R.id.tvTimeFr87);
        
        tvFrSub11 = v.findViewById(R.id.tvFrSub11);
        tvFrSub22 = v.findViewById(R.id.tvFrSub22);
        tvFrSub33 = v.findViewById(R.id.tvFrSub33);
        tvFrSub44 = v.findViewById(R.id.tvFrSub44);
        tvFrSub55 = v.findViewById(R.id.tvFrSub55);
        tvFrSub66 = v.findViewById(R.id.tvFrSub66);
        tvFrSub77 = v.findViewById(R.id.tvFrSub77);
        tvFrSub88 = v.findViewById(R.id.tvFrSub88);
        
        tvFrClass11 = v.findViewById(R.id.tvFrClass11);
        tvFrClass22 = v.findViewById(R.id.tvFrClass22);
        tvFrClass33 = v.findViewById(R.id.tvFrClass33);
        tvFrClass44 = v.findViewById(R.id.tvFrClass44);
        tvFrClass55 = v.findViewById(R.id.tvFrClass55);
        tvFrClass66 = v.findViewById(R.id.tvFrClass66);
        tvFrClass77 = v.findViewById(R.id.tvFrClass77);
        tvFrClass88 = v.findViewById(R.id.tvFrClass88);

        FirebaseDatabase database = FirebaseDatabase.getInstance();

        ref_time = database.getReference("Users").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child("Time");
        ref_time.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                T11 = String.valueOf(snapshot.child("T11").getValue());
                T12 = String.valueOf(snapshot.child("T12").getValue());
                T13 = String.valueOf(snapshot.child("T13").getValue());
                T14 = String.valueOf(snapshot.child("T14").getValue());
                T21 = String.valueOf(snapshot.child("T21").getValue());
                T22 = String.valueOf(snapshot.child("T22").getValue());
                T23 = String.valueOf(snapshot.child("T23").getValue());
                T24 = String.valueOf(snapshot.child("T24").getValue());
                T31 = String.valueOf(snapshot.child("T31").getValue());
                T32 = String.valueOf(snapshot.child("T32").getValue());
                T33 = String.valueOf(snapshot.child("T33").getValue());
                T34 = String.valueOf(snapshot.child("T34").getValue());
                T41 = String.valueOf(snapshot.child("T41").getValue());
                T42 = String.valueOf(snapshot.child("T42").getValue());
                T43 = String.valueOf(snapshot.child("T43").getValue());
                T44 = String.valueOf(snapshot.child("T44").getValue());
                T51 = String.valueOf(snapshot.child("T51").getValue());
                T52 = String.valueOf(snapshot.child("T52").getValue());
                T53 = String.valueOf(snapshot.child("T53").getValue());
                T54 = String.valueOf(snapshot.child("T54").getValue());
                T61 = String.valueOf(snapshot.child("T61").getValue());
                T62 = String.valueOf(snapshot.child("T62").getValue());
                T63 = String.valueOf(snapshot.child("T63").getValue());
                T64 = String.valueOf(snapshot.child("T64").getValue());
                T71 = String.valueOf(snapshot.child("T71").getValue());
                T72 = String.valueOf(snapshot.child("T72").getValue());
                T73 = String.valueOf(snapshot.child("T73").getValue());
                T74 = String.valueOf(snapshot.child("T74").getValue());
                T81 = String.valueOf(snapshot.child("T81").getValue());
                T82 = String.valueOf(snapshot.child("T82").getValue());
                T83 = String.valueOf(snapshot.child("T83").getValue());
                T84 = String.valueOf(snapshot.child("T84").getValue());

                tvTimeFr11.setText(T11);
                tvTimeFr13.setText(T12);
                tvTimeFr15.setText(T13);
                tvTimeFr17.setText(T14);

                tvTimeFr21.setText(T21);
                tvTimeFr23.setText(T22);
                tvTimeFr25.setText(T23);
                tvTimeFr27.setText(T24);

                tvTimeFr31.setText(T31);
                tvTimeFr33.setText(T32);
                tvTimeFr35.setText(T33);
                tvTimeFr37.setText(T34);

                tvTimeFr41.setText(T41);
                tvTimeFr43.setText(T42);
                tvTimeFr45.setText(T43);
                tvTimeFr47.setText(T44);

                tvTimeFr51.setText(T51);
                tvTimeFr53.setText(T52);
                tvTimeFr55.setText(T53);
                tvTimeFr57.setText(T54);

                tvTimeFr61.setText(T61);
                tvTimeFr63.setText(T62);
                tvTimeFr65.setText(T63);
                tvTimeFr67.setText(T64);

                tvTimeFr71.setText(T71);
                tvTimeFr73.setText(T72);
                tvTimeFr75.setText(T73);
                tvTimeFr77.setText(T74);

                tvTimeFr81.setText(T81);
                tvTimeFr83.setText(T82);
                tvTimeFr85.setText(T83);
                tvTimeFr87.setText(T84);

                if(T11.equals("null"))
                {
                    tvTimeFr11.setVisibility(View.GONE);
                    tvTimeFr12.setVisibility(View.GONE);
                    tvTimeFr13.setVisibility(View.GONE);
                    tvTimeFr14.setVisibility(View.GONE);
                    tvTimeFr15.setVisibility(View.GONE);
                    tvTimeFr16.setVisibility(View.GONE);
                    tvTimeFr17.setVisibility(View.GONE);
                }
                else
                {
                    tvTimeFr12.setVisibility(View.VISIBLE);
                    tvTimeFr14.setVisibility(View.VISIBLE);
                    tvTimeFr16.setVisibility(View.VISIBLE);
                }

                if(T21.equals("null"))
                {
                    tvTimeFr21.setVisibility(View.GONE);
                    tvTimeFr22.setVisibility(View.GONE);
                    tvTimeFr23.setVisibility(View.GONE);
                    tvTimeFr24.setVisibility(View.GONE);
                    tvTimeFr25.setVisibility(View.GONE);
                    tvTimeFr26.setVisibility(View.GONE);
                    tvTimeFr27.setVisibility(View.GONE);
                }
                else
                {
                    tvTimeFr22.setVisibility(View.VISIBLE);
                    tvTimeFr24.setVisibility(View.VISIBLE);
                    tvTimeFr26.setVisibility(View.VISIBLE);
                }

                if(T31.equals("null"))
                {
                    tvTimeFr31.setVisibility(View.GONE);
                    tvTimeFr32.setVisibility(View.GONE);
                    tvTimeFr33.setVisibility(View.GONE);
                    tvTimeFr34.setVisibility(View.GONE);
                    tvTimeFr35.setVisibility(View.GONE);
                    tvTimeFr36.setVisibility(View.GONE);
                    tvTimeFr37.setVisibility(View.GONE);
                }
                else
                {
                    tvTimeFr32.setVisibility(View.VISIBLE);
                    tvTimeFr34.setVisibility(View.VISIBLE);
                    tvTimeFr36.setVisibility(View.VISIBLE);
                }

                if(T41.equals("null"))
                {
                    tvTimeFr41.setVisibility(View.GONE);
                    tvTimeFr42.setVisibility(View.GONE);
                    tvTimeFr43.setVisibility(View.GONE);
                    tvTimeFr44.setVisibility(View.GONE);
                    tvTimeFr45.setVisibility(View.GONE);
                    tvTimeFr46.setVisibility(View.GONE);
                    tvTimeFr47.setVisibility(View.GONE);
                }
                else
                {
                    tvTimeFr42.setVisibility(View.VISIBLE);
                    tvTimeFr44.setVisibility(View.VISIBLE);
                    tvTimeFr46.setVisibility(View.VISIBLE);
                }

                if(T51.equals("null"))
                {
                    tvTimeFr51.setVisibility(View.GONE);
                    tvTimeFr52.setVisibility(View.GONE);
                    tvTimeFr53.setVisibility(View.GONE);
                    tvTimeFr54.setVisibility(View.GONE);
                    tvTimeFr55.setVisibility(View.GONE);
                    tvTimeFr56.setVisibility(View.GONE);
                    tvTimeFr57.setVisibility(View.GONE);
                }
                else
                {
                    tvTimeFr52.setVisibility(View.VISIBLE);
                    tvTimeFr54.setVisibility(View.VISIBLE);
                    tvTimeFr56.setVisibility(View.VISIBLE);
                }

                if(T61.equals("null"))
                {
                    tvTimeFr61.setVisibility(View.GONE);
                    tvTimeFr62.setVisibility(View.GONE);
                    tvTimeFr63.setVisibility(View.GONE);
                    tvTimeFr64.setVisibility(View.GONE);
                    tvTimeFr65.setVisibility(View.GONE);
                    tvTimeFr66.setVisibility(View.GONE);
                    tvTimeFr67.setVisibility(View.GONE);
                }
                else
                {
                    tvTimeFr62.setVisibility(View.VISIBLE);
                    tvTimeFr64.setVisibility(View.VISIBLE);
                    tvTimeFr66.setVisibility(View.VISIBLE);
                }

                if(T71.equals("null"))
                {
                    tvTimeFr71.setVisibility(View.GONE);
                    tvTimeFr72.setVisibility(View.GONE);
                    tvTimeFr73.setVisibility(View.GONE);
                    tvTimeFr74.setVisibility(View.GONE);
                    tvTimeFr75.setVisibility(View.GONE);
                    tvTimeFr76.setVisibility(View.GONE);
                    tvTimeFr77.setVisibility(View.GONE);
                }
                else
                {
                    tvTimeFr72.setVisibility(View.VISIBLE);
                    tvTimeFr74.setVisibility(View.VISIBLE);
                    tvTimeFr76.setVisibility(View.VISIBLE);
                }

                if(T81.equals("null"))
                {
                    tvTimeFr81.setVisibility(View.GONE);
                    tvTimeFr82.setVisibility(View.GONE);
                    tvTimeFr83.setVisibility(View.GONE);
                    tvTimeFr84.setVisibility(View.GONE);
                    tvTimeFr85.setVisibility(View.GONE);
                    tvTimeFr86.setVisibility(View.GONE);
                    tvTimeFr87.setVisibility(View.GONE);
                }
                else
                {
                    tvTimeFr82.setVisibility(View.VISIBLE);
                    tvTimeFr84.setVisibility(View.VISIBLE);
                    tvTimeFr86.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


        ref_save = database.getReference("Users").child(FirebaseAuth.getInstance().getCurrentUser().getUid());
        ref_save.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Fr1Sub = String.valueOf(snapshot.child("Schedule").child("Fr1Sub").getValue());
                Fr2Sub = String.valueOf(snapshot.child("Schedule").child("Fr2Sub").getValue());
                Fr3Sub = String.valueOf(snapshot.child("Schedule").child("Fr3Sub").getValue());
                Fr4Sub = String.valueOf(snapshot.child("Schedule").child("Fr4Sub").getValue());
                Fr5Sub = String.valueOf(snapshot.child("Schedule").child("Fr5Sub").getValue());
                Fr6Sub = String.valueOf(snapshot.child("Schedule").child("Fr6Sub").getValue());
                Fr7Sub = String.valueOf(snapshot.child("Schedule").child("Fr7Sub").getValue());
                Fr8Sub = String.valueOf(snapshot.child("Schedule").child("Fr8Sub").getValue());

                Fr1Class = String.valueOf(snapshot.child("Schedule").child("Fr1Class").getValue());
                Fr2Class = String.valueOf(snapshot.child("Schedule").child("Fr2Class").getValue());
                Fr3Class = String.valueOf(snapshot.child("Schedule").child("Fr3Class").getValue());
                Fr4Class = String.valueOf(snapshot.child("Schedule").child("Fr4Class").getValue());
                Fr5Class = String.valueOf(snapshot.child("Schedule").child("Fr5Class").getValue());
                Fr6Class = String.valueOf(snapshot.child("Schedule").child("Fr6Class").getValue());
                Fr7Class = String.valueOf(snapshot.child("Schedule").child("Fr7Class").getValue());
                Fr8Class = String.valueOf(snapshot.child("Schedule").child("Fr8Class").getValue());

                tvFrSub11.setText(Fr1Sub);
                tvFrSub22.setText(Fr2Sub);
                tvFrSub33.setText(Fr3Sub);
                tvFrSub44.setText(Fr4Sub);
                tvFrSub55.setText(Fr5Sub);
                tvFrSub66.setText(Fr6Sub);
                tvFrSub77.setText(Fr7Sub);
                tvFrSub88.setText(Fr8Sub);

                tvFrClass11.setText(Fr1Class);
                tvFrClass22.setText(Fr2Class);
                tvFrClass33.setText(Fr3Class);
                tvFrClass44.setText(Fr4Class);
                tvFrClass55.setText(Fr5Class);
                tvFrClass66.setText(Fr6Class);
                tvFrClass77.setText(Fr7Class);
                tvFrClass88.setText(Fr8Class);

                if (Fr1Sub.length()>11)
                {
                    tvFrSub11.setPadding(0,0,0,8);
                }

                if (Fr2Sub.length()>11)
                {
                    tvFrSub22.setPadding(0,0,0,8);
                }

                if (Fr3Sub.length()>11)
                {
                    tvFrSub33.setPadding(0,0,0,8);
                }

                if (Fr4Sub.length()>11)
                {
                    tvFrSub44.setPadding(0,0,0,8);
                }

                if (Fr5Sub.length()>11)
                {
                    tvFrSub55.setPadding(0,0,0,8);
                }

                if (Fr6Sub.length()>11)
                {
                    tvFrSub66.setPadding(0,0,0,8);
                }

                if (Fr7Sub.length()>11)
                {
                    tvFrSub77.setPadding(0,0,0,8);
                }

                if (Fr8Sub.length()>11)
                {
                    tvFrSub88.setPadding(0,0,0,8);
                }

                LinearLayout ll_row1 = v.findViewById(R.id.teacherFr1_row1);
                LinearLayout ll_row2 = v.findViewById(R.id.teacherFr2_row2);
                LinearLayout ll_row3 = v.findViewById(R.id.teacherFr3_row3);
                LinearLayout ll_row4 = v.findViewById(R.id.teacherFr4_row4);
                LinearLayout ll_row5 = v.findViewById(R.id.teacherFr5_row5);
                LinearLayout ll_row6 = v.findViewById(R.id.teacherFr6_row6);
                LinearLayout ll_row7 = v.findViewById(R.id.teacherFr7_row7);
                LinearLayout ll_row8 = v.findViewById(R.id.teacherFr8_row8);

                //1 СТРОКА
                if (Fr1Sub.equals("null"))
                {
                    ll_row1.setVisibility(View.GONE);
                }
                else
                {
                    ll_row1.setVisibility(View.VISIBLE);
                }

                //2 строка
                if (Fr2Sub.equals("null"))
                {
                    ll_row2.setVisibility(View.GONE);
                }
                else
                {
                    ll_row2.setVisibility(View.VISIBLE);
                }

                //3 строка
                if (Fr3Sub.equals("null"))
                {
                    ll_row3.setVisibility(View.GONE);
                }
                else
                {
                    ll_row3.setVisibility(View.VISIBLE);
                }

                //4 строка
                if (Fr4Sub.equals("null"))
                {
                    ll_row4.setVisibility(View.GONE);
                }
                else
                {
                    ll_row4.setVisibility(View.VISIBLE);
                }

                //5 строка
                if (Fr5Sub.equals("null"))
                {
                    ll_row5.setVisibility(View.GONE);
                }
                else
                {
                    ll_row5.setVisibility(View.VISIBLE);
                }

                //6 строка
                if (Fr6Sub.equals("null"))
                {
                    ll_row6.setVisibility(View.GONE);
                }
                else
                {
                    ll_row6.setVisibility(View.VISIBLE);
                }

                //7 строка
                if (Fr7Sub.equals("null"))
                {
                    ll_row7.setVisibility(View.GONE);
                }
                else
                {
                    ll_row7.setVisibility(View.VISIBLE);
                }

                //8 строка
                if (Fr8Sub.equals("null"))
                {
                    ll_row8.setVisibility(View.GONE);
                }
                else
                {
                    ll_row8.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        return v;
    }
}