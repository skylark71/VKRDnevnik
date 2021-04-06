package ru.shkolaandstudents.Teacher;

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

public class TeacherFragmentRaspWend extends Fragment implements OnBackPressedListener {

    TextView tvW1,tvW2,tvW3,tvW4,tvW5,tvW6,tvW7,tvW8,tvTimeW11,tvTimeW12,tvTimeW13,tvTimeW14,tvTimeW15,tvTimeW16,tvTimeW17,tvTimeW21,tvTimeW22,tvTimeW23,tvTimeW24,tvTimeW25,tvTimeW26,tvTimeW27,tvTimeW31,tvTimeW32,tvTimeW33,tvTimeW34,tvTimeW35,tvTimeW36,tvTimeW37,tvTimeW41,tvTimeW42,tvTimeW43,tvTimeW44,tvTimeW45,tvTimeW46,tvTimeW47,tvTimeW51,tvTimeW52,tvTimeW53,tvTimeW54,tvTimeW55,tvTimeW56,tvTimeW57,tvTimeW61,tvTimeW62,tvTimeW63,tvTimeW64,tvTimeW65,tvTimeW66,tvTimeW67,tvTimeW71,tvTimeW72,tvTimeW73,tvTimeW74,tvTimeW75,tvTimeW76,tvTimeW77,tvTimeW81,tvTimeW82,tvTimeW83,tvTimeW84,tvTimeW85,tvTimeW86,tvTimeW87;
    TextView tvWSub11,tvWSub22,tvWSub33,tvWSub44,tvWSub55,tvWSub66,tvWSub77,tvWSub88;
    TextView tvWClass11,tvWClass22,tvWClass33,tvWClass44,tvWClass55,tvWClass66,tvWClass77,tvWClass88;
    Button btnHelp;
    DatabaseReference ref_save;
    DatabaseReference ref_time;

    String W1Sub;
    String W2Sub;
    String W3Sub;
    String W4Sub;
    String W5Sub;
    String W6Sub;
    String W7Sub;
    String W8Sub;

    String W1Class;
    String W2Class;
    String W3Class;
    String W4Class;
    String W5Class;
    String W6Class;
    String W7Class;
    String W8Class;

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
        final View v = inflater.inflate(R.layout.teacher_fragment_rasp_wend, container, false);

        btnHelp = v.findViewById(R.id.btnWenHelp);

        btnHelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new TapTargetSequence(getActivity())
                        .targets(
                                TapTarget.forView(v.findViewById(R.id.tvW1), getResources().getString(R.string.nomer_predmeta), getResources().getString(R.string.click_TapTargetView))
                                        .titleTextSize(20)
                                        .titleTextColor(R.color.colorWhite)
                                        .descriptionTextColor(R.color.colorWhite)
                                        .cancelable(false)
                                        .tintTarget(false)
                                        .targetRadius(10)
                                        .transparentTarget(true)
                                        .outerCircleColor(R.color.colorTuesday),
                                TapTarget.forView(v.findViewById(R.id.tvTimeW12), getResources().getString(R.string.nachalo_uroka), getResources().getString(R.string.click_TapTargetView))
                                        .titleTextSize(20)
                                        .titleTextColor(R.color.colorWhite)
                                        .descriptionTextColor(R.color.colorWhite)
                                        .cancelable(false)
                                        .tintTarget(false)
                                        .targetRadius(20)
                                        .transparentTarget(true)
                                        .outerCircleColor(R.color.colorTuesday),
                                TapTarget.forView(v.findViewById(R.id.tvTimeW16), getResources().getString(R.string.konec_uroka), getResources().getString(R.string.click_TapTargetView))
                                        .titleTextSize(20)
                                        .titleTextColor(R.color.colorWhite)
                                        .descriptionTextColor(R.color.colorWhite)
                                        .cancelable(false)
                                        .tintTarget(false)
                                        .targetRadius(20)
                                        .transparentTarget(true)
                                        .outerCircleColor(R.color.colorTuesday),
                                TapTarget.forView(v.findViewById(R.id.tvWSub11), getResources().getString(R.string.predmet), getResources().getString(R.string.click_TapTargetView))
                                        .titleTextSize(20)
                                        .titleTextColor(R.color.colorWhite)
                                        .descriptionTextColor(R.color.colorWhite)
                                        .cancelable(false)
                                        .tintTarget(false)
                                        .targetRadius(30)
                                        .transparentTarget(true)
                                        .outerCircleColor(R.color.colorTuesday),
                                TapTarget.forView(v.findViewById(R.id.tvWClass11), "Класс", getResources().getString(R.string.click_TapTargetView))
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


        tvW1 = v.findViewById(R.id.tvW1);
        tvW2 = v.findViewById(R.id.tvW2);
        tvW3 = v.findViewById(R.id.tvW3);
        tvW4 = v.findViewById(R.id.tvW4);
        tvW5 = v.findViewById(R.id.tvW5);
        tvW6 = v.findViewById(R.id.tvW6);
        tvW7 = v.findViewById(R.id.tvW7);
        tvW8 = v.findViewById(R.id.tvW8);

        tvTimeW11 = v.findViewById(R.id.tvTimeW11);
        tvTimeW12 = v.findViewById(R.id.tvTimeW12);
        tvTimeW13 = v.findViewById(R.id.tvTimeW13);
        tvTimeW14 = v.findViewById(R.id.tvTimeW14);
        tvTimeW15 = v.findViewById(R.id.tvTimeW15);
        tvTimeW16 = v.findViewById(R.id.tvTimeW16);
        tvTimeW17 = v.findViewById(R.id.tvTimeW17);
        tvTimeW21 = v.findViewById(R.id.tvTimeW21);
        tvTimeW22 = v.findViewById(R.id.tvTimeW22);
        tvTimeW23 = v.findViewById(R.id.tvTimeW23);
        tvTimeW24 = v.findViewById(R.id.tvTimeW24);
        tvTimeW25 = v.findViewById(R.id.tvTimeW25);
        tvTimeW26 = v.findViewById(R.id.tvTimeW26);
        tvTimeW27 = v.findViewById(R.id.tvTimeW27);
        tvTimeW31 = v.findViewById(R.id.tvTimeW31);
        tvTimeW32 = v.findViewById(R.id.tvTimeW32);
        tvTimeW33 = v.findViewById(R.id.tvTimeW33);
        tvTimeW34 = v.findViewById(R.id.tvTimeW34);
        tvTimeW35 = v.findViewById(R.id.tvTimeW35);
        tvTimeW36 = v.findViewById(R.id.tvTimeW36);
        tvTimeW37 = v.findViewById(R.id.tvTimeW37);
        tvTimeW41 = v.findViewById(R.id.tvTimeW41);
        tvTimeW42 = v.findViewById(R.id.tvTimeW42);
        tvTimeW43 = v.findViewById(R.id.tvTimeW43);
        tvTimeW44 = v.findViewById(R.id.tvTimeW44);
        tvTimeW45 = v.findViewById(R.id.tvTimeW45);
        tvTimeW46 = v.findViewById(R.id.tvTimeW46);
        tvTimeW47 = v.findViewById(R.id.tvTimeW47);
        tvTimeW51 = v.findViewById(R.id.tvTimeW51);
        tvTimeW52 = v.findViewById(R.id.tvTimeW52);
        tvTimeW53 = v.findViewById(R.id.tvTimeW53);
        tvTimeW54 = v.findViewById(R.id.tvTimeW54);
        tvTimeW55 = v.findViewById(R.id.tvTimeW55);
        tvTimeW56 = v.findViewById(R.id.tvTimeW56);
        tvTimeW57 = v.findViewById(R.id.tvTimeW57);
        tvTimeW61 = v.findViewById(R.id.tvTimeW61);
        tvTimeW62 = v.findViewById(R.id.tvTimeW62);
        tvTimeW63 = v.findViewById(R.id.tvTimeW63);
        tvTimeW64 = v.findViewById(R.id.tvTimeW64);
        tvTimeW65 = v.findViewById(R.id.tvTimeW65);
        tvTimeW66 = v.findViewById(R.id.tvTimeW66);
        tvTimeW67 = v.findViewById(R.id.tvTimeW67);
        tvTimeW71 = v.findViewById(R.id.tvTimeW71);
        tvTimeW72 = v.findViewById(R.id.tvTimeW72);
        tvTimeW73 = v.findViewById(R.id.tvTimeW73);
        tvTimeW74 = v.findViewById(R.id.tvTimeW74);
        tvTimeW75 = v.findViewById(R.id.tvTimeW75);
        tvTimeW76 = v.findViewById(R.id.tvTimeW76);
        tvTimeW77 = v.findViewById(R.id.tvTimeW77);
        tvTimeW81 = v.findViewById(R.id.tvTimeW81);
        tvTimeW82 = v.findViewById(R.id.tvTimeW82);
        tvTimeW83 = v.findViewById(R.id.tvTimeW83);
        tvTimeW84 = v.findViewById(R.id.tvTimeW84);
        tvTimeW85 = v.findViewById(R.id.tvTimeW85);
        tvTimeW86 = v.findViewById(R.id.tvTimeW86);
        tvTimeW87 = v.findViewById(R.id.tvTimeW87);

        tvWSub11 = v.findViewById(R.id.tvWSub11);
        tvWSub22 = v.findViewById(R.id.tvWSub22);
        tvWSub33 = v.findViewById(R.id.tvWSub33);
        tvWSub44 = v.findViewById(R.id.tvWSub44);
        tvWSub55 = v.findViewById(R.id.tvWSub55);
        tvWSub66 = v.findViewById(R.id.tvWSub66);
        tvWSub77 = v.findViewById(R.id.tvWSub77);
        tvWSub88 = v.findViewById(R.id.tvWSub88);

        tvWClass11 = v.findViewById(R.id.tvWClass11);
        tvWClass22 = v.findViewById(R.id.tvWClass22);
        tvWClass33 = v.findViewById(R.id.tvWClass33);
        tvWClass44 = v.findViewById(R.id.tvWClass44);
        tvWClass55 = v.findViewById(R.id.tvWClass55);
        tvWClass66 = v.findViewById(R.id.tvWClass66);
        tvWClass77 = v.findViewById(R.id.tvWClass77);
        tvWClass88 = v.findViewById(R.id.tvWClass88);

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

                tvTimeW11.setText(T11);
                tvTimeW13.setText(T12);
                tvTimeW15.setText(T13);
                tvTimeW17.setText(T14);

                tvTimeW21.setText(T21);
                tvTimeW23.setText(T22);
                tvTimeW25.setText(T23);
                tvTimeW27.setText(T24);

                tvTimeW31.setText(T31);
                tvTimeW33.setText(T32);
                tvTimeW35.setText(T33);
                tvTimeW37.setText(T34);

                tvTimeW41.setText(T41);
                tvTimeW43.setText(T42);
                tvTimeW45.setText(T43);
                tvTimeW47.setText(T44);

                tvTimeW51.setText(T51);
                tvTimeW53.setText(T52);
                tvTimeW55.setText(T53);
                tvTimeW57.setText(T54);

                tvTimeW61.setText(T61);
                tvTimeW63.setText(T62);
                tvTimeW65.setText(T63);
                tvTimeW67.setText(T64);

                tvTimeW71.setText(T71);
                tvTimeW73.setText(T72);
                tvTimeW75.setText(T73);
                tvTimeW77.setText(T74);

                tvTimeW81.setText(T81);
                tvTimeW83.setText(T82);
                tvTimeW85.setText(T83);
                tvTimeW87.setText(T84);

                if(T11.equals("null"))
                {
                    tvTimeW11.setVisibility(View.GONE);
                    tvTimeW12.setVisibility(View.GONE);
                    tvTimeW13.setVisibility(View.GONE);
                    tvTimeW14.setVisibility(View.GONE);
                    tvTimeW15.setVisibility(View.GONE);
                    tvTimeW16.setVisibility(View.GONE);
                    tvTimeW17.setVisibility(View.GONE);
                }
                else
                {
                    tvTimeW12.setVisibility(View.VISIBLE);
                    tvTimeW14.setVisibility(View.VISIBLE);
                    tvTimeW16.setVisibility(View.VISIBLE);
                }

                if(T21.equals("null"))
                {
                    tvTimeW21.setVisibility(View.GONE);
                    tvTimeW22.setVisibility(View.GONE);
                    tvTimeW23.setVisibility(View.GONE);
                    tvTimeW24.setVisibility(View.GONE);
                    tvTimeW25.setVisibility(View.GONE);
                    tvTimeW26.setVisibility(View.GONE);
                    tvTimeW27.setVisibility(View.GONE);
                }
                else
                {
                    tvTimeW22.setVisibility(View.VISIBLE);
                    tvTimeW24.setVisibility(View.VISIBLE);
                    tvTimeW26.setVisibility(View.VISIBLE);
                }

                if(T31.equals("null"))
                {
                    tvTimeW31.setVisibility(View.GONE);
                    tvTimeW32.setVisibility(View.GONE);
                    tvTimeW33.setVisibility(View.GONE);
                    tvTimeW34.setVisibility(View.GONE);
                    tvTimeW35.setVisibility(View.GONE);
                    tvTimeW36.setVisibility(View.GONE);
                    tvTimeW37.setVisibility(View.GONE);
                }
                else
                {
                    tvTimeW32.setVisibility(View.VISIBLE);
                    tvTimeW34.setVisibility(View.VISIBLE);
                    tvTimeW36.setVisibility(View.VISIBLE);
                }

                if(T41.equals("null"))
                {
                    tvTimeW41.setVisibility(View.GONE);
                    tvTimeW42.setVisibility(View.GONE);
                    tvTimeW43.setVisibility(View.GONE);
                    tvTimeW44.setVisibility(View.GONE);
                    tvTimeW45.setVisibility(View.GONE);
                    tvTimeW46.setVisibility(View.GONE);
                    tvTimeW47.setVisibility(View.GONE);
                }
                else
                {
                    tvTimeW42.setVisibility(View.VISIBLE);
                    tvTimeW44.setVisibility(View.VISIBLE);
                    tvTimeW46.setVisibility(View.VISIBLE);
                }

                if(T51.equals("null"))
                {
                    tvTimeW51.setVisibility(View.GONE);
                    tvTimeW52.setVisibility(View.GONE);
                    tvTimeW53.setVisibility(View.GONE);
                    tvTimeW54.setVisibility(View.GONE);
                    tvTimeW55.setVisibility(View.GONE);
                    tvTimeW56.setVisibility(View.GONE);
                    tvTimeW57.setVisibility(View.GONE);
                }
                else
                {
                    tvTimeW52.setVisibility(View.VISIBLE);
                    tvTimeW54.setVisibility(View.VISIBLE);
                    tvTimeW56.setVisibility(View.VISIBLE);
                }

                if(T61.equals("null"))
                {
                    tvTimeW61.setVisibility(View.GONE);
                    tvTimeW62.setVisibility(View.GONE);
                    tvTimeW63.setVisibility(View.GONE);
                    tvTimeW64.setVisibility(View.GONE);
                    tvTimeW65.setVisibility(View.GONE);
                    tvTimeW66.setVisibility(View.GONE);
                    tvTimeW67.setVisibility(View.GONE);
                }
                else
                {
                    tvTimeW62.setVisibility(View.VISIBLE);
                    tvTimeW64.setVisibility(View.VISIBLE);
                    tvTimeW66.setVisibility(View.VISIBLE);
                }

                if(T71.equals("null"))
                {
                    tvTimeW71.setVisibility(View.GONE);
                    tvTimeW72.setVisibility(View.GONE);
                    tvTimeW73.setVisibility(View.GONE);
                    tvTimeW74.setVisibility(View.GONE);
                    tvTimeW75.setVisibility(View.GONE);
                    tvTimeW76.setVisibility(View.GONE);
                    tvTimeW77.setVisibility(View.GONE);
                }
                else
                {
                    tvTimeW72.setVisibility(View.VISIBLE);
                    tvTimeW74.setVisibility(View.VISIBLE);
                    tvTimeW76.setVisibility(View.VISIBLE);
                }

                if(T81.equals("null"))
                {
                    tvTimeW81.setVisibility(View.GONE);
                    tvTimeW82.setVisibility(View.GONE);
                    tvTimeW83.setVisibility(View.GONE);
                    tvTimeW84.setVisibility(View.GONE);
                    tvTimeW85.setVisibility(View.GONE);
                    tvTimeW86.setVisibility(View.GONE);
                    tvTimeW87.setVisibility(View.GONE);
                }
                else
                {
                    tvTimeW82.setVisibility(View.VISIBLE);
                    tvTimeW84.setVisibility(View.VISIBLE);
                    tvTimeW86.setVisibility(View.VISIBLE);
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
                W1Sub = String.valueOf(snapshot.child("Schedule").child("W1Sub").getValue());
                W2Sub = String.valueOf(snapshot.child("Schedule").child("W2Sub").getValue());
                W3Sub = String.valueOf(snapshot.child("Schedule").child("W3Sub").getValue());
                W4Sub = String.valueOf(snapshot.child("Schedule").child("W4Sub").getValue());
                W5Sub = String.valueOf(snapshot.child("Schedule").child("W5Sub").getValue());
                W6Sub = String.valueOf(snapshot.child("Schedule").child("W6Sub").getValue());
                W7Sub = String.valueOf(snapshot.child("Schedule").child("W7Sub").getValue());
                W8Sub = String.valueOf(snapshot.child("Schedule").child("W8Sub").getValue());

                W1Class = String.valueOf(snapshot.child("Schedule").child("W1Class").getValue());
                W2Class = String.valueOf(snapshot.child("Schedule").child("W2Class").getValue());
                W3Class = String.valueOf(snapshot.child("Schedule").child("W3Class").getValue());
                W4Class = String.valueOf(snapshot.child("Schedule").child("W4Class").getValue());
                W5Class = String.valueOf(snapshot.child("Schedule").child("W5Class").getValue());
                W6Class = String.valueOf(snapshot.child("Schedule").child("W6Class").getValue());
                W7Class = String.valueOf(snapshot.child("Schedule").child("W7Class").getValue());
                W8Class = String.valueOf(snapshot.child("Schedule").child("W8Class").getValue());

                tvWSub11.setText(W1Sub);
                tvWSub22.setText(W2Sub);
                tvWSub33.setText(W3Sub);
                tvWSub44.setText(W4Sub);
                tvWSub55.setText(W5Sub);
                tvWSub66.setText(W6Sub);
                tvWSub77.setText(W7Sub);
                tvWSub88.setText(W8Sub);

                tvWClass11.setText(W1Class);
                tvWClass22.setText(W2Class);
                tvWClass33.setText(W3Class);
                tvWClass44.setText(W4Class);
                tvWClass55.setText(W5Class);
                tvWClass66.setText(W6Class);
                tvWClass77.setText(W7Class);
                tvWClass88.setText(W8Class);

                if (W1Sub.length()>11)
                {
                    tvWSub11.setPadding(0,0,0,8);
                }

                if (W2Sub.length()>11)
                {
                    tvWSub22.setPadding(0,0,0,8);
                }

                if (W3Sub.length()>11)
                {
                    tvWSub33.setPadding(0,0,0,8);
                }

                if (W4Sub.length()>11)
                {
                    tvWSub44.setPadding(0,0,0,8);
                }

                if (W5Sub.length()>11)
                {
                    tvWSub55.setPadding(0,0,0,8);
                }

                if (W6Sub.length()>11)
                {
                    tvWSub66.setPadding(0,0,0,8);
                }

                if (W7Sub.length()>11)
                {
                    tvWSub77.setPadding(0,0,0,8);
                }

                if (W8Sub.length()>11)
                {
                    tvWSub88.setPadding(0,0,0,8);
                }

                LinearLayout ll_row1 = v.findViewById(R.id.teacherW1_row1);
                LinearLayout ll_row2 = v.findViewById(R.id.teacherW2_row2);
                LinearLayout ll_row3 = v.findViewById(R.id.teacherW3_row3);
                LinearLayout ll_row4 = v.findViewById(R.id.teacherW4_row4);
                LinearLayout ll_row5 = v.findViewById(R.id.teacherW5_row5);
                LinearLayout ll_row6 = v.findViewById(R.id.teacherW6_row6);
                LinearLayout ll_row7 = v.findViewById(R.id.teacherW7_row7);
                LinearLayout ll_row8 = v.findViewById(R.id.teacherW8_row8);

                //1 СТРОКА
                if (W1Sub.equals("null"))
                {
                    ll_row1.setVisibility(View.GONE);
                }
                else
                {
                    ll_row1.setVisibility(View.VISIBLE);
                }

                //2 строка
                if (W2Sub.equals("null"))
                {
                    ll_row2.setVisibility(View.GONE);
                }
                else
                {
                    ll_row2.setVisibility(View.VISIBLE);
                }

                //3 строка
                if (W3Sub.equals("null"))
                {
                    ll_row3.setVisibility(View.GONE);
                }
                else
                {
                    ll_row3.setVisibility(View.VISIBLE);
                }

                //4 строка
                if (W4Sub.equals("null"))
                {
                    ll_row4.setVisibility(View.GONE);
                }
                else
                {
                    ll_row4.setVisibility(View.VISIBLE);
                }

                //5 строка
                if (W5Sub.equals("null"))
                {
                    ll_row5.setVisibility(View.GONE);
                }
                else
                {
                    ll_row5.setVisibility(View.VISIBLE);
                }

                //6 строка
                if (W6Sub.equals("null"))
                {
                    ll_row6.setVisibility(View.GONE);
                }
                else
                {
                    ll_row6.setVisibility(View.VISIBLE);
                }

                //7 строка
                if (W7Sub.equals("null"))
                {
                    ll_row7.setVisibility(View.GONE);
                }
                else
                {
                    ll_row7.setVisibility(View.VISIBLE);
                }

                //8 строка
                if (W8Sub.equals("null"))
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