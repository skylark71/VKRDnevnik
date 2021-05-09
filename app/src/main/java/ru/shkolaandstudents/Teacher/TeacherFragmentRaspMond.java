package ru.shkolaandstudents.Teacher;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

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

import ru.shkolaandstudents.OnBackPressedListener;
import ru.shkolaandstudents.R;

public class TeacherFragmentRaspMond extends Fragment implements OnBackPressedListener {

    TextView tvMSub11,tvMSub22,tvMSub33,tvMSub44,tvMSub55,tvMSub66,tvMSub77,tvMSub88,tvM1,tvM2,tvM3,tvM4,tvM5,tvM6,tvM7,tvM8,tvTimeM1,tvTimeM2,tvTimeM3,tvTimeM4,tvTimeM5,tvTimeM6,tvTimeM7,tvTimeM8,tvTimeM9,tvTimeM10,tvTimeM111,tvTimeM12,tvTimeM13,tvTimeM14,tvTimeM15,tvTimeM16,tvTimeM17,tvTimeM18,tvTimeM19,tvTimeM20,tvTimeM21,tvTimeM222,tvTimeM23,tvTimeM24,tvTimeM25,tvTimeM26,tvTimeM27,tvTimeM28,tvTimeM29,tvTimeM30,tvTimeM31,tvTimeM32;
    TextView tvMClass11,tvMClass22,tvMClass33,tvMClass44,tvMClass55,tvMClass66,tvMClass77,tvMClass88;
    TextView tvTimeM11,tvTimeM22,tvTimeM33,tvTimeM51,tvTimeM61,tvTimeM71,tvTimeM91,tvTimeM101,tvTimeM112,tvTimeM131,tvTimeM141,tvTimeM151,tvTimeM171,tvTimeM181,tvTimeM191,tvTimeM211,tvTimeM221,tvTimeM231,tvTimeM251,tvTimeM261,tvTimeM271,tvTimeM291,tvTimeM301,tvTimeM311;
    Button btnHelp;
    DatabaseReference ref_save;
    DatabaseReference ref_time;

    String M1Sub;
    String M2Sub;
    String M3Sub;
    String M4Sub;
    String M5Sub;
    String M6Sub;
    String M7Sub;
    String M8Sub;

    String M1Class;
    String M2Class;
    String M3Class;
    String M4Class;
    String M5Class;
    String M6Class;
    String M7Class;
    String M8Class;

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
        final View v =  inflater.inflate(R.layout.teacher_fragment_rasp_mond, container, false);

        btnHelp = v.findViewById(R.id.btnMonHelp);

        btnHelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new TapTargetSequence(getActivity())
                        .targets(
                                TapTarget.forView(v.findViewById(R.id.tvM1), getResources().getString(R.string.nomer_predmeta), getResources().getString(R.string.click_TapTargetView))
                                        .titleTextSize(20)
                                        .titleTextColor(R.color.colorWhite)
                                        .descriptionTextColor(R.color.colorWhite)
                                        .cancelable(false)
                                        .tintTarget(false)
                                        .targetRadius(20)
                                        .transparentTarget(true)
                                        .outerCircleColor(R.color.colorTuesday),
                                TapTarget.forView(v.findViewById(R.id.tvTimeM11), getResources().getString(R.string.nachalo_uroka), getResources().getString(R.string.click_TapTargetView))
                                        .titleTextSize(20)
                                        .titleTextColor(R.color.colorWhite)
                                        .descriptionTextColor(R.color.colorWhite)
                                        .cancelable(false)
                                        .tintTarget(false)
                                        .targetRadius(20)
                                        .transparentTarget(true)
                                        .outerCircleColor(R.color.colorTuesday),
                                TapTarget.forView(v.findViewById(R.id.tvTimeM33), getResources().getString(R.string.konec_uroka), getResources().getString(R.string.click_TapTargetView))
                                        .titleTextSize(20)
                                        .titleTextColor(R.color.colorWhite)
                                        .descriptionTextColor(R.color.colorWhite)
                                        .cancelable(false)
                                        .tintTarget(false)
                                        .targetRadius(20)
                                        .transparentTarget(true)
                                        .outerCircleColor(R.color.colorTuesday),
                                TapTarget.forView(v.findViewById(R.id.tvMSub11), getResources().getString(R.string.predmet), getResources().getString(R.string.click_TapTargetView))
                                        .titleTextSize(20)
                                        .titleTextColor(R.color.colorWhite)
                                        .descriptionTextColor(R.color.colorWhite)
                                        .cancelable(false)
                                        .tintTarget(false)
                                        .targetRadius(30)
                                        .transparentTarget(true)
                                        .outerCircleColor(R.color.colorTuesday),
                                TapTarget.forView(v.findViewById(R.id.tvMClass11), "Класс", getResources().getString(R.string.click_TapTargetView))
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

        tvMSub11 = v.findViewById(R.id.tvMSub11); tvMClass22 = v.findViewById(R.id.tvMClass22);
        tvMSub22 = v.findViewById(R.id.tvMSub22); tvMClass11 = v.findViewById(R.id.tvMClass11);
        tvMSub33 = v.findViewById(R.id.tvMSub33); tvMClass33 = v.findViewById(R.id.tvMClass33);
        tvMSub44 = v.findViewById(R.id.tvMSub44); tvMClass66 = v.findViewById(R.id.tvMClass66);
        tvMSub55 = v.findViewById(R.id.tvMSub55); tvMClass44 = v.findViewById(R.id.tvMClass44);
        tvMSub66 = v.findViewById(R.id.tvMSub66); tvMClass77 = v.findViewById(R.id.tvMClass77);
        tvMSub77 = v.findViewById(R.id.tvMSub77); tvMClass55 = v.findViewById(R.id.tvMClass55);
        tvMSub88 = v.findViewById(R.id.tvMSub88); tvMClass88 = v.findViewById(R.id.tvMClass88);

        tvM1 = v.findViewById(R.id.tvM1);
        tvM2 = v.findViewById(R.id.tvM2);
        tvM3 = v.findViewById(R.id.tvM3);
        tvM4 = v.findViewById(R.id.tvM4);
        tvM5 = v.findViewById(R.id.tvM5);
        tvM6 = v.findViewById(R.id.tvM6);
        tvM7 = v.findViewById(R.id.tvM7);
        tvM8 = v.findViewById(R.id.tvM8);

        tvTimeM1 = v.findViewById(R.id.tvTimeM1); tvTimeM9 = v.findViewById(R.id.tvTimeM9);     tvTimeM17 = v.findViewById(R.id.tvTimeM17);  tvTimeM25 = v.findViewById(R.id.tvTimeM25);
        tvTimeM2 = v.findViewById(R.id.tvTimeM2); tvTimeM10 = v.findViewById(R.id.tvTimeM10);   tvTimeM18 = v.findViewById(R.id.tvTimeM18);  tvTimeM26 = v.findViewById(R.id.tvTimeM26);
        tvTimeM3 = v.findViewById(R.id.tvTimeM3); tvTimeM111 = v.findViewById(R.id.tvTimeM111); tvTimeM19 = v.findViewById(R.id.tvTimeM19);  tvTimeM27 = v.findViewById(R.id.tvTimeM27);
        tvTimeM4 = v.findViewById(R.id.tvTimeM4); tvTimeM12 = v.findViewById(R.id.tvTimeM12);   tvTimeM20 = v.findViewById(R.id.tvTimeM20);  tvTimeM28 = v.findViewById(R.id.tvTimeM28);
        tvTimeM5 = v.findViewById(R.id.tvTimeM5); tvTimeM13 = v.findViewById(R.id.tvTimeM13);   tvTimeM21 = v.findViewById(R.id.tvTimeM21);  tvTimeM29 = v.findViewById(R.id.tvTimeM29);
        tvTimeM6 = v.findViewById(R.id.tvTimeM6); tvTimeM14 = v.findViewById(R.id.tvTimeM14);   tvTimeM222 = v.findViewById(R.id.tvTimeM222); tvTimeM30 = v.findViewById(R.id.tvTimeM30);
        tvTimeM7 = v.findViewById(R.id.tvTimeM7); tvTimeM15 = v.findViewById(R.id.tvTimeM15);   tvTimeM23 = v.findViewById(R.id.tvTimeM23);  tvTimeM31 = v.findViewById(R.id.tvTimeM31);
        tvTimeM8 = v.findViewById(R.id.tvTimeM8); tvTimeM16 = v.findViewById(R.id.tvTimeM16);   tvTimeM24 = v.findViewById(R.id.tvTimeM24);  tvTimeM32 = v.findViewById(R.id.tvTimeM32);

        tvTimeM11 = v.findViewById(R.id.tvTimeM11); tvTimeM61 = v.findViewById(R.id.tvTimeM61); tvTimeM112 = v.findViewById(R.id.tvTimeM112);  tvTimeM171 = v.findViewById(R.id.tvTimeM171);
        tvTimeM22 = v.findViewById(R.id.tvTimeM22); tvTimeM71 = v.findViewById(R.id.tvTimeM71); tvTimeM131 = v.findViewById(R.id.tvTimeM131);  tvTimeM181 = v.findViewById(R.id.tvTimeM181);
        tvTimeM33 = v.findViewById(R.id.tvTimeM33); tvTimeM91 = v.findViewById(R.id.tvTimeM91); tvTimeM141 = v.findViewById(R.id.tvTimeM141);   tvTimeM191 = v.findViewById(R.id.tvTimeM191);
        tvTimeM51 = v.findViewById(R.id.tvTimeM51); tvTimeM101 = v.findViewById(R.id.tvTimeM101); tvTimeM151 = v.findViewById(R.id.tvTimeM151); tvTimeM211 = v.findViewById(R.id.tvTimeM211);

        tvTimeM211 = v.findViewById(R.id.tvTimeM211); tvTimeM251 = v.findViewById(R.id.tvTimeM251); tvTimeM291 = v.findViewById(R.id.tvTimeM291);
        tvTimeM221 = v.findViewById(R.id.tvTimeM221); tvTimeM261 = v.findViewById(R.id.tvTimeM261); tvTimeM301 = v.findViewById(R.id.tvTimeM301);
        tvTimeM231 = v.findViewById(R.id.tvTimeM231); tvTimeM271 = v.findViewById(R.id.tvTimeM271); tvTimeM311 = v.findViewById(R.id.tvTimeM311);
        tvMClass11 = v.findViewById(R.id.tvMClass11);
        tvMClass22 = v.findViewById(R.id.tvMClass22);
        tvMClass33 = v.findViewById(R.id.tvMClass33);
        tvMClass44 = v.findViewById(R.id.tvMClass44);
        tvMClass55 = v.findViewById(R.id.tvMClass55);
        tvMClass66 = v.findViewById(R.id.tvMClass66);
        tvMClass77 = v.findViewById(R.id.tvMClass77);
        tvMClass88 = v.findViewById(R.id.tvMClass88);

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

                tvTimeM1.setText(T11);
                tvTimeM2.setText(T12);
                tvTimeM3.setText(T13);
                tvTimeM4.setText(T14);
                //////////////////
                tvTimeM5.setText(T21);
                tvTimeM6.setText(T22);
                tvTimeM7.setText(T23);
                tvTimeM8.setText(T24);
                /////////////////////
                tvTimeM9.setText(T31);
                tvTimeM10.setText(T32);
                tvTimeM111.setText(T33);
                tvTimeM12.setText(T34);
                ////////////////////////
                tvTimeM13.setText(T41);
                tvTimeM14.setText(T42);
                tvTimeM15.setText(T43);
                tvTimeM16.setText(T44);
                //////////////////////
                tvTimeM17.setText(T51);
                tvTimeM18.setText(T52);
                tvTimeM19.setText(T53);
                tvTimeM20.setText(T54);
                //////////////////////
                tvTimeM21.setText(T61);
                tvTimeM222.setText(T62);
                tvTimeM23.setText(T63);
                tvTimeM24.setText(T64);
                //////////////////////
                tvTimeM25.setText(T71);
                tvTimeM26.setText(T72);
                tvTimeM27.setText(T73);
                tvTimeM28.setText(T74);
                ///////////////////////
                tvTimeM29.setText(T81);
                tvTimeM30.setText(T82);
                tvTimeM31.setText(T83);
                tvTimeM32.setText(T84);
                ///////////////////////

                if(T11.equals("null"))
                {
                    tvTimeM11.setVisibility(View.GONE);
                    tvTimeM22.setVisibility(View.GONE);
                    tvTimeM33.setVisibility(View.GONE);
                    tvTimeM1.setVisibility(View.GONE);
                    tvTimeM2.setVisibility(View.GONE);
                    tvTimeM3.setVisibility(View.GONE);
                    tvTimeM4.setVisibility(View.GONE);
                }
                else
                {
                    tvTimeM11.setVisibility(View.VISIBLE);
                    tvTimeM22.setVisibility(View.VISIBLE);
                    tvTimeM33.setVisibility(View.VISIBLE);
                }

                if(T21.equals("null"))
                {
                    tvTimeM51.setVisibility(View.GONE);
                    tvTimeM61.setVisibility(View.GONE);
                    tvTimeM71.setVisibility(View.GONE);
                    tvTimeM5.setVisibility(View.GONE);
                    tvTimeM6.setVisibility(View.GONE);
                    tvTimeM7.setVisibility(View.GONE);
                    tvTimeM8.setVisibility(View.GONE);
                }
                else
                {
                    tvTimeM51.setVisibility(View.VISIBLE);
                    tvTimeM61.setVisibility(View.VISIBLE);
                    tvTimeM71.setVisibility(View.VISIBLE);
                }

                if(T31.equals("null"))
                {
                    tvTimeM91.setVisibility(View.GONE);
                    tvTimeM101.setVisibility(View.GONE);
                    tvTimeM112.setVisibility(View.GONE);
                    tvTimeM9.setVisibility(View.GONE);
                    tvTimeM10.setVisibility(View.GONE);
                    tvTimeM111.setVisibility(View.GONE);
                    tvTimeM12.setVisibility(View.GONE);
                }
                else
                {
                    tvTimeM91.setVisibility(View.VISIBLE);
                    tvTimeM101.setVisibility(View.VISIBLE);
                    tvTimeM112.setVisibility(View.VISIBLE);
                }

                if(T41.equals("null"))
                {
                    tvTimeM131.setVisibility(View.GONE);
                    tvTimeM141.setVisibility(View.GONE);
                    tvTimeM151.setVisibility(View.GONE);
                    tvTimeM13.setVisibility(View.GONE);
                    tvTimeM14.setVisibility(View.GONE);
                    tvTimeM15.setVisibility(View.GONE);
                    tvTimeM16.setVisibility(View.GONE);
                }
                else
                {
                    tvTimeM131.setVisibility(View.VISIBLE);
                    tvTimeM141.setVisibility(View.VISIBLE);
                    tvTimeM151.setVisibility(View.VISIBLE);
                }

                if(T51.equals("null"))
                {
                    tvTimeM171.setVisibility(View.GONE);
                    tvTimeM181.setVisibility(View.GONE);
                    tvTimeM191.setVisibility(View.GONE);
                    tvTimeM17.setVisibility(View.GONE);
                    tvTimeM18.setVisibility(View.GONE);
                    tvTimeM19.setVisibility(View.GONE);
                    tvTimeM20.setVisibility(View.GONE);
                }
                else
                {
                    tvTimeM171.setVisibility(View.VISIBLE);
                    tvTimeM181.setVisibility(View.VISIBLE);
                    tvTimeM191.setVisibility(View.VISIBLE);
                }

                if(T61.equals("null"))
                {
                    tvTimeM211.setVisibility(View.GONE);
                    tvTimeM231.setVisibility(View.GONE);
                    tvTimeM221.setVisibility(View.GONE);
                    tvTimeM21.setVisibility(View.GONE);
                    tvTimeM222.setVisibility(View.GONE);
                    tvTimeM23.setVisibility(View.GONE);
                    tvTimeM24.setVisibility(View.GONE);
                }
                else
                {
                    tvTimeM211.setVisibility(View.VISIBLE);
                    tvTimeM231.setVisibility(View.VISIBLE);
                    tvTimeM221.setVisibility(View.VISIBLE);
                }

                if(T71.equals("null"))
                {
                    tvTimeM251.setVisibility(View.GONE);
                    tvTimeM261.setVisibility(View.GONE);
                    tvTimeM271.setVisibility(View.GONE);
                    tvTimeM25.setVisibility(View.GONE);
                    tvTimeM26.setVisibility(View.GONE);
                    tvTimeM27.setVisibility(View.GONE);
                    tvTimeM28.setVisibility(View.GONE);
                }
                else
                {
                    tvTimeM251.setVisibility(View.VISIBLE);
                    tvTimeM261.setVisibility(View.VISIBLE);
                    tvTimeM271.setVisibility(View.VISIBLE);
                }

                if(T81.equals("null"))
                {
                    tvTimeM291.setVisibility(View.GONE);
                    tvTimeM301.setVisibility(View.GONE);
                    tvTimeM311.setVisibility(View.GONE);
                    tvTimeM29.setVisibility(View.GONE);
                    tvTimeM30.setVisibility(View.GONE);
                    tvTimeM31.setVisibility(View.GONE);
                    tvTimeM32.setVisibility(View.GONE);
                }
                else
                {
                    tvTimeM291.setVisibility(View.VISIBLE);
                    tvTimeM301.setVisibility(View.VISIBLE);
                    tvTimeM311.setVisibility(View.VISIBLE);
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
                M1Sub = String.valueOf(snapshot.child("Schedule").child("M1Sub").getValue());
                M2Sub = String.valueOf(snapshot.child("Schedule").child("M2Sub").getValue());
                M3Sub = String.valueOf(snapshot.child("Schedule").child("M3Sub").getValue());
                M4Sub = String.valueOf(snapshot.child("Schedule").child("M4Sub").getValue());
                M5Sub = String.valueOf(snapshot.child("Schedule").child("M5Sub").getValue());
                M6Sub = String.valueOf(snapshot.child("Schedule").child("M6Sub").getValue());
                M7Sub = String.valueOf(snapshot.child("Schedule").child("M7Sub").getValue());
                M8Sub = String.valueOf(snapshot.child("Schedule").child("M8Sub").getValue());

                M1Class = String.valueOf(snapshot.child("Schedule").child("M1Class").getValue());
                M2Class = String.valueOf(snapshot.child("Schedule").child("M2Class").getValue());
                M3Class = String.valueOf(snapshot.child("Schedule").child("M3Class").getValue());
                M4Class = String.valueOf(snapshot.child("Schedule").child("M4Class").getValue());
                M5Class = String.valueOf(snapshot.child("Schedule").child("M5Class").getValue());
                M6Class = String.valueOf(snapshot.child("Schedule").child("M6Class").getValue());
                M7Class = String.valueOf(snapshot.child("Schedule").child("M7Class").getValue());
                M8Class = String.valueOf(snapshot.child("Schedule").child("M8Class").getValue());

                tvMSub11.setText(M1Sub);
                tvMSub22.setText(M2Sub);
                tvMSub33.setText(M3Sub);
                tvMSub44.setText(M4Sub);
                tvMSub55.setText(M5Sub);
                tvMSub66.setText(M6Sub);
                tvMSub77.setText(M7Sub);
                tvMSub88.setText(M8Sub);

                tvMClass11.setText(M1Class);
                tvMClass22.setText(M2Class);
                tvMClass33.setText(M3Class);
                tvMClass44.setText(M4Class);
                tvMClass55.setText(M5Class);
                tvMClass66.setText(M6Class);
                tvMClass77.setText(M7Class);
                tvMClass88.setText(M8Class);


                if (M1Sub.length()>11)
                {
                    tvMSub11.setPadding(0,0,0,8);
                }

                if (M2Sub.length()>11)
                {
                    tvMSub22.setPadding(0,0,0,8);
                }

                if (M3Sub.length()>11)
                {
                    tvMSub33.setPadding(0,0,0,8);
                }

                if (M4Sub.length()>11)
                {
                    tvMSub44.setPadding(0,0,0,8);
                }

                if (M5Sub.length()>11)
                {
                    tvMSub55.setPadding(0,0,0,8);
                }

                if (M6Sub.length()>11)
                {
                    tvMSub66.setPadding(0,0,0,8);
                }

                if (M7Sub.length()>11)
                {
                    tvMSub77.setPadding(0,0,0,8);
                }

                if (M8Sub.length()>11)
                {
                    tvMSub88.setPadding(0,0,0,8);
                }

                LinearLayout ll_row1 = v.findViewById(R.id.teacherM1_row1);
                LinearLayout ll_row2 = v.findViewById(R.id.teacherM2_row2);
                LinearLayout ll_row3 = v.findViewById(R.id.teacherM3_row3);
                LinearLayout ll_row4 = v.findViewById(R.id.teacherM4_row4);
                LinearLayout ll_row5 = v.findViewById(R.id.teacherM5_row5);
                LinearLayout ll_row6 = v.findViewById(R.id.teacherM6_row6);
                LinearLayout ll_row7 = v.findViewById(R.id.teacherM7_row7);
                LinearLayout ll_row8 = v.findViewById(R.id.teacherM8_row8);

                //1 СТРОКА
                if (M1Sub.equals("null"))
                {
                    ll_row1.setVisibility(View.GONE);
                }
                else
                {
                    ll_row1.setVisibility(View.VISIBLE);
                }

                //2 строка
                if (M2Sub.equals("null"))
                {
                    ll_row2.setVisibility(View.GONE);
                }
                else
                {
                    ll_row2.setVisibility(View.VISIBLE);
                }

                //3 строка
                if (M3Sub.equals("null"))
                {
                    ll_row3.setVisibility(View.GONE);
                }
                else
                {
                    ll_row3.setVisibility(View.VISIBLE);
                }

                //4 строка
                if (M4Sub.equals("null"))
                {
                    ll_row4.setVisibility(View.GONE);
                }
                else
                {
                    ll_row4.setVisibility(View.VISIBLE);
                }

                //5 строка
                if (M5Sub.equals("null"))
                {
                    ll_row5.setVisibility(View.GONE);
                }
                else
                {
                    ll_row5.setVisibility(View.VISIBLE);
                }

                //6 строка
                if (M6Sub.equals("null"))
                {
                    ll_row6.setVisibility(View.GONE);
                }
                else
                {
                    ll_row6.setVisibility(View.VISIBLE);
                }

                //7 строка
                if (M7Sub.equals("null"))
                {
                    ll_row7.setVisibility(View.GONE);
                }
                else
                {
                    ll_row7.setVisibility(View.VISIBLE);
                }

                //8 строка
                if (M8Sub.equals("null"))
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


    @Override
    public void onBackPressed() {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.container, new TeacherFragmentRasp());
        transaction.commit();
    }
}