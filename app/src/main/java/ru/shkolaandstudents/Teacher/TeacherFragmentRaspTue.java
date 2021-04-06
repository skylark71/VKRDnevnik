package ru.shkolaandstudents.Teacher;


import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

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

import ru.shkolaandstudents.OnBackPressedListener;
import ru.shkolaandstudents.R;


public class TeacherFragmentRaspTue extends Fragment implements OnBackPressedListener {

    TextView tvT11, tvTimeT12,tvTimeT13,tvTimeT14,tvTimeT15,tvTimeT16,tvTimeT17,tvTimeT18,tvT2,tvTimeT21,tvTimeT22,tvTimeT23,tvTimeT24,tvTimeT25,tvTimeT26,tvTimeT27,tvT3,tvTimeT31,tvTimeT32,tvTimeT33,tvTimeT34,tvTimeT35,tvTimeT36,tvTimeT37,tvT4,tvTimeT41,tvTimeT42,tvTimeT43,tvTimeT44,tvTimeT45,tvTimeT46,tvTimeT47,tvT5,tvTimeT51,tvTimeT52,tvTimeT53,tvTimeT54,tvTimeT55,tvTimeT56,tvTimeT57,tvT6,tvTimeT61,tvTimeT62,tvTimeT63,tvTimeT64,tvTimeT65,tvTimeT66,tvTimeT67,tvT7,tvTimeT71,tvTimeT72,tvTimeT73,tvTimeT74,tvTimeT75,tvTimeT76,tvTimeT77,tvT8,tvTimeT81,tvTimeT82,tvTimeT83,tvTimeT84,tvTimeT85,tvTimeT86,tvTimeT87;
    TextView tvTSub19,tvTSub22,tvTSub33,tvTSub44,tvTSub55,tvTSub66,tvTSub77,tvTSub88;
    TextView tvTClass19,tvTClass22,tvTClass33,tvTClass44,tvTClass55,tvTClass66,tvTClass77,tvTClass88;
    Button btnHelp;
    DatabaseReference ref_save;
    DatabaseReference ref_time;

    String T1Sub;
    String T2Sub;
    String T3Sub;
    String T4Sub;
    String T5Sub;
    String T6Sub;
    String T7Sub;
    String T8Sub;

    String T1Class;
    String T2Class;
    String T3Class;
    String T4Class;
    String T5Class;
    String T6Class;
    String T7Class;
    String T8Class;

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
    public void onBackPressed() {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.container, new TeacherFragmentRasp());
        transaction.commit();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View v = inflater.inflate(R.layout.teacher_fragment_rasp_tue, container, false);


        btnHelp = v.findViewById(R.id.btnTueHelp);

        btnHelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new TapTargetSequence(getActivity())
                        .targets(
                                TapTarget.forView(v.findViewById(R.id.tvT11), getResources().getString(R.string.nomer_predmeta), getResources().getString(R.string.click_TapTargetView))
                                        .titleTextSize(20)
                                        .titleTextColor(R.color.colorWhite)
                                        .descriptionTextColor(R.color.colorWhite)
                                        .cancelable(false)
                                        .tintTarget(false)
                                        .targetRadius(10)
                                        .transparentTarget(true)
                                        .outerCircleColor(R.color.colorTuesday),
                                TapTarget.forView(v.findViewById(R.id.tvTimeT13), getResources().getString(R.string.nachalo_uroka), getResources().getString(R.string.click_TapTargetView))
                                        .titleTextSize(20)
                                        .titleTextColor(R.color.colorWhite)
                                        .descriptionTextColor(R.color.colorWhite)
                                        .cancelable(false)
                                        .tintTarget(false)
                                        .targetRadius(20)
                                        .transparentTarget(true)
                                        .outerCircleColor(R.color.colorTuesday),
                                TapTarget.forView(v.findViewById(R.id.tvTimeT17), getResources().getString(R.string.konec_uroka), getResources().getString(R.string.click_TapTargetView))
                                        .titleTextSize(20)
                                        .titleTextColor(R.color.colorWhite)
                                        .descriptionTextColor(R.color.colorWhite)
                                        .cancelable(false)
                                        .tintTarget(false)
                                        .targetRadius(20)
                                        .transparentTarget(true)
                                        .outerCircleColor(R.color.colorTuesday),
                                TapTarget.forView(v.findViewById(R.id.tvTSub19), getResources().getString(R.string.predmet), getResources().getString(R.string.click_TapTargetView))
                                        .titleTextSize(20)
                                        .titleTextColor(R.color.colorWhite)
                                        .descriptionTextColor(R.color.colorWhite)
                                        .cancelable(false)
                                        .tintTarget(false)
                                        .targetRadius(30)
                                        .transparentTarget(true)
                                        .outerCircleColor(R.color.colorTuesday),
                                TapTarget.forView(v.findViewById(R.id.tvTClass19), "Класс", getResources().getString(R.string.click_TapTargetView))
                                        .titleTextSize(20)
                                        .titleTextColor(R.color.colorWhite)
                                        .descriptionTextColor(R.color.colorWhite)
                                        .cancelable(false)
                                        .tintTarget(false)
                                        .targetRadius(30)
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

        tvT11 = v.findViewById(R.id.tvT11);
        tvT2 = v.findViewById(R.id.tvT2);
        tvT3 = v.findViewById(R.id.tvT3);
        tvT4 = v.findViewById(R.id.tvT4);
        tvT5 = v.findViewById(R.id.tvT5);
        tvT6 = v.findViewById(R.id.tvT6);
        tvT7 = v.findViewById(R.id.tvT7);
        tvT8 = v.findViewById(R.id.tvT8);
        
        tvTimeT12 = v.findViewById(R.id.tvTimeT12);
        tvTimeT21 = v.findViewById(R.id.tvTimeT21);
        tvTimeT31 = v.findViewById(R.id.tvTimeT31);
        tvTimeT41 = v.findViewById(R.id.tvTimeT41);
        tvTimeT51 = v.findViewById(R.id.tvTimeT51);
        tvTimeT61 = v.findViewById(R.id.tvTimeT61);
        tvTimeT71 = v.findViewById(R.id.tvTimeT71);
        tvTimeT81 = v.findViewById(R.id.tvTimeT81);
        tvTimeT13 = v.findViewById(R.id.tvTimeT13);
        tvTimeT22 = v.findViewById(R.id.tvTimeT22);
        tvTimeT32 = v.findViewById(R.id.tvTimeT32);
        tvTimeT42 = v.findViewById(R.id.tvTimeT42);
        tvTimeT52 = v.findViewById(R.id.tvTimeT52);
        tvTimeT62 = v.findViewById(R.id.tvTimeT62);
        tvTimeT72 = v.findViewById(R.id.tvTimeT72);
        tvTimeT82 = v.findViewById(R.id.tvTimeT82);
        tvTimeT14 = v.findViewById(R.id.tvTimeT14);
        tvTimeT23 = v.findViewById(R.id.tvTimeT23);
        tvTimeT33 = v.findViewById(R.id.tvTimeT33);
        tvTimeT43 = v.findViewById(R.id.tvTimeT43);
        tvTimeT53 = v.findViewById(R.id.tvTimeT53);
        tvTimeT63 = v.findViewById(R.id.tvTimeT63);
        tvTimeT73 = v.findViewById(R.id.tvTimeT73);
        tvTimeT83 = v.findViewById(R.id.tvTimeT83);
        tvTimeT15 = v.findViewById(R.id.tvTimeT15);
        tvTimeT24 = v.findViewById(R.id.tvTimeT24);
        tvTimeT34 = v.findViewById(R.id.tvTimeT34);
        tvTimeT44 = v.findViewById(R.id.tvTimeT44);
        tvTimeT54 = v.findViewById(R.id.tvTimeT54);
        tvTimeT64 = v.findViewById(R.id.tvTimeT64);
        tvTimeT74 = v.findViewById(R.id.tvTimeT74);
        tvTimeT84 = v.findViewById(R.id.tvTimeT84);
        tvTimeT16 = v.findViewById(R.id.tvTimeT16);
        tvTimeT25 = v.findViewById(R.id.tvTimeT25);
        tvTimeT35 = v.findViewById(R.id.tvTimeT35);
        tvTimeT45 = v.findViewById(R.id.tvTimeT45);
        tvTimeT55 = v.findViewById(R.id.tvTimeT55);
        tvTimeT65 = v.findViewById(R.id.tvTimeT65);
        tvTimeT75 = v.findViewById(R.id.tvTimeT75);
        tvTimeT85 = v.findViewById(R.id.tvTimeT85);
        tvTimeT17 = v.findViewById(R.id.tvTimeT17);
        tvTimeT26 = v.findViewById(R.id.tvTimeT26);
        tvTimeT36 = v.findViewById(R.id.tvTimeT36);
        tvTimeT46 = v.findViewById(R.id.tvTimeT46);
        tvTimeT56 = v.findViewById(R.id.tvTimeT56);
        tvTimeT66 = v.findViewById(R.id.tvTimeT66);
        tvTimeT76 = v.findViewById(R.id.tvTimeT76);
        tvTimeT86 = v.findViewById(R.id.tvTimeT86);
        tvTimeT18 = v.findViewById(R.id.tvTimeT18);
        tvTimeT27 = v.findViewById(R.id.tvTimeT27);
        tvTimeT37 = v.findViewById(R.id.tvTimeT37);
        tvTimeT47 = v.findViewById(R.id.tvTimeT47);
        tvTimeT57 = v.findViewById(R.id.tvTimeT57);
        tvTimeT67 = v.findViewById(R.id.tvTimeT67);
        tvTimeT77 = v.findViewById(R.id.tvTimeT77);
        tvTimeT87 = v.findViewById(R.id.tvTimeT87);
        tvTSub19 = v.findViewById(R.id.tvTSub19);
        tvTSub22 = v.findViewById(R.id.tvTSub22);
        tvTSub33 = v.findViewById(R.id.tvTSub33);
        tvTSub44 = v.findViewById(R.id.tvTSub44);
        tvTSub55 = v.findViewById(R.id.tvTSub55);
        tvTSub66 = v.findViewById(R.id.tvTSub66);
        tvTSub77 = v.findViewById(R.id.tvTSub77);
        tvTSub88 = v.findViewById(R.id.tvTSub88);
        tvTClass19 = v.findViewById(R.id.tvTClass19);
        tvTClass22 = v.findViewById(R.id.tvTClass22);
        tvTClass33 = v.findViewById(R.id.tvTClass33);
        tvTClass44 = v.findViewById(R.id.tvTClass44);
        tvTClass55 = v.findViewById(R.id.tvTClass55);
        tvTClass66 = v.findViewById(R.id.tvTClass66);
        tvTClass77 = v.findViewById(R.id.tvTClass77);
        tvTClass88 = v.findViewById(R.id.tvTClass88);

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

                tvTimeT12.setText(T11);
                tvTimeT14.setText(T12);
                tvTimeT16.setText(T13);
                tvTimeT18.setText(T14);

                tvTimeT21.setText(T21);
                tvTimeT23.setText(T22);
                tvTimeT25.setText(T23);
                tvTimeT27.setText(T24);

                tvTimeT31.setText(T31);
                tvTimeT33.setText(T32);
                tvTimeT35.setText(T33);
                tvTimeT37.setText(T34);

                tvTimeT41.setText(T41);
                tvTimeT43.setText(T42);
                tvTimeT45.setText(T43);
                tvTimeT47.setText(T44);

                tvTimeT51.setText(T51);
                tvTimeT53.setText(T52);
                tvTimeT55.setText(T53);
                tvTimeT57.setText(T54);

                tvTimeT61.setText(T61);
                tvTimeT63.setText(T62);
                tvTimeT65.setText(T63);
                tvTimeT67.setText(T64);

                tvTimeT71.setText(T71);
                tvTimeT73.setText(T72);
                tvTimeT75.setText(T73);
                tvTimeT77.setText(T74);

                tvTimeT81.setText(T81);
                tvTimeT83.setText(T82);
                tvTimeT85.setText(T83);
                tvTimeT87.setText(T84);

                if(T11.equals("null"))
                {
                    tvTimeT12.setVisibility(View.GONE);
                    tvTimeT13.setVisibility(View.GONE);
                    tvTimeT14.setVisibility(View.GONE);
                    tvTimeT15.setVisibility(View.GONE);
                    tvTimeT16.setVisibility(View.GONE);
                    tvTimeT17.setVisibility(View.GONE);
                    tvTimeT18.setVisibility(View.GONE);
                }
                else
                {
                    tvTimeT13.setVisibility(View.VISIBLE);
                    tvTimeT15.setVisibility(View.VISIBLE);
                    tvTimeT17.setVisibility(View.VISIBLE);
                }

                if(T21.equals("null"))
                {
                    tvTimeT21.setVisibility(View.GONE);
                    tvTimeT22.setVisibility(View.GONE);
                    tvTimeT23.setVisibility(View.GONE);
                    tvTimeT24.setVisibility(View.GONE);
                    tvTimeT25.setVisibility(View.GONE);
                    tvTimeT26.setVisibility(View.GONE);
                    tvTimeT27.setVisibility(View.GONE);
                }
                else
                {
                    tvTimeT22.setVisibility(View.VISIBLE);
                    tvTimeT24.setVisibility(View.VISIBLE);
                    tvTimeT26.setVisibility(View.VISIBLE);
                }

                if(T31.equals("null"))
                {
                    tvTimeT31.setVisibility(View.GONE);
                    tvTimeT32.setVisibility(View.GONE);
                    tvTimeT33.setVisibility(View.GONE);
                    tvTimeT34.setVisibility(View.GONE);
                    tvTimeT35.setVisibility(View.GONE);
                    tvTimeT36.setVisibility(View.GONE);
                    tvTimeT37.setVisibility(View.GONE);
                }
                else
                {
                    tvTimeT32.setVisibility(View.VISIBLE);
                    tvTimeT34.setVisibility(View.VISIBLE);
                    tvTimeT36.setVisibility(View.VISIBLE);
                }

                if(T41.equals("null"))
                {
                    tvTimeT41.setVisibility(View.GONE);
                    tvTimeT42.setVisibility(View.GONE);
                    tvTimeT43.setVisibility(View.GONE);
                    tvTimeT44.setVisibility(View.GONE);
                    tvTimeT45.setVisibility(View.GONE);
                    tvTimeT46.setVisibility(View.GONE);
                    tvTimeT47.setVisibility(View.GONE);
                }
                else
                {
                    tvTimeT42.setVisibility(View.VISIBLE);
                    tvTimeT44.setVisibility(View.VISIBLE);
                    tvTimeT46.setVisibility(View.VISIBLE);
                }

                if(T51.equals("null"))
                {
                    tvTimeT51.setVisibility(View.GONE);
                    tvTimeT52.setVisibility(View.GONE);
                    tvTimeT53.setVisibility(View.GONE);
                    tvTimeT54.setVisibility(View.GONE);
                    tvTimeT55.setVisibility(View.GONE);
                    tvTimeT56.setVisibility(View.GONE);
                    tvTimeT57.setVisibility(View.GONE);
                }
                else
                {
                    tvTimeT52.setVisibility(View.VISIBLE);
                    tvTimeT54.setVisibility(View.VISIBLE);
                    tvTimeT56.setVisibility(View.VISIBLE);
                }

                if(T61.equals("null"))
                {
                    tvTimeT61.setVisibility(View.GONE);
                    tvTimeT62.setVisibility(View.GONE);
                    tvTimeT63.setVisibility(View.GONE);
                    tvTimeT64.setVisibility(View.GONE);
                    tvTimeT65.setVisibility(View.GONE);
                    tvTimeT66.setVisibility(View.GONE);
                    tvTimeT67.setVisibility(View.GONE);
                }
                else
                {
                    tvTimeT62.setVisibility(View.VISIBLE);
                    tvTimeT64.setVisibility(View.VISIBLE);
                    tvTimeT66.setVisibility(View.VISIBLE);
                }

                if(T71.equals("null"))
                {
                    tvTimeT71.setVisibility(View.GONE);
                    tvTimeT72.setVisibility(View.GONE);
                    tvTimeT73.setVisibility(View.GONE);
                    tvTimeT74.setVisibility(View.GONE);
                    tvTimeT75.setVisibility(View.GONE);
                    tvTimeT76.setVisibility(View.GONE);
                    tvTimeT77.setVisibility(View.GONE);
                }
                else
                {
                    tvTimeT72.setVisibility(View.VISIBLE);
                    tvTimeT74.setVisibility(View.VISIBLE);
                    tvTimeT76.setVisibility(View.VISIBLE);
                }

                if(T81.equals("null"))
                {
                    tvTimeT81.setVisibility(View.GONE);
                    tvTimeT82.setVisibility(View.GONE);
                    tvTimeT83.setVisibility(View.GONE);
                    tvTimeT84.setVisibility(View.GONE);
                    tvTimeT85.setVisibility(View.GONE);
                    tvTimeT86.setVisibility(View.GONE);
                    tvTimeT87.setVisibility(View.GONE);
                }
                else
                {
                    tvTimeT82.setVisibility(View.VISIBLE);
                    tvTimeT84.setVisibility(View.VISIBLE);
                    tvTimeT86.setVisibility(View.VISIBLE);
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
                T1Sub = String.valueOf(snapshot.child("Schedule").child("T1Sub").getValue());
                T2Sub = String.valueOf(snapshot.child("Schedule").child("T2Sub").getValue());
                T3Sub = String.valueOf(snapshot.child("Schedule").child("T3Sub").getValue());
                T4Sub = String.valueOf(snapshot.child("Schedule").child("T4Sub").getValue());
                T5Sub = String.valueOf(snapshot.child("Schedule").child("T5Sub").getValue());
                T6Sub = String.valueOf(snapshot.child("Schedule").child("T6Sub").getValue());
                T7Sub = String.valueOf(snapshot.child("Schedule").child("T7Sub").getValue());
                T8Sub = String.valueOf(snapshot.child("Schedule").child("T8Sub").getValue());

                T1Class = String.valueOf(snapshot.child("Schedule").child("T1Class").getValue());
                T2Class = String.valueOf(snapshot.child("Schedule").child("T2Class").getValue());
                T3Class = String.valueOf(snapshot.child("Schedule").child("T3Class").getValue());
                T4Class = String.valueOf(snapshot.child("Schedule").child("T4Class").getValue());
                T5Class = String.valueOf(snapshot.child("Schedule").child("T5Class").getValue());
                T6Class = String.valueOf(snapshot.child("Schedule").child("T6Class").getValue());
                T7Class = String.valueOf(snapshot.child("Schedule").child("T7Class").getValue());
                T8Class = String.valueOf(snapshot.child("Schedule").child("T8Class").getValue());

                tvTSub19.setText(T1Sub);
                tvTSub22.setText(T2Sub);
                tvTSub33.setText(T3Sub);
                tvTSub44.setText(T4Sub);
                tvTSub55.setText(T5Sub);
                tvTSub66.setText(T6Sub);
                tvTSub77.setText(T7Sub);
                tvTSub88.setText(T8Sub);

                tvTClass19.setText(T1Class);
                tvTClass22.setText(T2Class);
                tvTClass33.setText(T3Class);
                tvTClass44.setText(T4Class);
                tvTClass55.setText(T5Class);
                tvTClass66.setText(T6Class);
                tvTClass77.setText(T7Class);
                tvTClass88.setText(T8Class);


                if (T1Sub.length()>11)
                {
                    tvTSub19.setPadding(0,0,0,8);
                }

                if (T2Sub.length()>11)
                {
                    tvTSub22.setPadding(0,0,0,8);
                }

                if (T3Sub.length()>11)
                {
                    tvTSub33.setPadding(0,0,0,8);
                }

                if (T4Sub.length()>11)
                {
                    tvTSub44.setPadding(0,0,0,8);
                }

                if (T5Sub.length()>11)
                {
                    tvTSub55.setPadding(0,0,0,8);
                }

                if (T6Sub.length()>11)
                {
                    tvTSub66.setPadding(0,0,0,8);
                }

                if (T7Sub.length()>11)
                {
                    tvTSub77.setPadding(0,0,0,8);
                }

                if (T8Sub.length()>11)
                {
                    tvTSub88.setPadding(0,0,0,8);
                }
                

                LinearLayout ll_row1 = v.findViewById(R.id.teacherT1_row1);
                LinearLayout ll_row2 = v.findViewById(R.id.teacherT2_row2);
                LinearLayout ll_row3 = v.findViewById(R.id.teacherT3_row3);
                LinearLayout ll_row4 = v.findViewById(R.id.teacherT4_row4);
                LinearLayout ll_row5 = v.findViewById(R.id.teacherT5_row5);
                LinearLayout ll_row6 = v.findViewById(R.id.teacherT6_row6);
                LinearLayout ll_row7 = v.findViewById(R.id.teacherT7_row7);
                LinearLayout ll_row8 = v.findViewById(R.id.teacherT8_row8);

                //1 СТРОКА
                if (T1Sub.equals("null"))
                {
                    ll_row1.setVisibility(View.GONE);
                }
                else
                {
                    ll_row1.setVisibility(View.VISIBLE);
                }

                //2 строка
                if (T2Sub.equals("null"))
                {
                    ll_row2.setVisibility(View.GONE);
                }
                else
                {
                    ll_row2.setVisibility(View.VISIBLE);
                }

                //3 строка
                if (T3Sub.equals("null"))
                {
                    ll_row3.setVisibility(View.GONE);
                }
                else
                {
                    ll_row3.setVisibility(View.VISIBLE);
                }

                //4 строка
                if (T4Sub.equals("null"))
                {
                    ll_row4.setVisibility(View.GONE);
                }
                else
                {
                    ll_row4.setVisibility(View.VISIBLE);
                }

                //5 строка
                if (T5Sub.equals("null"))
                {
                    ll_row5.setVisibility(View.GONE);
                }
                else
                {
                    ll_row5.setVisibility(View.VISIBLE);
                }

                //6 строка
                if (T6Sub.equals("null"))
                {
                    ll_row6.setVisibility(View.GONE);
                }
                else
                {
                    ll_row6.setVisibility(View.VISIBLE);
                }

                //7 строка
                if (T7Sub.equals("null"))
                {
                    ll_row7.setVisibility(View.GONE);
                }
                else
                {
                    ll_row7.setVisibility(View.VISIBLE);
                }

                //8 строка
                if (T8Sub.equals("null"))
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