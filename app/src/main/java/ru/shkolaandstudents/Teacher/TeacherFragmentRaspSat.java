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

public class TeacherFragmentRaspSat extends Fragment implements OnBackPressedListener {

    TextView tvSat1,tvSat2,tvSat3,tvSat4,tvSat5,tvSat6,tvSat7,tvSat8,tvTimeSat11,tvTimeSat12,tvTimeSat13,tvTimeSat14,tvTimeSat15,tvTimeSat16,tvTimeSat17,tvTimeSat21,tvTimeSat22,tvTimeSat23,tvTimeSat24,tvTimeSat25,tvTimeSat26,tvTimeSat27,tvTimeSat31,tvTimeSat32,tvTimeSat33,tvTimeSat34,tvTimeSat35,tvTimeSat36,tvTimeSat37,tvTimeSat41,tvTimeSat42,tvTimeSat43,tvTimeSat44,tvTimeSat45,tvTimeSat46,tvTimeSat47,tvTimeSat51,tvTimeSat52,tvTimeSat53,tvTimeSat54,tvTimeSat55,tvTimeSat56,tvTimeSat57,tvTimeSat61,tvTimeSat62,tvTimeSat63,tvTimeSat64,tvTimeSat65,tvTimeSat66,tvTimeSat67,tvTimeSat71,tvTimeSat72,tvTimeSat73,tvTimeSat74,tvTimeSat75,tvTimeSat76,tvTimeSat77,tvTimeSat81,tvTimeSat82,tvTimeSat83,tvTimeSat84,tvTimeSat85,tvTimeSat86,tvTimeSat87;
    TextView tvSatClass11,tvSatClass22,tvSatClass33,tvSatClass44,tvSatClass55,tvSatClass66,tvSatClass77,tvSatClass88;
    TextView tvSatSub11,tvSatSub22,tvSatSub33,tvSatSub44,tvSatSub55,tvSatSub66,tvSatSub77,tvSatSub88;
    Button btnHelp;
    DatabaseReference ref_save;
    DatabaseReference ref_time;

    String Sat1Sub;
    String Sat2Sub;
    String Sat3Sub;
    String Sat4Sub;
    String Sat5Sub;
    String Sat6Sub;
    String Sat7Sub;
    String Sat8Sub;

    String Sat1Class;
    String Sat2Class;
    String Sat3Class;
    String Sat4Class;
    String Sat5Class;
    String Sat6Class;
    String Sat7Class;
    String Sat8Class;

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
        final View v = inflater.inflate(R.layout.teacher_fragment_rasp_sat, container, false);

        btnHelp = v.findViewById(R.id.btnSunHelp);

        btnHelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new TapTargetSequence(getActivity())
                        .targets(
                                TapTarget.forView(v.findViewById(R.id.tvSat1), getResources().getString(R.string.nomer_predmeta), getResources().getString(R.string.click_TapTargetView))
                                        .titleTextSize(20)
                                        .titleTextColor(R.color.colorWhite)
                                        .descriptionTextColor(R.color.colorWhite)
                                        .cancelable(false)
                                        .tintTarget(false)
                                        .targetRadius(10)
                                        .transparentTarget(true)
                                        .outerCircleColor(R.color.colorTuesday),
                                TapTarget.forView(v.findViewById(R.id.tvTimeSat12), getResources().getString(R.string.nachalo_uroka), getResources().getString(R.string.click_TapTargetView))
                                        .titleTextSize(20)
                                        .titleTextColor(R.color.colorWhite)
                                        .descriptionTextColor(R.color.colorWhite)
                                        .cancelable(false)
                                        .tintTarget(false)
                                        .targetRadius(20)
                                        .transparentTarget(true)
                                        .outerCircleColor(R.color.colorTuesday),
                                TapTarget.forView(v.findViewById(R.id.tvTimeSat16), getResources().getString(R.string.konec_uroka), getResources().getString(R.string.click_TapTargetView))
                                        .titleTextSize(20)
                                        .titleTextColor(R.color.colorWhite)
                                        .descriptionTextColor(R.color.colorWhite)
                                        .cancelable(false)
                                        .tintTarget(false)
                                        .targetRadius(20)
                                        .transparentTarget(true)
                                        .outerCircleColor(R.color.colorTuesday),
                                TapTarget.forView(v.findViewById(R.id.tvSatClass11), getResources().getString(R.string.predmet), getResources().getString(R.string.click_TapTargetView))
                                        .titleTextSize(20)
                                        .titleTextColor(R.color.colorWhite)
                                        .descriptionTextColor(R.color.colorWhite)
                                        .cancelable(false)
                                        .tintTarget(false)
                                        .targetRadius(30)
                                        .transparentTarget(true)
                                        .outerCircleColor(R.color.colorTuesday),
                                TapTarget.forView(v.findViewById(R.id.tvSatSub11), "Класс", getResources().getString(R.string.click_TapTargetView))
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
                        }
                ).start();
            }
        });

        tvSat1 = v.findViewById(R.id.tvSat1);
        tvSat2 = v.findViewById(R.id.tvSat2);
        tvSat3 = v.findViewById(R.id.tvSat3);
        tvSat4 = v.findViewById(R.id.tvSat4);
        tvSat5 = v.findViewById(R.id.tvSat5);
        tvSat6 = v.findViewById(R.id.tvSat6);
        tvSat7 = v.findViewById(R.id.tvSat7);
        tvSat8 = v.findViewById(R.id.tvSat8);

        tvTimeSat11 = v.findViewById(R.id.tvTimeSat11);
        tvTimeSat12 = v.findViewById(R.id.tvTimeSat12);
        tvTimeSat13 = v.findViewById(R.id.tvTimeSat13);
        tvTimeSat14 = v.findViewById(R.id.tvTimeSat14);
        tvTimeSat15 = v.findViewById(R.id.tvTimeSat15);
        tvTimeSat16 = v.findViewById(R.id.tvTimeSat16);
        tvTimeSat17 = v.findViewById(R.id.tvTimeSat17);
        tvTimeSat21 = v.findViewById(R.id.tvTimeSat21);
        tvTimeSat22 = v.findViewById(R.id.tvTimeSat22);
        tvTimeSat23 = v.findViewById(R.id.tvTimeSat23);
        tvTimeSat24 = v.findViewById(R.id.tvTimeSat24);
        tvTimeSat25 = v.findViewById(R.id.tvTimeSat25);
        tvTimeSat26 = v.findViewById(R.id.tvTimeSat26);
        tvTimeSat27 = v.findViewById(R.id.tvTimeSat27);
        tvTimeSat31 = v.findViewById(R.id.tvTimeSat31);
        tvTimeSat32 = v.findViewById(R.id.tvTimeSat32);
        tvTimeSat33 = v.findViewById(R.id.tvTimeSat33);
        tvTimeSat34 = v.findViewById(R.id.tvTimeSat34);
        tvTimeSat35 = v.findViewById(R.id.tvTimeSat35);
        tvTimeSat36 = v.findViewById(R.id.tvTimeSat36);
        tvTimeSat37 = v.findViewById(R.id.tvTimeSat37);
        tvTimeSat41 = v.findViewById(R.id.tvTimeSat41);
        tvTimeSat42 = v.findViewById(R.id.tvTimeSat42);
        tvTimeSat43 = v.findViewById(R.id.tvTimeSat43);
        tvTimeSat44 = v.findViewById(R.id.tvTimeSat44);
        tvTimeSat45 = v.findViewById(R.id.tvTimeSat45);
        tvTimeSat46 = v.findViewById(R.id.tvTimeSat46);
        tvTimeSat47 = v.findViewById(R.id.tvTimeSat47);
        tvTimeSat51 = v.findViewById(R.id.tvTimeSat51);
        tvTimeSat52 = v.findViewById(R.id.tvTimeSat52);
        tvTimeSat53 = v.findViewById(R.id.tvTimeSat53);
        tvTimeSat54 = v.findViewById(R.id.tvTimeSat54);
        tvTimeSat55 = v.findViewById(R.id.tvTimeSat55);
        tvTimeSat56 = v.findViewById(R.id.tvTimeSat56);
        tvTimeSat57 = v.findViewById(R.id.tvTimeSat57);
        tvTimeSat61 = v.findViewById(R.id.tvTimeSat61);
        tvTimeSat62 = v.findViewById(R.id.tvTimeSat62);
        tvTimeSat63 = v.findViewById(R.id.tvTimeSat63);
        tvTimeSat64 = v.findViewById(R.id.tvTimeSat64);
        tvTimeSat65 = v.findViewById(R.id.tvTimeSat65);
        tvTimeSat66 = v.findViewById(R.id.tvTimeSat66);
        tvTimeSat67 = v.findViewById(R.id.tvTimeSat67);
        tvTimeSat71 = v.findViewById(R.id.tvTimeSat71);
        tvTimeSat72 = v.findViewById(R.id.tvTimeSat72);
        tvTimeSat73 = v.findViewById(R.id.tvTimeSat73);
        tvTimeSat74 = v.findViewById(R.id.tvTimeSat74);
        tvTimeSat75 = v.findViewById(R.id.tvTimeSat75);
        tvTimeSat76 = v.findViewById(R.id.tvTimeSat76);
        tvTimeSat77 = v.findViewById(R.id.tvTimeSat77);
        tvTimeSat81 = v.findViewById(R.id.tvTimeSat81);
        tvTimeSat82 = v.findViewById(R.id.tvTimeSat82);
        tvTimeSat83 = v.findViewById(R.id.tvTimeSat83);
        tvTimeSat84 = v.findViewById(R.id.tvTimeSat84);
        tvTimeSat85 = v.findViewById(R.id.tvTimeSat85);
        tvTimeSat86 = v.findViewById(R.id.tvTimeSat86);
        tvTimeSat87 = v.findViewById(R.id.tvTimeSat87);

        tvSatClass11 = v.findViewById(R.id.tvSatClass11);
        tvSatClass22 = v.findViewById(R.id.tvSatClass22);
        tvSatClass33 = v.findViewById(R.id.tvSatClass33);
        tvSatClass44 = v.findViewById(R.id.tvSatClass44);
        tvSatClass55 = v.findViewById(R.id.tvSatClass55);
        tvSatClass66 = v.findViewById(R.id.tvSatClass66);
        tvSatClass77 = v.findViewById(R.id.tvSatClass77);
        tvSatClass88 = v.findViewById(R.id.tvSatClass88);
        
        tvSatSub11 = v.findViewById(R.id.tvSatSub11);
        tvSatSub22 = v.findViewById(R.id.tvSatSub22);
        tvSatSub33 = v.findViewById(R.id.tvSatSub33);
        tvSatSub44 = v.findViewById(R.id.tvSatSub44);
        tvSatSub55 = v.findViewById(R.id.tvSatSub55);
        tvSatSub66 = v.findViewById(R.id.tvSatSub66);
        tvSatSub77 = v.findViewById(R.id.tvSatSub77);
        tvSatSub88 = v.findViewById(R.id.tvSatSub88);

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

                tvTimeSat11.setText(T11);
                tvTimeSat13.setText(T12);
                tvTimeSat15.setText(T13);
                tvTimeSat17.setText(T14);

                tvTimeSat21.setText(T21);
                tvTimeSat23.setText(T22);
                tvTimeSat25.setText(T23);
                tvTimeSat27.setText(T24);

                tvTimeSat31.setText(T31);
                tvTimeSat33.setText(T32);
                tvTimeSat35.setText(T33);
                tvTimeSat37.setText(T34);

                tvTimeSat41.setText(T41);
                tvTimeSat43.setText(T42);
                tvTimeSat45.setText(T43);
                tvTimeSat47.setText(T44);

                tvTimeSat51.setText(T51);
                tvTimeSat53.setText(T52);
                tvTimeSat55.setText(T53);
                tvTimeSat57.setText(T54);

                tvTimeSat61.setText(T61);
                tvTimeSat63.setText(T62);
                tvTimeSat65.setText(T63);
                tvTimeSat67.setText(T64);

                tvTimeSat71.setText(T71);
                tvTimeSat73.setText(T72);
                tvTimeSat75.setText(T73);
                tvTimeSat77.setText(T74);

                tvTimeSat81.setText(T81);
                tvTimeSat83.setText(T82);
                tvTimeSat85.setText(T83);
                tvTimeSat87.setText(T84);

                if(T11.equals("null"))
                {
                    tvTimeSat11.setVisibility(View.GONE);
                    tvTimeSat12.setVisibility(View.GONE);
                    tvTimeSat13.setVisibility(View.GONE);
                    tvTimeSat14.setVisibility(View.GONE);
                    tvTimeSat15.setVisibility(View.GONE);
                    tvTimeSat16.setVisibility(View.GONE);
                    tvTimeSat17.setVisibility(View.GONE);
                }
                else
                {
                    tvTimeSat12.setVisibility(View.VISIBLE);
                    tvTimeSat14.setVisibility(View.VISIBLE);
                    tvTimeSat16.setVisibility(View.VISIBLE);
                }

                if(T21.equals("null"))
                {
                    tvTimeSat21.setVisibility(View.GONE);
                    tvTimeSat22.setVisibility(View.GONE);
                    tvTimeSat23.setVisibility(View.GONE);
                    tvTimeSat24.setVisibility(View.GONE);
                    tvTimeSat25.setVisibility(View.GONE);
                    tvTimeSat26.setVisibility(View.GONE);
                    tvTimeSat27.setVisibility(View.GONE);
                }
                else
                {
                    tvTimeSat22.setVisibility(View.VISIBLE);
                    tvTimeSat24.setVisibility(View.VISIBLE);
                    tvTimeSat26.setVisibility(View.VISIBLE);
                }

                if(T31.equals("null"))
                {
                    tvTimeSat31.setVisibility(View.GONE);
                    tvTimeSat32.setVisibility(View.GONE);
                    tvTimeSat33.setVisibility(View.GONE);
                    tvTimeSat34.setVisibility(View.GONE);
                    tvTimeSat35.setVisibility(View.GONE);
                    tvTimeSat36.setVisibility(View.GONE);
                    tvTimeSat37.setVisibility(View.GONE);
                }
                else
                {
                    tvTimeSat32.setVisibility(View.VISIBLE);
                    tvTimeSat34.setVisibility(View.VISIBLE);
                    tvTimeSat36.setVisibility(View.VISIBLE);
                }

                if(T41.equals("null"))
                {
                    tvTimeSat41.setVisibility(View.GONE);
                    tvTimeSat42.setVisibility(View.GONE);
                    tvTimeSat43.setVisibility(View.GONE);
                    tvTimeSat44.setVisibility(View.GONE);
                    tvTimeSat45.setVisibility(View.GONE);
                    tvTimeSat46.setVisibility(View.GONE);
                    tvTimeSat47.setVisibility(View.GONE);
                }
                else
                {
                    tvTimeSat42.setVisibility(View.VISIBLE);
                    tvTimeSat44.setVisibility(View.VISIBLE);
                    tvTimeSat46.setVisibility(View.VISIBLE);
                }

                if(T51.equals("null"))
                {
                    tvTimeSat51.setVisibility(View.GONE);
                    tvTimeSat52.setVisibility(View.GONE);
                    tvTimeSat53.setVisibility(View.GONE);
                    tvTimeSat54.setVisibility(View.GONE);
                    tvTimeSat55.setVisibility(View.GONE);
                    tvTimeSat56.setVisibility(View.GONE);
                    tvTimeSat57.setVisibility(View.GONE);
                }
                else
                {
                    tvTimeSat52.setVisibility(View.VISIBLE);
                    tvTimeSat54.setVisibility(View.VISIBLE);
                    tvTimeSat56.setVisibility(View.VISIBLE);
                }

                if(T61.equals("null"))
                {
                    tvTimeSat61.setVisibility(View.GONE);
                    tvTimeSat62.setVisibility(View.GONE);
                    tvTimeSat63.setVisibility(View.GONE);
                    tvTimeSat64.setVisibility(View.GONE);
                    tvTimeSat65.setVisibility(View.GONE);
                    tvTimeSat66.setVisibility(View.GONE);
                    tvTimeSat67.setVisibility(View.GONE);
                }
                else
                {
                    tvTimeSat62.setVisibility(View.VISIBLE);
                    tvTimeSat64.setVisibility(View.VISIBLE);
                    tvTimeSat66.setVisibility(View.VISIBLE);
                }

                if(T71.equals("null"))
                {
                    tvTimeSat71.setVisibility(View.GONE);
                    tvTimeSat72.setVisibility(View.GONE);
                    tvTimeSat73.setVisibility(View.GONE);
                    tvTimeSat74.setVisibility(View.GONE);
                    tvTimeSat75.setVisibility(View.GONE);
                    tvTimeSat76.setVisibility(View.GONE);
                    tvTimeSat77.setVisibility(View.GONE);
                }
                else
                {
                    tvTimeSat72.setVisibility(View.VISIBLE);
                    tvTimeSat74.setVisibility(View.VISIBLE);
                    tvTimeSat76.setVisibility(View.VISIBLE);
                }

                if(T81.equals("null"))
                {
                    tvTimeSat81.setVisibility(View.GONE);
                    tvTimeSat82.setVisibility(View.GONE);
                    tvTimeSat83.setVisibility(View.GONE);
                    tvTimeSat84.setVisibility(View.GONE);
                    tvTimeSat85.setVisibility(View.GONE);
                    tvTimeSat86.setVisibility(View.GONE);
                    tvTimeSat87.setVisibility(View.GONE);
                }
                else
                {
                    tvTimeSat82.setVisibility(View.VISIBLE);
                    tvTimeSat84.setVisibility(View.VISIBLE);
                    tvTimeSat86.setVisibility(View.VISIBLE);
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
                Sat1Sub = String.valueOf(snapshot.child("Schedule").child("Sat1Sub").getValue());
                Sat2Sub = String.valueOf(snapshot.child("Schedule").child("Sat2Sub").getValue());
                Sat3Sub = String.valueOf(snapshot.child("Schedule").child("Sat3Sub").getValue());
                Sat4Sub = String.valueOf(snapshot.child("Schedule").child("Sat4Sub").getValue());
                Sat5Sub = String.valueOf(snapshot.child("Schedule").child("Sat5Sub").getValue());
                Sat6Sub = String.valueOf(snapshot.child("Schedule").child("Sat6Sub").getValue());
                Sat7Sub = String.valueOf(snapshot.child("Schedule").child("Sat7Sub").getValue());
                Sat8Sub = String.valueOf(snapshot.child("Schedule").child("Sat8Sub").getValue());

                Sat1Class = String.valueOf(snapshot.child("Schedule").child("Sat1Class").getValue());
                Sat2Class = String.valueOf(snapshot.child("Schedule").child("Sat2Class").getValue());
                Sat3Class = String.valueOf(snapshot.child("Schedule").child("Sat3Class").getValue());
                Sat4Class = String.valueOf(snapshot.child("Schedule").child("Sat4Class").getValue());
                Sat5Class = String.valueOf(snapshot.child("Schedule").child("Sat5Class").getValue());
                Sat6Class = String.valueOf(snapshot.child("Schedule").child("Sat6Class").getValue());
                Sat7Class = String.valueOf(snapshot.child("Schedule").child("Sat7Class").getValue());
                Sat8Class = String.valueOf(snapshot.child("Schedule").child("Sat8Class").getValue());

                tvSatSub11.setText(Sat1Sub);
                tvSatSub22.setText(Sat2Sub);
                tvSatSub33.setText(Sat3Sub);
                tvSatSub44.setText(Sat4Sub);
                tvSatSub55.setText(Sat5Sub);
                tvSatSub66.setText(Sat6Sub);
                tvSatSub77.setText(Sat7Sub);
                tvSatSub88.setText(Sat8Sub);

                tvSatClass11.setText(Sat1Class);
                tvSatClass22.setText(Sat2Class);
                tvSatClass33.setText(Sat3Class);
                tvSatClass44.setText(Sat4Class);
                tvSatClass55.setText(Sat5Class);
                tvSatClass66.setText(Sat6Class);
                tvSatClass77.setText(Sat7Class);
                tvSatClass88.setText(Sat8Class);

                if (Sat1Sub.length()>11)
                {
                    tvSatSub11.setPadding(0,0,0,8);
                }

                if (Sat2Sub.length()>11)
                {
                    tvSatSub22.setPadding(0,0,0,8);
                }

                if (Sat3Sub.length()>11)
                {
                    tvSatSub33.setPadding(0,0,0,8);
                }

                if (Sat4Sub.length()>11)
                {
                    tvSatSub44.setPadding(0,0,0,8);
                }

                if (Sat5Sub.length()>11)
                {
                    tvSatSub55.setPadding(0,0,0,8);
                }

                if (Sat6Sub.length()>11)
                {
                    tvSatSub66.setPadding(0,0,0,8);
                }

                if (Sat7Sub.length()>11)
                {
                    tvSatSub77.setPadding(0,0,0,8);
                }

                if (Sat8Sub.length()>11)
                {
                    tvSatSub88.setPadding(0,0,0,8);
                }

                LinearLayout ll_row1 = v.findViewById(R.id.teacherSat1_row1);
                LinearLayout ll_row2 = v.findViewById(R.id.teacherSat2_row2);
                LinearLayout ll_row3 = v.findViewById(R.id.teacherSat3_row3);
                LinearLayout ll_row4 = v.findViewById(R.id.teacherSat4_row4);
                LinearLayout ll_row5 = v.findViewById(R.id.teacherSat5_row5);
                LinearLayout ll_row6 = v.findViewById(R.id.teacherSat6_row6);
                LinearLayout ll_row7 = v.findViewById(R.id.teacherSat7_row7);
                LinearLayout ll_row8 = v.findViewById(R.id.teacherSat8_row8);

                //1 СТРОКА
                if (Sat1Sub.equals("null"))
                {
                    ll_row1.setVisibility(View.GONE);
                }
                else
                {
                    ll_row1.setVisibility(View.VISIBLE);
                }

                //2 строка
                if (Sat2Sub.equals("null"))
                {
                    ll_row2.setVisibility(View.GONE);
                }
                else
                {
                    ll_row2.setVisibility(View.VISIBLE);
                }

                //3 строка
                if (Sat3Sub.equals("null"))
                {
                    ll_row3.setVisibility(View.GONE);
                }
                else
                {
                    ll_row3.setVisibility(View.VISIBLE);
                }

                //4 строка
                if (Sat4Sub.equals("null"))
                {
                    ll_row4.setVisibility(View.GONE);
                }
                else
                {
                    ll_row4.setVisibility(View.VISIBLE);
                }

                //5 строка
                if (Sat5Sub.equals("null"))
                {
                    ll_row5.setVisibility(View.GONE);
                }
                else
                {
                    ll_row5.setVisibility(View.VISIBLE);
                }

                //6 строка
                if (Sat6Sub.equals("null"))
                {
                    ll_row6.setVisibility(View.GONE);
                }
                else
                {
                    ll_row6.setVisibility(View.VISIBLE);
                }

                //7 строка
                if (Sat7Sub.equals("null"))
                {
                    ll_row7.setVisibility(View.GONE);
                }
                else
                {
                    ll_row7.setVisibility(View.VISIBLE);
                }

                //8 строка
                if (Sat8Sub.equals("null"))
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